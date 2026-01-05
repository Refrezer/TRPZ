package monitor.visitor;

import monitor.sensors.CpuSensor;
import monitor.sensors.MemorySensor;

public interface IVisitor {
    void visit(CpuSensor cpu);
    void visit(MemorySensor memory);
}