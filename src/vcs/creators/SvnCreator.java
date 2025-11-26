package vcs.creators;

import vcs.clients.IVCSClient;
import vcs.clients.SvnClient;

public class SvnCreator extends VCSClientCreator {
    @Override
    public IVCSClient createClient() {
        System.out.println("-> [Factory]: Створення клієнта SVN.");
        return new SvnClient();
    }
}