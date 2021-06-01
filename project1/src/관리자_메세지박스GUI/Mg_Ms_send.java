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
import java.awt.Font;
import javax.swing.ImageIcon;

public class Mg_Ms_send {

	private JFrame frame;
	private JTextField tf_receive_id;
	int 보내는사람관리자;
//	int receiver ;
	private JTextField tf_send_id;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Mg_Ms_send(int 관리자번호) {
		보내는사람관리자 = 관리자번호;
//		receiver = Integer.parseInt(회원번호);
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("한컴 고딕", Font.BOLD, 15));
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 425, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBC1B\uB294\uC0AC\uB78C :");
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(21, 146, 85, 28);
		frame.getContentPane().add(lblNewLabel);
		
		tf_send_id = new JTextField();
		tf_send_id.setColumns(10);
		tf_send_id.setBounds(118, 115, 116, 21);
		frame.getContentPane().add(tf_send_id);
		tf_send_id.setText(Integer.toString(보내는사람관리자));
		
		tf_receive_id = new JTextField();           //받는사람 id
		tf_receive_id.setBounds(118, 150, 116, 21);
		frame.getContentPane().add(tf_receive_id);
		tf_receive_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(23, 198, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(23, 223, 361, 222);
		frame.getContentPane().add(tp_content);
		
		JButton btn_send = new JButton("\uBCF4\uB0B4\uAE30");
		btn_send.setBackground(new Color(240, 255, 255));
		btn_send.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int receive_id = Integer.parseInt(tf_receive_id.getText());
				String content = tp_content.getText();
				Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
				boolean result = dao.insert_Ms(보내는사람관리자, receive_id, content);
				
				if(result == true) {
					JOptionPane.showMessageDialog(null, "메시지 전송 성공!");
					Mg_MessageBox_Main.main(null);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "메시지 전송 실패!");
				}
			}
		});
		btn_send.setBounds(43, 488, 131, 48);
		frame.getContentPane().add(btn_send);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBackground(new Color(240, 255, 255));
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mg_MessageBox_Main.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(226, 488, 131, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBCF4\uB0B4\uB294 \uC0AC\uB78C :");
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(11, 118, 95, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Mg_Ms_send.class.getResource("/image/mes-removebg-preview.png")));
		lblNewLabel_3.setBounds(78, 10, 266, 95);
		frame.getContentPane().add(lblNewLabel_3);
		
		
	}
}
