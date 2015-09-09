/* Author: Luigi Vincent */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class SimpleClient {
	static final int PORT = 5290;
	static final String SERVER_ADDRESS = "localhost";
	static Scanner keyboard = new Scanner(System.in);
	static BufferedReader in;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(SERVER_ADDRESS, PORT);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

		while (true) {
			String input = in.readLine();
			if (input.equals("Hello")) {
				System.out.println("What is your name?");
				out.println(keyboard.nextLine());
			}
		}
	}
}
