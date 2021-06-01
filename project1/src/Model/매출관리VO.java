package Model;

public class 概免包府VO {
	
	int Pay_no;
	int Member_no;
	int Money;
	String Pay_date;
	String Pay_method;
	
	
	public 概免包府VO() {
		
	}


	public 概免包府VO(int pay_no, int member_no, int money, String pay_date, String pay_method) {
		super();
		Pay_no = pay_no;
		Member_no = member_no;
		Money = money;
		Pay_date = pay_date;
		Pay_method = pay_method;
	}


	public int getPay_no() {
		return Pay_no;
	}


	public void setPay_no(int pay_no) {
		Pay_no = pay_no;
	}


	public int getMember_no() {
		return Member_no;
	}


	public void setMember_no(int member_no) {
		Member_no = member_no;
	}


	public int getMoney() {
		return Money;
	}


	public void setMoney(int money) {
		Money = money;
	}


	public String getPay_date() {
		return Pay_date;
	}


	public void setPay_date(String pay_date) {
		Pay_date = pay_date;
	}


	public String getPay_method() {
		return Pay_method;
	}


	public void setPay_method(String pay_method) {
		Pay_method = pay_method;
	}
	
	
	
	
	
	
	

}
