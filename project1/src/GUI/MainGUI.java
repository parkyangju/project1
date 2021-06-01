package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.MemberDAO;
import Model.MemberVO;

public class MainGUI {

	private JFrame frame;
	private JTextField tf_number;
	private JTextField tf_pw;
	String name = "";
	int num = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 826, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tf_number = new JTextField();
		tf_number.setBounds(567, 154, 159, 32);
		frame.getContentPane().add(tf_number);
		tf_number.setColumns(10);
		
		tf_pw = new JPasswordField();
		tf_pw.setColumns(10);
		tf_pw.setBounds(567, 254, 159, 32);
		frame.getContentPane().add(tf_pw);
		
		JButton btn_login = new JButton("LOGIN");
		btn_login.setIcon(null);
		btn_login.setBackground(new Color(255, 153, 51));
		btn_login.setForeground(new Color(0, 0, 0));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int id = Integer.parseInt(tf_number.getText());
				String pw = tf_pw.getText();
				
				MemberDAO dao = new MemberDAO();
				MemberVO vo = dao.loginSelect(id,pw);
				if(vo == null) {
					JOptionPane.showMessageDialog(null, "�α��� ����", "�α���",JOptionPane.ERROR_MESSAGE);
					MainGUI.main(null);
				}else {
					if(id==0000&&pw.equals("0000")) {
						JOptionPane.showMessageDialog(null, vo.getMEM_NAME()+"�� ȯ���մϴ�!");
						������GUI an = new ������GUI();  //���ӱ��� ���ǿ� �����ڷ� �Ǿ��ִ�.
					}else {
					JOptionPane.showMessageDialog(null, vo.getMEM_NAME()+"�� ȯ���մϴ�!");
					POPUPGUI.main(null);
					name = vo.getMEM_NAME();
					num =vo.getMEMBER_NO();
					MenuchoiceGUI menuchoice = new MenuchoiceGUI(name,num); 
					
				}
				}	
				frame.dispose();
			}
			
		});
		btn_login.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
		btn_login.setBounds(582, 327, 125, 40);
		frame.getContentPane().add(btn_login);
		
		JButton btn_join = new JButton("JOIN");
		btn_join.setBackground(new Color(255, 153, 51));
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JoinGUI tb = new JoinGUI();
				frame.dispose();
			}
		});
		btn_join.setFont(new Font("Segoe UI Historic", Font.BOLD, 27));
		btn_join.setBounds(582, 385, 125, 40);
		frame.getContentPane().add(btn_join);
		
		JLabel lblȸ����ȣ = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		lblȸ����ȣ.setFont(new Font("���� ���", Font.BOLD, 18));
		lblȸ����ȣ.setBounds(567, 115, 86, 40);
		frame.getContentPane().add(lblȸ����ȣ);
		
		JLabel lbl��й�ȣ = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl��й�ȣ.setFont(new Font("���� ���", Font.BOLD, 18));
		lbl��й�ȣ.setBounds(568, 217, 101, 40);
		frame.getContentPane().add(lbl��й�ȣ);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 51));
		panel.setBounds(0, 0, 473, 523);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-33, 76, 523, 344);
		lblNewLabel_1.setIcon(new ImageIcon(MainGUI.class.getResource("/image/unnamed.jpg")));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainGUI.class.getResource("/image/INSSA-removebg-preview (1).png")));
		lblNewLabel.setBounds(81, 0, 303, 105);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblGym = new JLabel("");
		lblGym.setIcon(new ImageIcon(MainGUI.class.getResource("/image/gt-removebg-preview.png")));
		lblGym.setHorizontalAlignment(SwingConstants.CENTER);
		lblGym.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblGym.setBounds(114, 394, 234, 105);
		panel.add(lblGym);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MainGUI.class.getResource("/image/user2.png")));
		lblNewLabel_3.setBounds(531, 142, 34, 57);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainGUI.class.getResource("/image/lock.png")));
		lblNewLabel_2.setBounds(531, 246, 34, 40);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
