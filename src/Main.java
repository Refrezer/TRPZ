import monitor.SystemMonitor;
import monitor.LegacyMetricsLib;
import monitor.LegacyMetricsAdapter;
import service.MetricsRepository;

public class Main {
    public static void main(String[] args) {

        // 0. Ініціалізація існуючих компонентів
        MetricsRepository repository = new MetricsRepository();

        // 1. Створення Adaptee
        LegacyMetricsLib legacyLib = new LegacyMetricsLib();

        // 2. Створення Adapter, обгортаючи Adaptee
        LegacyMetricsAdapter metricsProvider = new LegacyMetricsAdapter(legacyLib);

        // 3. Створення Client (SystemMonitor), передача йому Adapter
        SystemMonitor monitor = new SystemMonitor(metricsProvider, repository);

        // Запуск функціоналу Client
        monitor.captureAndSaveSnapshot();
    }
}