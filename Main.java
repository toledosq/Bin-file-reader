import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
        throws IOException
    {
	// A program that will read a .bin file and output binary, hexadecimal, 6-bit unsigned int, and 16-bit unsigned int
	Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.nextLine();
        readBinaryFile.readFile(fileName);
    }
}
