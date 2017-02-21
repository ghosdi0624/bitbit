import java.util.Scanner;

class Replace
{
	public void comma(char[] ch)
	{
		for(int i=0; i<ch.length; i++)
		{
			if(ch[i]==' ')
				System.out.print(",");
			else
				System.out.print(ch[i]);
		}
	}
}

public class Main4 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Replace re = new Replace();
		char[] ch = scan.nextLine().toCharArray();
		re.comma(ch);
		
		
		
	
	
	}
}
