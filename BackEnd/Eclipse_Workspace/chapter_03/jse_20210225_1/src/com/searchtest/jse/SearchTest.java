package com.searchtest.jse;

public class SearchTest 
{
	/**
	 * �˻��� ��� ���忡�� Ư�� �˻����� ������  ��ȯ�ϴ� �޼���
	 * @param target �˻��� ����
	 * @param searchWord �˻���
	 * @return �˻��� ����
	 */
	public static int getCountBySearchWord(String target, String searchWord) 
	{
		// ī���� ������ �ۼ��Ͽ� �ʱ�ȭ�մϴ�
		int cnt = 0;
		
		// �˻��� ����� �Ǵ� ����(target)�� �� �ܾ "�и�"�մϴ�.
		String[] strArray = target.split(" ");
		
		// �ݺ���(for)�� Ȱ���Ͽ� �ܾ� �ӿ� �˻�� "����"�Ǿ� �ִ��� 
		// ���θ� �����Ͽ� ������ ī���͸� ������ŵ�ϴ�.
		for(int i=0; i<strArray.length; i++)
		{
			if(strArray[i].contains(searchWord))
				cnt++;
		}
		
		// ��ü������ ������ ī���� ������ ����(��ȯ)�մϴ�.
		return cnt;
	}
	
	public static void main(String[] args) 
	{
		String sentence = "Ŭ���� ��ǻ��(����: cloud computing)�� "
				+ "Ŭ����(���ͳ�)�� ���� ����ȭ�� ��ǻ���� �ý��۸��ҽ�(IT ���ҽ�)�� "
				+ "�䱸�ϴ� ��� ����(on-demand availability)�ϴ� ���̴�. "
				+ "���ͳ� ��� ��ǻ���� �������� ������ �ڽ��� ��ǻ�Ͱ� �ƴ� Ŭ����(���ͳ�)�� "
				+ "����� �ٸ� ��ǻ�ͷ� ó���ϴ� ����� �ǹ��Ѵ�. ���� ��ǻ�� ó�� �ڿ��� �����͸� "
				+ "��ǻ�Ϳ� �ٸ� ��ġ�鿡 ��û �� �������ش�. ���� ������ ��ǻ�� �ڿ�(��: ��ǻ�� ��Ʈ��ũ, "
				+ "������ ���̽�, ����, ���丮��, ���ø����̼�, ����, ���ڸ�����)�� ���� "
				+ "��𼭳� ������ �� �ִ�, �ֹ��� ����(on-demand availability "
				+ "of computer system resources)�� �������ϴ� ���̸� "
				+ "�ּ����� ���� ������� ������ ���� �� �������� ������ �Ѵ�. Ŭ���� ��ǻ�ð� "
				+ "���丮�� �ַ�ǵ��� ����ڿ� ����鿡�� ���� ������ Ÿ�� ������ ������ �����͸� ����, "
				+ "�����ϴ� �پ��� ����� �����ϸ� ���ø� ���� �� ����α��� ��ġ�� ���� �� �ִ�. "
				+ "Ŭ���� ��ǻ���� ������� ���� ���¸��� ����� �ϰ��� �� �Ը��� ������ �޼��ϱ� ���� "
				+ "�ڿ��� ������ �����Ѵ�.";
		
		System.out.println(getCountBySearchWord(sentence, "����"));
		// System.out.println(getCountBySearchWord(sentence, "��ǻ��"));
	}
}