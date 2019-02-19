package Collection;
import java.io.IOException;
import java.util.*;

public class MapsCollections {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException {
		Map map =new HashMap();
		List l=ListFramewrk.lists();
//		System.out.println(l);
		Set s=SetFramewrk.sets();
//		System.out.println(s);
		Map m=MapFramewrk.maps();
//		System.out.println(m);
		
		map.put(1, l);
		map.put(2, s);
		map.put(3,m);
		System.out.println(map);
		
	}
}
