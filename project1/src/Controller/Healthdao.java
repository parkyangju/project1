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
			// 1. jdbc ����̹� �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			// 2. �����ͺ��̽� ���ᰴü(Connection) ����
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
	    	//�����Ű�� �ι�
	    	//1. jdbc ����̹� �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			
			//2.�����ͺ��̽� ���ᰴü ����(connection)����
			 conn = DriverManager.getConnection(url, user, password);
			
			String sql ="insert into Health values(HealthSeq.nextval,?,?,?,?) ";
			//3 sql ���� �غ� ��ü(prepardStatement) ����
			 pst = conn.prepareStatement(sql);
			
			//4.���ε� ������ ä���
			pst.setInt(1, Member_no );
			pst.setString(2,tool);
			pst.setString(3, date1);
			pst.setString(4, time1);
			
			
			//5. sql�� �����ϰ� ��� ó��
			//executeUpdate : insert, delete, update
			int cnt = pst.executeUpdate();
			
			if(cnt>0) {
				
				result = true;
			}else {
			 
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			//������ ���� ������ ����Ǵ� �κ�, ��ü���� �ݾ��ִ� �κ�, �������� �ݴ�� �ۼ�
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		return result;
	
}
//////////////////////////////////////////////////����//////////////////////////////////////////////////////////////
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
	
	
	//////////////////////////////////////////////////����ǥ///////////////////////////////////////////////////////
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
	///////////////////////////////////////////////����///////////////////////////////////////////////////////
	public boolean ����(int reservation_no, int member_no, String tool, String date, String time) {
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
	
	/////////////////////////////////////////////////////����//////////////////////////////////////////////////
	
	public boolean ����(int selnumber) {
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
	///////////////////////////////////////////////////�ʱ�ȭ///////////////////////////////////////////////////////
	public boolean �ʱ�ȭ() {
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
	
	
	public int �����ȣ�ҷ�����(int ȸ����ȣ) {
		int �����ȣ = 0;
		int member_no = ȸ����ȣ;
		connect();
		
		String sql = "select reservation_no from health where member_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, member_no);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				�����ȣ = rs.getInt("reservation_no");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		return �����ȣ;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
