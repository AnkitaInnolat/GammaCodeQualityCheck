//Receiving value from cli

package socketClientDemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ser extends JFrame {
	private String msg;
	private JLabel receivedMessage;
	private JTextField message;
	private static String port;
	private static String name;
	private JTextField sendMessage;
	private JButton SEND;

	ServerSocket s1= new ServerSocket(Integer.parseInt(port));
	Socket ss = s1.accept();			//accept the incoming request from client
	Scanner sc = new Scanner(ss.getInputStream());		//accepts data from client
	PrintStream p = new PrintStream(ss.getOutputStream()); 		//pass the num to server through PrintStream

	public ser() throws IOException {
		super("Server side application");
		setLayout(new FlowLayout());
		
		receivedMessage = new JLabel("message recieved is :");
		receivedMessage.setBounds(300,150,20,40);
		add(receivedMessage);
		
		message=new JTextField(20);
		message.setEditable(false);
		message.setBounds(300,180,20, 40);
		add(message);
		
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
	
	
	public static void main(String[] args) throws Exception {
		
		name=JOptionPane.showInputDialog("enter you name");
		port=JOptionPane.showInputDialog("Enter Listening port number");
		JOptionPane.showMessageDialog(null, "waiting for client connection" );
		ser obj = new ser();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(500,350);
		obj.setLocation(1000, 50);

		obj.setVisible(true);
		
		while(true) {
			try {
				obj.msg=obj.sc.nextLine();
				obj.message.setText(obj.msg);
			}catch(Exception e) {
				obj.message.setText("Client Disconnected");
			}
		}
	
	}
}
