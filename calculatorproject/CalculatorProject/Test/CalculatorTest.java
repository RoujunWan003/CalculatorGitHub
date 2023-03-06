
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeEach
	void setup() 
	{
		calculator = new Calculator();
	}
	/*                      Test Cases Agenda
	
		1. Test String clean up
		2. Basic Operations
		
			Addition Test
			Subtraction Test
			Multiplication 
			Division
			Power with Integer Exponent
			Bracket
			
		3. Test BODMAS
		
	     ( Bracket > Order > Division or Multiplication > Addition and Subtraction)
			
			Division or Multiplication and Addition or Subtraction
			Division or Multiplication and Addition or Subtraction and Order
			Division or Multiplication and Addition or Subtraction and Order and Bracket
			BODMAS in Bracket
			BODMAS in and out Bracket
	*/
	///////////////////////////////////////////////////////////////////////
	
	//1. Test Remove empty space and double operator

	@Test
	void test_evaluate_main_Test_Remove_empty_space()
	{
		String String = "  0 +     1. 7 5 -       5  ";
		assertEquals(-3.25, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_Test_Remove_empty_space2()
	{
		String String = " 1279 9.3   - 0 .23 +     1. 7  5 ";
		assertEquals(12800.82, calculator.evaluate(String),1e-6);
	}

	@Test
	void test_evaluate_main_Test_combine_double_operators_doubleMinos()
	{
		String String = " 1 -- 1  ";
		assertEquals(2, calculator.evaluate(String),1e-6);
	}

	@Test
	void test_evaluate_main_Test_combine_double_operators_doublePlus()
	{
		String String = " 3.5 ++ 1  ";
		assertEquals(4.5, calculator.evaluate(String),1e-6);
	}

	@Test
	void test_evaluate_main_Test_combine_double_operators_minosPlus()
	{
		String String = " 3.5 -+ 7.9  ";
		assertEquals(-4.4, calculator.evaluate(String),1e-6);
	}

	@Test
	void test_evaluate_main_Test_combine_double_operators_PlusMinos()
	{
		String String = " -3.5 +- 7.9  ";
		assertEquals(-11.4, calculator.evaluate(String),1e-6);
	}

	@Test
	void test_evaluate_main_Test_combine()
	{
		String String = "-3.14  +- 2-+11 --0.12 ++ 2.55";
		assertEquals(-13.47, calculator.evaluate(String),1e-6);
	}
    
	//////////////////////////////////////////////////////////////////////////////
							
								//Addition Test
	
	@Test
	void test_evaluate_main_addition_of_two_integer_numbers()
	{
		String String = "1+1";
		assertEquals(2, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_addition_of_two_integer_numbers2()
	{
		String String = "0+0";
		assertEquals(0, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_addition_of_two_negative_integer_numbers()
	{
		String String = "-1+-4";
		assertEquals(-5, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_addition_of_one_positive_and_one_negative_integer()
	{
		String String = "-1+4";
		assertEquals(3, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_addition_of_one_positive_and_one_negative_numbers()
	{
		String String = "-1.567+4.3568";
		assertEquals(2.7898, calculator.evaluate(String),1e-6);
	}
	
	///////////////////////////////////////////////////////////////////////
	
	    						//Subtraction Test
	
	@Test
	void test_evaluate_main_Subtraction_of_two_integer_numbers()
	{
		String String = "5-1";
		assertEquals(4, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_Subtraction_of_two_integer_numbers2()
	{
		String String = "0-0";
		assertEquals(0, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_Subtraction_of_two_negative_integer_numbers()
	{
		String String = "-1--4";
		assertEquals(3, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_Subtraction_of_one_positive_and_one_negative_integer()
	{
		String String = "-1-4";
		assertEquals(-5, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_Subtraction_of_one_positive_and_one_negative_numbers()
	{
		String String = "-1.567-4.3568";
		assertEquals(-5.9238, calculator.evaluate(String),1e-6);
	}
	
	///////////////////////////////////////////////////////////////////////
	
								//Multiplication 
	
	@Test
	void test_evaluate_main_Test_multiplication_of_two_integer_numbers()
	{
		String String = "2*3";
		assertEquals(6, calculator.evaluate(String),1e-6);
	}
	@Test
	void test_evaluate_main_multiplication_of_two_negative_integer_numbers()
	{
		String String = "-1*-4";
		assertEquals(4, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_multiplication_of_one_positive_and_one_negative_integer()
	{
		String String = "-1*4";
		assertEquals(-4, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_multiplication_of_one_positive_and_one_negative_numbers()
	{
		String String = "-1.567*4.3568";
		assertEquals(-6.827105, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_multiplication_check_zero_multiplier()
	{
		String String = " 47894.24368 * 0  ";
		assertEquals(0, calculator.evaluate(String),1e-6);
	}
	
	///////////////////////////////////////////////////////////////////////
	
								//Division
	
	@Test
	void test_evaluate_main_main_Test_division_of_two_integer_numbers()
	{
		String String = "1/5";
		assertEquals(0.2, calculator.evaluate(String),1e-6);
	}

	@Test
	void test_evaluate_main_division_of_two_negative_integer_numbers()
	{
		String String = "-1/-4";
		assertEquals(0.25, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_division_of_one_positive_and_one_negative_integer()
	{
		String String = "-1/4";
		assertEquals(-0.25, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_division_of_one_positive_and_one_negative_numbers()
	{
		String String = "-1.567/4.3568";
		assertEquals(-0.3596676, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_division_check_zero_divider()
	{
		String String = " 47894.24368 / 0  ";
		assertEquals(Double.POSITIVE_INFINITY, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_division_check_zero_divider2()
	{
		String String = " -47894.24368 / 0  ";
		assertEquals(Double.NEGATIVE_INFINITY, calculator.evaluate(String),1e-6);
	}
	


	///////////////////////////////////////////////////////////////////////
	
								//Power (Integer Exponent)

	
	@Test
	void test_evaluate_main_check_power_positive_base_and_positive_exponent()
	{
		String String = " 19.3 ^8  ";
		assertEquals(1.925122953e10, calculator.evaluate(String),1);
	}
	@Test
	void test_evaluate_main_check_power_positive_base_and_positive_exponent2()
	{
		String String = " 1.3 ^8  ";
		assertEquals(8.157307, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_check_power_negative_base_and_positive_exponent()
	{
		String String = " -10 ^8  ";
		assertEquals(1e8, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_check_power_negative_base_and_positive_exponent3()
	{
		String String = " -23.6^2 ";
		assertEquals(556.96, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_check_power_positive_base_and_negative_exponent()
	{
		String String = " 19.3 ^-8  ";
		assertEquals(5.194473e-11, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_power_negative_base_and_negative_exponent1()
	{
		String String = " -1.5 ^-3  ";
		assertEquals(-0.296296, calculator.evaluate(String),1e-6);
	}

	@Test
	void test_evaluate_main_check_power_zero_base_and_positive_exponent()
	{
		String String = " 0 ^3  ";
		assertEquals(0, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_check_power_positive_base_and_zero_exponent()
	{
		String String = " 19.3 ^0  ";
		assertEquals(1, calculator.evaluate(String),1e-6);
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
										// Brackets
	
	@Test
	void test_evaluate_main_string_start_with_bracket()
	{
		String String = "(1+5)*3";
		assertEquals(18, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_bracket_in_middel()
	{
		String String = "7*(1+5)*3";
		assertEquals(126, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_string_end_with_bracket()
	{
		String String = "7*(1+5)";
		assertEquals(42, calculator.evaluate(String),1e-6);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	
							//        Test BODMAS
	     // Bracket > Order > Division or Multiplication > Addition and Subtraction
	
	@Test
	void test_evaluate_main_Multiplication_and_Addition()
	{
		String String = " 2+478.5*-10.54+23.6*1.23";
		assertEquals(-5012.362, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_Multiplication_and_Subtraction()
	{
		String String = " 2-478.5*10.54-23.6*1.23";
		assertEquals(-5070.418, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_Multiplication_and_Addition_and_Subtraction()
	{
		String String = "2-478.5*10.54-23.6*1.23+3.278*10-6";
		assertEquals(-5043.638, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_Division_and_Addition()
	{
		String String = " 2+478.5/-10.54+23.6/1.23";
		assertEquals(-24.211490, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_Division_and_Subtraction()
	{
		String String = " 2-478.5/-10.54-23.6/1.23";
		assertEquals(28.211490, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_Division_and_Addition_and_Subtraction()
	{
		String String = "2-478.5/-10.54-23.6/1.23+3.278/10-6";
		assertEquals(22.539290, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Division_Multiplication_Addition_and_Subtraction()
	{
		String String = "2-478.5*-10.54-23.6/1.23+3.278/10-6";
		assertEquals(5020.530808, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Division_Multiplication_Addition_and_Subtraction2()
	{
		String String = "-4.6489+225373.3*0.12245+2374/234.65+200/10.53+429.2";
		assertEquals(28050.622233, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Division_Multiplication_Addition_and_Subtraction_and_order()
	{
		String String = " -478.5*10.54+5^6-2 ";
		assertEquals(10579.61, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Division_Multiplication_Addition_and_Subtraction_and_order2()
	{
		String String = " -478.5*10.54+5^-6-3 ";
		assertEquals(-5046.389680, calculator.evaluate(String),1e-3);
	}
	
	@Test
	void test_evaluate_main_with_Division_Multiplication_Addition_and_Subtraction_and_order3()
	{
		String String = "478.5*10.54+5^-6-3^2";
		assertEquals(5034.390064, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Division_Multiplication_Addition_and_Subtraction_and_order4()
	{
		String String = "478.5^-1*10.54^2+5^-6-3^2";
		assertEquals(-8.767769, calculator.evaluate(String),1e-6);
	}
	
	
	@Test
	void test_evaluate_main_with_Division_Multiplication_Addition_and_Subtraction_and_Bracket()
	{
		String String = " 23.6*-478.5*10.54+(5+6)/2-5 ";
		assertEquals(-119023.504, calculator.evaluate(String),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Division_Multiplication_Addition_and_Subtraction_and_Bracket2()
	{
		String String = " 58.76/48.5234*10.54+(5+6)*192-5";
		assertEquals(2119.763541, calculator.evaluate(String),1e-3);
	}
	
	@Test
	void test_evaluate_main_with_Multiplication_Addition_and_Subtraction_and_PositiveNumberInBrackets()
	{
		String String3 = "3.2+6.5*(-38-12.567)";
		assertEquals(-325.4855, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Multiplication_Addition_and_Subtraction_and_PositiveNumberInBrackets2()
	{
		String String3 = "-1-38*-12.567/(4.2+-4)";
		assertEquals(2386.73, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Multiplication_Addition_and_Subtraction_and_NegativeNumberInBrackets1()
	{
		String String3 = "-3.2*6.5*(0-3879.64)";
		assertEquals(80696.512, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Multiplication_Addition_and_Subtraction_and_NegativeNumberInBrackets2()
	{
		String String3 = "-1-38*-12.567/(4.2+4-8+6)";
		assertEquals(76.023548, calculator.evaluate(String3),1e-6);
	}
	
	
	@Test
	void test_evaluate_main_with_Multiplication_Addition_and_Subtraction_and_NegativeNumberInBrackets3()
	{
		String String3 = "-1-38*-12.567/(4.2+-4-8+6)";
		assertEquals(-266.303333, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_test_evaluate_main_with_Multiplication_Addition_and_Subtraction_and_ZeroInBrackets()
	{
		String String3 = "-1-38*-12.567/(4.2-4.2+0)";
		assertEquals(Double.POSITIVE_INFINITY, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_test_evaluate_main_with_Multiplication_Addition_and_Subtraction_and_ZeroInBrackets2()
	{
		String String3 = "896.34*3.21+5/(4.2-2.1-2.1+0)";
		assertEquals(Double.POSITIVE_INFINITY, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Multiplication_Addition_and_Subtraction_and_order_and_PositiveNumberInBrackets()
	{
		String String3 = "-8.54^-1+(-38*-12.567)";
		assertEquals(477.428904, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Multiplication_Divistion_Addition_and_Subtraction_and_negativeorder_and_PositiveNumberInBrackets()
	{
		String String3 = "-8.54^-1+(-38*-12.567)/4.2";
		assertEquals(113.5843326, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_with_Multiplication_Divistion_Addition_and_Subtraction_and_positiveorder_and_PositiveNumberInBrackets()
	{
		String String3 = "-8.54^4+(-38*-12.567)/4.2";
		assertEquals(5432.719707, calculator.evaluate(String3),1e-6);
	}

	@Test
	void test_evaluate_main_Test3_Check_order_in_Brackets()
	{
		String String3 = "-3.2+-6.5++(3^9)";
		assertEquals(19673.3, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_Test3_Check_order_with_negative_exponent_in_Brackets2()
	{
		String String3 = "-3.2+-6.5++ (2^-3)";
		assertEquals(-9.575, calculator.evaluate(String3),1e-6);
	}
	@Test
	void test_evaluate_main_Test3_Check_order_with_negative_exponent_in_Brackets3()
	{
		String String3 = "(2.5^-2)-3.2+-6.5++ 2^-3";
		assertEquals(-9.415, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_Test3_Check_BODMAS_in_Brackets1()
	{
		String String3 = "-12.567/(4.2+5*3-7)";
		assertEquals(-1.030081, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_Test3_Check_BODMAS_in_Brackets2()
	{
		String String3 = "-12.567/(4.2+5^3/7)";
		assertEquals(-0.569747, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_Test3_Check_BODMAS_in_Brackets3()
	{
		String String3 = "-12.567/(4.2+5^3/7+2.31*100)";
		assertEquals(-0.049660, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_Test3_Check_BODMAS_in_Brackets5()
	{
		String String3 = "-1+90/(-8.54^-1-38*-12.567/4.20)";
		assertEquals(-0.207637, calculator.evaluate(String3),1e-6);
	}	
	
	@Test
	void test_evaluate_main_Test3_Check_BODMAS_in_Brackets6()
	{
		String String3 = "-1.55+9/(4.2+5^3/7+2.31*100-100)";
		assertEquals(-1.491198, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_Test3_Check_BODMAS_in_Brackets7()
	{
		String String3 = "(4.2+5^3/7+2.31*100)/-12.567";
		assertEquals(-20.136639, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_Test3_Check_BODMAS_in_and_out_Brackets1()
	{
		String String3 = "100^-1+90*9.81/(4.2+5^3/7+2.31*100-100)";
		assertEquals(5.778433, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_Test3_Check_BODMAS_in_and_out_Brackets2()
	{
		String String3 = "289+90/(4.2+5^3/7+2.31*100-100/100+6^-1)";
		assertEquals(289.3122573, calculator.evaluate(String3),1e-1);
	}
	
	@Test
	void test_evaluate_main_Test3_Check_BODMAS_in_and_out_Brackets3()
	{
		String String3 = "2.533^3-9.023/(4.56-5^5/2.12-2.31/100+100/10+6^-2)";
		assertEquals(16.258135, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_Test3_Check_BODMAS_in_and_out_Brackets4()
	{
		String String3 = "(2+32.533^3-9.023*2)/4.56-5^5/2.12-2.31/100+100/10+6^-2";
		assertEquals(6083.481837, calculator.evaluate(String3),1e-6);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
                      //Combined
	@Test
	void test_evaluate_main_other_case_long_input()
	{
		String String3 = "     289++  90/4.2+5^3/7++ 2 .31*100 -100/100 +6^-1+2.533^ 3 -9.02 3/(4.56-5^5 /2.1 2-+2.31/100   +100/1 0+6^-2)";
		assertEquals(574.710516, calculator.evaluate(String3),1e-6);
	}
	
	@Test
	void test_evaluate_main_other_case_2()
	{
		String String3 = "5.23*(152.82901-353.820163+8.3537389)*253.7291-26115739*2.37^4";
		assertEquals(-824195851.498, calculator.evaluate(String3),1e-2); 
	}
	
	@Test
	void test_evaluate_main_other_case_small_and_big_number3()
	{
		String String3 = "823^-3+2537291-2617*237^-4+0.2357398+0.0342625-0.00352";
		assertEquals(2537291.26648, calculator.evaluate(String3),1e-5); 
	}
	

}
