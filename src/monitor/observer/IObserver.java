package monitor.observer;

// Інтерфейс, який мають реалізувати всі, хто хоче отримувати сповіщення
public interface IObserver {
    void update(String eventType, String message);
}