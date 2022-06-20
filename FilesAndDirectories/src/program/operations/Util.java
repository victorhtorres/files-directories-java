package program.operations;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Util
{
    private static String _fileName;

    public Util( String fileName )
    {
        _fileName = fileName;
    }

    public void runBasicOperations()
    {
        try {
            Path path = Paths.get(_fileName);

            if (Files.exists(path)) {
                System.out.printf("%n%s exist%n", path.getFileName());
                System.out.printf("%s a directory%n", Files.isDirectory(path) ? "It's" : "It's not");
                System.out.printf("%s a absolute route%n", path.isAbsolute() ? "It's" : "It's not");
                System.out.printf("Last modification: %s%n", Files.getLastModifiedTime(path));
                System.out.printf("File size: %s%n", Files.size(path));
                System.out.printf("%s a path %n", Files.isDirectory(path) ? "It's" : "It's not");
                System.out.printf("%s a directory%n", Files.isDirectory(path) ? "It's" : "It's not");

                if (Files.isDirectory(path)) {
                    System.out.println("Directory Info");

                    DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
                    for (Path p : directoryStream) {
                        System.out.println(p);
                    }
                } else {
                    System.out.printf("%s not exist%n", path);
                }
            }
        }
        catch ( IOException ioException )
        {
            System.err.println( ioException.getStackTrace() );
        }
    }
}
