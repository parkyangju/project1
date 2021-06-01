package Model;

public class Healthvo {
	private int reservation_no;
	private int member_no;
	private String tool;
	private String date1;
	private String time1;
	
	
	public Healthvo(int reservation_no, int member_no, String tool, String date1, String time1) {
		super();
		this.reservation_no = reservation_no;
		this.member_no = member_no;
		this.tool = tool;
		this.date1 = date1;
		this.time1 = time1;
	}
	
	
	
	
	public Healthvo(int member_no, String tool, String date1, String time1) {
		super();
		this.member_no = member_no;
		this.tool = tool;
		this.date1 = date1;
		this.time1 = time1;
	}




	public Healthvo(int reservation_no) {
		super();
		this.reservation_no = reservation_no;
	}


	public int getReservation_no() {
		return reservation_no;
	}
	public void setReservation_no(int reservation_no) {
		this.reservation_no = reservation_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
	}
	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}

	

}
