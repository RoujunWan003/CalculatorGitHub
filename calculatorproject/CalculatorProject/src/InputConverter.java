

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;




public class InputConverter 
{
	
	
	/**
	 * @param oldString
	 * @return
	 */
	public String removeSpace(String oldString) 
	{
		
		return oldString.replaceAll(" ","");
		
	}
	
	
	/**
	 * @param string
	 * @return
	 */
	public String combinePlusMinos(String string)
	{
		return string.replaceAll("\\+-","-");
	}
	
	/**
	 * @param string
	 * @return
	 */
	public  String combineMinosPlus(String string)
	{
		
		return string.replace("-+","-");
	}
	
	/**
	 * @param string
	 * @return
	 */
	public String combinePlusPlus(String string)
	{
		return string.replace("++","+");
	}
	
	/**
	 * @param string
	 * @return
	 */
	public String combineMinosMinos(String string)
	{
		return string.replace("--","+");
	}
	

	/**
	 * @param string
	 * @return
	 */
	public String combineSymbols(String string)
	{
		return combineMinosMinos(combinePlusPlus(combineMinosPlus(combinePlusMinos(string))));
	}
	
	
	
	/**
	 * @param string
	 * @param symbolsIndex
	 * @param startindex
	 * @param output
	 * @return
	 */
	public ArrayList <String> SeperatedString(String string,ArrayList <Integer> symbolsIndex, int startindex,ArrayList <String> output)
	{
		
		if(startindex == 0) 
		{
			String firstnumber = string.substring(0,symbolsIndex.get(startindex));
			String firstsymbol = string.substring(symbolsIndex.get(startindex),symbolsIndex.get(startindex)+1);
			
			output.add(firstnumber);
			output.add(firstsymbol);
			
			return SeperatedString(string,symbolsIndex, startindex +1, output);	
		}
		
		else if (startindex <= symbolsIndex.size()-1) 
		{	
			String number = string.substring(symbolsIndex.get(startindex-1)+1,symbolsIndex.get(startindex));
			String symbol = string.substring(symbolsIndex.get(startindex),symbolsIndex.get(startindex)+1);
			
			output.add(number);
			output.add(symbol);
			
			return SeperatedString(string,symbolsIndex, startindex +1, output);		
		}
		
		else
		{	
			String lastnumber = string.substring(symbolsIndex.get(startindex-1)+1,string.length());
			
			output.add(lastnumber);
			return output;
		}
			

	 }
	

	
	
	/**
	 * @param string
	 * @param startindex
	 * @param symbolsIndex
	 * @return
	 */
	public ArrayList <Integer>  getSymbolIdex(String string, int startindex, ArrayList <Integer> symbolsIndex)
	{
	
		ArrayList <Character> symbols = new ArrayList<>();
		
		symbols.add('+');
		
		symbols.add('-');
		
		symbols.add('*');
		
		symbols.add('/');	
		
		symbols.add('^');
		
		
		if (startindex < string.length()) 
		{
			// check whether the first element is negative sign, if yes skip to check next one
			if (startindex == 0 && string.charAt(startindex)=='-')
				
			{
				return getSymbolIdex(string , startindex +1,symbolsIndex);
			}
			// check whether the symbol after / * and ^ operation is negative, if yes, skip 
			// since it is not a symbol of operation but a negative sign of number behind
			
			if (symbols.contains(string.charAt(startindex)))
			{	
				if (string.charAt(startindex)=='/' || string.charAt(startindex)=='*'|| string.charAt(startindex)=='^')
				{
					if (string.charAt(startindex+1)=='-')
					{
						symbolsIndex.add(startindex);
						
						return getSymbolIdex(string , startindex +2,symbolsIndex);
					}
					else
					{
						symbolsIndex.add(startindex);
						
						return getSymbolIdex(string , startindex +1,symbolsIndex);
					}
				}
				else
				{
					symbolsIndex.add(startindex);
					
					return getSymbolIdex(string , startindex +1,symbolsIndex);
				}
				
			}
			else
			{
				return getSymbolIdex(string , startindex +1,symbolsIndex);
			}
			
		}	
		else 
		{
			return symbolsIndex;
		}
	}
	

	
	
	
	/**
	 * @param string
	 * @param num1
	 * @param num2
	 * @return
	 */
	public double numOperation(String string, double num1, double num2) 
	{
		
		if (string.equals("+")){
			return num1 + num2;
		}
		
		else if (string.equals("-")) {
			return num1 - num2;
		}
		
		else if (string.equals("*")) {
			return num1 * num2;
		}
		
		else if (string.equals("^")) {
			
			return integerExponent(num1, (int)num2, 0, 1);
		}
		
		else {
			return num1 / num2;
		}
	}
		
	
	
	/**
	 * @param stringlist
	 * @param i
	 * @param result
	 * @return
	 */
	public double stringListOperation(ArrayList<String> stringlist, int i, double result) 
	{	
		if (i ==0 )
		{
			result = result + Double.parseDouble(stringlist.get(i));
			
			
			return stringListOperation(stringlist, i+1 , result);
			
		}
		else if (i <= stringlist.size()-2)
		{	
			
			result = numOperation(stringlist.get(i),result, Double.parseDouble(stringlist.get(i+1)));
			
			return stringListOperation(stringlist, i+2 , result);
		}
		else
		{	
			
			return result;
		}
	}
	

	
	
	/**
	 * @param stringlist
	 * @param i
	 * @param output
	 * @return
	 */
	public ArrayList<String> highPriorityOperation(ArrayList<String> stringlist, int i,ArrayList<String> output) 
	{	
		
		if (i < stringlist.size())
		{
			if (stringlist.get(i).contentEquals("*")||stringlist.get(i).contentEquals("/"))
			{	
				if (i ==1) 
				{
					double value = numOperation(stringlist.get(i),  Double.parseDouble(stringlist.get(i-1)),  Double.parseDouble(stringlist.get(i+1)));
					
					output.set(i-1,"0");
					output.set(i,"+");
					output.set(i+1,Double.toString(value));
					
					return highPriorityOperation(stringlist, i+2, output);
					
				}
				else 
				{
					double value = numOperation(output.get(i),  Double.parseDouble(output.get(i-1)),  Double.parseDouble(output.get(i+1)));
					output.set(i-1,"0");
					output.set(i,output.get(i-2));
					output.set(i+1,Double.toString(value));
					
					return highPriorityOperation(stringlist, i+2, output);
				}
			}
			else
			{
				
				return highPriorityOperation(stringlist, i+2, output);
				
			}
		}
		else
		{	
			
			return output;
		}
	}
	

	
	/**
	 * @param string
	 * @param newString
	 * @return
	 */
	public String replaceBracket(String string, String newString)
	{
		if (string.contains("("))
		{
			int indexofLeftBracket = string.indexOf("(");
			int indexofrightBracket = string.indexOf(")");
			
			String inBracket = string.substring(indexofLeftBracket+1, indexofrightBracket);
			
			ArrayList<String> lowpriorityList = convertToLowPriority(inBracket);
			
			// StringList Operation
			
			double result = stringListOperation(lowpriorityList,0, 0) ;
						
			BigDecimal bd = new BigDecimal(result).setScale(6, RoundingMode.HALF_UP);  
			
			String targetToBeReplaced = string.substring(indexofLeftBracket, indexofrightBracket+1);
			
			newString = string.replace(targetToBeReplaced, bd.toString());
			
			return replaceBracket(newString ,newString);
		}
		else
		{
			return string;
		}

	}
	
	/**
	 * @param basenumber
	 * @param exponents
	 * @param counter i (counter to count times of operation default 0)
	 * @param result (default 1))
	 * @return
	 */
	public double integerExponent(double basenumber, int exponents, int counter, double result)
	{	
		if (exponents==0)
		{
			return 1;
		}
		else if (exponents > 0)
		{
			if (counter < exponents)
			{
				result *= basenumber;
				
				return integerExponent(basenumber, exponents, counter+1, result);
			}
			else
			{
				return result;
			}
		}
		else
		{
			if (counter < -exponents)
			{
				result *= 1/basenumber;
				
				return integerExponent(basenumber, exponents, counter+1, result);
			}
			else
			{
				return result;
			}
		}
	}

	/**
	 * @param stringlist
	 * @param i (index to search from, default 0)
	 * @param output
	 * @return
	 */
	public ArrayList<String> convertintegerExponent(ArrayList<String> stringlist, int i,ArrayList<String> output)
	{
		if (i < stringlist.size())
		{
			if (stringlist.get(i).contentEquals("^"))
			{	

				double value = integerExponent(Double.parseDouble(stringlist.get(i-1)), Integer.parseInt(stringlist.get(i+1)), 0, 1.0);
				output.set(i-1,"1");
				output.set(i,"*");
				output.set(i+1,Double.toString(value));
					
				return convertintegerExponent(stringlist,i+2,output);

			}
			else
			{
				
				return convertintegerExponent(stringlist,i+1,output);
				
			}
		}
		else
		{	
			
			return output;
		}
	}
	
	//Step 1 . Preprocess the string 
	
	//1.1.remove empty space
	//1.2.Combine operation symbols such as +- ,++, --, -+
	
	/**
	 * @param expression
	 * @return
	 */
	public String stringPreprocessing(String expression)
    {
		
		String noEmptyString = removeSpace(expression);
		
		String combined = combineSymbols(noEmptyString);
		
		return combined;
    }	
	
	//Step 2. Identify the operation Symbols and separate the string
			
			//(Distinguish number or negative number with operation )
	
	         //create a new ArrayList to store the index
	
	         //set start searching from index 0
		
		     // store the index of operation 
	
	
	// Separate the string into a ArrayList of Strings based on index of operation
	
		//create a new ArrayList to store the ArrayList of Strings
	
		//set start searching from index 0
	/**
	 * @param inputString
	 * @return
	 */
	public 	ArrayList <String> stringSeperate(String inputString)
	{
		//1
		ArrayList <Integer> symbolsindex = new ArrayList<>();
		
		int startindex = 0;
		
		ArrayList <Integer> symbolsIndex = getSymbolIdex(inputString, startindex, symbolsindex);
				

		//2
		ArrayList <String> stringList = new ArrayList<>();
		
		int startindex2 = 0;
		
		ArrayList <String> StringList = SeperatedString(inputString,symbolsIndex,startindex2,stringList);
		
		return StringList;
    }
    
	
	// Step 3 Convert the high priority calculation to low priority 
	// Priority rank : bracket > Power > ( * or / )> (+ or -)


	// Separate the string into string list
	/**
	 * @param preprocessedString
	 * @return
	 */
	public  ArrayList<String> convertToLowPriority( String preprocessedString)
	{
			
		String noBracket = replaceBracket(preprocessedString, "");
		
		noBracket = stringPreprocessing(noBracket);
		
		ArrayList <String> stringListNoBracket = stringSeperate(noBracket);
		
		ArrayList<String> outputNoPower = new ArrayList <String>(stringListNoBracket);
		
		ArrayList <String> stringListNoPower = convertintegerExponent(stringListNoBracket, 0 ,outputNoPower);	
		
		ArrayList<String> outputLowerPriority = new ArrayList <String>(stringListNoPower);
		
		ArrayList<String> lowestPriority = highPriorityOperation(stringListNoPower, 1 ,outputLowerPriority) ;
		
		return lowestPriority;	
		
	}
	
}
