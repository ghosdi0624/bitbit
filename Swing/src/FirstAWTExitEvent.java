import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FirstAWTExitEvent {

	public static void main(String[] args) {

		Frame frm = new Frame("First Swing");
		frm.setBounds(120, 120, 400, 100);
		frm.setLayout(new FlowLayout());
		
		WindowListener listen = new WindowAdapter(){
			public void windowClosing(WindowEvent ev){
				System.exit(0);
			}
		};
		
		Button bt1 = new Button("My Button");
		Button bt2 = new Button("Your Button");
		Button bt3 = new Button("Our Button");
		
		frm.add(bt1);
		frm.add(bt2);
		frm.add(bt3);
		frm.setVisible(true);
	}

}
