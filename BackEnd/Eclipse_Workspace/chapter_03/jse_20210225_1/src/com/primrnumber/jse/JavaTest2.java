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
		
		System.out.println("�Ҽ� Ȯ���� ���� ���ڸ� �Է��ϼ���.");
		System.out.println("�����Ϸ��� exit�� �Է��ϼ���.");
		while(true)
		{
			try
			{
				System.out.print("���� �Է� : ");
				tempStr = scan.next();
				inputNum = Integer.parseInt(tempStr);
				if(checkPrimeInstance.isPrimeNum(inputNum))
					System.out.println(inputNum + "��(��) �Ҽ��Դϴ�.");
				else
					System.out.println(inputNum + "��(��) �Ҽ��� �ƴմϴ�.");
			}
			catch (Exception e) 
			{
				if(tempStr.equals("exit"))
					break;
				else
					System.out.println("������ �Է��� �ּ���.");
			}
		}
	}
}