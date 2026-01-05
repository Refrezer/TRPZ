package monitor.sensors;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.io.File;

public class MemorySensor {
    public String getMemoryInfo() {
        // Отримуємо доступ до інтерфейсу ОС
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

        long totalRam = 0;
        long freeRam = 0;

        // Спроба отримати доступ до фізичної пам'яті (специфіка Sun/Oracle Java)
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            com.sun.management.OperatingSystemMXBean nativeBean =
                    (com.sun.management.OperatingSystemMXBean) osBean;

            totalRam = nativeBean.getTotalPhysicalMemorySize();
            freeRam = nativeBean.getFreePhysicalMemorySize();
        }

        // Дані про диск C:
        File disk = new File("C:");
        long totalDisk = disk.getTotalSpace();
        long freeDisk = disk.getFreeSpace();

        return String.format(
                "RAM (Фізична): %.1f GB / %.1f GB | HDD (C:): %.1f GB / %.1f GB",
                (totalRam - freeRam) / 1073741824.0, // Зайнято RAM
                totalRam / 1073741824.0,             // Всього RAM
                freeDisk / 1073741824.0,             // Вільно на диску
                totalDisk / 1073741824.0             // Всього на диску
        );
    }
}