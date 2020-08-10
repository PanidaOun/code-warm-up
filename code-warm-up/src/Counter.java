import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that use to count number in flie.
 * @author Panida Ounnaitham
 */
public class Counter {
    private int count = 0;
    private double total = 0;

    public Counter() {
    }

    /**
     * Reads data values from a file and add them to the sum and count.
     * If the file doesn’t exist then print “File not found: filename” and return.
     * @param filename is a file that you want to know number of values and total of values.
     */
    public void readfile(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String lines;
            String ch;
            double num;
            while ((lines = bufferedReader.readLine()) != null) {
                Scanner scanner = new Scanner(lines);
                while (scanner.hasNext()) {
                    ch = scanner.next();
                    if (ch.equals("#")) {
                        break;
                    }
                    try {
                        num = Double.parseDouble(ch);
                        count++;
                        total += num;
                    } catch (NumberFormatException ex) {
                        // pass
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Can not read file");
        }
    }

    /**
     * To get how many number in the file.
     * @return the number of values read so far.
     */
    public int getCount() {
        return count;
    }

    /**
     * To get the total of number in the file.
     * @return  the total of values read so far.
     */
    public double getTotal() {
        return total;
    }
}