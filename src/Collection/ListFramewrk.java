package Collection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListFramewrk {
	public static void main(String[] args) {
		List<String> li = lists();
		
		System.out.println(li);
	}

	public static List<String> lists() {
		List<String> li=new ArrayList<String>();
		String line=null;
		FileReader file;
		try {
			file = new FileReader("G:\\java\\Framework HW\\list.txt");
			BufferedReader br=new BufferedReader(file);
			
			try {
				while(null!=(line=br.readLine())) {
					li.add(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		li.add("Arrays");
//		li.add("String");
//		li.add("OOPS");
//		li.add("Inhertance");
		return li;
	}
}
