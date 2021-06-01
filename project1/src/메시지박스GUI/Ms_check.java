package 메시지박스GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.MessageBoxDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Ms_check {

	private JFrame frame;
	private JTextField tf_send_id;
	String num = "";
	int receivenum = 0;
	private JTextField tf_Ms_no;
	int 보내는사람번호;
	String 회원이름 = "";


	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Ms_check(int number, int 메시지번호,int 회원번호, String name) {
		회원이름 = name;
		보내는사람번호 = 회원번호;
		num = Integer.toString(number);
		receivenum = 메시지번호;
	
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 425, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBCF4\uB0B8\uC0AC\uB78C \u25B6");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(94, 149, 81, 28);
		frame.getContentPane().add(lblNewLabel);
		
		tf_Ms_no = new JTextField();
		tf_Ms_no.setText(Integer.toString(receivenum));
		tf_Ms_no.setColumns(10);
		tf_Ms_no.setBounds(188, 122, 60, 21);
		frame.getContentPane().add(tf_Ms_no);
		
		tf_send_id = new JTextField();
		tf_send_id.setBounds(187, 155, 116, 21);
		frame.getContentPane().add(tf_send_id);
		tf_send_id.setColumns(10);
		tf_send_id.setText(num);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B \uB0B4\uC6A9 \u203B");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(28, 198, 95, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(26, 223, 356, 260);
		frame.getContentPane().add(tp_content);
		MessageBoxDAO dao = new MessageBoxDAO();
		tp_content.setText(dao.View_Ms_content(receivenum));
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageBoxDAO dao = new MessageBoxDAO();
				boolean result = dao.changeCheck(receivenum);
				
				if(result == true) {
					JOptionPane.showMessageDialog(null, "확인완료!");
					MessageBox_Main mb = new MessageBox_Main(회원이름, 보내는사람번호);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "확인실패!");
					MessageBox_Main mb = new MessageBox_Main(회원이름, 보내는사람번호);
					frame.dispose();
				}
				
				
			}
		});
		btnNewButton.setBounds(64, 512, 106, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("  \uBA54\uC2DC\uC9C0 \uBC88\uD638 \u25B6");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(64, 116, 111, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("\uB2F5\uC7A5\uD558\uAE30");
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ms_answer answer = new Ms_answer(num,회원이름, 보내는사람번호);
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(229, 512, 102, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Ms_check.class.getResource("/image/mes-removebg-preview.png")));
		lblNewLabel_3.setBounds(77, 24, 332, 76);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("\uB2EB\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox_Main mb = new MessageBox_Main(회원이름, 보내는사람번호);
				frame.dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		btnNewButton_2.setBounds(322, 553, 60, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		
	}

}
