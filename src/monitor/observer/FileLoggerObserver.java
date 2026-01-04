package monitor.observer;

import monitor.utils.SystemLogger;

public class FileLoggerObserver implements IObserver {
    @Override
    public void update(String eventType, String message) {
        // Використовуємо наш Singleton з 5-ї лаби
        SystemLogger.getInstance().addLog("[OBSERVER] Отримано подію " + eventType + ": " + message);
    }
}