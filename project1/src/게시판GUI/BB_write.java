package 게시판GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.BulletinBoardDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class BB_write {

	private JFrame frame;
	private JTextField tf_subject;
	private JTextField tf_id;
	int 작성회원번호;
	String name="";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public BB_write(int 회원번호, String name1) {
		name = name1;
		작성회원번호 = 회원번호;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 425, 626);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9 \u25B6");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(26, 77, 79, 50);
		frame.getContentPane().add(lblNewLabel);

		tf_subject = new JTextField();
		tf_subject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tf_subject.setText("");
			}
		});
		tf_subject.setText("\uC81C\uBAA9\uC744 \uC785\uB825\uD558\uC138\uC694.");
		tf_subject.setBounds(98, 87, 261, 40);
		frame.getContentPane().add(tf_subject);
		tf_subject.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(26, 168, 79, 40);
		frame.getContentPane().add(lblNewLabel_1);

		JTextPane tp_content = new JTextPane();
		tp_content.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tp_content.setText("");
			}
		});
		tp_content.setText("\uB0B4\uC6A9\uC744 \uC785\uB825\uD558\uC138\uC694.");
		tp_content.setBounds(26, 205, 333, 275);
		frame.getContentPane().add(tp_content);
		
		tf_id = new JTextField();               //여기에 회원번호를 자동으로 받아와야함
		tf_id.setBounds(98, 137, 86, 21);
		frame.getContentPane().add(tf_id);
		tf_id.setColumns(10);
		tf_id.setText(Integer.toString(작성회원번호));
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D\uD558\uAE30");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(new Color(255, 255, 255));
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
							회원게시판_Main 회원게시판 = new 회원게시판_Main(작성회원번호,name);
							frame.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "등록실패!");

						}
					}

				}

			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnNewButton.setBounds(59, 509, 107, 40);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				회원게시판_Main 회원게시판 = new 회원게시판_Main(작성회원번호,name);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_1.setBounds(209, 508, 107, 40);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("\uB2C9\uB124\uC784 \u25B6");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_2.setBounds(26, 137, 107, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(BB_write.class.getResource("/image/v-removebg-preview.png")));
		lblNewLabel_3.setBounds(114, 10, 211, 67);
		frame.getContentPane().add(lblNewLabel_3);

	}

}
