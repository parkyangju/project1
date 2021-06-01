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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Mg_answer {

	private JFrame frame;
	private JTextField 관리자;
	private JTextField 받는회원;
	int 보낸사람회원번호;
	int 관리자번호;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Mg_answer window = new Mg_answer();
//					window.
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Mg_answer(int sendnum, int managernum) {
		보낸사람회원번호 = sendnum;
		관리자번호 = managernum;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 425, 626);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uBCF4\uB0B4\uB294 \uC0AC\uB78C :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_2.setBounds(26, 154, 85, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		관리자 = new JTextField();
		관리자.setText(Integer.toString(관리자번호));
		관리자.setColumns(10);
		관리자.setBounds(127, 151, 116, 21);
		frame.getContentPane().add(관리자);
		
		받는회원 = new JTextField();
		받는회원.setColumns(10);
		받는회원.setBounds(127, 182, 116, 21);
		frame.getContentPane().add(받는회원);
		받는회원.setText(Integer.toString(보낸사람회원번호));
		
		JLabel lblNewLabel = new JLabel("\uBC1B\uB294\uC0AC\uB78C :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(26, 179, 85, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(26, 242, 355, 196);
		frame.getContentPane().add(tp_content);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(26, 217, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btn_send = new JButton("\uBCF4\uB0B4\uAE30");
		btn_send.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btn_send.setBackground(new Color(240, 255, 255));
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
				boolean result = dao.insert_Ms(관리자번호, 보낸사람회원번호, tp_content.getText());
				
				if(result==true) {
					JOptionPane.showMessageDialog(null, "전송성공!");
					Mg_MessageBox_Main.main(null);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "전송실패!");
				}	
			}
		});
		btn_send.setBounds(47, 481, 131, 48);
		frame.getContentPane().add(btn_send);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(240, 255, 255));
		btnNewButton_1.setBounds(230, 481, 131, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("(\uAD00\uB9AC\uC790\uC6A9)");
		lblNewLabel_3.setBounds(12, 562, 71, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(Mg_answer.class.getResource("/image/\uB2F5\uC7A5-removebg-preview.png")));
		lblNewLabel_4.setBounds(12, 10, 385, 113);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
