package com.incubyte.assessment.stringcalculatortest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.incubyte.assessment.stringcalculator.StringCalculator;

class StringCalculatorTest 
{

	StringCalculator calculator = new StringCalculator();
	
	@Test
	public void checkIfStringIsEmptyAndReturnZero() 
	{
	
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void checkIfStringHasOnlyOneNumberAndReturnNumberItself() 
	{
		
		assertEquals(2, calculator.add("2"));
	}
	
	@Test
	public void checkIfStringHasTwoNumbersDelimitedByCommaAndReturnSum() 
	{
		
		assertEquals(5, calculator.add("3,2"));
	}
	
	@Test
	public void checkIfStringHasMultipleNumbersDelimitedByCommaAndReturnSum() 
	{
		
		assertEquals(10, calculator.add("3,2,5"));
	}
	
	@Test
	public void allowNewLineAsValidDelimiterBetweenNumbersAndReturnSum() 
	{
		
		assertEquals(10, calculator.add("3\n2,5"));
	}

}
