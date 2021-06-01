package 관리자_게시판GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;

import Controller.BulletinBoardDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Mg_BB_Modify {

	private JFrame frame;
	private JTextField tf_BB_no;
	private JTextField tf_subject;
	private JTextField tf_id;
	String number ;
	String subject;
	String content;
	int id;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Mg_BB_Modify(int selectBB,String selsubject,String selcontent,int selmember_no) {
		number = Integer.toString(selectBB);
		subject = selsubject;
		content = selcontent;
		id = selmember_no;
		initialize();
		frame.setVisible(true);
		
	}
	
	BulletinBoardDAO dao = new BulletinBoardDAO();
	private JButton btn_edit;
	private JButton btn_cancel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 425, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uAC8C\uC2DC\uAE00\uBC88\uD638 :");
		lblNewLabel_3.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_3.setBounds(12, 89, 79, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		tf_BB_no = new JTextField();
		tf_BB_no.setText(number);
		tf_BB_no.setColumns(10);
		tf_BB_no.setBounds(94, 86, 86, 21);
		frame.getContentPane().add(tf_BB_no);
		
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9 : ");
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(12, 114, 69, 50);
		frame.getContentPane().add(lblNewLabel);
		
		tf_subject = new JTextField();
		tf_subject.setText(subject);
		tf_subject.setColumns(10);
		tf_subject.setBounds(80, 123, 317, 40);
		frame.getContentPane().add(tf_subject);
		
		tf_id = new JTextField();
		tf_id.setText(Integer.toString(id));
		tf_id.setColumns(10);
		tf_id.setBounds(318, 185, 79, 21);
		frame.getContentPane().add(tf_id);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 175, 115, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setText(content);
		tp_content.setBounds(12, 215, 385, 275);
		frame.getContentPane().add(tp_content);
		
		btn_edit = new JButton("\uC218\uC815\uC644\uB8CC");
		btn_edit.setBackground(new Color(255, 240, 245));
		btn_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Esubject = tf_subject.getText();
				String Econtent = tp_content.getText();
				
				BulletinBoardDAO dao = new BulletinBoardDAO();
				boolean result1 = dao.BBEdit_subject(number, Esubject);
				boolean result2 = dao.BBEdit_content(number, Econtent);
				
				if(result1 == true && result2 == true) {
					JOptionPane.showMessageDialog(null, "수정성공!");
					Mg_BB_Main.main(null);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "수정실패!");
				}
				
			}
		});
		btn_edit.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		btn_edit.setBounds(50, 512, 120, 50);
		frame.getContentPane().add(btn_edit);
		
		btn_cancel = new JButton("\uCDE8\uC18C");
		btn_cancel.setBackground(new Color(255, 240, 245));
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mg_BB_Main.main(null);
				frame.dispose();
				
			}
		});
		btn_cancel.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		btn_cancel.setBounds(228, 512, 120, 50);
		frame.getContentPane().add(btn_cancel);
		
		lblNewLabel_2 = new JLabel("\uC791\uC131\uC790 \uB2C9\uB124\uC784 :");
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_2.setBounds(212, 188, 94, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(Mg_BB_Modify.class.getResource("/image/\uC218\uC815\uBA54\uC138\uC9C0-removebg-preview (1).png")));
		lblNewLabel_4.setBounds(0, 0, 409, 76);
		frame.getContentPane().add(lblNewLabel_4);
	}

}
