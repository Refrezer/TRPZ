package vcs.clients;

public class SvnClient implements IVCSClient {
    @Override
    public void commit(String message) {
        System.out.println("[SVN]: Committing changes to repository trunk. Log: \"" + message + "\"");
    }

    @Override
    public void update() {
        System.out.println("[SVN]: Executing 'svn update' (Update).");
    }

    @Override
    public void fetch() {
        // SVN не має окремої команди fetch, це робиться під час update
        System.out.println("[SVN]: Fetch command is not applicable. Data fetched during update.");
    }
}