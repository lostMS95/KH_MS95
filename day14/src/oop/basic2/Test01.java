package oop.basic2;

public class Test01 {
	public static void main(String[] args) {
		//올림픽 4개국 메달 정보를 구현
		//= Country 객체 4개 생성 후 초기화 및 출력
		Country first = new Country();

		first.countryName = "미국";
		first.gold = 39;
		first.silver = 41;
		first.bronze = 33;
		first.ranking = 1;

		System.out.println(first.countryName);
		System.out.println(first.gold);
		System.out.println(first.silver);
		System.out.println(first.bronze);
		System.out.println(first.ranking);
		

		Country second = new Country();

		second.countryName = "중국";
		second.gold = 38;
		second.silver = 32;
		second.bronze = 18;
		second.ranking = 2;

		System.out.println(second.countryName);
		System.out.println(second.gold);
		System.out.println(second.silver);
		System.out.println(second.bronze);
		System.out.println(second.ranking);
		

		Country third = new Country();

		third.countryName = "일본";
		third.gold = 27;
		third.silver = 14;
		third.bronze = 17;
		third.ranking = 3;

		System.out.println(third.countryName);
		System.out.println(third.gold);
		System.out.println(third.silver);
		System.out.println(third.bronze);
		System.out.println(third.ranking);
	
		Country forth = new Country();

		forth.countryName = "영국";
		forth.gold = 22;
		forth.silver = 21;
		forth.bronze = 22;
		forth.ranking = 4;

		System.out.println(forth.countryName);
		System.out.println(forth.gold);
		System.out.println(forth.silver);
		System.out.println(forth.bronze);
		System.out.println(forth.ranking);
	}
}
