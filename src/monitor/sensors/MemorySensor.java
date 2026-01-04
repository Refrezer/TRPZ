package monitor.sensors;

// Конкретний продукт 2: Сенсор пам'яті
public class MemorySensor implements ISystemSensor {
    @Override
    public void collectData() {
        System.out.println("[Сенсор RAM]: Сканування обсягу вільної пам'яті... Оброблено.");
    }

    @Override
    public String getStatus() {
        return "Оптимально (Free: 6GB)";
    }

    @Override
    public String getSensorType() {
        return "RAM Монітор";
    }
}