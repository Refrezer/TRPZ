package monitor;

// Цільовий інтерфейс, який буде використовувати SystemMonitor
public interface IMetricProvider {
    SystemMetrics getSystemLoad();
}