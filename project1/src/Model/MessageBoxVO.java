package Model;

public class MessageBoxVO {
	
	private int Ms_no;
	private int send_id;
	private int receive_id;
	private String Ms_content; 
	private String Ms_check ;
	
	
	public MessageBoxVO(int ms_no, int send_id, int receive_id, String ms_content, String ms_check) {
		super();
		Ms_no = ms_no;
		this.send_id = send_id;
		this.receive_id = receive_id;
		Ms_content = ms_content;
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
