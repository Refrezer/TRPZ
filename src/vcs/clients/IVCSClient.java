package vcs.clients;

public interface IVCSClient {
    void commit(String message);
    void update();
    void fetch();
}