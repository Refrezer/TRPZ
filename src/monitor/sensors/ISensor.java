package monitor.sensors;

import monitor.visitor.IVisitor;

public interface ISensor {
    // Цей метод впускає відвідувача
    void accept(IVisitor visitor);
}