import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

//====================================================================
// 객체타입을 파일에 저장하기 !!
//	- 숫자형태의 이진데이타
//	- 문자형태의 텍스트
//	- 클래스 타입의 변수를 파일에 저장 !! (객체 타입)
//====================================================================


class Student implements Serializable
{
	int studentNo;
	String name;
	int score;
	
	public Student(int studentNo, String name, int score) 
	{
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.score = score;
	}

	public void show()
	{
		System.out.println("학번 : " + studentNo + "이름 : " + name + "점수 : " + score);
	}
}

public class IO6 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		/*
		Student s1 = new Student(1, "김철수", 100);
		Student s2 = new Student(2, "이철수", 100);
		Student s3 = new Student(3, "길철수", 100);
		
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.stu"));
		
			out.writeObject(s1);
			out.writeObject(s2);
			out.writeObject(s3);
			
			out.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		*/
		
		// Object.stu 파일에서 객체를 읽어 ArrayList에 저장
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.stu"));
		
/*		Student s1 = (Student)in.readObject();
		Student s2 = (Student)in.readObject();
		Student s3 = (Student)in.readObject();
*/
		ArrayList<Student> list = new ArrayList<Student>();
		Student s;
		try
		{
			while(true)
			{
				Object o = in.readObject();
				if(o==null)
					break;
				
			list.add((Student)o);
			
			}
		}
		catch(EOFException e){
			System.out.println(e.getMessage());
		}
		finally
		{
			
		}
		// 출력
		for (Student student : list)
		{
			student.show();
		}
		in.close();
		
	}

}
