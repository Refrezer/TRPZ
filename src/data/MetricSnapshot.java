package data;

// Клас, що зберігає знімок метрик
public class MetricSnapshot {
    private final double cpu;
    private final long ram;

    public MetricSnapshot(double cpu, long ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return String.format("[Snapshot] CPU: %.1f%%, RAM: %d MB", cpu, ram);
    }
}