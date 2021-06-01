package Model;

public class Mg_MessageBoxVO {
	
	 int Ms_no;
	 int send_id;
	 int receive_id;
	 String Ms_content; 
	 String Ms_check ;
	
	
	public Mg_MessageBoxVO(int ms_no, int send_id, int receive_id, String ms_content, String ms_check) {
		super();
		Ms_no = ms_no;
		this.send_id = send_id;
		this.receive_id = receive_id;
		Ms_content = ms_content;
		Ms_check = ms_check;
	}


	public void setMs_no(int ms_no) {
		Ms_no = ms_no;
	}


	public void setSend_id(int send_id) {
		this.send_id = send_id;
	}


	public void setReceive_id(int receive_id) {
		this.receive_id = receive_id;
	}


	public void setMs_content(String ms_content) {
		Ms_content = ms_content;
	}


	public void setMs_check(String ms_check) {
		Ms_check = ms_check;
	}


	public int getMs_no() {
		return Ms_no;
	}


	public int getSend_id() {
		return send_id;
	}


	public int getReceive_id() {
		return receive_id;
	}


	public String getMs_content() {
		return Ms_content;
	}


	public String getMs_check() {
		return Ms_check;
	}
	
	
	
	

}
