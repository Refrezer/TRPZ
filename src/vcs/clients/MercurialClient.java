package vcs.clients;

public class MercurialClient implements IVCSClient {
    @Override
    public void commit(String message) {
        System.out.println("[Hg]: Recording changes with 'hg commit -m': \"" + message + "\"");
    }

    @Override
    public void update() {
        System.out.println("[Hg]: Executing 'hg pull -u' (Update & Merge).");
    }

    @Override
    public void fetch() {
        System.out.println("[Hg]: Executing 'hg pull' (Fetch/Pull changes).");
    }
}