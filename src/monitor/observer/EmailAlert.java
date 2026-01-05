package monitor.observer;

public class EmailAlert implements IObserver {
    @Override
    public void update(String event) {
        System.out.println("   >>> [EMAIL] Надсилання адміністратору: " + event);
    }
}