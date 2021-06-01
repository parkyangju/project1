package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.attribute.IntegerSyntax;

import Model.BulletinBoardVO;

public class BulletinBoardDAO {
	
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
	
	
	public boolean BB_Enrollment(int member_no, String subject, String content) {   //게시판 테이블에 저장하는 메소드
		
		boolean result = false;
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);

			String sql = "insert into BulletinBoard values (BulletinBoradSeq.nextval, ?, ? , ?)";

			pst = conn.prepareStatement(sql);

			pst.setInt(1, member_no);
			pst.setString(2, subject);
			pst.setString(3, content); 

			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				result = true;
			} else {
				
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return result;
	}
	
	
	public void All_BB() {                   //전체 게시글 불러오는 메소드
		
		try {
			connect();

			String sql = "select subject from BulletinBoard";

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				String subject = rs.getString("subject");

				System.out.println("< " + subject + " >");

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			close();

		}
		
	}
	
	
	public void one_BB (String subject) {     // 게시글 제목에 따라 내용 불러오는 메소드
		
		try {
			connect();
			
			String sql = "select BB_content from BulletinBoard where subject = ?";
			
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, subject);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String content = rs.getString("BB_content");
				
			System.out.println(content);
			
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			close();
		}
		
	}
	
	
	public ArrayList<BulletinBoardVO> selectBB(){     //테이블내용을 VO객체에 담아주는 메서드
		
		ArrayList<BulletinBoardVO> al = new ArrayList<BulletinBoardVO>();
		
		try {
			
			connect();
			
			String sql = "select * from BulletinBoard order by BB_no";
			
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				int BB_no = rs.getInt(1);
				int member_no = rs.getInt(2);
				String subject = rs.getString(3);
				String BB_content = rs.getString(4);
				
				BulletinBoardVO vo = new BulletinBoardVO(BB_no, member_no, subject, BB_content);
				al.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();


		}
		return al;
		
	}
	
	public String callsubject(String viewNumber) {
		
		String subject = "";
		
		connect();
		
		String sql = "select subject from BulletinBoard where BB_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, Integer.parseInt(viewNumber));
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				subject = rs.getString("subject");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close();
		}
		
		return subject;
		
		
		
	}
	
	
	public String callContent(String viewNumber) {
		
		String content = "";
		
		connect();
		
		String sql = "select BB_content from BulletinBoard where BB_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, Integer.parseInt(viewNumber));
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				content = rs.getString("BB_content");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close();
		}
		
		return content;
	}
	
	
	public int callId(String viewNumber) {
		
		int id = 0;
		
		connect();
		
		String sql = "select member_no from BulletinBoard where BB_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, Integer.parseInt(viewNumber));
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				id = rs.getInt("member_no");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close();
		}
		
		return id;
		
	}
	
	
	public boolean compare (String viewNumber) {
		
		boolean result = false;
		
		connect();
		
		String sql ="select BB_no from BulletinBoard where BB_no=?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(viewNumber));
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				result = true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
		
	}
	
public String callBB_no(int number) {
		
		int bb_no = 0;
		
		connect();
		
		String sql = "select BB_no from BulletinBoard where BB_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, number);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				bb_no = rs.getInt("BB_no");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close();
		}
		
		return Integer.toString(bb_no);
		
	}


	public boolean BBEdit_subject(String number, String Esubject) {
		
		boolean result = false;
		connect();
		
		int num = Integer.parseInt(number);
		
		String sql = "update BulletinBoard set subject =? where BB_no = ?  ";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, Esubject);
			
			pst.setInt(2, num);
			
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
	
	public boolean BBEdit_content(String number, String Econtent) {
		
		boolean result = false;
		connect();
		
		int num = Integer.parseInt(number);
		
		String sql = "update BulletinBoard set BB_content = ? where BB_no = ?  ";
		
		try {
			pst = conn.prepareStatement(sql);
			
			
			pst.setString(1, Econtent);
			pst.setInt(2, num);
			
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
	
	
	public boolean delete (int selectBB) {
		
		boolean result = false;
		connect();
		
		String sql = "delete from BulletinBoard where BB_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, selectBB);
			
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
