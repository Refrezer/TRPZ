package monitor.visitor;

import monitor.sensors.CpuSensor;
import monitor.sensors.MemorySensor;

public class TextReportVisitor implements IVisitor {
    @Override
    public void visit(CpuSensor cpu) {
        System.out.println("--- ЗВІТ ПО CPU ---");
        System.out.println("Ядер: " + cpu.getCores());
        System.out.printf("Навантаження: %.1f%%\n", cpu.getLoad());
        System.out.println("Температура: " + cpu.getTemperature() + "C");
        System.out.println("-------------------");
    }

    @Override
    public void visit(MemorySensor memory) {
        System.out.println("--- ЗВІТ ПО RAM ---");
        System.out.printf("Всього: %.2f GB\n", memory.getTotalRam());
        System.out.printf("Вільно: %.2f GB\n", memory.getFreeRam());
        System.out.println("-------------------");
    }
}