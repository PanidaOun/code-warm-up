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
     * To get the number.
     */
    public int getCount() {
        return count;
    }

    /**
     * To get total of number .
     */
    public double getTotal() {
        return total;
    }
}