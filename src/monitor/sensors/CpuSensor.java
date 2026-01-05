package monitor.sensors;

import monitor.visitor.IVisitor;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Random;

public class CpuSensor implements ISensor {

    // ВАЖНО: Делаем bean полем класса, чтобы он хранил историю замеров
    private OperatingSystemMXBean osBean;

    public CpuSensor() {
        this.osBean = ManagementFactory.getOperatingSystemMXBean();

        // "Прогрев" датчика: первый вызов всегда дает 0 или NaN,
        // поэтому делаем его сразу при запуске программы вхолостую.
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            ((com.sun.management.OperatingSystemMXBean) osBean).getSystemCpuLoad();
        }
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    // Получение реальной загрузки
    public double getLoad() {
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            double load = ((com.sun.management.OperatingSystemMXBean) osBean).getSystemCpuLoad();
            // Если Java вернула NaN (не успела замерить), возвращаем 0.0, иначе проценты
            return Double.isNaN(load) ? 0.0 : load * 100;
        }
        return 0.0;
    }

    // Остальные методы
    public int getCores() {
        return osBean.getAvailableProcessors();
    }

    public int getCurrentTemperature() {
        // Температуру без админ-прав Java не видит, имитируем
        return new Random().nextInt(20) + 50;
    }

    public int getTemperature() {
        return getCurrentTemperature();
    }

    // Метод для вывода (используется в Facade)
    public String getCpuInfo() {
        return String.format("CPU: Ядер - %d, Загрузка - %.1f%%, Температура - %d°C",
                getCores(), getLoad(), getTemperature());
    }
}