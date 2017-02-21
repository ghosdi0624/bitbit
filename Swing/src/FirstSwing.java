
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MouseEventHandler implements MouseListener{
	// 마우스 버튼이 클릭되었을 때 (눌렸다 풀렸을때) 호출
	public void mouseClicked(MouseEvent e){
		JButton button = (JButton)e.getComponent();
		button.setText("Clicked");
		System.out.println("Clicked Button"+e.getButton());
		System.out.println("마우스 버튼 눌렸다 풀림");
	}
	// 마우스 커서가 버튼위에 올라가면 호출
	public void mouseEntered(MouseEvent e){
		//System.out.println("커서 버튼 위 진입");
	}
	// 마우스 커서가 버튼을 빠져나가면 호출
	public void mouseExited(MouseEvent e){
		//System.out.println("커서 버튼 위 탈출");
	}
	// 마우스 버튼이 눌리는 순간 호출
	public void mousePressed(MouseEvent e){
		//System.out.println("마우스 버튼 눌림");
	}
	// 마우스 버튼이 풀리는 순간 호출
	public void mouseReleased(MouseEvent e){
		//System.out.println("마우스 버튼 풀림");
	}
}

class MyJFrame extends JFrame implements MouseListener{
	MouseListener listener;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	
	public MyJFrame(String title){
		super(title);
		setBounds(120, 120, 400, 100);
		setLayout(new FlowLayout());
		addMouseListener(this);
		
		listener = new MouseEventHandler();
		btn1 = new JButton("My Button");
		btn2 = new JButton("Your Button");
		btn3 = new JButton("Our Button");
		
		btn1.addMouseListener(listener);
		btn2.addMouseListener(listener);
		btn3.addMouseListener(listener);
		
		add(btn1);
		add(btn2);
		add(btn3);
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("JFrame상에서 마우스 버튼 눌렸다 풀림");
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}

public class FirstSwing {

	public static void main(String[] args) {

		JFrame frm = new MyJFrame("Frist Swing");
		frm.setVisible(true);		
		
	}

}
