# Bin-file-reader
Java method to read .bin files and output several conversions.

This java method performs the following actions:


1. Open a .bin file
2. Read a 32-bit number from the file
3. Display the 32-bit binary number including leading zeroes
4. Display the 8-digit hexadecimal conversion including leading zeroes
5. Display a 6-bit unsigned base-10 integer parsed from bits 21-16 of the number
6. Display a 16-bit unsigned base-10 integer parsed from bits 15-0 of the integer
7. Repeat from step 2 until EOF is reached
8. Close the file
