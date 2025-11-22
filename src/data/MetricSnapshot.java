package data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MetricSnapshot {
    private int id;
    private double cpuLoad;
    private long memoryUsage;
    private LocalDateTime timestamp;

    public MetricSnapshot(int id, double cpuLoad, long memoryUsage) {
        this.id = id;
        this.cpuLoad = cpuLoad;
        this.memoryUsage = memoryUsage;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("[ID:%d | %s] CPU: %.1f%%, RAM: %d MB",
                id, timestamp.format(fmt), cpuLoad, memoryUsage);
    }
}