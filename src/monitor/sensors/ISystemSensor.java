package monitor.sensors;

// Інтерфейс (Product), який визначає загальні методи для всіх сенсорів
public interface ISystemSensor {
    void collectData();      // Зібрати дані
    String getStatus();      // Отримати статус
    String getSensorType();  // Отримати назву типу сенсора
}