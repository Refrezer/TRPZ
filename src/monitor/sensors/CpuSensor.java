package monitor.sensors;

// Конкретний продукт 1: Сенсор процесора
public class CpuSensor implements ISystemSensor {
    @Override
    public void collectData() {
        System.out.println("[Сенсор CPU]: Зчитування частоти та температури... Оброблено.");
    }

    @Override
    public String getStatus() {
        return "Стабільно (Temp: 48C)";
    }

    @Override
    public String getSensorType() {
        return "CPU Монітор";
    }
}