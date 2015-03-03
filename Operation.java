enum Operation {
	SUM((x, y) -> x + y),
	DIFFERENCE((x, y) -> x - y),
	PRODUCT((x, y) -> x * y),
	QUOTIENT((x, y) -> x / y),
	MODOLU((x, y) -> x % y),
	PERCENTAGE((x, y) -> x * 100 / y),
	EXPONENT(Math::pow);

	private final Equation equation;

	Operation(Equation equation) {
		this.equation = equation;
	}

	public Equation getEquation() {
		return this.equation;
	}

	@Override
	public String toString() {
		return 
			this.name().charAt(0) +
			this.name().substring(1).toLowerCase()
		;
	}
}
