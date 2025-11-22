package monitor;

import java.util.Map;

// Стороння/Застаріла бібліотека з несумісним інтерфейсом
public class LegacyMetricsLib {

    // Несумісний метод: повертає Map<String, Double>
    public Map<String, Double> retrieveCpuAndMemoryData() {
        System.out.println("-> [Legacy] Отримання сирих даних з застарілої бібліотеки...");
        // Імітація даних з нестандартними ключами
        return Map.of(
                "cpu_usage_percent", 42.0,
                "memory_total_bytes", 8589934592.0 // 8 GB в байтах
        );
    }
}