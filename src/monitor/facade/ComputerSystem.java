package monitor.facade;

import monitor.observer.EmailAlert;
import monitor.observer.EventHub;
import monitor.sensors.CpuSensor;
import monitor.sensors.MemorySensor;
import monitor.utils.SystemLogger;

// ФАСАД: Приховує складність системи
public class ComputerSystem {
    private CpuSensor cpu;
    private MemorySensor memory;
    private SystemLogger logger;
    private EventHub events;

    public ComputerSystem() {
        this.cpu = new CpuSensor();
        this.memory = new MemorySensor();
        this.logger = SystemLogger.getInstance(); // Singleton
        this.events = new EventHub(); // Observer

        // Підписуємо Email-сповіщення
        events.subscribe(new EmailAlert());
    }

    public void checkSystem() {
        logger.log("[ФАСАД] Запуск повної діагностики...");

        // 1. Опитування CPU
        String cpuStatus = cpu.getCpuInfo();
        logger.log(cpuStatus);

        // 2. Опитування RAM
        String ramStatus = memory.getMemoryInfo();
        logger.log(ramStatus);

        // 3. Перевірка температури (Observer test)
        int temp = cpu.getCurrentTemperature();
        if (temp > 80) {
            logger.log("УВАГА! Критична температура!");
            events.notifySubscribers("Перегрів процесора: " + temp + "C");
        }

        logger.log("[ФАСАД] Діагностику завершено.");
    }
}