package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.�������VO;

public class �������DAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void connect() { // ����޼ҵ�

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

	public void close() { // �ݾ��ִ� �޼ҵ�
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

	public ArrayList<�������VO> selectPay() {

		ArrayList<�������VO> al = new ArrayList<�������VO>();

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

				�������VO vo = new �������VO(pay_no, member_no, money, pay_date, pay_method);
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

	public ArrayList<�������VO> ��¥���ڷ�(String year, String month, String day) {
		ArrayList<�������VO> al = new ArrayList<�������VO>();

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

				�������VO vo = new �������VO(pay_no, member_no, money, pay_date, pay_method);
				al.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return al;

	}

	public ArrayList<�������VO> ȸ����ȣ���ڷ�(int ȸ����ȣ) {
		ArrayList<�������VO> al = new ArrayList<�������VO>();

		connect();

		String sql = "select * from payment where member_no = ?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, ȸ����ȣ);

			rs = pst.executeQuery();

			while (rs.next()) {

				int pay_no = rs.getInt("pay_no");
				int member_no = rs.getInt("member_no");
				int money = rs.getInt("money");
				String pay_date = rs.getString("pay_date");
				String pay_method = rs.getString("pay_method");

				�������VO vo = new �������VO(pay_no, member_no, money, pay_date, pay_method);
				al.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return al;

	}

	public String ī���ѱݾ�() {

		int allcard = 0;

		connect();

		String sql = "select money from payment where pay_method = ?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, "ī��");
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

	public String �����ѱݾ�() {

		int allcard = 0;

		connect();

		String sql = "select money from payment where pay_method = ?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, "����");
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

	public String �����Ѹ���(int ����⵵) {
		String year1 = Integer.toString(����⵵)+"-01-01";
		String year2 = Integer.toString(����⵵)+"-12-31";

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
	
	
	public String �̹��޸���(int ����⵵, int �����) {
		String month1 = Integer.toString(����⵵)+"-"+Integer.toString(�����)+"-1";
		String month2 = Integer.toString(����⵵)+"-"+Integer.toString(�����)+"-31";
		
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
	
	
	
	public String ���ø���(int ����⵵, int �����, int ������) {
		String day = Integer.toString(����⵵)+"-"+Integer.toString(�����)+"-"+Integer.toString(������);
		
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
