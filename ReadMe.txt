This program will read the ProgrammingAssignment.csv file to load bank data and allow a user to
search for banks based on the Bank ID, Name, Type, City, State, and Zipcode.

The program takes a commandline parameter that tells the complete path to the ProgrammingAssignment.csv file.

For example, to run the program you could use the following command.

java.exe -classpath PATH_TO_ROOT_FOLDER_OF_CLASSES com.suddeth.bankfinder.application.Main PATH_TO_DATA\ProgrammingAssignment.csv

After the program loads the CSV file it prompts the user for a search command. The user will enter a valid
command, which would be an integer from 0 through 7. The meaning of these commands is displayed to the user.

If a search command requires more data (such as search by city) the program will prompt the user for that data.

If the user wants to terminate the program they should enter "exit" when prompted for a search command.

If running the program in a programming editor then be sure to set the configuration to pass the path to the
ProgrammingAssignment.csv file as a commandline argument.

For Unit and Integration tests I would use JUnit. I would create a folder structure in the test/java
directory that matched the folder structure in the java directory. I would create test classes for each of the
classes and their public methods.

I would mock the ConsoleIO::prompt function so that whenever it is called it would return whatever command
is currently being tested.
