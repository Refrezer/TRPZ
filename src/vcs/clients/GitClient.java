package vcs.clients;

public class GitClient implements IVCSClient {
    @Override
    public void commit(String message) {
        System.out.println("[Git]: Staging changes & committing: \"" + message + "\"");
    }

    @Override
    public void update() {
        System.out.println("[Git]: Executing 'git pull' (Update).");
    }

    @Override
    public void fetch() {
        System.out.println("[Git]: Executing 'git fetch' (Fetch metadata).");
    }
}