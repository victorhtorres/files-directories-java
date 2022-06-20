package program;

import program.operations.CreateTextFile;
import program.operations.ReadTextFile;
import program.operations.Util;

public class FilesAndDirectories
{
    private static final String FILE_NAME = "test.txt";

    public static void main(String[] args)
    {
        // Some basic operations with files and directories:
        Util util = new Util( FILE_NAME );
        util.runBasicOperations();

        // Create a file and write into it
        // Warning: this way it will eliminate any information into the file and re-write a new information
        CreateTextFile createTextFile = new CreateTextFile( FILE_NAME );
        createTextFile.openFile();
        createTextFile.addRecords();
        createTextFile.closeFile();

        // Read a file
        ReadTextFile readTextFile = new ReadTextFile( FILE_NAME );
        readTextFile.openFile();
        readTextFile.readFile();
        readTextFile.closeFile();
    }
}
