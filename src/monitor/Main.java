package monitor;

import monitor.facade.ComputerSystem;
import monitor.visitor.JsonReportVisitor;
import monitor.visitor.TextReportVisitor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== SYSTEM MONITOR (Lab 8: Visitor) ===\n");

        // 1. Створюємо систему (Тут ініціалізуються сенсори)
        ComputerSystem computer = new ComputerSystem();

        // ВАЖЛИВО: Даємо системі 1 секунду, щоб накопичити статистику CPU.
        // Без цієї паузи Java не встигає порахувати різницю і видає 0%.
        Thread.sleep(1000);

        System.out.println("--- ЕТАП 1: Стандартна діагностика ---");
        computer.checkSystem();

        System.out.println("\n--- ЕТАП 2: Демонстрація VISITOR ---");

        // Ще одна пауза, щоб дані змінилися
        Thread.sleep(1000);

        System.out.println("\n[1] Формування текстового звіту:");
        computer.generateReport(new TextReportVisitor());

        System.out.println("\n[2] Експорт у JSON формат:");
        computer.generateReport(new JsonReportVisitor());
    }
}