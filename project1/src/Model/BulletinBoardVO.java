package Model;

public class BulletinBoardVO {
	
	private int BB_no;
	private int member_no;
	private String subject;
	private String BB_content;
	
	
	public BulletinBoardVO(int bB_no, int member_no, String subject, String bB_content) {
		super();
		BB_no = bB_no;
		this.member_no = member_no;
		this.subject = subject;
		BB_content = bB_content;
	}


	public int getBB_no() {
		return BB_no;
	}


	


	public int getMember_no() {
		return member_no;
	}


	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}


	public String getSubject() {
		return subject;
	}


	public String getBB_content() {
		return BB_content;
	}
	
	
	

}
