package GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Gui extends JFrame{
	private JButton reg;
	private JButton custom;
	
	private JTextField tf;
	private JCheckBox boldbox;
	private JCheckBox italicbox;
	
	private JRadioButton male;
	private JRadioButton female;
	
	private ButtonGroup group;
	
	private JList list;
	private static String[] colornames = {"black","blue","red","white"};
	private static Color[] color= {Color.BLACK,Color.BLUE,Color.RED,Color.WHITE};
	
	public Gui() {
		super("title bar");
		setLayout(new FlowLayout());
		
		reg=new JButton("reg button");
		add(reg);
		
		Icon b=new ImageIcon(getClass().getResource(""));		//give icon in parameter
		custom=new JButton("custom",b);
		add(custom);
		
		tf= new JTextField("This is a Sentence",20);
		tf.setFont(new Font("Serif", Font.PLAIN, 14));
		add(tf);
		
		boldbox=new JCheckBox("bold");
		italicbox=new JCheckBox("italic");
		add(boldbox);
		add(italicbox);
		
		male=new JRadioButton("Male");
		female = new JRadioButton("Female");
		add(male);
		add(female);
		
		group = new ButtonGroup();
		group.add(male);
		group.add(female); 
		
		list=new JList(colornames);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
		
		HandlerClass handler=new HandlerClass();
		reg.addActionListener(handler);					
		custom.addActionListener(handler);
		boldbox.addItemListener(handler);
		italicbox.addItemListener(handler);
		male.addItemListener(handler);
		female.addItemListener(handler);
		list.addListSelectionListener(handler);
	}
	
	private class HandlerClass implements ActionListener,ItemListener,ListSelectionListener{
		public  void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null,String.format("%s", event.getActionCommand()));
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			Font font=null;
			
			if(boldbox.isSelected() && italicbox.isSelected())
				font=new Font("Serif",Font.BOLD + Font.ITALIC,14);
			else if(boldbox.isSelected())
				font=new Font("Serif",Font.BOLD,14);
			else if(italicbox.isSelected())
				font=new Font("Serif",Font.ITALIC,14);
			else
				font=new Font("Serif",Font.PLAIN,14);
			
			tf.setFont(font);
			
			if(male.isSelected()) {
				tf.setText("Male");
			}
			else if(female.isSelected()) {
				tf.setText("Female");
			}
			
		}

		@Override
		public void valueChanged(ListSelectionEvent event) {
			getContentPane().setBackground(color[list.getSelectedIndex()]);
		}
	}
	
	public static void main(String[] args) {
		Gui obj=new Gui();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(300,200);
		obj.setVisible(true);
	}
}
