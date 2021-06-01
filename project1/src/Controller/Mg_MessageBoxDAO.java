package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.MemberVO;
import Model.Mg_MessageBoxVO;

//import 회원게시판VO.BulletinBoardVO;

public class Mg_MessageBoxDAO {

	
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
	
	
	
public ArrayList<Mg_MessageBoxVO> selectMs(int 관리자번호 ){     //테이블내용을 VO객체에 담아주는 메서드
		
		
		ArrayList<Mg_MessageBoxVO> al = new ArrayList<Mg_MessageBoxVO>();
		
		try {
			
			connect();
			
			String sql = "select * from MessageBox where receive_id = ?";
			
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, 관리자번호);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				int Ms_no = rs.getInt("Ms_no");
				int send_id = rs.getInt("send_id");
				int receive_id = rs.getInt( "receive_id");
				String Ms_content = rs.getString("Ms_content");
				String Ms_check = rs.getString("Ms_check");
				
				Mg_MessageBoxVO vo = new Mg_MessageBoxVO(Ms_no, send_id, receive_id, Ms_content, Ms_check);
				al.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();


		}
		return al;
		
	}

	
	public boolean insert_Ms(int 관리자번호, int receive_id, String content) {
		
		boolean result = false;
		connect();
		
		String sql = "insert into MessageBox values(MsSeq.nextval, ?, ?, ?, ?) ";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, 관리자번호 );
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
	
	public String View_Ms_content(int 메시지번호) {         // 보낸사람의 번호를 받아서 내용을 출력해주는 메소드
		String content = "";
		
		connect();
		
		String sql = "select Ms_content from MessageBox where Ms_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, 메시지번호);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				content = rs.getString("Ms_content");				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return content;
		
		
		
	}
	
	public boolean changeCheck(int 메시지번호) {
		
		boolean result = false;
		connect();
		
		String sql = "Update MessageBox set Ms_check = ? where Ms_no = ? ";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, "확인");
			pst.setInt(2, 메시지번호);
			
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
	
	

	
	
	public boolean delete_Ms(int 메시지번호) {
		boolean result = false;
		connect();
		
		String sql = "delete from MessageBox where Ms_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 메시지번호 );
			
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
	
	
	
	public ArrayList<MemberVO> AllMember(){             //모든 회원정보를 어레이 리스트에 저장
		ArrayList<MemberVO> al = new ArrayList<MemberVO>();
		
		connect();
		String sql = "select * from member";
		
		try {
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMEMBER_NO(rs.getInt("member_no"));
				vo.setMEM_PW(rs.getString("mem_pw"));
				vo.setMEM_NAME(rs.getString("mem_name"));
				vo.setMEM_GENDER(rs.getString("mem_gender"));
				vo.setMEM_PHONE(rs.getString("mem_phone"));
				vo.setPERIOD(rs.getString("period"));
				vo.setTRAINER_NO(rs.getInt("trainer_no"));
				
				
				al.add(vo);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		return al;
		
		
	}
	
	
	
	public boolean ALLSend(Mg_MessageBoxVO vo) {            //전체메시지전송
		
		boolean result = false;
		connect();
				
		try {
			String sql = "insert into MessageBox values (MsSeq.nextval, ?,?,?,?)";
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, 0000);
			pst.setInt(2, vo.getReceive_id());
			pst.setString(3, vo.getMs_content());
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
	
	
	
	
	
	
	
	
	
	
}
