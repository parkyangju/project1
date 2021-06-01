package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.매출관리VO;

public class 매출관리DAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void connect() { // 연결메소드

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

	public void close() { // 닫아주는 메소드
		try {
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<매출관리VO> selectPay() {

		ArrayList<매출관리VO> al = new ArrayList<매출관리VO>();

		connect();

		String sql = "select * from payment";

		try {
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {

				int pay_no = rs.getInt("pay_no");
				int member_no = rs.getInt("member_no");
				int money = rs.getInt("money");
				String pay_date = rs.getString("pay_date");
				String pay_method = rs.getString("pay_method");

				매출관리VO vo = new 매출관리VO(pay_no, member_no, money, pay_date, pay_method);
				al.add(vo);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return al;
	}

	public String AllPayment() {

		int allpay = 0;
		connect();

		String sql = "select money from payment";

		try {
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {

				allpay = allpay + rs.getInt("money");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return Integer.toString(allpay);

	}

	public ArrayList<매출관리VO> 날짜별자료(String year, String month, String day) {
		ArrayList<매출관리VO> al = new ArrayList<매출관리VO>();

		connect();

		String sql = "select * from payment where to_char(pay_date,'YYYYMMDD') = ?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, year + month + day);

			rs = pst.executeQuery();

			while (rs.next()) {

				int pay_no = rs.getInt("pay_no");
				int member_no = rs.getInt("member_no");
				int money = rs.getInt("money");
				String pay_date = rs.getString("pay_date");
				String pay_method = rs.getString("pay_method");

				매출관리VO vo = new 매출관리VO(pay_no, member_no, money, pay_date, pay_method);
				al.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return al;

	}

	public ArrayList<매출관리VO> 회원번호별자료(int 회원번호) {
		ArrayList<매출관리VO> al = new ArrayList<매출관리VO>();

		connect();

		String sql = "select * from payment where member_no = ?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, 회원번호);

			rs = pst.executeQuery();

			while (rs.next()) {

				int pay_no = rs.getInt("pay_no");
				int member_no = rs.getInt("member_no");
				int money = rs.getInt("money");
				String pay_date = rs.getString("pay_date");
				String pay_method = rs.getString("pay_method");

				매출관리VO vo = new 매출관리VO(pay_no, member_no, money, pay_date, pay_method);
				al.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return al;

	}

	public String 카드총금액() {

		int allcard = 0;

		connect();

		String sql = "select money from payment where pay_method = ?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, "카드");
			rs = pst.executeQuery();

			while (rs.next()) {
				allcard = allcard + rs.getInt("money");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return Integer.toString(allcard);

	}

	public String 현금총금액() {

		int allcard = 0;

		connect();

		String sql = "select money from payment where pay_method = ?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, "현금");
			rs = pst.executeQuery();

			while (rs.next()) {
				allcard = allcard + rs.getInt("money");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return Integer.toString(allcard);

	}

	public String 올해총매출(int 현재년도) {
		String year1 = Integer.toString(현재년도)+"-01-01";
		String year2 = Integer.toString(현재년도)+"-12-31";

		int yearmoney = 0;
		connect();
		String sql = "select money from payment where pay_date between ? and ?";

		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, year1);
			pst.setString(2, year2);
			rs = pst.executeQuery();

			while (rs.next()) {
				yearmoney += rs.getInt("money");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return Integer.toString(yearmoney);

	}
	
	
	public String 이번달매출(int 현재년도, int 현재월) {
		String month1 = Integer.toString(현재년도)+"-"+Integer.toString(현재월)+"-1";
		String month2 = Integer.toString(현재년도)+"-"+Integer.toString(현재월)+"-31";
		
		int monthmoney = 0;
		connect();
		String sql = "select money from payment where pay_date between ? and ?";

		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, month1);
			pst.setString(2, month2);
			rs = pst.executeQuery();

			while (rs.next()) {
				monthmoney += rs.getInt("money");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return Integer.toString(monthmoney);

	}
	
	
	
	public String 오늘매출(int 현재년도, int 현재월, int 현재일) {
		String day = Integer.toString(현재년도)+"-"+Integer.toString(현재월)+"-"+Integer.toString(현재일);
		
		int daymoney = 0;
		connect();
		String sql = "select money from payment where pay_date = ?";

		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, day);
			
			rs = pst.executeQuery();

			while (rs.next()) {
				daymoney += rs.getInt("money");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return Integer.toString(daymoney);

	}
	
	
	
	
	

}
