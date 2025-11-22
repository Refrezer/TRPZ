package pattern;
import data.MetricSnapshot;
import java.util.List;

public class SnapshotIterator implements IIterator {
    private List<MetricSnapshot> list;
    private int position = 0;

    public SnapshotIterator(List<MetricSnapshot> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public MetricSnapshot next() {
        if (hasNext()) {
            return list.get(position++);
        }
        return null;
    }
}