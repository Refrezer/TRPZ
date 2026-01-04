package monitor.creators;

import monitor.sensors.CpuSensor;
import monitor.sensors.ISystemSensor;

// Конкретна фабрика для створення CPU сенсора
public class CpuFactory extends SensorFactory {
    @Override
    public ISystemSensor createSensor() {
        return new CpuSensor();
    }
}