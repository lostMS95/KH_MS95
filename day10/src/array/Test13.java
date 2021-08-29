package array;

public class Test13 {
	public static void main(String[] args) {
		int[] data = new int[] { 30, 50, 20, 10, 40 };

		for (int i = 0; i < data.length / 2; i++) {
			int temp = data[i];
			data[i] = data[data.length - 1 - i];
			data[data.length - 1 - i] = temp;
		}

		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}

	}
}