package com.primrnumber.jse;

import java.util.Scanner;

public class JavaTest2 
{
	public static void main(String[] args) 
	{
		int inputNum = 0;
		String tempStr = "";
		
		Scanner scan = new Scanner(System.in);
		CheckPrimeImpl checkPrimeInstance = new CheckPrimeImpl();
		
		System.out.println("소수 확인을 위한 숫자를 입력하세요.");
		System.out.println("종료하려면 exit를 입력하세요.");
		while(true)
		{
			try
			{
				System.out.print("숫자 입력 : ");
				tempStr = scan.next();
				inputNum = Integer.parseInt(tempStr);
				if(checkPrimeInstance.isPrimeNum(inputNum))
					System.out.println(inputNum + "는(은) 소수입니다.");
				else
					System.out.println(inputNum + "는(은) 소수가 아닙니다.");
			}
			catch (Exception e) 
			{
				if(tempStr.equals("exit"))
					break;
				else
					System.out.println("정수를 입력해 주세요.");
			}
		}
	}
}
