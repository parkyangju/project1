package 관리자_회원조회GUI;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.TR_MemberDAO;
import GUI.관리자GUI;
import Model.TR_MemberVO;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class MemberSearch_deco {

	private JFrame frame;
	private JTextField tf_search;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_1;
	private JLabel lblNewLabel_7;
	private JPanel panel;
	private JLabel lblNewLabel_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSearch_deco window = new MemberSearch_deco();
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
	public MemberSearch_deco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		TR_MemberDAO dao = new TR_MemberDAO();
		ArrayList<TR_MemberVO> memberList = dao.select_mem();
		String[] header = { "회원번호", "이름", "전화번호" }; 
		String[][] content = new String[memberList.size()][3];
		for (int i = 0; i < memberList.size(); i++) {
			content[i][0] = Integer.toString(memberList.get(i).getNum());
			content[i][1] = memberList.get(i).getName();
			content[i][2] = memberList.get(i).getPhone();
		}
		DefaultTableModel model = new DefaultTableModel(content, header);
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 736, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tf_search = new JTextField();
		tf_search.setBounds(337, 117, 99, 22);
		frame.getContentPane().add(tf_search);
		tf_search.setColumns(10);
		
		JButton btn_search = new JButton("\uAC80\uC0C9");
		btn_search.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btn_search.setForeground(new Color(0, 0, 0));
		btn_search.setBackground(new Color(255, 228, 225));
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_search.setBounds(448, 117, 62, 22);
		frame.getContentPane().add(btn_search);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(298, 149, 385, 297);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable(model);
		table.setBounds(298, 149, 385, 297);
//		frame.getContentPane().add(table);
		scrollPane_1.setViewportView(table);
		
		lblNewLabel = new JLabel("\uD68C\uC6D0 \uB9AC\uC2A4\uD2B8");
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(602, 133, 80, 15);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(298, 117, 42, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("\uC774\uB984");
		lblNewLabel_3.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		lblNewLabel_3.setBounds(78, 144, 42, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(127, 147, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_4.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		lblNewLabel_4.setBounds(39, 227, 86, 22);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\uC774\uC6A9\uAE30\uAC04");
		lblNewLabel_5.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		lblNewLabel_5.setBounds(39, 277, 86, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("\uD2B8\uB808\uC774\uB108");
		lblNewLabel_6.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		lblNewLabel_6.setBounds(39, 327, 86, 22);
		frame.getContentPane().add(lblNewLabel_6);
		
		rdbtnNewRadioButton = new JRadioButton("\uB0A8");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(127, 187, 42, 22);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("\uC5EC");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(188, 187, 42, 22);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 227, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(5);
		comboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC1A1\uC6A9\uBB35", "\uC870\uAD8C\uC6B0", "\uC774\uC218\uBE48"}));
		comboBox.setSelectedIndex(0);
		comboBox.setEditable(true);
		comboBox.setBounds(127, 327, 106, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(40, 383, 65, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC218\uC815");
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.setBounds(110, 383, 65, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 240, 245));
		btnNewButton_2.setBounds(180, 383, 65, 30);
		frame.getContentPane().add(btnNewButton_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"3\uAC1C\uC6D4", "6\uAC1C\uC6D4", "9\uAC1C\uC6D4", "12\uAC1C\uC6D4"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setFont(new Font("굴림", Font.PLAIN, 12));
		comboBox_1.setBounds(127, 277, 106, 22);
		frame.getContentPane().add(comboBox_1);
		
		lblNewLabel_7 = new JLabel("\uC131\uBCC4");
		lblNewLabel_7.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		lblNewLabel_7.setBounds(78, 185, 42, 22);
		frame.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_3 = new JButton("\uB2EB\uAE30");
		btnNewButton_3.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				관리자GUI as= new 관리자GUI();
			}
		});
		btnNewButton_3.setBounds(603, 456, 80, 30);
		frame.getContentPane().add(btnNewButton_3);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 720, 87);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("\uD68C\uC6D0 \uC870\uD68C");
		lblNewLabel_2.setBounds(268, 10, 200, 52);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 46));
		lblNewLabel_2.setForeground(new Color(245, 255, 250));
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(MemberSearch_deco.class.getResource("/image/\uBA64\uBC84\uC11C\uCE58-removebg-preview.png")));
		lblNewLabel_8.setBounds(78, 453, 501, 82);
		frame.getContentPane().add(lblNewLabel_8);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
	
	}
}
