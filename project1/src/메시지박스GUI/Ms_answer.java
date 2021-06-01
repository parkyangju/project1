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
import javax.swing.SwingConstants;

public class Ms_answer {

	private JFrame frame;
	private JTextField tf_send_id;
	private JTextField tf_receive_id;
	String 받는사람;
	int 보내는사람;
	String 회원이름 = "";

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Ms_answer(String num, String name, int 보내는사람번호) {
		회원이름 = name;
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
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 425, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uBCF4\uB0B4\uB294 \uC0AC\uB78C \u25B6");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_2.setBounds(48, 127, 92, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		tf_send_id = new JTextField();
		tf_send_id.setText(Integer.toString(보내는사람));
		tf_send_id.setColumns(10);
		tf_send_id.setBounds(154, 126, 116, 21);
		frame.getContentPane().add(tf_send_id);
		
		tf_receive_id = new JTextField();
		tf_receive_id.setColumns(10);
		tf_receive_id.setBounds(154, 158, 116, 21);
		frame.getContentPane().add(tf_receive_id);
		tf_receive_id.setText(받는사람);
		
		JLabel lblNewLabel = new JLabel("\uBC1B\uB294 \uC0AC\uB78C \u25B6 ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(60, 154, 82, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B \uB0B4\uC6A9 \u203B");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(27, 235, 105, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(27, 260, 355, 215);
		frame.getContentPane().add(tp_content);
		
		JButton btn_send = new JButton("\uC804\uC1A1");
		btn_send.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		btn_send.setForeground(Color.WHITE);
		btn_send.setBackground(Color.DARK_GRAY);
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBoxDAO dao = new MessageBoxDAO();
				boolean result = dao.insert_Ms(보내는사람, Integer.parseInt(받는사람), tp_content.getText());
				
				if(result ==true) {
					JOptionPane.showMessageDialog(null, "메시지 전송성공!");
					MessageBox_Main mb = new MessageBox_Main(회원이름, 보내는사람);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "메시지 전송실패!");
				}
			}
		});
		btn_send.setBounds(65, 499, 92, 33);
		frame.getContentPane().add(btn_send);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox_Main mb = new MessageBox_Main(회원이름, 보내는사람);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(222, 499, 92, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(Ms_answer.class.getResource("/image/mes-removebg-preview.png")));
		lblNewLabel_3.setBounds(0, 0, 409, 116);
		frame.getContentPane().add(lblNewLabel_3);
	}

}
