package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class multiple_lists extends JFrame {
	private JList left;
	private JList right;
	private JButton movebutton;
	private static String[] foods= {"bacon","wings","ham","beef","more"};
	
	public multiple_lists() {
		super("the title");
		setLayout(new FlowLayout());
		
		left = new JList(foods);
		left.setVisibleRowCount(3);
		left.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(left));
		
		movebutton = new JButton("Move -->");
		movebutton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						right.setListData(left.getSelectedValues());
					}
					
				}
		);
		add(movebutton);
		
		right = new JList();
		right.setVisibleRowCount(3);
		right.setFixedCellWidth(100);
		right.setFixedCellHeight(15);
		right.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(right));
	}
	
	public static void main(String[] args) {
		multiple_lists obj=new multiple_lists();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(300,200);
		obj.setVisible(true);
	}
}
