package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.MessageBoxVO;

//import ȸ���Խ���VO.BulletinBoardVO;

public class MessageBoxDAO {

	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
		
	public void connect() {          //����޼ҵ�

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void close() {       // �ݾ��ִ� �޼ҵ�
		try {
			if(pst!=null) {
			pst.close();
			}
			if(conn!=null) {
				conn.close();
			}
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
public ArrayList<MessageBoxVO> selectMs(int ȸ����ȣ ){     //���̺����� VO��ü�� ����ִ� �޼���
		
		int send_id1 = ȸ����ȣ;
		ArrayList<MessageBoxVO> al = new ArrayList<MessageBoxVO>();
		
		try {
			
			connect();
			
			String sql = "select * from MessageBox where receive_id = ?";
			
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, send_id1 );
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				int Ms_no = rs.getInt("Ms_no");
				int send_id = rs.getInt("send_id");
				int receive_id = rs.getInt( "receive_id");
				String Ms_content = rs.getString("Ms_content");
				String Ms_check = rs.getString("Ms_check");
				
				MessageBoxVO vo = new MessageBoxVO(Ms_no, send_id, receive_id, Ms_content, Ms_check);
				al.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();


		}
		return al;
		
	}

	
	public boolean insert_Ms(int receiver, int receive_id, String content) {
		
		boolean result = false;
		connect();
		
		String sql = "insert into MessageBox values(MsSeq.nextval, ?, ?, ?, ?)";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, receiver );
			pst.setInt(2, receive_id );
			pst.setString(3, content);
			pst.setString(4, "��Ȯ��");
			
			int cnt = pst.executeUpdate();
			
			if(cnt>0) {
				result = true;
			}else {
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
		
	}
	
	public String View_Ms_content(int num) {         // ��������� ��ȣ�� �޾Ƽ� ������ ������ִ� �޼ҵ�
		String content = "";
		
		connect();
		
		String sql = "select Ms_content from MessageBox where Ms_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, num);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				content = rs.getString("Ms_content");				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return content;
		
		
		
	}
	
	public boolean changeCheck(int receivenum) {
		
		boolean result = false;
		connect();
		
		String sql = "Update MessageBox set Ms_check = ? where Ms_no = ? ";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, "Ȯ��");
			pst.setInt(2, receivenum);
			
			int cnt = pst.executeUpdate();
			
			if(cnt>0) {
				result = true;
			}else {
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
		
		
		
	}
	
	public boolean delete_Ms(int �Խñ۹�ȣ) {
		boolean result = false;
		connect();
		
		String sql = "delete from MessageBox where Ms_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, �Խñ۹�ȣ );
			
			int cnt = pst.executeUpdate();
			
			if(cnt>0) {
				result = true;
			}else {
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;

	}
	
}
