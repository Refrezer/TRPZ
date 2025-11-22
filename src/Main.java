import monitor.SystemMonitor;

public class Main {
    public static void main(String[] args) {
        SystemMonitor monitor = new SystemMonitor();

        System.out.println("=== ЗАПУСК SYSTEM ACTIVITY MONITOR ===\n");

        // 1. Імітуємо роботу програми (збираємо 3 знімки)
        monitor.captureSnapshot();
        try { Thread.sleep(100); } catch (Exception e) {} // Пауза

        monitor.captureSnapshot();
        try { Thread.sleep(100); } catch (Exception e) {}

        monitor.captureSnapshot();

        // 2. Викликаємо метод з патерном Ітератор (Вимога ЛР4)
        monitor.generateReport();
    }
}