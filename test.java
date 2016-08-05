import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;


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
    
    public Polynomial(HashMap<Integer,Integer> map){
    	polynomialMap.putAll(map);
    }
    
    private Polynomial parseStringToPoly(String polyString){
		String[] result, elementSet;
		String element;
		Integer coefficient, exponent;
		String pattern = "[+-][0-9]+[a-z]{1}[0-9]";
		polyString.toLowerCase();

		if(!(polyString.startsWith("-")))
				polyString = '+'+polyString;
			
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(polyString);
		while(m.find()){
			element = m.group();
			elementSet = element.split("[a-z]");
			coefficient = Integer.parseInt(elementSet[0]);
			exponent = Integer.parseInt(elementSet[1]);
			this.polynomialMap.put(exponent, coefficient);
		}
		return this;
	}
   
  /*  
    public String toString(){
        for (polynomialMap.Entry<Integer, Integer> entry : polynomialMap.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        
    }

        
    }
    
    public String toHTML(){
        
    }
    
    public String toLatex(){
        
    }
    */
    public HashMap<Integer,Integer> getPMap(){
        return polynomialMap;
    }
    

}

class PolynomialArithmetic{
    
    Polynomial result;
    
    PolynomialArithmetic(){
        result = new Polynomial();
    }
    
    
    public Polynomial addTwo(Polynomial A, Polynomial B){
    		HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
    		HashMap<Integer,Integer> AMap = A.getPMap();
    		HashMap<Integer,Integer> BMap = B.getPMap();
    		
    		sumMap.putAll(AMap);
    		
    		for (Map.Entry<Integer, Integer> entry : BMap.entrySet()) {
    		    if(sumMap.containsKey(entry.getKey())){
    		    	sumMap.put(entry.getKey(), sumMap.get(entry.getKey())+entry.getValue());
    		    }
    		    else
    		    	sumMap.put(entry.getKey(), entry.getValue());
    			//System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    		}
    		
    		Polynomial sum=new Polynomial(sumMap);
    		
    		for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
    		   System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    		}
    		return sum;
    } 
    
    
    public Polynomial subtractTwo(Polynomial A, Polynomial B){
    	HashMap<Integer,Integer> diffMap = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> AMap = A.getPMap();
		HashMap<Integer,Integer> BMap = B.getPMap();
		
		diffMap.putAll(AMap);
		
		for (Map.Entry<Integer, Integer> entry : BMap.entrySet()) {
		    if(diffMap.containsKey(entry.getKey())){
		    	diffMap.put(entry.getKey(), diffMap.get(entry.getKey())+entry.getValue());
		    }
		    else
		    	diffMap.put(entry.getKey(), entry.getValue());
			//System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		
		Polynomial diff=new Polynomial(diffMap);
		return diff;
    }
 /*   
    public Polynomial multiplyTwo(Polynomial A, Polynomial B){
        
    }
   */
}

class Test {
    
    public static void main (String[] args) throws java.lang.Exception
	{
	    PolynomialArithmetic op = new PolynomialArithmetic();
	    Polynomial p1 = new Polynomial("3x2");
	    Polynomial p2 = new Polynomial("4x2");
	    op.addTwo(p1,p2);
	    op.subtractTwo(p1,p2);
	    
		
	}
}


