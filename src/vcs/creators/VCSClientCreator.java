package vcs.creators;

import vcs.clients.IVCSClient;

public abstract class VCSClientCreator {

    // Фабричний метод, який має бути реалізований підкласами
    public abstract IVCSClient createClient();

    // Загальна бізнес-логіка, яка використовує створюваний продукт
    public void performRepoSync(String message) {
        // ВИКЛИК ФАБРИЧНОГО МЕТОДУ: створення продукту делегується підкласу
        IVCSClient client = createClient();

        System.out.println("\n--- Запуск операції ---");

        client.update();
        client.commit(message);
        client.fetch();

        System.out.println("--- Операція завершена. ---");
    }
}