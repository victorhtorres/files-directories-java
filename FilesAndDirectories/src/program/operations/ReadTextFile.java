package program.operations;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile
{
    private static Scanner _scanner;
    private String _fileName;

    public ReadTextFile( String fileName )
    {
        _fileName = fileName;
    }

    public void openFile()
    {
        try {
            _scanner = new Scanner(Paths.get( _fileName ) );
        }
        catch ( IOException ioException )
        {
            System.err.print( "Error when the system tried open the file." );
            System.exit( 1 );
        }
    }

    public void readFile()
    {
        System.out.printf( "%-10s%-12s%-12s%10s%n", "Account", "First name", "Last name", "Amount" );

        try {
            while ( _scanner.hasNext() )
            {
                System.out.printf( "%-10d%-12s%-12s%10.2f%n", _scanner.nextInt(), _scanner.next(),
                        _scanner.next(), _scanner.nextDouble() );
            }
        }
        catch ( NoSuchElementException elementException )
        {
            System.err.println( "The file doesn't have the correct format" );
        }
        catch ( IllegalStateException illegalStateException )
        {
            System.err.println( "Error to read the file." );
        }
    }

    public void closeFile()
    {
        if ( _scanner != null )
        {
            _scanner.close();
        }
    }
}
