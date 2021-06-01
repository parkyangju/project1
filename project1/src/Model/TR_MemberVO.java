package Model;

public class TR_MemberVO {
	int num;
	String name;
	String gender;
	String phone;
	String kakaotalkId;
	String image;

	public TR_MemberVO(int num, String name, String gender, String phone, String kakaotalkId, String image) {
		super();
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.kakaotalkId = kakaotalkId;
		this.image = image;

	}

	public TR_MemberVO(int num, String name, String phone) {
		super();
		this.num = num;
		this.name = name;
		this.phone = phone;

	}
	
	public TR_MemberVO(int num, String name) {
		this.num = num;
		this.name = name;
		
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getKakaotalkId() {
		return kakaotalkId;
	}

	public void setKakaotalkId(String kakaotalkId) {
		this.kakaotalkId = kakaotalkId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
