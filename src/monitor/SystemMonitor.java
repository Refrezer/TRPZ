package monitor;

import service.MetricsRepository;
import data.MetricSnapshot;

// SystemMonitor тепер залежить лише від IMetricProvider (Target)
public class SystemMonitor {

    // ДОДАНО: Залежність від інтерфейсу Target
    private final IMetricProvider provider;
    private final MetricsRepository repository;

    // ЗМІНЕНО: Конструктор приймає IMetricProvider
    public SystemMonitor(IMetricProvider provider, MetricsRepository repository) {
        this.provider = provider;
        this.repository = repository;
        System.out.println("=== System Monitor: Ініціалізовано ===");
    }

    // ЗМІНЕНО: Виклик методу через IMetricProvider
    public void captureAndSaveSnapshot() {
        System.out.println("\n--- Запуск збору метрик ---");

        // Виклик через уніфікований інтерфейс (це може бути Adapter або будь-який інший провайдер)
        SystemMetrics metrics = provider.getSystemLoad();

        // Створення MetricSnapshot (потребує імпорту data.MetricSnapshot)
        MetricSnapshot snapshot = new MetricSnapshot(metrics.getCpuLoad(), metrics.getMemoryUsageMB());
        repository.save(snapshot);

        System.out.println("Знімок системи збережено: " + snapshot.toString());
        System.out.println("--- Збір завершено ---");
    }

    // ... Інші методи (generateReport, що використовує ітератор)
}