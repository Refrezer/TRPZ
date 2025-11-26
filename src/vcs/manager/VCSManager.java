package vcs.manager;

import vcs.creators.VCSClientCreator;

public class VCSManager {

    private final VCSClientCreator creator; // Залежність від абстрактного творця

    public VCSManager(VCSClientCreator creator) {
        this.creator = creator;
    }

    // Клієнт використовує загальний метод, не знаючи про конкретний тип VCS
    public void startOperation(String commitMessage) {
        System.out.println("\n[Manager]: Отримано запит на синхронізацію репозиторію.");
        creator.performRepoSync(commitMessage);
    }
}