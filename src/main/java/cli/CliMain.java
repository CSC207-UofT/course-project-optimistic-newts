package cli;

import adapters.CliController;
import adapters.CliPresenter;

/**
 * Runs the main application in a command line interface.
 */
public class CliMain {
    public static void main(String[] args) {
        CliDriver cli = new CliDriver();
        CliPresenter presenter = new CliPresenter(cli);
        CliController controller = new CliController(cli, presenter);
        controller.run();
    }
}