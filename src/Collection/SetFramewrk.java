package Collection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SetFramewrk {
	public static void main(String[] args) throws IOException{
		Set<String> s = sets();
		
		System.out.println(s);
	}

	public static Set<String> sets() throws IOException {
		Set<String> s= new HashSet<String>();
		
		String line=null;
		FileReader file = new FileReader("G:\\java\\Framework HW\\set.txt");
		BufferedReader br=new BufferedReader(file);
		
		while(null!=(line=br.readLine())) {
			s.add(line);
		}
//		s.add("123");
//		s.add("456");
//		s.add("789");
//		s.add("123");				// it will not be included in set coz it is already present
//		s.add("147");
		return s;
	}
}
