package program.operations;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException ;
import java.util.Scanner;

public class CreateTextFile
{
    private static Formatter _out;
    private String _fileName;

    public CreateTextFile ( String fileName )
    {
        _fileName = fileName;
    }

    public void openFile()
    {
        try {
            _out = new Formatter( _fileName );
        }
        catch ( SecurityException securityException )
        {
            System.err.println( "Writing action denied. Finished." );
            System.exit( 1 );
        }
        catch ( FileNotFoundException fileNotFoundException )
        {
            System.err.println( "There was an error when the system tried to open the file. Finished." );
            System.exit( 1 ); // This is useful when you are working with batch files
        }
    }

    public void addRecords()
    {
        Scanner scanner = new Scanner( System.in );
        System.out.printf( "%s%n%s%n? ", "Add an account number, first name, last name and amount.", "To finish, add the end's indicator." );

        while ( scanner.hasNext() )
        {
            try
            {
                _out.format( "%d %s %s %.2f%n", scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextDouble() );
            }
            catch ( FormatterClosedException formatterClosedException)
            {
                System.err.println( "There was an error when the system tried to writing into file. Finished" );
                break;
            }
            catch ( NoSuchElementException noSuchElementException )
            {
                System.err.println( "Invalid input. Try again." );
                scanner.nextLine(); // Discard the input and the user could try again
            }

            System.out.print( "? " );
        }
    }

    public void closeFile()
    {
        if ( _out != null )
        {
            _out.close();
        }
    }
}