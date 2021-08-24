package array;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
	
		int[] arr = new int[3];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 3개 입력 : ");
		
		
		
		
		for(int i =0; i <3; i++) {
		arr[i] = sc.nextInt();
	
		}
		sc.close();
		
		int total = 0;
		for(int i = 0; i<3; i++) {
			total += arr[i];
		}
		
		for(int i = 0; i <3; i++) {
		System.out.println("점수 = " + arr[i]);
		
		}
		System.out.println("total = " + total);
	}
	
		}
