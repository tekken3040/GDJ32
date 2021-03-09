package jre_210215_01;

import java.util.Scanner;

public class CalcTest extends CalcClass{
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int inputNum1 = 0;

		int inputNum2 = 0;
		
		int CalcFunc = 0;
		
		Scanner sc = new Scanner(System.in);
		
		CalcClass calc = new CalcClass();
		
		System.out.println("계산할 연산을 선택 하세요 : 1[덧셈] 2[뺄셈] 3[곱셈] 4[나눗셈]");
		try
		{
			CalcFunc = sc.nextInt();
			System.out.println("첫번째 정수를 입력하세요 :");
			inputNum1 = sc.nextInt();
			System.out.println("두번째 정수를 입력하세요 :");
			inputNum2 = sc.nextInt();
			
			switch(CalcFunc)
			{
			case 1:
				System.out.println("덧셈 결과 : " + calc.add(inputNum1, inputNum2));
				break;
				
			case 2:
				System.out.println("뺄셈 결과 : " + calc.subtract(inputNum1, inputNum2));
				break;
					
			case 3:
				System.out.println("곱셈 결과 : " + calc.multiply(inputNum1, inputNum2));
				break;
						
			case 4:
				System.out.println("나눗셈 결과 : " + calc.divide(inputNum1, inputNum2) + "나머지 : " + calc.remainder(inputNum1, inputNum2));
				break;
			}
		}
		catch (Exception e) {
			System.out.println("정수만 입력하세요.");
		}
	}
}