package 관리자_메세지박스GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.Mg_MessageBoxDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Mg_Ms_answer {

	private JFrame frame;
	private JTextField tf_send_id;
	private JTextField tf_receive_id;
	String 받는사람;
	String 보내는사람;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Mg_Ms_answer(String num, String 보내는사람번호) {
		보내는사람 = 보내는사람번호;
		받는사람 = num;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 425, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uBCF4\uB0B4\uB294 \uC0AC\uB78C :");
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 163, 95, 15);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblNewLabel_2);
		
		tf_send_id = new JTextField();
		tf_send_id.setBounds(118, 163, 116, 21);
		tf_send_id.setText(보내는사람);
		tf_send_id.setColumns(10);
		frame.getContentPane().add(tf_send_id);
		
		tf_receive_id = new JTextField();
		tf_receive_id.setBounds(118, 194, 116, 21);
		tf_receive_id.setColumns(10);
		frame.getContentPane().add(tf_receive_id);
		tf_receive_id.setText(받는사람);
		
		JLabel lblNewLabel = new JLabel("\uBC1B\uB294 \uC0AC\uB78C :");
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 188, 85, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 226, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(24, 251, 361, 235);
		frame.getContentPane().add(tp_content);
		
		JButton btn_send = new JButton("\uBCF4\uB0B4\uAE30");
		btn_send.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		btn_send.setBounds(48, 496, 131, 48);
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
				boolean result = dao.insert_Ms(Integer.parseInt(보내는사람), Integer.parseInt(받는사람), tp_content.getText());
				
				if(result ==true) {
					JOptionPane.showMessageDialog(null, "메시지 전송성공!");
					Mg_MessageBox_Main.main(null);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "메시지 전송실패!");
				}
			}
		});
		frame.getContentPane().add(btn_send);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		btnNewButton_1.setBounds(213, 496, 131, 48);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Mg_MessageBox_Main.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(73, 21, 286, 92);
		lblNewLabel_3.setIcon(new ImageIcon(Mg_Ms_answer.class.getResource("/image/\uB2F5\uC7A5-removebg-preview.png")));
		frame.getContentPane().add(lblNewLabel_3);
	}

}
