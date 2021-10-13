Scenario Walkthrough:

First the User runs the CliDriver.java file through a command line. To do so they should first ensure they are in the root directory. Then they can use the command:

$ javac cli/CliMain.java

This command compiles the code and then the program should start after using the command:

$ java driver/CliMain

Then they can make a new profile for themselves by using the terminal and using the command: 

make user <name> <password>

In this scenario, the user should change <name> to a username they would like to use and <password> to a password they would like to use. Now that a new profile has been created, they can log in using the terminal and using the command:

login <name> <password>

Where <name> and <password> are the same as what they set it to earlier. Then the user can log out of the system by using the terminal and command:

logout <name>

