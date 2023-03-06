
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class InputConverterTest {
	
	InputConverter inputConverter;
	
	
	@BeforeEach
	void setup()
	{
		InputConverter inputConverter  = new InputConverter();
	}
	
	@Test
	void test_remove_empty_space_from_string() {
		
		InputConverter inputConverter  = new InputConverter();
		
		String string = " 123*5 +23 -2 +4   ";
		String result = inputConverter.removeSpace(string);
		
		assertEquals("123*5+23-2+4", result);
	}
	
	@Test
	void test_combineDoubleSymbols()
	{
		InputConverter inputConverter  = new InputConverter();
		
		String target = "12-2-3-4+5+6+7-8+6+7-300";
		
		String resultString2 = inputConverter.combineSymbols("12-2-+3-4+5++6+7-+8--6++7+-300");
		
		assertEquals(target, resultString2);
	}
	
	@Test
	void test_combineDoubleSymbols2()
	{
		InputConverter inputConverter  = new InputConverter();
		
		String resultString3 = inputConverter.combineSymbols("125.6-+266+-3.678-+9.6++5--6.89++7.54--8-+69--7-+300");
		String target = "125.6-266-3.678-9.6+5+6.89+7.54+8-69+7-300";
		
		assertEquals(target, resultString3);
	}
	
	
	@Test
	void test_getSymbolIdex() 
	{
		
		InputConverter inputConverter  = new InputConverter();
		
		ArrayList <Integer> symbolsindex = new ArrayList<>();
		String string = " 1+2-3*5/2";
		ArrayList <Integer> result = inputConverter.getSymbolIdex(string,0,symbolsindex);
		ArrayList <Integer> target = new ArrayList<>();
		target.add(2);
		target.add(4);
		target.add(6);
		target.add(8);
		
		assertEquals(target, result);
	}
	
	@Test
	void test_getSymbolIdex2() 
	{	
		InputConverter inputConverter  = new InputConverter();
		
		ArrayList <Integer> symbolsindex2 = new ArrayList<>();
		String stringsymbol2 = "189/65/786*8/6";
		ArrayList <Integer> resultlistsymbol = inputConverter.getSymbolIdex(stringsymbol2,0,symbolsindex2);
		ArrayList <Integer> targetintlist = new ArrayList<>();
		
		targetintlist.add(3);
		targetintlist.add(6);
		targetintlist.add(10);
		targetintlist.add(12);
		
		assertEquals( targetintlist, resultlistsymbol);
	}
	
	@Test
	void test_getSymbolIdex_with_bracket1() 
	{
		InputConverter inputConverter  = new InputConverter();
		
		ArrayList <Integer> symbolsindex3 = new ArrayList<>();
		String stringsymbol3 = "51+(3+5)*82/6";
		ArrayList <Integer> resultlistsymbol3 = inputConverter.getSymbolIdex(stringsymbol3,0,symbolsindex3);
		ArrayList <Integer> targetintlist3 = new ArrayList<>();
		
		targetintlist3.add(2);
		targetintlist3.add(5);
		targetintlist3.add(8);
		targetintlist3.add(11);
		
		assertEquals( targetintlist3, resultlistsymbol3);
	}
	
	@Test
	void test_getSymbolIdex_with_bracket2() 
	{
		InputConverter inputConverter  = new InputConverter();
		
		ArrayList <Integer> symbolsindex4 = new ArrayList<>();
		String stringsymbol4 = "51+(3+5)*82/(6+2)";
		ArrayList <Integer> resultlistsymbol4 = inputConverter.getSymbolIdex(stringsymbol4,0,symbolsindex4);
		ArrayList <Integer> targetintlist4 = new ArrayList<>();
		
		targetintlist4.add(2);
		targetintlist4.add(5);

		targetintlist4.add(8);
		targetintlist4.add(11);
		targetintlist4.add(14);
		
		
		assertEquals( targetintlist4, resultlistsymbol4);
	}
	
	@Test
	void test_getSymbolIdex_with_negative_MultiplierandDivider() 
	{
		InputConverter inputConverter  = new InputConverter();
		
		ArrayList <Integer> symbolsindex55 = new ArrayList<>();
		String stringsymbol55 = "-51+3+5*-82/-6+2";
		ArrayList <Integer> resultlistsymbol55 = inputConverter.getSymbolIdex(stringsymbol55,0,symbolsindex55);
		ArrayList <Integer> targetintlist55 = new ArrayList<>();
		
		targetintlist55.add(3);
		targetintlist55.add(5);
		targetintlist55.add(7);
		targetintlist55.add(11);
		targetintlist55.add(14);

		assertEquals( targetintlist55, resultlistsymbol55);
	}
	
	
	@Test
	void test_SeperatedString1() 
	{	
		InputConverter inputConverter  = new InputConverter();
		
		String string= "59+43*6-843";
		ArrayList <Integer> empty = new ArrayList<>();
		ArrayList <Integer> symbolsIndex = inputConverter.getSymbolIdex(string,0,empty);

		int startindex = 0;
		ArrayList <String> output = new ArrayList<>();
		
		ArrayList <String> result = inputConverter.SeperatedString(string,symbolsIndex,startindex,output);
		ArrayList <String> target = new ArrayList<>();
		target.add("59");
		target.add("+");
		target.add("43");
		target.add("*");
		target.add("6");
		target.add("-");
		target.add("843");
		
		assertEquals(target, result);
	}
		
	@Test
	void test_SeperatedString2() 
	{	
		InputConverter inputConverter  = new InputConverter();
		
		String string= "59.567+43*6-843/8";
		ArrayList <Integer> empty2 = new ArrayList<>();
		ArrayList <Integer> symbolsIndex2 = inputConverter.getSymbolIdex(string,0,empty2);

		int startindex = 0;
		ArrayList <String> output2 = new ArrayList<>();
			
		ArrayList <String> result2 = inputConverter.SeperatedString(string,symbolsIndex2,startindex,output2);
		ArrayList <String> target2 = new ArrayList<>();
		target2.add("59.567");
		target2.add("+");
		target2.add("43");
		target2.add("*");
		target2.add("6");
		target2.add("-");
		target2.add("843");
		target2.add("/");
		target2.add("8");
			
		assertEquals(target2, result2);
			
	}
	
	@Test
	void test_SeperatedString_with_Negative_multiplier() 
	{	
		InputConverter inputConverter  = new InputConverter();
		
		String string= "52+43*-6-843/-8";
		ArrayList <Integer> empty2 = new ArrayList<>();
		ArrayList <Integer> symbolsIndex2 = inputConverter.getSymbolIdex(string,0,empty2);

		int startindex = 0;
		ArrayList <String> output2 = new ArrayList<>();
			
		ArrayList <String> result2 = inputConverter.SeperatedString(string,symbolsIndex2,startindex,output2);
		ArrayList <String> target2 = new ArrayList<>();
		target2.add("52");
		target2.add("+");
		target2.add("43");
		target2.add("*");
		target2.add("-6");
		target2.add("-");
		target2.add("843");
		target2.add("/");
		target2.add("-8");
			
		assertEquals(target2, result2);
			
	}
	
	@Test
	void test_SeperatedString_with_negative_exponent() 
	{	
		InputConverter inputConverter  = new InputConverter();
		
		String string22= "52+43^-6-843^-8";
		ArrayList <Integer> empty22 = new ArrayList<>();
		ArrayList <Integer> symbolsIndex22 = inputConverter.getSymbolIdex(string22,0,empty22);

		int startindex = 0;
		ArrayList <String> output22 = new ArrayList<>();
			
		ArrayList <String> result22 = inputConverter.SeperatedString(string22,symbolsIndex22,startindex,output22);
		ArrayList <String> target22 = new ArrayList<>();
		target22.add("52");
		target22.add("+");
		target22.add("43");
		target22.add("^");
		target22.add("-6");
		target22.add("-");
		target22.add("843");
		target22.add("^");
		target22.add("-8");
			
		assertEquals(target22, result22);
			
	}
	
	//numOperation(String string, double num1, double num2) 
	@Test
	void test_numOperation1()
	{	
		InputConverter inputConverter  = new InputConverter();
		double TargetNO1 = 5;
		double resultNO1 = inputConverter.numOperation("+", 1.5, 3.5) ;
		
		assertEquals(TargetNO1, resultNO1,1e-6);
	}
	
	//numOperation(String string, double num1, double num2) 
	@Test
	void test_numOperation2()
	{	
		InputConverter inputConverter  = new InputConverter();
		double TargetNO2 = -2;
		double resultNO2 = inputConverter.numOperation("-", 1.5, 3.5) ;
		
		assertEquals(TargetNO2, resultNO2,1e-6);
	}
	
	//numOperation(String string, double num1, double num2) 
	@Test
	void test_numOperation3()
	{	
		InputConverter inputConverter  = new InputConverter();
		double TargetNO3 = 5.25;
		double resultNO3 = inputConverter.numOperation("*", 1.5, 3.5) ;
		
		assertEquals(TargetNO3, resultNO3,1e-6);
	}
	
	//numOperation(String string, double num1, double num2) 
	@Test
	void test_numOperation4()
	{	
		InputConverter inputConverter  = new InputConverter();
		double TargetNO4 = 0.428571;
		double resultNO4 = inputConverter.numOperation("/", 1.5, 3.5) ;
		
		assertEquals(TargetNO4, resultNO4,1e-6);
	}
	
	//numOperation(String string, double num1, double num2) 
	@Test
	void test_numOperation5()
	{	
		InputConverter inputConverter  = new InputConverter();
		double TargetNO5 = 125;
		double resultNO5 = inputConverter.numOperation("^", 5, 3) ;
		
		assertEquals(TargetNO5, resultNO5,1e-6);
	}
	
	
	
	@Test
	void test_stringListOperation()
	{	
		InputConverter inputConverter  = new InputConverter();
		
		ArrayList <String> inputList = new ArrayList<>();
		inputList.add("45");
		inputList.add("+");
		inputList.add("65");
		inputList.add("+");
		inputList.add("87");
		inputList.add("-");
		inputList.add("189");
		
		double result3 = inputConverter.stringListOperation(inputList,0,0);
		
		assertEquals(8, result3);
	}
	
	@Test
	void test_stringListOperation_with_negative_multiplier()
	{	
		InputConverter inputConverter  = new InputConverter();
		
		ArrayList <String> inputList33 = new ArrayList<>();
		inputList33.add("5");
		inputList33.add("*");
		inputList33.add("-65");
		inputList33.add("/");
		inputList33.add("-87");
		inputList33.add("-");
		inputList33.add("189");
		
		double result33 = inputConverter.stringListOperation(inputList33,0,0);
		
		assertEquals(-185.264368, result33,1e-6);
	}
	


	@Test
	void test_highPriorityOperation()
	{
		InputConverter inputConverter  = new InputConverter();
		
		String input4= "0+5*6-8/6";
			
		ArrayList <Integer> symbolsIndex4 = new ArrayList<>();
			
		ArrayList <String> output4 = new ArrayList<>();
			
		ArrayList <Integer> symbolindex4 =  inputConverter.getSymbolIdex(input4,0, symbolsIndex4);
		
		ArrayList <String> seperatedString4 = inputConverter.SeperatedString(input4,symbolindex4, 0,output4);
		
		ArrayList <String> outputEmpty4 = new ArrayList<>(seperatedString4);
			
		ArrayList<String> resultlist4 = inputConverter.highPriorityOperation(seperatedString4,1,outputEmpty4) ;
		
		double result4 = inputConverter.stringListOperation(resultlist4,0,0);
		
		assertEquals(28.6666666, result4, 1e-6);
	}
	
	
	@Test
	void test_highPriorityOperation2()
	{	
		InputConverter inputConverter  = new InputConverter();
			
		String input5= "189/65/786*8/6";
		
		ArrayList <Integer> symbolsIndex5 = new ArrayList<>();
			
		ArrayList <Integer> symbolindex5 =  inputConverter.getSymbolIdex(input5,0, symbolsIndex5);
		
		ArrayList <String> output5 = new ArrayList<>();
		
		ArrayList <String> seperatedString5 = inputConverter.SeperatedString(input5,symbolindex5, 0,output5);
		
		ArrayList <String> outputEmpty5 = new ArrayList<>(seperatedString5);
			
		ArrayList<String> resultlist5 = inputConverter.highPriorityOperation(seperatedString5, 1,outputEmpty5) ;
		
		double result5 = inputConverter.stringListOperation(resultlist5,0,0);
		
		assertEquals(4.932472e-3, result5, 1e-6);
	}
	
	@Test
	void test_highPriorityOperation3()
	{
		InputConverter inputConverter  = new InputConverter();
		
		String input6= "3-189/65+6/786*8/6";
		
		ArrayList <Integer> symbolsIndex6 = new ArrayList<>();
			
		ArrayList <Integer> symbolindex6 =  inputConverter.getSymbolIdex(input6,0, symbolsIndex6);
		
		ArrayList <String> output6 = new ArrayList<>();
		
		ArrayList <String> seperatedString6 = inputConverter.SeperatedString(input6,symbolindex6, 0,output6);
		
		ArrayList <String> outputEmpty6 = new ArrayList<>(seperatedString6);
			
		ArrayList<String> resultlist6 = inputConverter.highPriorityOperation(seperatedString6, 1,outputEmpty6) ;
		
		double result6 = inputConverter.stringListOperation(resultlist6,0,0);
		
		assertEquals(0.1024858, result6, 1e-6);
	}
	

	@Test
	void test_replaceBracket1()
	{
		InputConverter inputConverter = new InputConverter();
		assertEquals("1+11.000000/6.000000*6",inputConverter.replaceBracket("1+(5+6)/(8-2)*6",""));
	}
	
	@Test
	void test_replaceBracket2()
	{
		InputConverter inputConverter = new InputConverter();
		
		String target8 = "-25.600000/704.840000*8*-314.586200*2469";
		String result8 = inputConverter.replaceBracket("(3-28.6)/(25.3+679.54)*8*(6-320.5862)*2469","");
		assertEquals(target8,result8);
	}
	
	@Test
	void test_replaceBracket3()
	{
		InputConverter inputConverter = new InputConverter();
		assertEquals("1+-9.000000/-10.000000*6",inputConverter.replaceBracket("1+(-15+6)/(-8-2)*6",""));
	}
	
	@Test
	void test_integerExponent_with_positive_exponent1() 
	{
		InputConverter inputConverter  = new InputConverter();
		double result99 = inputConverter.integerExponent(2.5, 13, 0, 1);
		assertEquals(149011.6119, result99, 1e-4);
	}
	
	@Test
	void test_integerExponent_with_negative_exponent2() 
	{
		InputConverter inputConverter  = new InputConverter();
		double result99 = inputConverter.integerExponent(2.5, -13, 0, 1);
		assertEquals(6.71088e-6, result99, 1e-6);
	}
	
	@Test
	void test_integerExponent_with_zero_exponent2() 
	{
		InputConverter inputConverter  = new InputConverter();
		double result100 = inputConverter.integerExponent(2.5, 0, 0, 1);
		assertEquals(1, result100, 1e-6);
	}
	

	@Test
	void test_convertintegerExponent() 
	{
		InputConverter inputConverter  = new InputConverter();
		
		String input66= "3-4^-2+6/786*8^6";
		
		ArrayList <Integer> symbolsIndex66 = new ArrayList<>();
		
		ArrayList <Integer> symbolindex66 =  inputConverter.getSymbolIdex(input66,0, symbolsIndex66);
		
		ArrayList <String> output66 = new ArrayList<>();
		
		ArrayList <String> seperatedString66 = inputConverter.SeperatedString(input66,symbolindex66, 0,output66);
		
		ArrayList <String> output66s = new ArrayList<>(seperatedString66);
			
		ArrayList<String> resultlist66 = inputConverter.convertintegerExponent(output66s,1,output66s) ;
		
		ArrayList<String> targetlist66 = new ArrayList<>();
		
		targetlist66.add("3");
		targetlist66.add("-");
		targetlist66.add("1");
		targetlist66.add("*");
		targetlist66.add("0.0625");
		targetlist66.add("+");
		targetlist66.add("6");
		targetlist66.add("/");
		targetlist66.add("786");
		targetlist66.add("*");
		targetlist66.add("1");
		targetlist66.add("*");
		targetlist66.add("262144.0");
		
		assertEquals(targetlist66, resultlist66);	
	}
	
	@Test
	void test_convertintegerExponent2() 
	{
		InputConverter inputConverter  = new InputConverter();
		
		String input26= "3+0.3^3";
		
		ArrayList <Integer> symbolsIndex26 = new ArrayList<>();
		
		ArrayList <Integer> symbolindex26 =  inputConverter.getSymbolIdex(input26,0, symbolsIndex26);
		
		ArrayList <String> output26 = new ArrayList<>();
		
		ArrayList <String> seperatedString26 = inputConverter.SeperatedString(input26,symbolindex26, 0,output26);
		
		ArrayList <String> output26s = new ArrayList<>(seperatedString26);
			
		ArrayList<String> resultlist26 = inputConverter.convertintegerExponent(output26s,1,output26s) ;
		
		ArrayList<String> targetlist26 = new ArrayList<>();
		
		targetlist26.add("3");
		targetlist26.add("+");
		targetlist26.add("1");
		targetlist26.add("*");
		targetlist26.add("0.027");

		
		assertEquals(targetlist26, resultlist26);	
	}
	
	@Test
	void test_stringPreprocessing1()
	{
		InputConverter inputConverter  = new InputConverter();
		assertEquals(inputConverter.stringPreprocessing(" 3    + 3/ 7* 6^ 7.5 "), "3+3/7*6^7.5");
	}
	
	@Test
	void test_stringPreprocessing2()
	{
		InputConverter inputConverter  = new InputConverter();
		assertEquals(inputConverter.stringPreprocessing(" 3 +-1   ++ 3-+4/ 7* 6^ 7.5--3 "), "3-1+3-4/7*6^7.5+3");
	}
	
	@Test
	void test_stringSeperate()
	{
		InputConverter inputConverter  = new InputConverter();
		String inputString = "2.32+5/3^-3*5^2";
		ArrayList<String> stringSeperateList1 = new ArrayList<>();
		
		stringSeperateList1.add("2.32");
		stringSeperateList1.add("+");
		stringSeperateList1.add("5");
		stringSeperateList1.add("/");
		stringSeperateList1.add("3");
		stringSeperateList1.add("^");
		stringSeperateList1.add("-3");
		stringSeperateList1.add("*");
		stringSeperateList1.add("5");
		stringSeperateList1.add("^");
		stringSeperateList1.add("2");

		assertEquals(inputConverter.stringSeperate(inputString), stringSeperateList1);
	}
	
	@Test
	void test_convertToLowPriority1withBracket()
	{
		InputConverter inputConverter  = new InputConverter();
		String preprocessedString = "3+(0.5-0.2)*(3+4)";
		ArrayList<String> lowPriorityList1 = new ArrayList<>();
		
		lowPriorityList1.add("3");
		lowPriorityList1.add("+");
		lowPriorityList1.add("0");
		lowPriorityList1.add("+");
		lowPriorityList1.add("2.1");
		
		assertEquals(lowPriorityList1,inputConverter.convertToLowPriority(preprocessedString));	
		
	}
	
	@Test
	void test_convertToLowPriority2_with_powerAndBracket()
	{
		InputConverter inputConverter  = new InputConverter();
		String preprocessedString2 = "3+(0.5-0.2)^2+2";
		ArrayList<String> lowPriorityList2 = new ArrayList<>();
		
		lowPriorityList2.add("3");
		lowPriorityList2.add("+");
		lowPriorityList2.add("0");
		lowPriorityList2.add("+");
		lowPriorityList2.add("0.09");
		lowPriorityList2.add("+");
		lowPriorityList2.add("2");
		
		assertEquals(lowPriorityList2,inputConverter.convertToLowPriority(preprocessedString2));	
		
	}
}
