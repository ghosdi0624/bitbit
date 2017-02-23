
public class numberTest {

	public static void main(String[] args) {
		
		// 1~10000±îÁö ¼ýÀÚÁß 8ÀÌ ¸î¹ø µé¾î°¡´ÂÁö
		
		int count = 0;
		
		for(int i=0; i<10000; i++){
			
	/*		if(i%10==0){
				count++;
			}
			if(i%100==0){
				count += 10;
			}
			if(i%1000==0){
				count += 100;
			}
			if(i%10000==0){
				count += 1000;
			}*/
			int num = i;
			while(num != 0)
			{
				if(num % 10 == 8) count++;
				num /= 10;
			}
			
		}
		
		System.out.println(count);
		System.out.println("하이용");
		// °æÅÂ ºÁ¹Ù¶ó~~~~~
		// change Name
		// ¤»¤»¤»¤»¤»
		
	}

}
