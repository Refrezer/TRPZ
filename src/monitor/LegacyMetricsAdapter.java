package monitor;

import java.util.Map;

// Адаптер: реалізує Target і обгортає Adaptee
public class LegacyMetricsAdapter implements IMetricProvider {

    // Композиція: містить екземпляр Adaptee
    private final LegacyMetricsLib legacyLib;

    public LegacyMetricsAdapter(LegacyMetricsLib legacyLib) {
        this.legacyLib = legacyLib;
    }

    @Override
    public SystemMetrics getSystemLoad() {
        // 1. Виклик несумісного методу Adaptee
        Map<String, Double> rawData = legacyLib.retrieveCpuAndMemoryData();

        // 2. Логіка адаптації:
        double cpu = rawData.get("cpu_usage_percent");

        // Конвертація RAM з байтів у мегабайти
        long ramBytes = rawData.get("memory_total_bytes").longValue();
        long ramMB = ramBytes / (1024 * 1024);

        System.out.println("-> [Adapter] Дані успішно адаптовані та конвертовані.");

        // 3. Повернення об'єкта у форматі Target
        return new SystemMetrics(cpu, ramMB);
    }
}