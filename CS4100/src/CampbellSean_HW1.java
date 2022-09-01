import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class CampbellSean_HW1 {
    public static void main(String[] args) throws IOException {
        // Create the table
        System.out.println("Sean Campbell CS4100 Homework 1, Fall 2022");
        ReserveTable reserve = new ReserveTable(25);

        // Add to the table
        reserve.Add("cat", 15);
        reserve.Add("APPLE", 11);
        reserve.Add("Dog", 5);
        reserve.Add("DOnE", 21);
        reserve.Add("Over", 8);

        // Search the table
        System.out.println("The Code for 'over' is " + reserve.LookupName("over"));
        System.out.println("The Code for 'DOG' is " + reserve.LookupName("DOG"));
        System.out.println("The Code for 'Cat' is " + reserve.LookupName("Cat"));
        System.out.println("The Code for 'gone' is " + reserve.LookupName("gone"));
        System.out.println();

        System.out.println("The Name for 11 is " + reserve.LookupCode(11));
        System.out.println("The Name for 5 is " + reserve.LookupCode(5));
        System.out.println("The Name for 8 is " + reserve.LookupCode(8));
        System.out.println("The Name for 28 is " + reserve.LookupCode(28));

        // Print table to file
        System.out.println("Saving Printed Table to " + args[0]);
        reserve.PrintReserveTable(args[0]);
    }
}

class ReserveTable {
    private String[] nameTable;
    private int[] codeTable;
    private int numItems = 0;

    public ReserveTable(int maxSize) {
        nameTable = new String[maxSize];
        codeTable = new int[maxSize];
    }

    public int Add(String name, int code) {
        nameTable[numItems] = name;
        codeTable[numItems] = code;
        numItems++;

        return numItems - 1;
    }

    public int LookupName(String name) {
        for (int i = 0; i < numItems; i++) {
            if (name.compareToIgnoreCase(nameTable[i]) == 0){
                return codeTable[i];
            }
        }
        return -1;
    }

    public String LookupCode(int code) {
        for (int i = 0; i < numItems; i++) {
            if (codeTable[i] == code) {
                return nameTable[i];
            }
        }
        return "";
    }

    public void PrintReserveTable(String filename) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename));
        writer.printf("%8s%10s%6s\n", "Index", "Name", "Code");

        for (int i = 0; i < numItems; i++) {
            writer.printf("%8d%10s%6d\n", i, nameTable[i], codeTable[i]);
        }
        writer.close();
    }

}
