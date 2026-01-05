package monitor.visitor;

import monitor.sensors.CpuSensor;
import monitor.sensors.MemorySensor;

public class JsonReportVisitor implements IVisitor {
    @Override
    public void visit(CpuSensor cpu) {
        System.out.println("{ \"cpu\": { \"load\": " + cpu.getLoad() + ", \"temp\": " + cpu.getTemperature() + " } }");
    }

    @Override
    public void visit(MemorySensor memory) {
        System.out.println("{ \"memory\": { \"free\": " + memory.getFreeRam() + ", \"total\": " + memory.getTotalRam() + " } }");
    }
}