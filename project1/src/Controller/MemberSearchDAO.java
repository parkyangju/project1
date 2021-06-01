package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.MemberSearchVO;

public class MemberSearchDAO {
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

	public ArrayList<MemberSearchVO> select_mem() {
		ArrayList<MemberSearchVO> memberList = new ArrayList<MemberSearchVO>();
		getConn();
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int member_no = rs.getInt(1);
				String mem_pw = rs.getString(2);
				String mem_name = rs.getString(3);
				String mem_gender = rs.getString(4);
				String mem_phone = rs.getString(5);
				String mem_period = rs.getString(6);
				int trainer_no = rs.getInt(7);
				memberList.add(new MemberSearchVO(member_no, mem_name, mem_gender, mem_phone, mem_period, trainer_no));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return memberList;
	}
	
	public ArrayList<MemberSearchVO> select_correctmem(String member_num) {
		ArrayList<MemberSearchVO> memberList = new ArrayList<MemberSearchVO>();
		getConn();
		String sql = "select * from member where member_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(member_num));
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				int member_no = rs.getInt(1);
				String mem_pw = rs.getString(2);
				String mem_name = rs.getString(3);
				String mem_gender = rs.getString(4);
				String mem_phone = rs.getString(5);
				String mem_period = rs.getString(6);
				int trainer_no = rs.getInt(7);
				memberList.add(new MemberSearchVO(member_no, mem_name, mem_gender, mem_phone, mem_period, trainer_no));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return memberList;
	}
		
	public ArrayList<MemberSearchVO> search_memName(String name) {
		ArrayList<MemberSearchVO> memberList = new ArrayList<MemberSearchVO>();
		getConn();
		String sql = "select * from member m, trainer t where m.trainer_no=t.trainer_no and m.mem_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int member_no = rs.getInt(1);
				String mem_pw = rs.getString(2);
				String mem_name = rs.getString(3);
				String mem_gender = rs.getString(4);
				String mem_phone = rs.getString(5);
				String mem_period = rs.getString(6);
				int trainer_no = rs.getInt(7);
				String trainer_name = rs.getString(9);
				memberList.add(new MemberSearchVO(member_no, mem_name, mem_gender, mem_phone, mem_period, trainer_no, trainer_name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return memberList;
	}
	
	public ArrayList<MemberSearchVO> trainer_select() {
		ArrayList<MemberSearchVO> memberList = new ArrayList<MemberSearchVO>();
		getConn();
		String sql = "select * from trainer";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int trainer_num = Integer.parseInt(rs.getString(1));
				String trainer_name = rs.getString(2);
				String trainer_gender = rs.getString(3);
				String trainer_phone = rs.getString(4);
				String trainer_sns = rs.getString(5);
				String trainer_image = rs.getString(6);

				memberList.add(new MemberSearchVO(trainer_num, trainer_name, trainer_gender, trainer_phone, trainer_sns, trainer_image));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return memberList;
	}
	
	public ArrayList<MemberSearchVO> trainer_name_select(String name) {
		ArrayList<MemberSearchVO> memberList = new ArrayList<MemberSearchVO>();
		getConn();
		String sql = "select * from trainer where trainer_name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int trainer_num = Integer.parseInt(rs.getString(1));
				String trainer_name = rs.getString(2);
				String trainer_gender = rs.getString(3);
				String trainer_phone = rs.getString(4);
				String trainer_sns = rs.getString(5);
				String trainer_image = rs.getString(6);

				memberList.add(new MemberSearchVO(trainer_num, trainer_name, trainer_gender, trainer_phone, trainer_sns, trainer_image));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return memberList;
	}
	
	public boolean trainer_no_select(String name) {
		getConn();
		String sql = "select * from trainer where trainer_name=?";
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
	
	public int member_register(MemberSearchVO vo) {
		int cnt = 0;
		getConn();
		String sql = "insert into member(member_no, mem_name, mem_gender, mem_phone, period, trainer_no) values(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getMember_no());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getGender());
			psmt.setString(4, vo.getPhone());
			psmt.setString(5, vo.getPeriod());
			psmt.setInt(6, vo.getTrainer_no());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
	public boolean update_memName(int member_num, String mem_name) {
		getConn();
		boolean result = false;
		String sql = "update member set mem_name=? where member_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem_name);
			psmt.setInt(2, member_num);

			int cnt = psmt.executeUpdate();
			if(cnt>0) {
				result = true;
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}
	
	public boolean update_memGender(int member_num, String mem_gender) {
		getConn();
		boolean result = false;
		String sql = "update member set mem_gender=? where member_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem_gender);
			psmt.setInt(2, member_num);

			int cnt = psmt.executeUpdate();
			if(cnt>0) {
				result = true;
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}
	
	public boolean update_memPhone(int member_num, String mem_phone) {
		getConn();
		boolean result = false;
		String sql = "update member set mem_phone=? where member_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem_phone);
			psmt.setInt(2, member_num);

			int cnt = psmt.executeUpdate();
			if(cnt>0) {
				result = true;
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}
	
	public boolean update_memPeriod(int member_num, String mem_period) {
		getConn();
		boolean result = false;
		String sql = "update member set period=? where member_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem_period);
			psmt.setInt(2, member_num);

			int cnt = psmt.executeUpdate();
			if(cnt>0) {
				result = true;
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}
	
	public boolean update_memTrainerNo(int member_num, int trainer_no) {
		getConn();
		boolean result = false;
		String sql = "update member set trainer_no=? where member_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, trainer_no);
			psmt.setInt(2, member_num);

			int cnt = psmt.executeUpdate();
			if(cnt>0) {
				result = true;
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}
	
//	public boolean update_memTrainerName(int trainer_no) {
//		getConn();
//		boolean result = false;
//		String sql = "update trainer set trainer_name=? where member_no = ? ";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, trainer_no);
//			psmt.setInt(2, member_num);
//
//			int cnt = psmt.executeUpdate();
//			if(cnt>0) {
//				result = true;
//			}else {
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//
//		return result;
//	}
	
	public boolean delete_mem(int member_no) {
		getConn();
		boolean result = false;
		String sql = "delete from member where member_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, member_no);

			int cnt = psmt.executeUpdate();
			if(cnt>0) {
				result = true;
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}
	
	public ArrayList<MemberSearchVO> mem_join_trainer() {
		ArrayList<MemberSearchVO> memberList = new ArrayList<MemberSearchVO>();
		getConn();
		String sql = "select * from member m,trainer t where m.trainer_no = t.trainer_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int member_no = rs.getInt(1);
				String mem_pw = rs.getString(2);
				String mem_name = rs.getString(3);
				String mem_gender = rs.getString(4);
				String mem_phone = rs.getString(5);
				String mem_period = rs.getString(6);
				int trainer_no = rs.getInt(7);
				String trainer_name = rs.getString(9);
				
				memberList.add(new MemberSearchVO(member_no, mem_name, mem_gender, mem_phone, mem_period, trainer_no, trainer_name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return memberList;
	}
	
	
}
