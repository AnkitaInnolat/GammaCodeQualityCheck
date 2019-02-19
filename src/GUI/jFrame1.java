//this is the base class of jFrame2

package GUI;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class jFrame1 extends JFrame{
	private JLabel item1;
	
	public jFrame1() {
		super("the title bar");		//gives title
		setLayout(new FlowLayout()); 	//sets layout 
		
		item1 = new JLabel("this is a sentence");
		item1.setToolTipText("this is gonna show up on hover");
		add(item1);
	}
}
