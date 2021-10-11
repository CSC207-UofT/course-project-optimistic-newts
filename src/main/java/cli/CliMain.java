package cli;

import adapters.Controller;

/**
 * Runs the main application in a command line interface.
 */
public class CliMain {
    public static void main(String[] args) {
        CliDriver cli = new CliDriver();
        Controller controller = new Controller(cli);
        controller.run();
    }
}
