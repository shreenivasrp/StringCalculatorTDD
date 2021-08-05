package com.incubyte.assessment.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator 
{
	
	public static int getAddCount = 0;
	
	public int add(String numbers) 
	{ 
		getAddCount++;
		
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
        
        int size = number.length;
        
		// int[] newNumber = new int[size];
		
		int checkValidNumber = 0;
		
		String str = "";
				
		List <Integer> negativeNumbers = new ArrayList<>();
		
		List <Integer> ignoredNumbers = new ArrayList<>();
		
		for(int i = 0; i<size; i++)
		{
			Matcher match = Pattern.compile("^(\\+|-)?\\d+$").matcher(number[i]);
			
			while(match.find())
			{	
				str = match.group();
				
				checkValidNumber = Integer.parseInt(number[i]);

				if(checkValidNumber < 0)
				{
					negativeNumbers.add(checkValidNumber);
				}
				if(checkValidNumber > 1000)
				{
					checkValidNumber = 0;
				}
				
				ignoredNumbers.add(checkValidNumber);
				
				sum = sum + checkValidNumber;
			 }
        	       		
		}
		
		if(negativeNumbers.size() > 0)
		{
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers);
		}
        
		return sum;
    }
	
	private static String [] getStringTokens(String number)
    {
		if(number.startsWith("//"))
		{
			if(number.startsWith("//["))
			{
				return supportDifferentDelimiterAnyLengthAndSplit(number);
			}
			
			else
			{
				return supportDifferentDelimiterAndSplit(number);
			}			
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
	
	private static String[] supportDifferentDelimiterAnyLengthAndSplit(String number)
	{
		Matcher checkNumberMatch = Pattern.compile("//(\\[.+\\])\n(.*)").matcher(number);
		
		checkNumberMatch.matches();
		
		String delimiter = checkNumberMatch.group(1);
		
		String newNumber = checkNumberMatch.group(2);
		
		return newNumber.split(delimiter);
	}
	
	public static int getCalledCount()
	{
		return getAddCount;
	}

}

