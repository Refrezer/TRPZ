package monitor.creators;

import monitor.sensors.MemorySensor;
import monitor.sensors.ISystemSensor;

// Конкретна фабрика для створення RAM сенсора
public class MemoryFactory extends SensorFactory {
    @Override
    public ISystemSensor createSensor() {
        return new MemorySensor();
    }
}