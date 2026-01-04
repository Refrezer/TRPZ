package monitor.observer;

import java.util.ArrayList;
import java.util.List;

public class SensorHub {
    // Список підписників (слухачів)
    private List<IObserver> observers = new ArrayList<>();

    // Додати підписника
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    // Видалити підписника
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    // Сповістити всіх про подію
    public void notifyObservers(String eventType, String message) {
        for (IObserver observer : observers) {
            observer.update(eventType, message);
        }
    }

    // Бізнес-логіка: зміна температури
    public void setTemperature(int temp) {
        System.out.println("\n[SENSOR HUB]: Нові дані температури: " + temp + "C");

        if (temp > 70) {
            // Якщо гаряче - кричимо "CRITICAL"
            notifyObservers("CRITICAL", "Температура критична: " + temp + "C!");
        } else {
            // Якщо нормально - просто інформуємо
            notifyObservers("INFO", "Температура в нормі: " + temp + "C");
        }
    }
}