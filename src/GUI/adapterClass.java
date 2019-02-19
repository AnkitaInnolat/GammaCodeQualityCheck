package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class adapterClass extends JFrame{
	private String details;
	private JLabel statusbar;
	
	public adapterClass() {
		super("tilte");
		
		statusbar=new JLabel("this is default");
		add(statusbar,BorderLayout.SOUTH);
		addMouseListener(new mouseClass());
		
	}
	
	private class mouseClass extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			details = String.format("You clicked %d", e.getClickCount());
			
			if(e.isMetaDown())
				details += " with right mouse button";
			else if(e.isAltDown())
				details+= " with  center mouse button";
			else
				details +=" with left mouse button";
		
			statusbar.setText(details);
		}
	}
	public static void main(String[] args) {
		adapterClass obj=new adapterClass();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(800,500);
		obj.setVisible(true);
	}
}
