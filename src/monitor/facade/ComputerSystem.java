package monitor.facade;

import monitor.sensors.CpuSensor;
import monitor.sensors.MemorySensor;
import monitor.utils.SystemLogger;

// Цей клас - ФАСАД.
// Він приховує складність ініціалізації та роботи з різними сенсорами.
public class ComputerSystem {

    private CpuSensor cpuSensor;
    private MemorySensor memorySensor;
    private SystemLogger logger;

    public ComputerSystem() {
        this.cpuSensor = new CpuSensor();
        this.memorySensor = new MemorySensor();
        // Використовуємо наш Singleton з 5-ї лаби
        this.logger = SystemLogger.getInstance();
    }

    // Єдиний метод для клієнта, який робить всю брудну роботу
    public void startMonitoring() {
        logger.addLog("[FACADE] Початок повної діагностики системи...");

        System.out.println("\n--- Ініціалізація підсистем ---");

        // 1. Перевірка CPU
        cpuSensor.collectData();
        String cpuStatus = cpuSensor.getStatus();
        logger.addLog("[FACADE] CPU перевірено: " + cpuStatus);

        // 2. Перевірка RAM
        memorySensor.collectData();
        String ramStatus = memorySensor.getStatus();
        logger.addLog("[FACADE] RAM перевірено: " + ramStatus);

        System.out.println("--- Діагностику завершено ---\n");
    }
}