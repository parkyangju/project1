package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.MemberDAO;
import Model.MemberVO;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JoinGUI {

	private JFrame frame;
	private JTextField tf_joinid;
	private JTextField tf_joinPwCheck;
	private JTextField tf_joinpw;
	private JTextField tf_joinName;
	private JTextField tf_joinphone;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	MemberDAO dao = new MemberDAO();

	/**
	 * Create the application.
	 */
	public JoinGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 738, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(JoinGUI.class.getResource("/image/dumbbell (1).png")));
		lblNewLabel_4_1.setBounds(264, 21, 71, 55);
		frame.getContentPane().add(lblNewLabel_4_1);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(164, 21, 136, 55);
		frame.getContentPane().add(lblNewLabel);

		JLabel 회원번호 = new JLabel("\uD68C\uC6D0\uBC88\uD638 :");
		회원번호.setForeground(new Color(0, 0, 0));
		회원번호.setHorizontalAlignment(SwingConstants.RIGHT);
		회원번호.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		회원번호.setBounds(12, 95, 155, 35);
		frame.getContentPane().add(회원번호);

		JLabel lblNewLabel_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(12, 140, 155, 35);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778 :");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(12, 185, 155, 35);
		frame.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("\uC774\uB984 :");
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(12, 230, 155, 35);
		frame.getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("\uC804\uD654\uBC88\uD638 :");
		lblNewLabel_1_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(12, 320, 155, 35);
		frame.getContentPane().add(lblNewLabel_1_4);

		tf_joinid = new JTextField();
		tf_joinid.setBounds(176, 97, 118, 30);
		frame.getContentPane().add(tf_joinid);
		tf_joinid.setColumns(10);

		tf_joinpw = new JPasswordField();
		tf_joinpw.setColumns(10);
		tf_joinpw.setBounds(176, 143, 118, 30);
		frame.getContentPane().add(tf_joinpw);

		tf_joinPwCheck = new JPasswordField();
		tf_joinPwCheck.setColumns(10);
		tf_joinPwCheck.setBounds(176, 186, 118, 30);
		frame.getContentPane().add(tf_joinPwCheck);

		tf_joinName = new JTextField();
		tf_joinName.setColumns(10);
		tf_joinName.setBounds(176, 231, 118, 30);
		frame.getContentPane().add(tf_joinName);

		tf_joinphone = new JTextField();
		tf_joinphone.setColumns(10);
		tf_joinphone.setBounds(176, 322, 118, 30);
		frame.getContentPane().add(tf_joinphone);

		JRadioButton btn_male = new JRadioButton("\uB0A8\uC131");
		btn_male.setBackground(new Color(255, 153, 51));
		btn_male.setForeground(Color.BLACK);
		btn_male.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		buttonGroup.add(btn_male);
		btn_male.setBounds(176, 276, 60, 33);
		frame.getContentPane().add(btn_male);

		JRadioButton btn_female = new JRadioButton("\uC5EC\uC131");
		btn_female.setBackground(new Color(255, 153, 51));
		btn_female.setForeground(Color.BLACK);
		btn_female.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		buttonGroup.add(btn_female);
		btn_female.setBounds(232, 276, 60, 33);
		frame.getContentPane().add(btn_female);
		
		JComboBox period_comboBox = new JComboBox();
		period_comboBox.setModel(new DefaultComboBoxModel(new String[] {"3\uAC1C\uC6D4", "6\uAC1C\uC6D4", "9\uAC1C\uC6D4", "12\uAC1C\uC6D4"}));
		period_comboBox.setSelectedIndex(0);
		period_comboBox.setEditable(true);
		period_comboBox.setBounds(176, 362, 118, 30);
		frame.getContentPane().add(period_comboBox);
		
		JButton btn_join = new JButton("\uAC00\uC785");
		btn_join.setBackground(Color.GRAY);
		btn_join.setForeground(new Color(255, 255, 255));
		btn_join.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tf_joinid.getText());
				char[] temp_pw = ((JPasswordField) tf_joinpw).getPassword();
				String pw = "";
				for (char cha : temp_pw) {
					Character.toString(cha);
					pw += (pw.equals("") ? "" + cha + "" : "" + cha + "");
				}

				System.out.println(pw);
				String pwCheck = tf_joinPwCheck.getText();
				String name = tf_joinName.getText();
				String gender = "";
				String phone = tf_joinphone.getText();
				String PERIOD = period_comboBox.getSelectedItem().toString();
				int TRAINER_NO = 9999;

				if (btn_female.isSelected()) {
					gender = btn_female.getText();
				} else if (btn_male.isSelected()) {
					gender = btn_male.getText();
				}

				if (!pw.equals(pwCheck)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "회원가입", JOptionPane.ERROR_MESSAGE);
					tf_joinpw.setText("");
					tf_joinPwCheck.setText("");

				} else {
					if (id == 0000 || pw.equals("") || name.equals("") || gender.equals("") || phone.equals("")) { // 회원가입
																													// 실패
						JOptionPane.showMessageDialog(null, "빈칸을 모두 채우세요.", "회원가입", JOptionPane.ERROR_MESSAGE);
					} else {
						MemberDAO dao = new MemberDAO();
						MemberVO vo = new MemberVO(id, pw, name, gender, phone, PERIOD, TRAINER_NO);
						int cnt = dao.joinInsert(vo);

						if (cnt > 0) {
							JOptionPane.showMessageDialog(null, "회원가입 성공");
							frame.dispose();
							MainGUI.main(null);

						} else {
							JOptionPane.showMessageDialog(null, "회원가입 실패");

						}

					}
				}
			}

		});
		btn_join.setBounds(96, 418, 97, 23);
		frame.getContentPane().add(btn_join);

		JButton btn_joinDispose = new JButton("\uB2EB\uAE30");
		btn_joinDispose.setBackground(Color.GRAY);
		btn_joinDispose.setForeground(new Color(255, 255, 255));
		btn_joinDispose.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		btn_joinDispose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGUI.main(null);
				frame.dispose();

			}
		});
		btn_joinDispose.setBounds(250, 418, 97, 23);
		frame.getContentPane().add(btn_joinDispose);

		JLabel lblNewLabel_2 = new JLabel("\uC131\uBCC4 :");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		lblNewLabel_2.setBounds(12, 275, 155, 35);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("\uC911\uBCF5\uD655\uC778");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tf_joinid.getText();
				if (dao.id_select(id)) {
					JOptionPane.showMessageDialog(null, "중복되는 회원번호가 있습니다.", "회원번호 확인", JOptionPane.ERROR_MESSAGE);
					tf_joinid.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "사용가능한 회원번호 입니다.");
				}

			}
		});
		btnNewButton.setBounds(306, 101, 90, 25);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("IN SSA GYM");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 28));
		lblNewLabel_1.setBounds(135, 464, 200, 61);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(JoinGUI.class.getResource("/image/zxc.jpg")));
		lblNewLabel_3.setBounds(425, -20, 373, 574);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(JoinGUI.class.getResource("/image/dumbbell (1).png")));
		lblNewLabel_4.setBounds(85, 21, 71, 55);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
		JLabel lblNewLabel_1_4_1 = new JLabel("\uC774\uC6A9\uAE30\uAC04 :");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_4_1.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		lblNewLabel_1_4_1.setBounds(12, 362, 155, 35);
		frame.getContentPane().add(lblNewLabel_1_4_1);

	}
}
