package array2d;

import java.util.Random;

public class Test06 {
	public static void main(String[] args) {
		
		int[][] num = new int[5][5];
			
		Random r = new Random();
		
		
		int x = 0, y = 0;
		for(int i = 1; i<=25; i++) {
			
			num[x][y] = r.nextInt(25)+1;
			x++;
			if(x >=5 ) {
				y++;
				x = 0;
			}
		}
	
	
	
		
		
		
		
		
		
		
		
		for(int i = 0; i<num.length; i++) {
			for(int k = 0; k <num[i].length; k++) {
				System.out.print(num[i][k]);
				System.out.print("\t");
			}
		System.out.println();
		System.out.println();
		}
	}
}
