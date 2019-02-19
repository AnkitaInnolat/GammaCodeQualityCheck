//DROP DOWN LIST

package GUI;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui1 extends JFrame {
	
	private JComboBox box;
	private JLabel picture;
	
	private static String[] filename= {"name1.jpg","name2"};
	private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])) ,new ImageIcon(getClass().getResource(filename[1])) };
	
	public Gui1(){
		super ("the title");
		setLayout(new FlowLayout());
		
		box=new JComboBox(filename);
	
		box.addItemListener(
				new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange()==ItemEvent.SELECTED)
							picture.setIcon(pics[box.getSelectedIndex()]);
					}
					
				}
			);
		add(box);
		picture=new JLabel(pics[0]);
		add(picture);
	}
	
	public static void main(String[] args) {
		Gui1 obj=new Gui1();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(300,200);
		obj.setVisible(true);
	}
}
