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
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Ms_send {

	private JFrame frame;
	private JTextField tf_receive_id;
	int send_id = 0;
	int receiver = 0;
	private JTextField tf_send_id;
	String 회원이름 = "";

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Ms_send(String receive, int 회원번호, String name) {
		회원이름 = name;
		send_id = 회원번호;
		receiver = Integer.parseInt(receive);
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
		
		JLabel lblNewLabel = new JLabel("\uBC1B\uB294\uC0AC\uB78C \u25B6");
		lblNewLabel.setBounds(64, 167, 86, 28);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel);
		
		tf_send_id = new JTextField();
		tf_send_id.setBounds(161, 134, 116, 21);
		tf_send_id.setColumns(10);
		frame.getContentPane().add(tf_send_id);
		tf_send_id.setText(Integer.toString(receiver));
		
		tf_receive_id = new JTextField();
		tf_receive_id.setBounds(161, 172, 116, 21);
		frame.getContentPane().add(tf_receive_id);
		tf_receive_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setBounds(24, 244, 67, 15);
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(24, 269, 355, 221);
		frame.getContentPane().add(tp_content);
		
		JButton btn_send = new JButton("\uC804\uC1A1");
		btn_send.setBounds(64, 512, 101, 34);
		btn_send.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btn_send.setForeground(Color.WHITE);
		btn_send.setBackground(Color.DARK_GRAY);
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int receive_id = Integer.parseInt(tf_receive_id.getText());
				String content = tp_content.getText();
				MessageBoxDAO dao = new MessageBoxDAO();
				boolean result = dao.insert_Ms(receiver, receive_id, content);
				
				if(result == true) {
					JOptionPane.showMessageDialog(null, "메시지 전송 성공!");
					MessageBox_Main mb = new MessageBox_Main(회원이름, send_id);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "메시지 전송 실패!");
				}
			}
		});
		frame.getContentPane().add(btn_send);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBounds(224, 512, 101, 34);
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox_Main mb = new MessageBox_Main(회원이름, send_id);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBCF4\uB0B4\uB294 \uC0AC\uB78C \u25B6");
		lblNewLabel_2.setBounds(44, 129, 101, 28);
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("l");
		lblNewLabel_3.setIcon(new ImageIcon(Ms_send.class.getResource("/image/mes-removebg-preview.png")));
		lblNewLabel_3.setBounds(64, 27, 261, 65);
		frame.getContentPane().add(lblNewLabel_3);
		
		
	}
}
