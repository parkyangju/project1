package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.MessageBoxVO;

//import 회원게시판VO.BulletinBoardVO;

public class MessageBoxDAO {

	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
		
	public void connect() {          //연결메소드

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
	
	
	
	public void close() {       // 닫아주는 메소드
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
	
	
	
public ArrayList<MessageBoxVO> selectMs(int 회원번호 ){     //테이블내용을 VO객체에 담아주는 메서드
		
		int send_id1 = 회원번호;
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
			pst.setString(4, "미확인");
			
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
	
	public String View_Ms_content(int num) {         // 보낸사람의 번호를 받아서 내용을 출력해주는 메소드
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
			
			pst.setString(1, "확인");
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
	
	public boolean delete_Ms(int 게시글번호) {
		boolean result = false;
		connect();
		
		String sql = "delete from MessageBox where Ms_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 게시글번호 );
			
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
