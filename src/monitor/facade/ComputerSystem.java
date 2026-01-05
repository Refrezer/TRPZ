package monitor.facade;

import monitor.memento.SystemSnapshot; // <--- Імпорт
import monitor.observer.EmailAlert;
import monitor.observer.EventHub;
import monitor.sensors.CpuSensor;
import monitor.sensors.MemorySensor;
import monitor.utils.SystemLogger;
import monitor.visitor.IVisitor;

public class ComputerSystem {
    private CpuSensor cpu;
    private MemorySensor memory;
    private SystemLogger logger;
    private EventHub events;

    public ComputerSystem() {
        this.cpu = new CpuSensor();
        this.memory = new MemorySensor();
        this.logger = SystemLogger.getInstance();
        this.events = new EventHub();
        events.subscribe(new EmailAlert());
    }

    public void checkSystem() {
        logger.log("[ФАСАД] Поточний стан:");
        logger.log(cpu.getCpuInfo());
        logger.log(memory.getMemoryInfo());
    }

    // --- ЛР 8 (Visitor) ---
    public void generateReport(IVisitor visitor) {
        logger.log("[VISITOR] Генерація звіту...");
        cpu.accept(visitor);
        memory.accept(visitor);
    }

    // --- ЛР 9 (MEMENTO) ---

    // 1. Створити точку відновлення (Save)
    public SystemSnapshot save() {
        logger.log("[MEMENTO] Збереження точки відновлення...");
        // Ми беремо поточні дані з сенсорів і пакуємо їх у знімок
        return new SystemSnapshot(
                cpu.getCpuInfo(),
                memory.getMemoryInfo()
        );
    }

    // 2. Відновити стан (Restore)
    public void restore(SystemSnapshot snapshot) {
        logger.log("[MEMENTO] Завантаження точки відновлення...");
        System.out.println("   >>> ВІДНОВЛЕНО ДАНІ: " + snapshot.getSnapshotInfo());

        // Тут ми могли б "відкотити" налаштування, якби вони у нас були.
        // Але оскільки це моніторинг, ми просто показуємо збережені дані.
    }
}