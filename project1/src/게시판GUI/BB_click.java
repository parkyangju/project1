package 게시판GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.BulletinBoardDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class BB_click  {
	
	

	private JFrame frame;
	private JTextField tf_subject;
	private JTextField tf_id;
	private JTextField tf_ViewNo;
	String viewNumber;
	int 회원번호 ;
	String name = "";

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public BB_click(String ViewNo, String name1, int 번호) {
		회원번호 = 번호;
		name = name1;
		viewNumber = ViewNo;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 426, 626);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9 \u25B6");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(66, 134, 66, 50);
		frame.getContentPane().add(lblNewLabel);
		
		tf_ViewNo = new JTextField();
		tf_ViewNo.setBounds(135, 106, 86, 21);
		frame.getContentPane().add(tf_ViewNo);
		tf_ViewNo.setColumns(10);
		tf_ViewNo.setText(viewNumber);
		
		tf_subject = new JTextField();
		tf_subject.setColumns(10);
		tf_subject.setBounds(133, 140, 239, 40);
		frame.getContentPane().add(tf_subject);
		BulletinBoardDAO dao = new BulletinBoardDAO();      //dao 객체 생성
		tf_subject.setText(dao.callsubject(viewNumber));
		
		tf_id = new JTextField();
		tf_id.setColumns(10);
		tf_id.setBounds(133, 190, 135, 21);
		frame.getContentPane().add(tf_id);
		tf_id.setText(Integer.toString(dao.callId(viewNumber)));   //viewNumber 는 게시글번호
		
		JLabel lblNewLabel_2 = new JLabel("\uC791\uC131\uC790 \uB2C9\uB124\uC784 \u25B6");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_2.setBounds(17, 190, 115, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 209, 115, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(28, 249, 358, 252);
		frame.getContentPane().add(tp_content);
		tp_content.setText(dao.callContent(viewNumber));
		
		JLabel lblNewLabel_3 = new JLabel("\uAC8C\uC2DC\uAE00\uBC88\uD638 \u25B6");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_3.setBounds(27, 109, 105, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		JButton btnNewButton = new JButton("\uC804\uCCB4\uAC8C\uC2DC\uAE00 \uBCF4\uAE30");
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				회원게시판_Main 회원게시판 = new 회원게시판_Main(회원번호, name);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(102, 522, 186, 40);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(BB_click.class.getResource("/image/v-removebg-preview.png")));
		lblNewLabel_4.setBounds(39, 10, 325, 77);
		frame.getContentPane().add(lblNewLabel_4);
	}
	

}
