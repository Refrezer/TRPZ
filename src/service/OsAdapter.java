package service;

import java.util.Random;

// Адаптер: Імітує отримання даних від Windows/Linux
public class OsAdapter {
    private Random random = new Random();

    public double getCpuLoad() {
        // Імітуємо завантаження CPU від 10% до 60%
        return 10 + random.nextDouble() * 50;
    }

    public long getMemoryUsage() {
        // Імітуємо пам'ять від 2 ГБ до 6 ГБ
        return 2048 + random.nextInt(4096);
    }
}