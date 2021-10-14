Scenario Walkthrough:

First the User runs the CliMain.java file through a command line. To do so they should first ensure they are in the root directory. Then they can use the command:

$ javac cli/CliMain.java

This command compiles the code and then the program should start after using the command:

$ java cli/CliMain

Then they can make a new profile for themselves by using the terminal and using the command: 

make user "name" "password"

In this scenario, the user should change "name" to a username they would like to use and "password" to a password they would like to use. The CliMain class runs the main method which first creates a CliDriver object to be used to create a Controller object, at which point the controller.run() method is run. The CliDriver takes inputs and passes them to the Controller which validates the input name and password and calls the UserManager interactor to create a new User object with the given name and password.

Now that a new profile has been created, they can log in using the terminal and using the command:

login "name" "password"

Where "name" and "password" are the same as what they set it to earlier. The CliDriver takes the input and passes it to the Controller. Once again, the Controller validates the input by the user which then uses the UserManager interactor to log in to the created User object from earlier.

Then the user can log out of the system by using the terminal and command:

logout "name"

The CliDriver takes the input and passes it to the Controller. The Controller validates the input by the user and then uses the UserManager interactor to log out of the User object.
