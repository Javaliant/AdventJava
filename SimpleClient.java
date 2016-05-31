/* Author: Luigi Vincent
*
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TestClient {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        Socket socket = new Socket("localhost", 4050);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String input = null;
        if ((input = in.readLine()) != null) {
            JOptionPane.showMessageDialog(null, input);
        }
        while (true) {
            out.println(keyboard.nextLine());
        }
    }
}
