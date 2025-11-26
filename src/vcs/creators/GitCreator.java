package vcs.creators;

import vcs.clients.IVCSClient;
import vcs.clients.GitClient;

public class GitCreator extends VCSClientCreator {
    @Override
    public IVCSClient createClient() {
        System.out.println("-> [Factory]: Створення клієнта Git.");
        return new GitClient();
    }
}