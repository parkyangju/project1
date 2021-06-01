package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Healthvo;
import Model.MemberVO;

public class Healthdao {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void connect() {
		try {
			// 1. jdbc 드라이버 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			// 2. 데이터베이스 연결객체(Connection) 생성
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
			if(rs != null) {
				rs.close(); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public boolean insertHealth(int Member_no, String tool, String date1, String time1) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;
	    try {
	    	//실행시키는 부문
	    	//1. jdbc 드라이버 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			
			//2.데이터베이스 연결객체 생성(connection)생성
			 conn = DriverManager.getConnection(url, user, password);
			
			String sql ="insert into Health values(HealthSeq.nextval,?,?,?,?) ";
			//3 sql 구문 준비 객체(prepardStatement) 생성
			 pst = conn.prepareStatement(sql);
			
			//4.바인드 변수를 채운다
			pst.setInt(1, Member_no );
			pst.setString(2,tool);
			pst.setString(3, date1);
			pst.setString(4, time1);
			
			
			//5. sql문 실행하고 결과 처리
			//executeUpdate : insert, delete, update
			int cnt = pst.executeUpdate();
			
			if(cnt>0) {
				
				result = true;
			}else {
			 
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			//오류가 나도 무조건 실행되는 부분, 객체들을 닫아주는 부분, 생성순서 반대로 작성
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		return result;
	
}
//////////////////////////////////////////////////예약//////////////////////////////////////////////////////////////
	public boolean Reservation(Healthvo vo) {
		boolean result = false;
		connect();
		String sql = "insert into Health values(healthseq.nextval,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, vo.getMember_no());
			pst.setString(2, vo.getTool());
			pst.setString(3, vo.getDate1());
			pst.setString(4, vo.getTime1());
			
			
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
	
	
	//////////////////////////////////////////////////예약표///////////////////////////////////////////////////////
	public ArrayList<Healthvo> AllSelect() {
		ArrayList<Healthvo> list = new ArrayList<Healthvo>();

		connect();
		String sql = "select * from Health order by tool,  date1, time1 ";

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				int reservation_no = rs.getInt(1);
				int member_no = rs.getInt(2);
				String tool = rs.getString(3);
				String date1 = rs.getString(4);
				String time1 = rs.getString(5);
				Healthvo vo = new Healthvo( reservation_no, member_no, tool, date1, time1); 
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	///////////////////////////////////////////////수정///////////////////////////////////////////////////////
	public boolean 수정(int reservation_no, int member_no, String tool, String date, String time) {
		boolean result = false;
		connect();
		String sql = "update Health set  tool=?, date1=?, time1=?  where reservation_no = ?";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, tool);
			pst.setString(2, date);
			pst.setString(3, time);
			pst.setInt(4, reservation_no);
			
			
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
	
	/////////////////////////////////////////////////////삭제//////////////////////////////////////////////////
	
	public boolean 삭제(int selnumber) {
		boolean result = false;
		connect();
		String sql = "delete from Health where reservation_no = ?";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, selnumber);
			
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
	///////////////////////////////////////////////////초기화///////////////////////////////////////////////////////
	public boolean 초기화() {
		boolean result = false;
		connect();
		String sql = "delete from Health";
		try {
			pst = conn.prepareStatement(sql);
						
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
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public int 예약번호불러오기(int 회원번호) {
		int 예약번호 = 0;
		int member_no = 회원번호;
		connect();
		
		String sql = "select reservation_no from health where member_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, member_no);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				예약번호 = rs.getInt("reservation_no");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		return 예약번호;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
