Scenario Walkthrough:

First the User runs the CliDriver.java file through a command line. To do so they should first ensure they are in the root directory. Then they can use the command:

$ javac cli/CliDriver.java

This command compiles the code and then the program should start after using the command:

$ java driver/CliDriver

Then they can make a new profile for themselves by using the terminal and using the command: 

make user "name" "password"

In this scenario, the user should change "name" to a username they would like to use and "password" to a password they would like to use. The Controller class validates the input name and password and calls the UserManager interactor to create a new User object with the given name and password.

Now that a new profile has been created, they can log in using the terminal and using the command:

login "name" "password"

Where "name" and "password" are the same as what they set it to earlier. Once again, the Controller validates the input by the user which then uses the UserManager interactor to log in to the created User object from earlier.

Then the user can log out of the system by using the terminal and command:

logout "name"

The Controller class validates the input by the user and then uses the UserManager interactor to log out of the User object.
