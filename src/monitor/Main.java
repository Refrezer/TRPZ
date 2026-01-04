package monitor;

import monitor.observer.ConsoleAlert;
import monitor.observer.FileLoggerObserver;
import monitor.observer.SensorHub;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота №7: Патерн Observer ===\n");

        // 1. Створюємо видавця (Датчики)
        SensorHub hub = new SensorHub();

        // 2. Створюємо підписників
        ConsoleAlert display = new ConsoleAlert();
        FileLoggerObserver logger = new FileLoggerObserver();

        // 3. Підписуємо їх на новини
        hub.attach(display);
        hub.attach(logger);

        // 4. Імітуємо роботу системи
        System.out.println("--- Тест 1: Нормальна температура ---");
        hub.setTemperature(45);

        System.out.println("\n--- Тест 2: Перегрів ---");
        hub.setTemperature(85);

        System.out.println("\n--- Тест 3: Відписка логера ---");
        hub.detach(logger); // Логер більше не слухає
        hub.setTemperature(90);
    }
}