package poly;

class Test {

	public static void main(String[] args) throws java.lang.Exception {
		PolynomialArithmetic op = new PolynomialArithmetic();
		Polynomial p1 = new Polynomial("3x2-2x1");
		Polynomial p2 = new Polynomial("4x2+3");
		op.addTwo(p1, p2);
		op.subtractTwo(p1, p2);

	}
}