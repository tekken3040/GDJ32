package jre_210215_01;

public class CalcClass implements CalcInterface{

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		int addResult = x + y;
		return addResult;
	}

	@Override
	public int subtract(int x, int y) {
		// TODO Auto-generated method stub
		int subResult = x - y; 
		return subResult;
	}

	@Override
	public int multiply(int x, int y) {
		// TODO Auto-generated method stub
		int multiResult = x * y;
		return multiResult;
	}

	@Override
	public float divide(int x, int y) {
		// TODO Auto-generated method stub
		float divideResult = x / y;
		return divideResult;
	}

	@Override
	public int remainder(int x, int y) {
		// TODO Auto-generated method stub
		int remainderResult = x % y;
		return remainderResult;
	}
}
