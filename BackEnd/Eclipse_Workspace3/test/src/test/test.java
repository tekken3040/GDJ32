package test;

import java.util.Scanner;

public class test 
{
	// 1번 문제   답 : 2050333330
	/*
	public static void main(String[] args) 
	{
		int sum = 0;
		
		for(int i=1; i<101; i++)
		{
			sum += Math.pow(i, 4);
		}
		
		System.out.println("Sum : " + sum);
	}*/
	
	// 2번 문제   답 : 1734174
	/*
	public static void main(String[] args) 
	{
		int num = 1234567890;
		int sum = 0;
		
		for(int i=500000; i>0; i--)
		{
			if(num % i == 0)
				sum += i;
		}
		
		System.out.println("Sum : " + sum);
	}*/
	
	// 3번 문제   답 : 1675
	/*
	public static void main(String[] args) 
	{
		double nNum = 0f;
        int num = 1;
        
        while(true)
        {
            nNum += 1.0 / num;
            num++;
            if( nNum > 8 )
            {
                break;
            }
        }
		
		System.out.println("Num : " + num);
	}*/
	
	// 4번 문제   답 : 110894536
	/*
	public static void main(String[] args) 
	{
		int sum = 0;
		
		for(int i=20000; i>0; i--)
		{
			if(i % 3 == 0)
				sum+=i;
			else if(String.valueOf(i).contains("3"))
				sum+=i;
		}
		
		System.out.println("Sum : " + sum);
	}*/
	
	// 5번 문제   답 : 2450
	public static void main(String[] args) 
	{
		int num = 1;
        int sum = 0;
        int sum2 = 0;

        for( int i = 1000000; i > 0; i-- )
        {
            sum = 0;
            num = 1;
            String str = String.valueOf(i);
            int length = str.length();
    
            while(true)
            {
                sum++;
                
                for( int j = 0; j < length; j++ )
                {
                    if( j + 1 <= length )
                    {
                        num *= Integer.parseInt( str.substring( j, j+1 ) );
                    }
                }
                str = String.valueOf(num);
                length = str.length();
                //Console.WriteLine( "Sum : " + sum );
                if( num < 10 )
                {
                    break;
                }
                num = 1;
            }
            if( sum == 7 )
                sum2++;
        }
		
		System.out.println("Sum : " + sum2);
	}
}