public enum Operation implements Equation {
	ADD((a, b) -> a + b),
	SUBTRACT((a, b) -> a - b),
	MULTIPLY((a, b) -> a * b),
	DIVIDE((a, b) -> a / b),
	EXPONENTIATE(Math::pow);

	private final Equation equation;

	Operation(Equation equation) {
		this.equation = equation;
	}

	@Override
	public double compute(double alpha, double beta) {
		return equation.compute(alpha, beta);
	}

	@Override
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}
}
