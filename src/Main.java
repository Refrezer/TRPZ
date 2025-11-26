import vcs.manager.VCSManager;
import vcs.creators.VCSClientCreator;
import vcs.creators.GitCreator;
import vcs.creators.SvnCreator;
import vcs.creators.MercurialCreator;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== VCS All-in-One Application ===");

        // Створення менеджера для Git
        VCSClientCreator gitCreator = new GitCreator();
        VCSManager gitManager = new VCSManager(gitCreator);
        gitManager.startOperation("Added feature X.");

        System.out.println("\n==================================");

        // Створення менеджера для SVN
        VCSClientCreator svnCreator = new SvnCreator();
        VCSManager svnManager = new VCSManager(svnCreator);
        svnManager.startOperation("Fixed bug in module Y.");

        System.out.println("\n==================================");

        // Створення менеджера для Mercurial
        VCSClientCreator hgCreator = new MercurialCreator();
        VCSManager hgManager = new VCSManager(hgCreator);
        hgManager.startOperation("Experimental change for speed optimization.");
    }
}