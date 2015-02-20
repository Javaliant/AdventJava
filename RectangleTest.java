public class RectangleTest {
	public static void main(String[] args) {
		//Variables defined as lambda expressions
		MyEquation area = (height, width) -> height * width;
		MyEquation perimeter = (height, width) -> 2 * (height + width);

		System.out.println("Area: " + area.compute(3, 4));
		System.out.println("Perimeter: " + perimeter.compute(3, 4));
	}
}
