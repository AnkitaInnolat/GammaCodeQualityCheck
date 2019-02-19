package GUI;
import javax.swing.JFrame;

public class jFrame2 {
	public static void main(String[] args) {
		jFrame1 obj=new jFrame1();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//always include this to terminate the program when the window is closed
		obj.setSize(500, 300);
		obj.setVisible(true);
	}
}
