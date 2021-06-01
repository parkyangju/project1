package 매출관리GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.매출관리DAO;
import GUI.관리자GUI;
import Model.매출관리VO;

public class 매출관리main {

	private JFrame frame;
	private JTable table;
	private JTextField 회원번호입력란;
	private JTextField tf_올해총매출;
	private JTextField tf_카드;
	private JTextField tf_현금;
	private JTextField 총매출;
	private JTextField tf_이번달매출;
	private JTextField tf_오늘매출;
	private JTextField 오늘날짜;
	String year = "";
	String month = "";
	String day = "";
	int 회원번호 = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					매출관리main window = new 매출관리main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public 매출관리main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		SimpleDateFormat format = new SimpleDateFormat ("yyyy-mm-dd");
//		String format_time = format.format(System.currentTimeMillis());

		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.KOREA);
		Date currentTime = new Date();
		String mTime = mSimpleDateFormat.format(currentTime);

		Calendar cal = Calendar.getInstance();
		int 현재년도 = cal.get(cal.YEAR);
		int 현재월 = cal.get(cal.MONTH) + 1;
		int 현재일 = cal.get(cal.DATE);

		DecimalFormat formatter = new DecimalFormat("###,###");

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 736, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		매출관리DAO dao = new 매출관리DAO();
		String[] colNames = { "결제번호", "회원번호", "금액", "날짜", "결제수단" };
		ArrayList<매출관리VO> al = dao.selectPay();
		Object[][] data = new Object[al.size()][5];

		for (int i = 0; i < al.size(); i++) {
			data[i][0] = al.get(i).getPay_no();
			data[i][1] = al.get(i).getMember_no();
			data[i][2] = al.get(i).getMoney();
			data[i][3] = al.get(i).getPay_date();
			data[i][4] = al.get(i).getPay_method();
		}

		JPanel 전체매출 = new JPanel();
		전체매출.setBounds(12, 79, 579, 446);
		frame.getContentPane().add(전체매출);
		전체매출.setToolTipText("");
		전체매출.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 72, 555, 236);
		전체매출.add(scrollPane);

		DefaultTableModel model = new DefaultTableModel(data, colNames) { // 더블클릭 하면 값입력 못하게 방지
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		table = new JTable(model);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("\uC62C\uD574 \uCD1D\uB9E4\uCD9C :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel.setBounds(283, 330, 81, 27);
		전체매출.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uCE74\uB4DC \uACB0\uC81C :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(43, 364, 69, 27);
		전체매출.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uD604\uAE08 \uACB0\uC81C :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_2.setBounds(43, 401, 69, 27);
		전체매출.add(lblNewLabel_2);

		회원번호입력란 = new JTextField();
		회원번호입력란.setBounds(384, 7, 81, 21);
		전체매출.add(회원번호입력란);
		회원번호입력란.setColumns(10);

		JComboBox 회원번호콤보박스 = new JComboBox();

		회원번호콤보박스.setModel(
				new DefaultComboBoxModel(new String[] { "\uD68C\uC6D0\uBC88\uD638", "\uCE74\uB4DC", "\uD604\uAE08" }));
		회원번호콤보박스.setToolTipText("");
		회원번호콤보박스.setBounds(284, 7, 88, 21);
		전체매출.add(회원번호콤보박스);

		JButton btn_회원조회 = new JButton("\uC870\uD68C");
		btn_회원조회.setForeground(Color.WHITE);
		btn_회원조회.setFont(new Font("한컴 고딕", Font.BOLD, 12));
		btn_회원조회.setBackground(Color.DARK_GRAY);
		btn_회원조회.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (회원번호입력란.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "회원번호를 입력하세요!");
				} else {
					회원번호 = Integer.parseInt(회원번호입력란.getText());
					회원조회GUI b = new 회원조회GUI(회원번호);
				}
			}
		});
		btn_회원조회.setBounds(470, 5, 81, 23);
		전체매출.add(btn_회원조회);

		tf_올해총매출 = new JTextField();
		tf_올해총매출.setBounds(376, 333, 94, 21);
		전체매출.add(tf_올해총매출);
		tf_올해총매출.setColumns(10);
		tf_올해총매출.setText(formatter.format(Integer.parseInt(dao.올해총매출(현재년도))));

		tf_카드 = new JTextField();
		tf_카드.setColumns(10);
		tf_카드.setBounds(124, 370, 94, 21);
		전체매출.add(tf_카드);
		tf_카드.setText(formatter.format(Integer.parseInt(dao.카드총금액())));

		tf_현금 = new JTextField();
		tf_현금.setColumns(10);
		tf_현금.setBounds(124, 407, 94, 21);
		전체매출.add(tf_현금);
		tf_현금.setText(formatter.format(Integer.parseInt(dao.현금총금액())));

		총매출 = new JTextField();
		총매출.setColumns(10);
		총매출.setBounds(124, 333, 94, 21);
		전체매출.add(총매출);
		총매출.setText(formatter.format(Integer.parseInt(dao.AllPayment())));

		JLabel lblNewLabel_3 = new JLabel("       \uCD1D\uB9E4\uCD9C :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_3.setBounds(31, 330, 81, 27);
		전체매출.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC774\uBC88\uB2EC \uB9E4\uCD9C :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_4.setBounds(276, 364, 88, 27);
		전체매출.add(lblNewLabel_4);

		tf_이번달매출 = new JTextField();
		tf_이번달매출.setColumns(10);
		tf_이번달매출.setBounds(375, 367, 94, 21);
		전체매출.add(tf_이번달매출);
		tf_이번달매출.setText(formatter.format(Integer.parseInt(dao.이번달매출(현재년도, 현재월))));

		JLabel lblNewLabel_5 = new JLabel(" \uC624\uB298 \uB9E4\uCD9C :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_5.setBounds(271, 401, 93, 27);
		전체매출.add(lblNewLabel_5);

		tf_오늘매출 = new JTextField();
		tf_오늘매출.setColumns(10);
		tf_오늘매출.setBounds(376, 404, 94, 21);
		전체매출.add(tf_오늘매출);
		tf_오늘매출.setText(formatter.format(Integer.parseInt(dao.오늘매출(현재년도, 현재월, 현재일))));

		오늘날짜 = new JTextField();
		오늘날짜.setBounds(12, 7, 116, 21);
		전체매출.add(오늘날짜);
		오늘날짜.setColumns(10);
		오늘날짜.setText(mTime);

		JComboBox 년도 = new JComboBox();
		년도.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year = 년도.getSelectedItem().toString();
				회원번호입력란.setText("");
			}
		});
		년도.setModel(new DefaultComboBoxModel(new String[] { "\uB144\uB3C4", "2019", "2020", "2021" }));
		년도.setToolTipText("");
		년도.setBounds(262, 38, 59, 21);
		전체매출.add(년도);

		JComboBox 월 = new JComboBox();
		월.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				month = 월.getSelectedItem().toString();
			}
		});
		월.setModel(new DefaultComboBoxModel(
				new String[] { "\uC6D4", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		월.setToolTipText("");
		월.setBounds(341, 38, 44, 21);
		전체매출.add(월);

		JComboBox 일 = new JComboBox();
		일.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				day = 일.getSelectedItem().toString();
			}
		});
		일.setModel(new DefaultComboBoxModel(new String[] { "\uC77C", "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30", "31" }));
		일.setToolTipText("");
		일.setBounds(403, 38, 44, 21);
		전체매출.add(일);

		JButton btn_날짜조회 = new JButton("\uC870\uD68C");
		btn_날짜조회.setForeground(Color.WHITE);
		btn_날짜조회.setFont(new Font("한컴 고딕", Font.BOLD, 12));
		btn_날짜조회.setBackground(Color.DARK_GRAY);
		btn_날짜조회.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				날짜조회GUI a = new 날짜조회GUI(year, month, day);

			}
		});
		btn_날짜조회.setBounds(470, 39, 81, 23);
		전체매출.add(btn_날짜조회);

		JLabel lblNewLabel_6 = new JLabel("\uB144");
		lblNewLabel_6.setBounds(323, 38, 18, 24);
		전체매출.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("\uC6D4");
		lblNewLabel_6_1.setBounds(384, 38, 18, 24);
		전체매출.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_2 = new JLabel("\uC77C");
		lblNewLabel_6_2.setBounds(448, 38, 18, 24);
		전체매출.add(lblNewLabel_6_2);

		JLabel lblNewLabel_7 = new JLabel("\uC6D0");
		lblNewLabel_7.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_7.setBounds(224, 333, 36, 21);
		전체매출.add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel("\uC6D0");
		lblNewLabel_7_1.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_7_1.setBounds(224, 367, 36, 21);
		전체매출.add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_2 = new JLabel("\uC6D0");
		lblNewLabel_7_2.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_7_2.setBounds(224, 404, 36, 21);
		전체매출.add(lblNewLabel_7_2);

		JLabel lblNewLabel_7_3 = new JLabel("\uC6D0");
		lblNewLabel_7_3.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_7_3.setBounds(471, 330, 36, 21);
		전체매출.add(lblNewLabel_7_3);

		JLabel lblNewLabel_7_4 = new JLabel("\uC6D0");
		lblNewLabel_7_4.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_7_4.setBounds(471, 370, 36, 21);
		전체매출.add(lblNewLabel_7_4);

		JLabel lblNewLabel_7_5 = new JLabel("\uC6D0");
		lblNewLabel_7_5.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_7_5.setBounds(471, 401, 36, 21);
		전체매출.add(lblNewLabel_7_5);

		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				관리자GUI asd = new 관리자GUI();
				frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton.setBounds(611, 502, 97, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(매출관리main.class.getResource("/image/\uB9E4\uCD9C-removebg-preview.png")));
		lblNewLabel_8.setBounds(566, 28, 154, 463);
		frame.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("\uB9E4\uCD9C \uAD00\uB9AC");
		lblNewLabel_9.setFont(new Font("한컴 고딕", Font.BOLD, 40));
		lblNewLabel_9.setBounds(196, 10, 220, 59);
		frame.getContentPane().add(lblNewLabel_9);
	}
}
