package com.company;
import java.io.*;


public class readBinaryFile {

    public static void readFile(String file)

            throws IOException

    {
        int number; // A number read from the file
        String bin_string;
        char[] bit_21_16_string = new char[6];
        int bit_21_16_int = 0;
        char[] bit_15_0_string = new char[16];
        int bit_15_0_int = 0;

        boolean endOfFile = false;     // EOF flag

        // Create the binary file input objects.
        FileInputStream fstream = new FileInputStream(file);
        DataInputStream inputFile = new DataInputStream(fstream);

        // Read the contents of the file.
        while (!endOfFile)
        {
            try
            {
                // Retrieve binary number from file
                number = inputFile.readInt();
                // Convert the binary number to String for printing
                bin_string = Integer.toBinaryString(number);

                // Leading Zeroes for printing binary number
                if (bin_string.length() < 32) {
                    int pad_amount = 32 - bin_string.length();

                    String pad = "0";
                    while (pad_amount > 1) {
                        pad = pad + "0";
                        pad_amount -= 1;
                    }
                    bin_string = pad + bin_string;
                }

                // Retrieve bits 21-16 (little Endian) and place in variable
                bin_string.getChars(10, 16, bit_21_16_string, 0);

                // Retrieve bits 15-0 and place in variable
                bin_string.getChars(16, 32, bit_15_0_string, 0);

                // Parse the retrieved bits to find base-10 number
                bit_21_16_int = Integer.parseUnsignedInt(new String(bit_21_16_string), 2);
                bit_15_0_int = Integer.parseUnsignedInt(new String(bit_15_0_string), 2);

                // Print output
                System.out.printf(bin_string);
                System.out.printf("\t %08x", number);
                System.out.printf("%10d", bit_21_16_int);
                System.out.printf("\t");
                System.out.println(bit_15_0_int);

            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
        }

        // Close the file.
        inputFile.close();
    }
}
