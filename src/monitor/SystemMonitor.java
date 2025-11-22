package monitor;
import pattern.IContainer;
import pattern.IIterator;
import data.MetricSnapshot;
import service.MetricsRepository;
import service.OsAdapter;

public class SystemMonitor {
    private OsAdapter adapter = new OsAdapter();
    private MetricsRepository repository = new MetricsRepository();

    public void captureSnapshot() {
        double cpu = adapter.getCpuLoad();
        long ram = adapter.getMemoryUsage();
        repository.save(cpu, ram);
    }

    // Генерація звіту з використанням паттерну Iterator
    public void generateReport() {
        System.out.println("\n--- REPORT GENERATION (Iterator Pattern) ---");

        // 1. Отримуємо контейнер (інтерфейс IContainer)
        IContainer container = repository.getHistory();

        // 2. Створюємо ітератор (інтерфейс IIterator)
        IIterator iterator = container.createIterator();

        // 3. Послідовний обхід
        while (iterator.hasNext()) {
            MetricSnapshot item = iterator.next();
            System.out.println("LOG >> " + item.toString());
        }
        System.out.println("--- END OF REPORT ---\n");
    }
}