package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.MemberVO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public void connect() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// new orcle 오른쪽클릭 맨마지막 눌러서 커넥션 url 가져오면 댐
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		// 2. 데이터 베이스 연결 객체(Connection ) 생성
		conn = DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(pst !=null) {
				pst.close();
			}
			if(conn !=null) {
				conn.close();
			}
			if(rs != null) {
				rs.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MemberVO loginSelect(int MEMBER_NO, String MEM_PW) {
		MemberVO vo =null;
		
		connect();
		String sql = "select * from member where MEMBER_NO=? and MEM_PW=?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, MEMBER_NO);
			pst.setString(2, MEM_PW);
			rs = pst.executeQuery(); //쿼리는 셀렉트할때 쓰고, 업데이트는 변경될때, 
			while(rs.next()) {
				int selId = rs.getInt(1);
				String selpw = rs.getString(2);
				String selName = rs.getString(3);
				String selgender = rs.getString(4);
				String selphone = rs.getString(5);
				vo= new MemberVO(selId, selpw, selName, selgender, selphone);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		
		}
		
		return vo;
	}

	public int joinInsert(MemberVO vo) {
		
		int cnt =0;
		connect();
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,vo.getMEMBER_NO());
			pst.setString(2,vo.getMEM_PW());
			pst.setString(3,vo.getMEM_NAME());
			pst.setString(4,vo.getMEM_GENDER());
			pst.setString(5,vo.getMEM_PHONE());
			pst.setString(6,vo.getPERIOD());
			pst.setInt(7,vo.getTRAINER_NO());
			
			cnt = pst.executeUpdate();	
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	public boolean id_select(String id) {
		connect();
		String sql = "select * from member where MEMBER_NO=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return false;
	}
	
	
	public boolean selectName(String name) {
		connect();
		String sql = "select * from member where MEM_NAME=?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(3, name);
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		return false;
	}
	
	
}
