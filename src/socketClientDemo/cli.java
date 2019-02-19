//client program to send values to server

package socketClientDemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class cli extends JFrame{
	private String msg;

	private JButton SEND;
	private JTextField sendMessage;
	private static String port;
	private static String ip;
	private static String name;
	private JLabel recivedMessage;
	private JTextField recMessage;
	 Socket s=new Socket(ip,Integer.parseInt(port));	//local host and port number
	 PrintStream p = new PrintStream(s.getOutputStream()); 		//pass the num to server through PrintStream
		Scanner sc = new Scanner(s.getInputStream());		//accepts data from client

	public cli() throws UnknownHostException, IOException {
		super("client side application");
		setLayout(new FlowLayout());
		
		recivedMessage = new JLabel("message recieved is :");
		add(recivedMessage);
		
		recMessage=new JTextField(20);
		recMessage.setEditable(false);
		add(recMessage);
		
		sendMessage = new JTextField("Enter your message here",40);
		add(sendMessage);
		
		SEND=new JButton("SEND");
		add(SEND);
		
		HandlerClass handler = new HandlerClass();
		SEND.addActionListener(handler);
		
		
	}
	
	private class HandlerClass implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			p.println(name+": "+sendMessage.getText());
			
		}
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		name=JOptionPane.showInputDialog("enter you name");
		ip=JOptionPane.showInputDialog("Enter IP address");
		port = JOptionPane.showInputDialog("Enter port number");
		cli obj=new cli();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(500,350);
		obj.setLocation(100, 50);
		obj.setVisible(true);
		while(true) {
			try {
				obj.msg=obj.sc.nextLine();
				obj.recMessage.setText(obj.msg);
			}catch(Exception e) {
				obj.recMessage.setText("Server Disconnected");
			}
		}
	}
}