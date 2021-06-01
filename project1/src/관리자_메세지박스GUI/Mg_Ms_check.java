package 관리자_메세지박스GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.Mg_MessageBoxDAO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Mg_Ms_check {

	private JFrame frame;
	private JTextField tf_send_id;
	int 보낸사람회원번호;
	int 메시지번호;
	private JTextField tf_Ms_no;
	int 관리자번호;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Mg_Ms_check(int sendnum, int managernum,int messagenum) {
		보낸사람회원번호 = sendnum;
		관리자번호 = managernum;
		메시지번호 = messagenum;
	
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
		
		JLabel lblNewLabel = new JLabel("\uBCF4\uB0B8\uC0AC\uB78C :");
		lblNewLabel.setBounds(26, 147, 85, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel);
		
		tf_Ms_no = new JTextField();
		tf_Ms_no.setBounds(123, 117, 60, 21);
		tf_Ms_no.setText(Integer.toString(메시지번호));
		tf_Ms_no.setColumns(10);
		frame.getContentPane().add(tf_Ms_no);
		
		tf_send_id = new JTextField();
		tf_send_id.setBounds(123, 151, 116, 21);
		frame.getContentPane().add(tf_send_id);
		tf_send_id.setColumns(10);
		tf_send_id.setText(Integer.toString(보낸사람회원번호));
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setBounds(26, 208, 57, 15);
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(26, 233, 356, 260);
		frame.getContentPane().add(tp_content);
		Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
		tp_content.setText(dao.View_Ms_content(메시지번호));
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setBounds(51, 523, 132, 33);
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
				boolean result = dao.changeCheck(메시지번호);
				
				if(result == true) {
					JOptionPane.showMessageDialog(null, "확인완료!");
					Mg_MessageBox_Main.main(null);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "확인실패!");
					Mg_MessageBox_Main.main(null);
					frame.dispose();
				}
				
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel(" \uBA54\uC2DC\uC9C0 \uBC88\uD638 :");
		lblNewLabel_2.setBounds(26, 113, 91, 28);
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("\uB2F5\uC7A5\uD558\uAE30");
		btnNewButton_1.setBounds(219, 523, 132, 33);
		btnNewButton_1.setBackground(new Color(240, 255, 255));
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mg_answer answer = new Mg_answer(보낸사람회원번호, 관리자번호);
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 409, 103);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(Mg_Ms_check.class.getResource("/image/check-removebg-preview.png")));
		frame.getContentPane().add(lblNewLabel_3);
		
		
	}

}
