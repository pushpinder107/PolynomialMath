package poly;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Polynomial {

	private HashMap<Integer, Integer> polynomialMap = new HashMap<>();

	// For empty Polynomial
	public Polynomial() {
		polynomialMap = new HashMap<>();
	}

	public Polynomial(String input) {
		polynomialMap = new HashMap<>();
		parseStringToPoly(input);
	}

	public Polynomial(HashMap<Integer, Integer> map) {
		polynomialMap.putAll(map);
	}

	private Polynomial parseStringToPoly(String polyString) {
		String[] elementSet;
		String element;
		Integer coefficient, exponent;
		String pattern = "([+ - 0-9]+)([a-z]?)([0-9]+)";
		polyString.toLowerCase();

		if (!(polyString.startsWith("-")))
			polyString = '+' + polyString;

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(polyString);
		while (m.find()) {
			element = m.group();
			System.out.println(element);
			if (!(element.startsWith("+")))
				element = '-' + element;
			if(!element.contains("x")) {
				System.out.println("Here : " +element);
				element = element + "x0";
			}
			

		elementSet = element.split("[a-z]");
			coefficient = Integer.parseInt(elementSet[0]);
			exponent = Integer.parseInt(elementSet[1]);
			System.out.println("Element : " + element + " Coeff :" +coefficient + " Power : " + exponent);
			this.polynomialMap.put(exponent, coefficient);
		}
		return this;
	}

	/*
	 * public String toString(){ for (polynomialMap.Entry<Integer, Integer>
	 * entry : polynomialMap.entrySet()) { System.out.println(entry.getKey() +
	 * "/" + entry.getValue()); }
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * public String toHTML(){
	 * 
	 * }
	 * 
	 * public String toLatex(){
	 * 
	 * }
	 */
	public HashMap<Integer, Integer> getPMap() {
		return polynomialMap;
	}

}