/* Author: Luigi Vincent
A simple take on FizzBuzz
*/

import javax.swing.JOptionPane;

public class FizzBuzzCounter {
    public static void main(String[] args) {
        int goalNumber = 0;
        do {
            try {
                goalNumber = Integer.parseInt(
                        JOptionPane.showInputDialog("FizzBuzz goal number?")
              	);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Input must be a natural number!",
                	"Error", JOptionPane.WARNING_MESSAGE);
            }           
        } while (goalNumber  == 0);

        printFizzBuzz(goalNumber);
    }

    public static void printFizzBuzz(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) { sb.append("Fizz"); }
            if (i % 5 == 0) { sb.append("Buzz"); }
            if (sb.length() == 0) { System.out.println(i); }
            else { System.out.println(sb.toString()); }
            sb.setLength(0);
        }
    }
}
