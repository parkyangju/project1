package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ������_�Խ���GUI.Mg_BB_Main;
import ������_�ⱸGUI.������;
import ������_�޼����ڽ�GUI.Mg_MessageBox_Main;
import ������_ȸ����ȸGUI.MemberSearch;
import �������GUI.�������main;

public class ������GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					������GUI window = new ������GUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ������GUI() {
		
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(0, 102, 51));
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 586, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnȸ����ȸ = new JButton("");
		btnȸ����ȸ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MemberSearch.main(null);
				
			}
		});
		btnȸ����ȸ.setIcon(new ImageIcon(������GUI.class.getResource("/image/user.png")));
		btnȸ����ȸ.setBackground(new Color(240, 255, 255));
		btnȸ����ȸ.setBounds(29, 168, 117, 117);
		frame.getContentPane().add(btnȸ����ȸ);
		
		JButton btn�ⱸ������� = new JButton("");
		btn�ⱸ�������.setIcon(new ImageIcon(������GUI.class.getResource("/image/gym-dumbbell-black-silhouette.png")));
		btn�ⱸ�������.setBackground(new Color(240, 255, 255));
		btn�ⱸ�������.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				������.main(null);
			}
		});
		btn�ⱸ�������.setBounds(181, 168, 117, 117);
		frame.getContentPane().add(btn�ⱸ�������);
		
		JButton btnȸ���Խ��� = new JButton("");
		btnȸ���Խ���.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Mg_BB_Main.main(null);
				
			}
		});
		btnȸ���Խ���.setIcon(new ImageIcon(������GUI.class.getResource("/image/notepad.png")));
		btnȸ���Խ���.setBackground(new Color(240, 255, 255));
		btnȸ���Խ���.setBounds(29, 354, 117, 117);
		frame.getContentPane().add(btnȸ���Խ���);
		
		JButton btn�޼����� = new JButton("");
		btn�޼�����.setBackground(new Color(240, 255, 255));
		btn�޼�����.setIcon(new ImageIcon(������GUI.class.getResource("/image/conversation.png")));
		btn�޼�����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Mg_MessageBox_Main.main(null);
				
				
			}
		});
		btn�޼�����.setBounds(181, 354, 117, 117);
		frame.getContentPane().add(btn�޼�����);
		
		JLabel lblNewLabel_2 = new JLabel("\uD68C\uC6D0\uC870\uD68C");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("���� ���", Font.BOLD, 18));
		lblNewLabel_2.setBounds(44, 132, 91, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uAC8C\uC2DC\uAE00 \uC870\uD68C");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("���� ���", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(44, 314, 102, 30);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("\uAE30\uAD6C\uC608\uC57D \uAD00\uB9AC");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("���� ���", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(181, 132, 117, 26);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("\uBA54\uC138\uC9C0\uD568 \uAD00\uB9AC");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setFont(new Font("���� ���", Font.BOLD, 18));
		lblNewLabel_2_3.setBounds(185, 314, 113, 30);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 439, 106);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uD604\uC7AC \uD5EC\uC2A4\uC7A5 \uC778\uC6D0 \u25B6 12\uBA85");
		lblNewLabel_1.setBounds(12, 10, 233, 37);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC624\uB298 \uB204\uC801 \uC778\uC6D0 \u25B6 53\uBA85");
		lblNewLabel_1_1.setBounds(12, 42, 233, 25);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("���� ���", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uD2B8\uB808\uC774\uB108 \uC778\uC6D0 \u25B6 3\uBA85");
		lblNewLabel_1_1_1.setBounds(32, 69, 201, 27);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("���� ���", Font.BOLD, 18));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(������GUI.class.getResource("/image/\uB9E4\uB2C8\uC800-removebg-preview.png")));
		lblNewLabel_3.setBounds(439, 61, 119, 505);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_4 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(449, 558, 109, 23);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("���� ���", Font.BOLD, 15));
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		
		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790");
		lblNewLabel.setBounds(465, 10, 80, 39);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 25));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.setIcon(new ImageIcon(������GUI.class.getResource("/image/money.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				�������main.main(null);
				frame.dispose();
				
			}
		});
		btnNewButton.setBounds(325, 168, 114, 117);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("\uB9E4\uCD9C \uAD00\uB9AC");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_2_3_1.setFont(new Font("���� ���", Font.BOLD, 18));
		lblNewLabel_2_3_1.setBounds(336, 130, 91, 30);
		frame.getContentPane().add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(������GUI.class.getResource("/image/fitness.png")));
		lblNewLabel_4.setBounds(320, 295, 146, 231);
		frame.getContentPane().add(lblNewLabel_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI.main(null);
			}
		});
	}

}
