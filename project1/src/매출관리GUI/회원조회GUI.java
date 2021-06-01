package 매출관리GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

import Controller.매출관리DAO;
import Model.매출관리VO;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 회원조회GUI {

	private JFrame frame;
	private JTable table;
	int member_no = 0;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					회원조회GUI window = new 회원조회GUI();
//					window.
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public 회원조회GUI(int 회원번호) {
		member_no = 회원번호;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 32, 459, 180);
		frame.getContentPane().add(scrollPane);
		
		매출관리DAO dao = new 매출관리DAO();
		String[] colNames = {"결제번호", "회원번호", "금액", "날짜", "결제수단"};
		ArrayList<매출관리VO> al = dao.회원번호별자료(member_no);
		Object[][] data = new Object[al.size()][5];
		
		
		for(int i=0; i<al.size(); i++) {
			data[i][0] = al.get(i).getPay_no();
			data[i][1] = al.get(i).getMember_no();
			data[i][2] = al.get(i).getMoney();
			data[i][3] = al.get(i).getPay_date();
			data[i][4] = al.get(i).getPay_method();
		}
		
		table = new JTable(data, colNames);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(160, 245, 142, 39);
		frame.getContentPane().add(btnNewButton);
	}

}
