package monitor.observer;

public class ConsoleAlert implements IObserver {
    @Override
    public void update(String eventType, String message) {
        // Реагуємо тільки на критичні події
        if ("CRITICAL".equals(eventType)) {
            System.out.println("!!! [ALERT] УВАГА: " + message + " !!!");
            System.out.println("    -> Рекомендація: Перевірте систему охолодження.");
        } else {
            System.out.println("    [Log]: " + message);
        }
    }
}