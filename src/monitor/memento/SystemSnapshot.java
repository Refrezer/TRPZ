package monitor.memento;

import java.time.LocalTime;

// MEMENTO: Зберігає стан системи в певний момент часу
public class SystemSnapshot {
    private final String cpuState;
    private final String ramState;
    private final LocalTime timestamp;

    public SystemSnapshot(String cpuState, String ramState) {
        this.cpuState = cpuState;
        this.ramState = ramState;
        this.timestamp = LocalTime.now();
    }

    public String getCpuState() {
        return cpuState;
    }

    public String getRamState() {
        return ramState;
    }

    public String getSnapshotInfo() {
        return String.format("[%s] CPU: %s | RAM: %s", timestamp, cpuState, ramState);
    }
}