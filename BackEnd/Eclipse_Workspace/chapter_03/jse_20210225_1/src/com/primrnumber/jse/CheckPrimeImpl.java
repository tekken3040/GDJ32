package com.primrnumber.jse;

public class CheckPrimeImpl implements CheckPrime
{
	@Override
	public boolean isPrimeNum(int num) 
	{
		// TODO Auto-generated method stub
		int j=2;
		boolean flag = true;
		
		while(j<=(int)Math.sqrt(num))
		{
			if(num % j == 0)
			{
				flag = false;
				break;
			}
			else
			{
				j++;
				flag = true;
			}
		}
		return flag;
	}
}
