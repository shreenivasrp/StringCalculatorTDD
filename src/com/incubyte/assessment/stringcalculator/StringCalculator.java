package com.incubyte.assessment.stringcalculator;

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
			String[] newNumbers = numbers.split(",|\n");
			
			return getMultipleNumberSum(newNumbers);
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

}
