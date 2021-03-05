package sample_project;

public class Singleton {
	public static void main(String[] args) {
		StringBuilder strBuilderSpace = new StringBuilder();
		StringBuilder strBuilderStar = new StringBuilder();
		
		strBuilderSpace.append("    ");
		strBuilderStar.append("*");
		for(int i=0; i<5; i++)
		{
			System.out.print(strBuilderSpace);
			System.out.println(strBuilderStar);
			if(strBuilderSpace.length() > 0)
				strBuilderSpace.deleteCharAt(strBuilderSpace.length()-1);
			strBuilderStar.append("**");
		}
	}
}