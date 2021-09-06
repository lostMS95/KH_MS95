package api.lang.wrapper;

public class Test06 {
	public static void main(String[] args) {

		Integer a = 10;
		Integer b = 10;
		Integer c = new Integer(10);
		Integer d = new Integer(10);

		System.out.println(a == b);
		System.out.println(b == c);
		System.out.println(c == d);
		System.out.println(d == a);

		System.out.println(a.equals(b));
		System.out.println(b.equals(c));
		System.out.println(c.equals(d));
		System.out.println(d.equals(a));
	}
}
