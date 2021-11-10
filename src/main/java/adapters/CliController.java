package adapters;

import application.*;
import application.ConversationManager;
import application.MessageManager;
import application.user.LoginUser;
import application.UserManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Controller for the command line interface implementation of the application.
 */
public class CliController {
    private final InOut inOut;
    private final CliPresenter presenter;
    private UserManager currentUser;
    private ConversationManager currentConversation;
    private MessageManager currentMessage;

    /**
     * Create a new CliController.
     * @param inOut         InOut for retrieving input and send output
     * @param presenter     Presenter to send output by
     */
    public CliController(InOut inOut, CliPresenter presenter) {
        this.inOut = inOut;
        this.presenter = presenter;
    }

    /**
     * Runs the main CLI Program.
     */
    public void run() {
        while (true) {
            currentUser = logInMenu();
            if (currentUser == null) {
                stop();
            }
            userMenu();
        }
    }

    /**
     * Stops the CLI program.
     */
    private void stop() { // TODO: Make nicer stopping solution
    }

    /**
     * The User Menu, leads to the Conversations Menu, Friends Menu, and User Information Menu.
     * Also has option to logout.
     */
    private void userMenu() {
        String input = null;
        while (input == null) {
            presenter.present("-------");
            presenter.present("Hi " + currentUser.getUsername() + "!");
            presenter.present("User Menu options: conversations, friends, userinfo, logout:");
            try {
                input = inOut.getInput();
                if (Objects.equals(input, "logout")) {
                    logout();
                    break;
                } else if (Objects.equals(input, "conversations")) {
                    conversationsMenu();
                    input = null;
                } else if (Objects.equals(input, "friends")) {
                    friendsMenu();
                    input = null;
                } else if (Objects.equals(input, "userinfo")) {
                    userinfoMenu();
                    input = null;
                } else {
                    presenter.present("Invalid input.");
                    input = null;
                }
            } catch (IOException e) {
                presenter.present("Something went wrong.");
            }
        }
    }

    /**
     * The User Information Menu. Shows current User Information and allows user to change information.
     */
    private void userinfoMenu() {
        presenter.present("-------");
        presenter.present("User Information Menu not yet implemented, returning to User Menu");
    }

    /**
     * The Friends Menu. Shows list of user's current friends, allows removal of existing friends, and addition of new friends.
     */
    private void friendsMenu() {
        presenter.present("-------");
        presenter.present("Friends Menu not yet implemented, returning to User Menu");
    }

    /**
     * The Conversations Menu. Shows list of user's current conversations and allows user to enter a specific
     * Conversation's Menu. Also allows user to find new conversations.
     */
    private void conversationsMenu() {
        presenter.present("-------");
        presenter.present("Conversations Menu not yet implemented, returning to User Menu");
    }

    /**
     * Logs the user out.
     */
    private void logout() {
        presenter.present("-------");
        currentUser.logout();
        presenter.present(currentUser.getUsername() + " logged out");
    }

    /**
     * The Login Menu. Logs a user in or leads user to Create User Menu.
     * @return UserManager containing the logged-in user.
     */
    private UserManager logInMenu() {
        UserManager user = null;
        while (user == null) {
            presenter.present("-------");
            presenter.present("Enter 'exit' to stop the program.");
            presenter.present("Login Menu");
            presenter.present("To create a new account enter 'create'. To login to an existing account, enter your username:");
            try {
                String usernameInput = inOut.getInput();
                if (Objects.equals(usernameInput, "exit")) {
                    break;
                } else if (Objects.equals(usernameInput, "create")) {
                    return createUserMenu();
                } else {
                    presenter.present("Password:");
                    String passwordInput = inOut.getInput();
                    RequestModel loginRequest = new RequestModel(presenter);
                    loginRequest.fill(RequestField.USERNAME, usernameInput);
                    loginRequest.fill(RequestField.PASSWORD, passwordInput);
                    user = new UserManager();
                    user.login(loginRequest);
                }
            } catch (IOException e) {
                presenter.present("Something went wrong.");
            }
        }
        return user;
    }

    /**
     * The Create User Menu. Leads a user through account creation and then logs them into their new account.
     * @return  UserManager containing the logged-in, new user.
     */
    private UserManager createUserMenu() {
        UserManager user = null;
        while (user == null) {
            presenter.present("-------");
            presenter.present("Enter 'exit' to stop the program.");
            presenter.present("Create User Menu");
            presenter.present("Enter new username:");
            try {
                String username = inOut.getInput();
                if (Objects.equals(username, "exit")) {
                    break;
                } else if (Objects.equals(DataBase.getUser(username).getUsername(), username)) { // TODO: replace DataBase reference
                    presenter.present("Username already in use.");
                } else {
                    // username is unique, so we can create a new user with this username.
                    user = new UserManager();
                    presenter.present("Enter a password:");
                    String password = inOut.getInput();
                    presenter.present("Enter your location:");
                    String location = inOut.getInput();
                    presenter.present("Enter something you're interested in:");
                    ArrayList<String> interests = new ArrayList<>();
                    interests.add(inOut.getInput());
                    RequestModel createUserRequest = new RequestModel(presenter);
                    createUserRequest.fill(RequestField.USERNAME, username);
                    createUserRequest.fill(RequestField.PASSWORD, password);
                    createUserRequest.fill(RequestField.LOCATION, location);
                    createUserRequest.fill(RequestField.INTEREST, interests);
                    user.createUser(createUserRequest);
                    // We will now log the new user in
                    LoginUser loginUser = new LoginUser();
                    RequestModel loginRequest = new RequestModel(presenter);
                    loginRequest.fill(RequestField.USERNAME, username);
                    loginRequest.fill(RequestField.PASSWORD, password);
                    user.login(loginRequest);
                }
            } catch (IOException e) {
                presenter.present("Something went wrong.");
            }
        }
        return user;
    }
}