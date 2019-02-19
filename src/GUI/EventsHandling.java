//base class for actionListenerDemo

package GUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class EventsHandling extends JFrame {
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField passwordField;
	
	public EventsHandling() {
		super("the title");
		setLayout(new FlowLayout());
		
		item1=new JTextField(10);
		add(item1);
		
		item2 = new JTextField("enter text here");
		add(item2);
		
		item3 = new JTextField("uneditable",20);
		item3.setEditable(false);
		add(item3);
		
		passwordField = new JPasswordField("mypass");
		add(passwordField);
		
		thehandler handler = new thehandler();
		item1.addActionListener(handler);				//handler object is required to handle events from thehandler class  **diff item can handle events from diff class
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		passwordField.addActionListener(handler);
		
	
	}
	
	private class thehandler implements ActionListener{     // in order to handle event in java we need event handling class and that class need to implement ActionListener class
															// ActionListener allow to put listener on something and wait for that event to happen and once it happens it executes 
															// some code

		@Override
		public void actionPerformed(ActionEvent e) {					//this method is executed automatically whenever an event occurs
			String str= "";
			
			if(e.getSource()==item1) 
				str=String.format("field 1: %s",e.getActionCommand());
			else if(e.getSource()==item2)
				str=String.format("field 2: %s",e.getActionCommand());
			else if(e.getSource()==item3)
				str=String.format("field 3: %s",e.getActionCommand());
			else if(e.getSource()==passwordField)
				str=String.format("password field is %s", e.getActionCommand());
		
			JOptionPane.showMessageDialog(null, str);
		}
			
	}
	
}
