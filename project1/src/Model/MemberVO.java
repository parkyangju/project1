package Model;

public class MemberVO {

	private int MEMBER_NO;
	private String MEM_PW;
	private String MEM_NAME;
	private String MEM_GENDER;
	private String MEM_PHONE;
	private String PERIOD;
	private int TRAINER_NO;
	
	
	public MemberVO() {
		super();
	}

	public MemberVO(int MEMBER_NO, String MEM_PW, String MEM_NAME, String MEM_GENDER, String MEM_PHONE, String PERIOD, int TRAINER_NO) {
		super();
		this.MEMBER_NO = MEMBER_NO;
		this.MEM_PW = MEM_PW;
		this.MEM_NAME = MEM_NAME;
		this.MEM_GENDER = MEM_GENDER;
		this.MEM_PHONE = MEM_PHONE;
		this.PERIOD = PERIOD;
		this.TRAINER_NO = TRAINER_NO;
		
	}



	public void setMEMBER_NO(int mEMBER_NO) {
		MEMBER_NO = mEMBER_NO;
	}

	public void setMEM_PW(String mEM_PW) {
		MEM_PW = mEM_PW;
	}

	public void setMEM_NAME(String mEM_NAME) {
		MEM_NAME = mEM_NAME;
	}

	public void setMEM_GENDER(String mEM_GENDER) {
		MEM_GENDER = mEM_GENDER;
	}

	public void setMEM_PHONE(String mEM_PHONE) {
		MEM_PHONE = mEM_PHONE;
	}

	public void setPERIOD(String pERIOD) {
		PERIOD = pERIOD;
	}

	public void setTRAINER_NO(int tRAINER_NO) {
		TRAINER_NO = tRAINER_NO;
	}

	

	public int getMEMBER_NO() {
		return MEMBER_NO;
	}
	public String getMEM_PW() {
		return MEM_PW;
	}

	public String getMEM_NAME() {
		return MEM_NAME;
	}

	public String getMEM_GENDER() {
		return MEM_GENDER;
	}

	public String getMEM_PHONE() {
		return MEM_PHONE;
	}

	public String getPERIOD() {
		return PERIOD;
	}

	public int getTRAINER_NO() {
		return TRAINER_NO;
	}


	public MemberVO(int MEMBER_NO, String MEM_PW, String MEM_NAME, String MEM_GENDER, String MEM_PHONE) { 
		this.MEMBER_NO = MEMBER_NO;
		this.MEM_PW = MEM_PW;
		this.MEM_NAME = MEM_NAME;
		this.MEM_GENDER = MEM_GENDER;
		this.MEM_PHONE = MEM_PHONE;
	}
	
}
