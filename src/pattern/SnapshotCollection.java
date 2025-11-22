package pattern;
import data.MetricSnapshot;
import java.util.ArrayList;
import java.util.List;

public class SnapshotCollection implements IContainer {
    // Прихований список, до якого клієнт не має прямого доступу
    private List<MetricSnapshot> snapshots = new ArrayList<>();

    public void add(MetricSnapshot snapshot) {
        this.snapshots.add(snapshot);
    }

    @Override
    public IIterator createIterator() {
        return new SnapshotIterator(this.snapshots);
    }
}