package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import 게시판GUI.회원게시판_Main;
import 기구예약GUI.tool;
import 메시지박스GUI.MessageBox_Main;
import 트레이너GUI.SelectTrainer;

import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuchoiceGUI {

	private JFrame frame;
	private JLabel lbl_이름호출;
	String name = "";
	int num=0;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuchoiceGUI window = new MenuchoiceGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
			}
			}
		});
	}
	*/

	
	
	public MenuchoiceGUI(String in_name, int mem_no) {
		name = in_name;
		num = mem_no;
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 585, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				JLabel lblNewLabel_4_1 = new JLabel("\u25B6\uBA54\uC138\uC9C0\uD568\u25C0");
				lblNewLabel_4_1.setBounds(242, 321, 121, 34);
				lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4_1.setForeground(Color.WHITE);
				lblNewLabel_4_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				frame.getContentPane().add(lblNewLabel_4_1);
				
				lblNewLabel_4 = new JLabel("  \u25B6\uAE30\uAD6C\uC608\uC57D\u25C0");
				lblNewLabel_4.setBounds(230, 127, 134, 27);
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setForeground(Color.WHITE);
				lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				frame.getContentPane().add(lblNewLabel_4);
		
				
				lblNewLabel_3 = new JLabel("\u25B6\uD2B8\uB808\uC774\uB108 \uC608\uC57D\u25C0");
				lblNewLabel_3.setBounds(38, 322, 163, 34);
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
				lblNewLabel_3.setForeground(Color.WHITE);
				frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(242, 160, 122, 123);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setIcon(new ImageIcon(MenuchoiceGUI.class.getResource("/image/workout-machine.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tool asd = new tool(name, num);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(57, 356, 122, 123);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setIcon(new ImageIcon(MenuchoiceGUI.class.getResource("/image/workout.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectTrainer select_trainer = new SelectTrainer(name);
				
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnNewButton_3.setBounds(147, 514, 116, 43);
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGUI.main(null);
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(435, 10, 134, 571);
		lblNewLabel_5.setIcon(new ImageIcon(MenuchoiceGUI.class.getResource("/image/inssa\uB85C\uACE0-removebg-preview.png")));
		frame.getContentPane().add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 442, 117);
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		lbl_이름호출 = new JLabel(name+"님 환영합니다!");
		lbl_이름호출.setBounds(151, 60, 279, 33);
		panel.add(lbl_이름호출);
		lbl_이름호출.setFont(new Font("한컴 고딕", Font.BOLD, 25));
		lbl_이름호출.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(MenuchoiceGUI.class.getResource("/image/dumbbell (1).png")));
		lblNewLabel_6.setBounds(76, 54, 63, 39);
		panel.add(lblNewLabel_6);
		
		JLabel lbl회원번호 = new JLabel("회원번호 : " +Integer.toString(num));
		lbl회원번호.setBounds(12, 9, 146, 34);
		panel.add(lbl회원번호);
		lbl회원번호.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		lbl회원번호.setForeground(Color.WHITE);
		
		JLabel lbl잔여기간_1 = new JLabel("\uC0AC\uC6A9\uAE30\uAC04 : 2021.01.06 ~ 2021.09.06");
		lbl잔여기간_1.setForeground(Color.WHITE);
		lbl잔여기간_1.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lbl잔여기간_1.setBounds(211, 10, 231, 34);
		panel.add(lbl잔여기간_1);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setBounds(241, 356, 122, 123);
		btnNewButton_2_1.setIcon(new ImageIcon(MenuchoiceGUI.class.getResource("/image/email.png")));
		btnNewButton_2_1.setBackground(Color.DARK_GRAY);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageBox_Main mb = new MessageBox_Main(name,num);
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(btnNewButton_2_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("\u25B6\uAC8C\uC2DC\uD310\u25C0");
		lblNewLabel_4_2.setBounds(57, 127, 122, 27);
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_4_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(57, 160, 122, 123);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setIcon(new ImageIcon(MenuchoiceGUI.class.getResource("/image/schedule.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				회원게시판_Main 회원게시판 = new 회원게시판_Main(num,name);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		
		
		

		
		
		
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
