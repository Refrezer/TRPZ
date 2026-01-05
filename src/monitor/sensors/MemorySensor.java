package monitor.sensors;

import monitor.visitor.IVisitor;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.io.File;

// Додаємо: implements ISensor
public class MemorySensor implements ISensor {

    // --- ГОЛОВНА ЗМІНА ДЛЯ ЛАБИ 8 ---
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
    // --------------------------------

    public String getMemoryInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        long totalRam = 0;
        long freeRam = 0;

        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            com.sun.management.OperatingSystemMXBean nativeBean =
                    (com.sun.management.OperatingSystemMXBean) osBean;
            totalRam = nativeBean.getTotalPhysicalMemorySize();
            freeRam = nativeBean.getFreePhysicalMemorySize();
        }

        File disk = new File("C:");
        long totalDisk = disk.getTotalSpace();
        long freeDisk = disk.getFreeSpace();

        return String.format(
                "RAM: %.1f GB / %.1f GB | HDD: %.1f GB / %.1f GB",
                (totalRam - freeRam) / 1073741824.0,
                totalRam / 1073741824.0,
                freeDisk / 1073741824.0,
                totalDisk / 1073741824.0
        );
    }

    // Геттери для Visitor
    public double getTotalRam() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            return ((com.sun.management.OperatingSystemMXBean) osBean).getTotalPhysicalMemorySize() / 1073741824.0;
        }
        return 0;
    }

    public double getFreeRam() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            return ((com.sun.management.OperatingSystemMXBean) osBean).getFreePhysicalMemorySize() / 1073741824.0;
        }
        return 0;
    }
}