//add 2 number using input dialog


package GUI;
import javax.swing.JOptionPane;
public class GUIDemo {
	public static void main(String[] args) {
		String fn = JOptionPane.showInputDialog("Enter first number");   // input dialog box appears and wait for input which is stored in String fn  
		String sn = JOptionPane.showInputDialog("Enter second number");

		int num1 = Integer.parseInt(fn); 								 //converts the string format number to integer format (String "4" to int 4)
		int num2 = Integer.parseInt(sn);
		int sum=num1+num2;
		
		JOptionPane.showMessageDialog(null, "the sum is "+sum, "firstGUI", JOptionPane.PLAIN_MESSAGE);
	}
}
