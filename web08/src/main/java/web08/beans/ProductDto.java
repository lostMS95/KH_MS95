package web08.beans;

public class ProductDto {
	
	private int no;
	private String name;
	private String type;
	private int price;
	private String made;
	private String expire;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	public String getExpire() {
		return expire;
	}
	public void setExpire(String expire) {
		this.expire = expire;
	}
	//예시 : 날짜를 원하는 대로 잘라서 반환하는 가상의 getter
		public String getMadeDate() {
			return made.substring(0, 10);
		}
		public String getMadeTime() {
			return made.substring(11, 16);
		}
		public String getExpireDate() {
			return expire.substring(0, 10);
		}
		public String getExpireTime() {
			return expire.substring(11, 16);
	}
		@Override
		public String toString() {
			return "ProductDto [no=" + no + ", name=" + name + ", type=" + type + ", price=" + price + ", made=" + made
					+ ", expire=" + expire + "]";
		}
	
}
