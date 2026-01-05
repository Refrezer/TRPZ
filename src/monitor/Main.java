package monitor;

import monitor.facade.ComputerSystem;
import monitor.memento.SystemSnapshot;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== SYSTEM MONITOR (Lab 9: Memento) ===\n");

        ComputerSystem computer = new ComputerSystem();

        // 1. Початковий стан
        System.out.println("--- КРОК 1: Поточний стан ---");
        computer.checkSystem();
        Thread.sleep(1500); // Час на зміну параметрів

        // 2. ЗБЕРЕЖЕННЯ (Створюємо точку відновлення)
        System.out.println("\n--- КРОК 2: Створення бекапу (Save) ---");
        SystemSnapshot backup = computer.save();

        // 3. Зміна стану (імітуємо навантаження)
        System.out.println("\n--- КРОК 3: Робота системи (зміна даних) ---");
        Thread.sleep(2000); // Дані CPU зміняться
        computer.checkSystem();

        // 4. ВІДНОВЛЕННЯ (Повертаємося до старого запису)
        System.out.println("\n--- КРОК 4: Відкат системи (Restore) ---");
        computer.restore(backup);
    }
}