/* Author: Luigi Vicnent */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleServer {
	final static int PORT = 5290;

	public static void main(String[] args) {

		try(ServerSocket server = new ServerSocket(PORT)) {
			System.out.println(new Date() + "\nServer online.");

			while(true) {
				new ClientHandler(server.accept()).start();
			}
		} catch (IOException ioe) {}	
	}

	private static class ClientHandler extends Thread {
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;

		ClientHandler(Socket socket) {
			this.socket = socket;
			System.out.println("Client connected!");
		}

		@Override
		public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				out.println("Hello");
				String userName = in.readLine();
				System.out.println("Name is " + userName);
			} catch (IOException ioe) {}
		}
	}
}
