/* Author: Luigi Vincent
My first ever use of a Lambda expression. Simply counting 1-5.
*/

import java.util.Arrays;
import java.util.List;

public class AlphaLambda {
	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);

		ints.forEach(System.out::println);
	}
}
