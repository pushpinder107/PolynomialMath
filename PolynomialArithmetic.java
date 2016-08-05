package poly;

import java.util.HashMap;
import java.util.Map;

class PolynomialArithmetic {

	Polynomial result;

	PolynomialArithmetic() {
		result = new Polynomial();
	}

	public Polynomial addTwo(Polynomial A, Polynomial B) {
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> AMap = A.getPMap();
		HashMap<Integer, Integer> BMap = B.getPMap();

		sumMap.putAll(AMap);

		for (Map.Entry<Integer, Integer> entry : BMap.entrySet()) {
			if (sumMap.containsKey(entry.getKey())) {
				sumMap.put(entry.getKey(), sumMap.get(entry.getKey()) + entry.getValue());
			} else
				sumMap.put(entry.getKey(), entry.getValue());
			// System.out.println("Key = " + entry.getKey() + ", Value = " +
			// entry.getValue());
		}

		Polynomial sum = new Polynomial(sumMap);
		String result = "";
		for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
			result = result + entry.getValue() + "x" + entry.getKey() +" ";
		}
		System.out.println(result);
		return sum;
	}

	public Polynomial subtractTwo(Polynomial A, Polynomial B) {
		HashMap<Integer, Integer> diffMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> AMap = A.getPMap();
		HashMap<Integer, Integer> BMap = B.getPMap();

		diffMap.putAll(AMap);

		for (Map.Entry<Integer, Integer> entry : BMap.entrySet()) {
			if (diffMap.containsKey(entry.getKey())) {
				diffMap.put(entry.getKey(), diffMap.get(entry.getKey()) + entry.getValue());
			} else
				diffMap.put(entry.getKey(), entry.getValue());
			// System.out.println("Key = " + entry.getKey() + ", Value = " +
			// entry.getValue());
		}

		Polynomial diff = new Polynomial(diffMap);
		System.out.println(diff.getPMap());
		return diff;
	}
	/*
	 * public Polynomial multiplyTwo(Polynomial A, Polynomial B){
	 * 
	 * }
	 */
}