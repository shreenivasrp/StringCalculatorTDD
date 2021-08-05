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
	
	@Test
	public void checkIfStringContainsDelimiterStartWithLineAndReturnSum() 
	{
		
		assertEquals(3, calculator.add("//;\n1;2"));
	}
	
	@Test
	public void checkIfStringContainsNegativeNumberAndReturnException() 
	{
		try 
		{
			calculator.add("-3,-2,5");
			
			fail("Negative Number Exception expected.");
		}
		
		catch(RuntimeException e)
		{
			assertEquals("Negatives not allowed: [-3, -2]", e.getMessage());
		}
	}
	
	@Test
	public void getAddCallCount()
	{
		
		assertEquals(StringCalculator.getCalledCount(), StringCalculator.getAddCount);
	}

	@Test
	public void checkIfStringContainsNumberGreaterThan1000AndIgnoreTheNo() 
	{
		
		assertEquals(5, calculator.add("5,1002"));
	}
	
	@Test
	public void allowOneDelimiterOfAnyLengthBetweenNumbersAndReturnSum() 
	{
		
		assertEquals(10, calculator.add("//[***]\n3***2***5"));
	}


}
