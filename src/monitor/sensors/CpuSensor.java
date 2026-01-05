package monitor.sensors;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Random;

public class CpuSensor {

    public String getCpuInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        int cores = osBean.getAvailableProcessors();

        // Отримуємо реальне завантаження процесора
        double load = -1;
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            load = ((com.sun.management.OperatingSystemMXBean) osBean).getSystemCpuLoad();
        }

        // Якщо Java ще не встигла порахувати (перші мілісекунди), показуємо статус
        String loadStr = (load < 0 || Double.isNaN(load)) ? "Обчислення..." : String.format("%.1f%%", load * 100);

        // Температуру без прав адміністратора Java не віддає.
        // Генеруємо значення для перевірки патерну Observer.
        int temp = new Random().nextInt(15) + 40;

        return String.format("CPU: Ядер - %d, Завантаження - %s, Температура - %d°C",
                cores, loadStr, temp);
    }

    public int getCurrentTemperature() {
        // Генеруємо температуру (іноді високу), щоб спрацювала тривога
        return new Random().nextInt(30) + 60;
    }
}