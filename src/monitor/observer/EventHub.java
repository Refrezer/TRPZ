package monitor.observer;

import java.util.ArrayList;
import java.util.List;

public class EventHub {
    private List<IObserver> subscribers = new ArrayList<>();

    public void subscribe(IObserver observer) {
        subscribers.add(observer);
    }

    public void notifySubscribers(String event) {
        for (IObserver sub : subscribers) {
            sub.update(event);
        }
    }
}