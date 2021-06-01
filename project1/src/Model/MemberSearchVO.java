package Model;

public class MemberSearchVO {
	int member_no;
	String name;
	String gender;
	String phone;
	String period;
	int trainer_no;
	
	String trainer_name;
	String trainer_gender;
	String trainer_phone;
	String trainer_sns;
	String trainer_image;
	
	public MemberSearchVO(int member_no, String name, String gender, String phone, String period, int trainer_no) {
		super();
		this.member_no = member_no;
		this.name = name;
		this.gender = gender;	
		this.phone = phone;
		this.period = period;
		this.trainer_no = trainer_no;
	}

	public MemberSearchVO(int trainer_no, String trainer_name, String trainer_gender, String trainer_phone,
			String trainer_sns, String trainer_image) {
		super();
		this.trainer_no = trainer_no;
		this.trainer_name = trainer_name;
		this.trainer_gender = trainer_gender;
		this.trainer_phone = trainer_phone;
		this.trainer_sns = trainer_sns;
		this.trainer_image = trainer_image;
	}
	
	public MemberSearchVO(int member_no, String name, String gender, String phone, String period, int trainer_no, String trainer_name) {
		super();
		this.member_no = member_no;
		this.name = name;
		this.gender = gender;	
		this.phone = phone;
		this.period = period;
		this.trainer_no=trainer_no;
		this.trainer_name = trainer_name;
	}

	public int getMember_no() {
		return member_no;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getPhone() {
		return phone;
	}

	public String getPeriod() {
		return period;
	}

	public int getTrainer_no() {
		return trainer_no;
	}
	
	public String getTrainer_name() {
		return trainer_name;
	}

	public String getTrainer_gender() {
		return trainer_gender;
	}

	public String getTrainer_phone() {
		return trainer_phone;
	}

	public String getTrainer_sns() {
		return trainer_sns;
	}

	public String getTrainer_image() {
		return trainer_image;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}

}
