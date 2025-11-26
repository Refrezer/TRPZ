package vcs.creators;

import vcs.clients.IVCSClient;
import vcs.clients.MercurialClient;

public class MercurialCreator extends VCSClientCreator {
    @Override
    public IVCSClient createClient() {
        System.out.println("-> [Factory]: Створення клієнта Mercurial.");
        return new MercurialClient();
    }
}