package pattern;
import data.MetricSnapshot;

public interface IIterator {
    boolean hasNext();
    MetricSnapshot next();
}