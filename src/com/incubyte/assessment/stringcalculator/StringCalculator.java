package com.incubyte.assessment.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator 
{
	
	public int add(String numbers) 
	{ 
		
		if(numbers.isEmpty() || numbers == null)
		{
			return 0;
		}
		
		else if(numbers.contains(",") || numbers.contains("\n"))
		{			
			
			return getMultipleNumberSum(getStringTokens(numbers));
		}

		else
		{
			return Integer.parseInt(numbers);
		}
	
	}
	
	private static int getMultipleNumberSum(String [] number)
    {       
        int sum = 0;
        
        for(String addNumber : number)
        {
		    sum = sum + Integer.parseInt(addNumber);
		}
        
		return sum;
    }
	
	private static String [] getStringTokens(String number)
    {
		if(number.startsWith("//"))
		{
			return supportDifferentDelimiterAndSplit(number);
		}
		
		else
		{
			return supportNewlineAndCommasDelimiterAndSplit(number);
		}
    }
	
	private static String[] supportNewlineAndCommasDelimiterAndSplit(String number)
	{
		String[] numberSplit = number.split(",|\n");
		
		return numberSplit;
	}

	private static String[] supportDifferentDelimiterAndSplit(String number)
	{
		Matcher checkNumberMatch = Pattern.compile("//(.)\n(.*)").matcher(number);
		
		checkNumberMatch.matches();
		
		String delimiter = checkNumberMatch.group(1);
		
		String newNumber = checkNumberMatch.group(2);
		
		return newNumber.split(delimiter);
	}
	
	

}
