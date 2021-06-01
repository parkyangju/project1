package Controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.TR_MemberVO;

public class TR_MemberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	private void getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void close() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
 
	public ArrayList<TR_MemberVO> select() {
		ArrayList<TR_MemberVO> memberList = new ArrayList<TR_MemberVO>();
		getConn();
		String sql = "select * from trainer";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int num = Integer.parseInt(rs.getString(1));
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String phone = rs.getString(4);
				String kakaotalkId = rs.getString(5);
				String image = rs.getString(6);

				memberList.add(new TR_MemberVO(num, name, gender, phone, kakaotalkId, image));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return memberList;
	}

	public boolean name_select(String name) {
		getConn();
		String sql = "select * from trainer where name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return false;
	}
	
	public ArrayList<TR_MemberVO> select_mem() {
		ArrayList<TR_MemberVO> memberList = new ArrayList<TR_MemberVO>();
		getConn();
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int num = Integer.parseInt(rs.getString(1));
				String name = rs.getString(2);
				String phone = rs.getString(3);

				memberList.add(new TR_MemberVO(num, name, phone));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return memberList;
	}
	
	public int update_mem(TR_MemberVO vo) {
		getConn();
		int cnt = 0;
		String sql = "update member set trainer_no = ? where mem_name = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNum());
			psmt.setString(2, vo.getName());

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
}
