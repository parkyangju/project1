package 매출관리GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.매출관리DAO;
import Model.매출관리VO;

public class 날짜조회GUI {

	private JFrame frame;
	private JTable table;
	private JButton btnNewButton;
	String year;
	String month;
	String day;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					날짜조회GUI window = new 날짜조회GUI();
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
	public 날짜조회GUI(String 년, String 월, String 일) {
		year = 년;
		month = 월;
		day = 일;
		
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 575, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 144, 532, 275);
		frame.getContentPane().add(scrollPane);
		
		매출관리DAO dao = new 매출관리DAO();
		String[] colNames = {"결제번호", "회원번호", "금액", "날짜", "결제수단"};
		ArrayList<매출관리VO> al = dao.날짜별자료(year, month, day);
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
		
		btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(206, 463, 113, 37);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("\uB0A0\uC9DC\uBCC4 \uC870\uD68C");
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 36, 441, 75);
		frame.getContentPane().add(lblNewLabel);
	}
}
