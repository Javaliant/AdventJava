/* Author: Luigi Vincent
Quick exercise to remmeber java 8
*/

import java.util.stream.IntStream;

public class Java8FizzBuzz {
	final static int FIZZ = 3;
	final static int BUZZ = 5;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		IntStream.rangeClosed(1, 100).forEach(Java8FizzBuzz::fizzBuzzify);
	}

	private static void fizzBuzzify(int i) {
		if (i % FIZZ == 0) {
			sb.append("Fizz");
		}
		if (i % BUZZ == 0) {
			sb.append("Buzz");
		}

		System.out.println(sb.length() > 0 ? sb.toString() : i);
		sb.setLength(0);
	}
}
