package oop.multi6.box;

//내가 직접 저장할 형태를 작성해가면서 사용할 수 있는 상자
//= 클래스 옆에다가 <> 를 적고 사이에 이름을 적으면 해당하는 이름을 자료형 처럼 사용 가능
//= AllInOneBox<E> 라고 적으면 E 라는 미지의 자료형의 데이터를 저장할 수 있는 상자
//= Generic class(제네릭 클래스)라고 한다
public class AllInOneBox <E>{

	private E value;

	public void setValue(E value) {
		this.value = value;
	}

	public E getValue() {
		return this.value;
	}

}
