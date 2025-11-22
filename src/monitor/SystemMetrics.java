package monitor;

// Уніфікований об'єкт даних, який очікує SystemMonitor
public class SystemMetrics {
    private final double cpuLoad;
    private final long memoryUsageMB;

    public SystemMetrics(double cpuLoad, long memoryUsageMB) {
        this.cpuLoad = cpuLoad;
        this.memoryUsageMB = memoryUsageMB;
    }

    public double getCpuLoad() {
        return cpuLoad;
    }
    public long getMemoryUsageMB() {
        return memoryUsageMB;
    }

    @Override
    public String toString() {
        return String.format("CPU: %.1f%%, RAM: %d MB", cpuLoad, memoryUsageMB);
    }
}