package Collection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MapFramewrk {
	public static void main(String[] args) throws IOException {
		Map<Integer, String> m1 = maps();
		
		System.out.println(m1);
	}

	public static Map<Integer, String> maps() throws IOException {
		Map<Integer,String> m1=new HashMap<Integer,String>();
		
		String line=null;
		FileReader file = new FileReader("G:\\java\\Framework HW\\map.txt");
		BufferedReader br=new BufferedReader(file);
		int i=1;
		while(null!=(line=br.readLine())) {
			m1.put(i,line);
			i++;
		}
		br.close();
//		m1.put(1, "abc");
//		m1.put(2, "ghi");				//if same key is used then the value is overwritten
//		m1.put(3, "def");
		return m1;
	}
}