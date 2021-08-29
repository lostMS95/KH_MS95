package array;

public class Test15 {
	public static void main(String[] args) {

		// 입력
		int[] data = new int[] { 30, 50, 20, 10, 40 };

		// 처리 : 선택정렬에서 1회차 정렬을 수행(가장 작은 값을 앞에 배치)

		// 최소값 찾기
		int minIndex = 0;// 맨 앞 위치가 가장 작다고 생각
		for (int i = 1; i < data.length; i++) {
			System.out.println(minIndex + "위치와 " + i + "위치의 데이터를 비교!");
			if (data[minIndex] > data[i]) {// 더 작은 데이터가 발견되었다면
				minIndex = i;// 위치 정보를 변경
			}
		}
		System.out.println("가장 작은 데이터 위치 : " + minIndex);

		// 교체(swap) : minIndex와 맨 앞(0)의 데이터를 교체
		int temp = data[minIndex];
		data[minIndex] = data[0];
		data[0] = temp;

		// 출력
		System.out.print("[");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			if (i < data.length - 1) {// 마지막 데이터가 아니라면
				System.out.print(" , ");
			}
		}
		System.out.print("]");
		System.out.println();

	}
}