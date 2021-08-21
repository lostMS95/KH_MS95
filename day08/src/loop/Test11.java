package loop;
//import java.lang.*;
public class Test11 {
	public static void main(String[] args) {
		
		int count = 0;
		
		for(int i = 1 ; i < 100 ; i ++) {
			//boolean first = i >= 50 && i < 60;
			boolean first = i / 10 == 5;
			boolean second = i % 10 == 5;
			if(first || second) {
				//System.out.println("i = " + i);
				count++;
			}
		}
		
		System.out.println("count = " + count);
		
	}
}
