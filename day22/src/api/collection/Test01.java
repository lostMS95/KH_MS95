package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {

		Set<String> a = new TreeSet<String>();
		List<String> b = new ArrayList<String>();
		
		
		a.add("박보영");				b.add("박보영");				
		a.add("김을동");				b.add("김을동");				
		a.add("아이유");				b.add("아이유");
		a.add("차은우");				b.add("차은우");
		a.add("한지민");				b.add("한지민");
		a.add("태연");					b.add("태연");
		
		
		System.out.println(a.toString());
		System.out.println(b.toString());
	}
}
