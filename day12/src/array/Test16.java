package array;

public class Test16 {
	public static void main(String[] args) {

		int arr[] = new int[] { 3, 38, 44, 5, 47, 15, 36 };

		for (int h = arr.length - 1; h > 0; h--) {
			for (int k = 0; k < h; k++) {
				if (arr[k] > arr[k + 1]) {
					int temp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(" , ");
			}
		}
		System.out.println();
	}
}
