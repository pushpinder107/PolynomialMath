import java.util.*;
import java.lang.*;
import java.io.*;

class Polynomial
{
    
    private HashMap<Integer,Integer> polynomialMap =  new HashMap<>();
    
    // For empty Polynomial
    public Polynomial(){
        polynomialMap = new HashMap<>();
    }

    public Polynomial(String input){
        polynomialMap = new HashMap<>();
        parseStringToPoly(input);
    }
    
    private Polynomial parseStringToPoly(String polyString){
		String[] result, elementSet;
		String element;
		Integer coefficient, exponent;
		
		String pattern = "[+-][0-9]+[a-z]{1}[0-9]";
		if(!(polyString.startsWith("-")))
				polyString = '+'+polyString;
			
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(polyString);
		while(m.find()){
			element = m.group();
			elementSet = element.split("x");
			coefficient = Integer.parseInt(elementSet[0]);
			exponent = Integer.parseInt(elementSet[1]);
			this.polynomialMap.put(coefficient, exponent);
		}
		return this;
	}
    
    public String toString(){
    
        
    }
    
    public String toHTML(){
        
    }
    
    public String toLatex(){
        
    }
    
    public HashMap<Integer,Integer> getPMap(){
        return polynomialMap;
    }
    

}

class PolynomialArithmetic{
    
    Polynomial result;
    
    PolynomialArithmetic(){
        result = new Polynomial();
    }
    
    public Polynomial addTwo(Polynomial p1, Polynomial p2){
        
    }
    
    public Polynomial subtractTwo(Polynomial p1, Polynomial p2){
        
    }
    
    public Polynomial multiplyTwo(Polynomial p1, Polynomial p2){
        
    }
}

class Test {
    
    public static void main (String[] args) throws java.lang.Exception
	{
	    PolynomialArithmetic op = new PolynomialArithmetic();
	    Polynomial p1 = new Polynomial("");
	    Polynomial p2 = new Polynomial("");
	    p1.addTwo(p1,p2);
	    p2.subtractTwo(p1,p2);
	    
		
	}
}
