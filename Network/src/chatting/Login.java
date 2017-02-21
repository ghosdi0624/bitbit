package chatting;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);
      Members members = new Members();
      int choice = 0;
      
      while (true) {
         System.out.println("선택하세요");
         System.out.println("1.회원가입  2.로그인 3.종료");
         choice = scan.nextInt();
         switch (choice) {
         case 1:
            System.out.print("사용하실 ID를 입력하세요 >> ");
            scan.nextLine();
            String id = scan.nextLine();
            System.out.print("사용하실 비밀번호를 입력하세요 >> ");
            String pw = scan.nextLine();
            members.newMember(id,pw);
            break;
         case 2:
            System.out.print("ID를 입력하세요 >> ");
            scan.nextLine();
            id = scan.nextLine();
            System.out.print("비밀번호를 입력하세요 >> ");
            pw = scan.nextLine();
            members.Login(id,pw);
           break;   
         case 3:
            System.out.println("시스템을 종료 합니다.");
            return;
         }
      }
      
   }

}