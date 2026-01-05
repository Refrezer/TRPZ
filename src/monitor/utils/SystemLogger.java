package monitor.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SystemLogger {
    private static SystemLogger instance;

    // Приватний конструктор
    private SystemLogger() {
        System.out.println("-> [LOG]: Ініціалізація файлової системи логів...");
    }

    // Глобальна точка доступу (Singleton)
    public static synchronized SystemLogger getInstance() {
        if (instance == null) {
            instance = new SystemLogger();
        }
        return instance;
    }

    // Метод запису
    public void log(String message) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[" + time + "] " + message);
    }
}