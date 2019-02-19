package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mouseEvents extends JFrame {
	private JPanel mousepanel;
	private JLabel statusbar;
	
	public mouseEvents() {
		super("title");
		
		mousepanel=new JPanel();
		mousepanel.setBackground(Color.WHITE);
		add(mousepanel,BorderLayout.CENTER);
		
		statusbar=new JLabel("default");
		add(statusbar,BorderLayout.SOUTH);
		
		handlerClass handler= new handlerClass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener(handler);
		
	}
	
	private class handlerClass implements MouseListener,MouseMotionListener{
		public void mouseClicked(MouseEvent event) {
			statusbar.setText(String.format("Clicked at %d %d", event.getX(),event.getY()));
		}																				
		public void mousePressed(MouseEvent event) {
			statusbar.setText("you pressed down the mouse");								//mouse listener has first five abstract methods 
		}
		public void mouseReleased(MouseEvent event) {
			statusbar.setText("You released the button");
		}
		public void mouseEntered(MouseEvent event) {
			statusbar.setText("you entered the area");
			mousepanel.setBackground(Color.RED);
		}
		public void mouseExited(MouseEvent event) {
			statusbar.setText("you exited the area");
			mousepanel.setBackground(Color.WHITE);
		}
	
		//these are mouse motion events
		public void mouseDragged(MouseEvent event) {
			statusbar.setText("You are dragging the mouse");
		}
		public void mouseMoved(MouseEvent event) {
			statusbar.setText("you moved the mouse");
		}
	}
	public static void main(String[] args) {
		mouseEvents obj=new mouseEvents();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(500,350);
		obj.setLocation(1000, 50);
		obj.setVisible(true);
	}
}
