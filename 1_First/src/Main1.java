
public class Main1 {

	public static void main(String[] args) {
		
		for(int i=2; i<=9; i=i+3)
		{
			for(int j=1; j<=9; j++)
			{
				if(i<=7)
				{
					System.out.printf("%dx%d= %-2d  ",i,j,j*i);
					System.out.printf("%dx%d= %-2d  ",i+1,j,j*(i+1));
					System.out.printf("%dx%d= %-2d  \n",i+2,j,j*(i+2));
				}
				else
				{
					System.out.printf("%dx%d= %-2d  ",i,j,j*i);
					System.out.printf("%dx%d= %-2d  \n",i+1,j,j*(i+1));
				}
			}	
		}	
		
	}
}
