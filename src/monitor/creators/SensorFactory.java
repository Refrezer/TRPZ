package monitor.creators;

import monitor.sensors.ISystemSensor;

// Абстрактна фабрика (Creator)
public abstract class SensorFactory {

    // ФАБРИЧНИЙ МЕТОД: підкласи повинні реалізувати його, щоб створити конкретний сенсор
    public abstract ISystemSensor createSensor();

    // Бізнес-логіка: працює з сенсором через інтерфейс, не знаючи його конкретного типу
    public void reportStatus() {
        // Викликаємо фабричний метод для створення об'єкта
        ISystemSensor sensor = createSensor();

        System.out.println("\n--- Звіт від: " + sensor.getSensorType() + " ---");
        sensor.collectData();
        System.out.println("Поточний статус: " + sensor.getStatus());
    }
}