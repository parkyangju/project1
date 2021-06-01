package �������GUI;

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

import Controller.�������DAO;
import GUI.������GUI;
import Model.�������VO;

public class �������main {

	private JFrame frame;
	private JTable table;
	private JTextField ȸ����ȣ�Է¶�;
	private JTextField tf_�����Ѹ���;
	private JTextField tf_ī��;
	private JTextField tf_����;
	private JTextField �Ѹ���;
	private JTextField tf_�̹��޸���;
	private JTextField tf_���ø���;
	private JTextField ���ó�¥;
	String year = "";
	String month = "";
	String day = "";
	int ȸ����ȣ = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					�������main window = new �������main();
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
	public �������main() {
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
		int ����⵵ = cal.get(cal.YEAR);
		int ����� = cal.get(cal.MONTH) + 1;
		int ������ = cal.get(cal.DATE);

		DecimalFormat formatter = new DecimalFormat("###,###");

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 736, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		�������DAO dao = new �������DAO();
		String[] colNames = { "������ȣ", "ȸ����ȣ", "�ݾ�", "��¥", "��������" };
		ArrayList<�������VO> al = dao.selectPay();
		Object[][] data = new Object[al.size()][5];

		for (int i = 0; i < al.size(); i++) {
			data[i][0] = al.get(i).getPay_no();
			data[i][1] = al.get(i).getMember_no();
			data[i][2] = al.get(i).getMoney();
			data[i][3] = al.get(i).getPay_date();
			data[i][4] = al.get(i).getPay_method();
		}

		JPanel ��ü���� = new JPanel();
		��ü����.setBounds(12, 79, 579, 446);
		frame.getContentPane().add(��ü����);
		��ü����.setToolTipText("");
		��ü����.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 72, 555, 236);
		��ü����.add(scrollPane);

		DefaultTableModel model = new DefaultTableModel(data, colNames) { // ����Ŭ�� �ϸ� ���Է� ���ϰ� ����
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		table = new JTable(model);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("\uC62C\uD574 \uCD1D\uB9E4\uCD9C :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel.setBounds(283, 330, 81, 27);
		��ü����.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uCE74\uB4DC \uACB0\uC81C :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_1.setBounds(43, 364, 69, 27);
		��ü����.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uD604\uAE08 \uACB0\uC81C :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_2.setBounds(43, 401, 69, 27);
		��ü����.add(lblNewLabel_2);

		ȸ����ȣ�Է¶� = new JTextField();
		ȸ����ȣ�Է¶�.setBounds(384, 7, 81, 21);
		��ü����.add(ȸ����ȣ�Է¶�);
		ȸ����ȣ�Է¶�.setColumns(10);

		JComboBox ȸ����ȣ�޺��ڽ� = new JComboBox();

		ȸ����ȣ�޺��ڽ�.setModel(
				new DefaultComboBoxModel(new String[] { "\uD68C\uC6D0\uBC88\uD638", "\uCE74\uB4DC", "\uD604\uAE08" }));
		ȸ����ȣ�޺��ڽ�.setToolTipText("");
		ȸ����ȣ�޺��ڽ�.setBounds(284, 7, 88, 21);
		��ü����.add(ȸ����ȣ�޺��ڽ�);

		JButton btn_ȸ����ȸ = new JButton("\uC870\uD68C");
		btn_ȸ����ȸ.setForeground(Color.WHITE);
		btn_ȸ����ȸ.setFont(new Font("���� ���", Font.BOLD, 12));
		btn_ȸ����ȸ.setBackground(Color.DARK_GRAY);
		btn_ȸ����ȸ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ȸ����ȣ�Է¶�.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ȸ����ȣ�� �Է��ϼ���!");
				} else {
					ȸ����ȣ = Integer.parseInt(ȸ����ȣ�Է¶�.getText());
					ȸ����ȸGUI b = new ȸ����ȸGUI(ȸ����ȣ);
				}
			}
		});
		btn_ȸ����ȸ.setBounds(470, 5, 81, 23);
		��ü����.add(btn_ȸ����ȸ);

		tf_�����Ѹ��� = new JTextField();
		tf_�����Ѹ���.setBounds(376, 333, 94, 21);
		��ü����.add(tf_�����Ѹ���);
		tf_�����Ѹ���.setColumns(10);
		tf_�����Ѹ���.setText(formatter.format(Integer.parseInt(dao.�����Ѹ���(����⵵))));

		tf_ī�� = new JTextField();
		tf_ī��.setColumns(10);
		tf_ī��.setBounds(124, 370, 94, 21);
		��ü����.add(tf_ī��);
		tf_ī��.setText(formatter.format(Integer.parseInt(dao.ī���ѱݾ�())));

		tf_���� = new JTextField();
		tf_����.setColumns(10);
		tf_����.setBounds(124, 407, 94, 21);
		��ü����.add(tf_����);
		tf_����.setText(formatter.format(Integer.parseInt(dao.�����ѱݾ�())));

		�Ѹ��� = new JTextField();
		�Ѹ���.setColumns(10);
		�Ѹ���.setBounds(124, 333, 94, 21);
		��ü����.add(�Ѹ���);
		�Ѹ���.setText(formatter.format(Integer.parseInt(dao.AllPayment())));

		JLabel lblNewLabel_3 = new JLabel("       \uCD1D\uB9E4\uCD9C :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_3.setBounds(31, 330, 81, 27);
		��ü����.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC774\uBC88\uB2EC \uB9E4\uCD9C :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_4.setBounds(276, 364, 88, 27);
		��ü����.add(lblNewLabel_4);

		tf_�̹��޸��� = new JTextField();
		tf_�̹��޸���.setColumns(10);
		tf_�̹��޸���.setBounds(375, 367, 94, 21);
		��ü����.add(tf_�̹��޸���);
		tf_�̹��޸���.setText(formatter.format(Integer.parseInt(dao.�̹��޸���(����⵵, �����))));

		JLabel lblNewLabel_5 = new JLabel(" \uC624\uB298 \uB9E4\uCD9C :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_5.setBounds(271, 401, 93, 27);
		��ü����.add(lblNewLabel_5);

		tf_���ø��� = new JTextField();
		tf_���ø���.setColumns(10);
		tf_���ø���.setBounds(376, 404, 94, 21);
		��ü����.add(tf_���ø���);
		tf_���ø���.setText(formatter.format(Integer.parseInt(dao.���ø���(����⵵, �����, ������))));

		���ó�¥ = new JTextField();
		���ó�¥.setBounds(12, 7, 116, 21);
		��ü����.add(���ó�¥);
		���ó�¥.setColumns(10);
		���ó�¥.setText(mTime);

		JComboBox �⵵ = new JComboBox();
		�⵵.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year = �⵵.getSelectedItem().toString();
				ȸ����ȣ�Է¶�.setText("");
			}
		});
		�⵵.setModel(new DefaultComboBoxModel(new String[] { "\uB144\uB3C4", "2019", "2020", "2021" }));
		�⵵.setToolTipText("");
		�⵵.setBounds(262, 38, 59, 21);
		��ü����.add(�⵵);

		JComboBox �� = new JComboBox();
		��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				month = ��.getSelectedItem().toString();
			}
		});
		��.setModel(new DefaultComboBoxModel(
				new String[] { "\uC6D4", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		��.setToolTipText("");
		��.setBounds(341, 38, 44, 21);
		��ü����.add(��);

		JComboBox �� = new JComboBox();
		��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				day = ��.getSelectedItem().toString();
			}
		});
		��.setModel(new DefaultComboBoxModel(new String[] { "\uC77C", "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30", "31" }));
		��.setToolTipText("");
		��.setBounds(403, 38, 44, 21);
		��ü����.add(��);

		JButton btn_��¥��ȸ = new JButton("\uC870\uD68C");
		btn_��¥��ȸ.setForeground(Color.WHITE);
		btn_��¥��ȸ.setFont(new Font("���� ���", Font.BOLD, 12));
		btn_��¥��ȸ.setBackground(Color.DARK_GRAY);
		btn_��¥��ȸ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				��¥��ȸGUI a = new ��¥��ȸGUI(year, month, day);

			}
		});
		btn_��¥��ȸ.setBounds(470, 39, 81, 23);
		��ü����.add(btn_��¥��ȸ);

		JLabel lblNewLabel_6 = new JLabel("\uB144");
		lblNewLabel_6.setBounds(323, 38, 18, 24);
		��ü����.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("\uC6D4");
		lblNewLabel_6_1.setBounds(384, 38, 18, 24);
		��ü����.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_2 = new JLabel("\uC77C");
		lblNewLabel_6_2.setBounds(448, 38, 18, 24);
		��ü����.add(lblNewLabel_6_2);

		JLabel lblNewLabel_7 = new JLabel("\uC6D0");
		lblNewLabel_7.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_7.setBounds(224, 333, 36, 21);
		��ü����.add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel("\uC6D0");
		lblNewLabel_7_1.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_7_1.setBounds(224, 367, 36, 21);
		��ü����.add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_2 = new JLabel("\uC6D0");
		lblNewLabel_7_2.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_7_2.setBounds(224, 404, 36, 21);
		��ü����.add(lblNewLabel_7_2);

		JLabel lblNewLabel_7_3 = new JLabel("\uC6D0");
		lblNewLabel_7_3.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_7_3.setBounds(471, 330, 36, 21);
		��ü����.add(lblNewLabel_7_3);

		JLabel lblNewLabel_7_4 = new JLabel("\uC6D0");
		lblNewLabel_7_4.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_7_4.setBounds(471, 370, 36, 21);
		��ü����.add(lblNewLabel_7_4);

		JLabel lblNewLabel_7_5 = new JLabel("\uC6D0");
		lblNewLabel_7_5.setFont(new Font("���� ���", Font.BOLD, 14));
		lblNewLabel_7_5.setBounds(471, 401, 36, 21);
		��ü����.add(lblNewLabel_7_5);

		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������GUI asd = new ������GUI();
				frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("���� ���", Font.BOLD, 15));
		btnNewButton.setBounds(611, 502, 97, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(�������main.class.getResource("/image/\uB9E4\uCD9C-removebg-preview.png")));
		lblNewLabel_8.setBounds(566, 28, 154, 463);
		frame.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("\uB9E4\uCD9C \uAD00\uB9AC");
		lblNewLabel_9.setFont(new Font("���� ���", Font.BOLD, 40));
		lblNewLabel_9.setBounds(196, 10, 220, 59);
		frame.getContentPane().add(lblNewLabel_9);
	}
}
