package monitor.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SystemLogger {
    // 1. Статичне поле для зберігання єдиного екземпляра
    private static SystemLogger instance;

    // Список для зберігання історії логів
    private List<String> logList;

    // 2. ПРИВАТНИЙ конструктор
    // Забороняє створення об'єктів через new з інших класів
    private SystemLogger() {
        logList = new ArrayList<>();
        // Цей напис з'явиться лише один раз при першому зверненні
        System.out.println("-> [СИСТЕМА]: Логер ініціалізовано (Singleton створено).");
    }

    // 3. Публічний метод для отримання єдиного екземпляра
    public static SystemLogger getInstance() {
        if (instance == null) {
            instance = new SystemLogger();
        }
        return instance;
    }

    // Метод додавання запису в журнал (Бізнес-логіка)
    public void addLog(String message) {
        // Додаємо мітку часу
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String formattedMessage = String.format("[%s] %s", time, message);

        logList.add(formattedMessage);
        System.out.println(formattedMessage); // Дублюємо в консоль
    }

    // Метод для перегляду всієї історії
    public void showHistory() {
        System.out.println("\n--- ПОВНА ІСТОРІЯ ПОДІЙ ---");
        for (String log : logList) {
            System.out.println(log);
        }
        System.out.println("---------------------------");
    }
}