package service;

import data.MetricSnapshot;
import java.util.ArrayList;
import java.util.List;

// Клас, що зберігає історію знімків
public class MetricsRepository {
    private final List<MetricSnapshot> snapshots = new ArrayList<>();

    public void save(MetricSnapshot snapshot) {
        snapshots.add(snapshot);
        // Тут могла б бути логіка збереження у файл/БД
    }

    // Метод для ЛР4 (Iterator)
    public List<MetricSnapshot> getSnapshots() {
        return snapshots;
    }
}