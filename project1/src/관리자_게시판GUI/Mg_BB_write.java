package 관리자_게시판GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.BulletinBoardDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mg_BB_write {

	private JFrame frame;
	private JTextField tf_subject;
	private JTextField tf_id;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Mg_BB_write() {
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
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9 : ");
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel.setBounds(25, 90, 47, 50);
		frame.getContentPane().add(lblNewLabel);
		
		tf_subject = new JTextField();
		tf_subject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tf_subject.setText("");				
			}
		});
		tf_subject.setForeground(Color.BLUE);
		tf_subject.setText("\uC81C\uBAA9\uC744 \uC785\uB825\uD558\uC138\uC694.");
		tf_subject.setColumns(10);
		tf_subject.setBounds(81, 96, 302, 40);
		frame.getContentPane().add(tf_subject);
		
		
		tf_id = new JTextField();
		tf_id.setForeground(Color.RED);
		tf_id.setText("\uAD00\uB9AC\uC790");
		tf_id.setText(Integer.toString(0000));  
		tf_id.setBounds(336, 157, 47, 21);
		frame.getContentPane().add(tf_id);
		tf_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(25, 150, 79, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane tp_content = new JTextPane();
		tp_content.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tp_content.setText("");
			}
		});
		tp_content.setText("\uB0B4\uC6A9\uC744 \uC785\uB825\uD558\uC138\uC694.");
		tp_content.setBounds(25, 188, 358, 275);
		frame.getContentPane().add(tp_content);
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D\uD558\uAE30");
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String subject = tf_subject.getText();
				String content = tp_content.getText();
				int member_no = Integer.parseInt(tf_id.getText());

				if (subject.equals("제목을 입력하세요.") || subject.equals("")) {
					JOptionPane.showMessageDialog(null, "제목을 입력하세요!");
				} else {
					if (content.equals("내용을 입력하세요.") || content.equals("")) {
						JOptionPane.showMessageDialog(null, "내용을 입력하세요.!");
					} else {
						BulletinBoardDAO dao = new BulletinBoardDAO();
						boolean result = dao.BB_Enrollment(member_no, subject, content);

						if (result == true) {
							JOptionPane.showMessageDialog(null, "등록성공!");
							Mg_BB_Main.main(null);
							frame.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "등록실패!");

						}
					}

				}
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.setBounds(55, 499, 115, 59);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Mg_BB_Main.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 22));
		btnNewButton_1.setBounds(216, 500, 115, 59);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("\uB2C9\uB124\uC784 :");
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_2.setBounds(282, 157, 56, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Mg_BB_write.class.getResource("/image/\uACF5\uC9C0-removebg-preview.png")));
		lblNewLabel_3.setBounds(71, 10, 260, 70);
		frame.getContentPane().add(lblNewLabel_3);
	}

}
