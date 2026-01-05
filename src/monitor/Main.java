package monitor;

import monitor.facade.ComputerSystem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== REAL SYSTEM MONITOR (Labs 5-7) ===\n");

        ComputerSystem computer = new ComputerSystem();

        // Робимо 5 замірів з інтервалом, щоб побачити реальні зміни
        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- Замір #" + i + " ---");
            computer.checkSystem();

            // Пауза 1.5 секунди, щоб процесор встиг змінити навантаження
            Thread.sleep(1500);
        }
    }
}
