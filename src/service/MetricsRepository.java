package service;
import data.MetricSnapshot;
import pattern.SnapshotCollection;

public class MetricsRepository {
    // Використання власної колекції (Агрегата)
    private SnapshotCollection database = new SnapshotCollection();
    private int currentId = 0;

    public void save(double cpu, long ram) {
        MetricSnapshot snapshot = new MetricSnapshot(++currentId, cpu, ram);
        database.add(snapshot);
        System.out.println("-> [Repo] Saved: " + snapshot);
    }

    public SnapshotCollection getHistory() {
        return database;
    }
}