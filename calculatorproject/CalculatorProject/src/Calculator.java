

import java.util.ArrayList;

public class Calculator implements ICalculator{
	
	private static InputConverter inputConverter  = new InputConverter();
	
	/**
	 * @param string
	 * @return double
	 */
	@Override
	public double evaluate(String expression) {
		
		
		String preString = inputConverter.stringPreprocessing(expression);
		
		
		ArrayList<String> lowpriorityList = inputConverter.convertToLowPriority(preString);
		
		
		double result = inputConverter.stringListOperation(lowpriorityList,0, 0) ;
		
		
		return result;
	
	}
	
	

	
}
