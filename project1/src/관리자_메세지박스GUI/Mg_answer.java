package ������_�޼����ڽ�GUI;

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
	private JTextField ������;
	private JTextField �޴�ȸ��;
	int �������ȸ����ȣ;
	int �����ڹ�ȣ;

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
		�������ȸ����ȣ = sendnum;
		�����ڹ�ȣ = managernum;
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
		lblNewLabel_2.setFont(new Font("���� ���", Font.BOLD, 15));
		lblNewLabel_2.setBounds(26, 154, 85, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		������ = new JTextField();
		������.setText(Integer.toString(�����ڹ�ȣ));
		������.setColumns(10);
		������.setBounds(127, 151, 116, 21);
		frame.getContentPane().add(������);
		
		�޴�ȸ�� = new JTextField();
		�޴�ȸ��.setColumns(10);
		�޴�ȸ��.setBounds(127, 182, 116, 21);
		frame.getContentPane().add(�޴�ȸ��);
		�޴�ȸ��.setText(Integer.toString(�������ȸ����ȣ));
		
		JLabel lblNewLabel = new JLabel("\uBC1B\uB294\uC0AC\uB78C :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 15));
		lblNewLabel.setBounds(26, 179, 85, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(26, 242, 355, 196);
		frame.getContentPane().add(tp_content);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 15));
		lblNewLabel_1.setBounds(26, 217, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btn_send = new JButton("\uBCF4\uB0B4\uAE30");
		btn_send.setFont(new Font("���� ���", Font.BOLD, 15));
		btn_send.setBackground(new Color(240, 255, 255));
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
				boolean result = dao.insert_Ms(�����ڹ�ȣ, �������ȸ����ȣ, tp_content.getText());
				
				if(result==true) {
					JOptionPane.showMessageDialog(null, "���ۼ���!");
					Mg_MessageBox_Main.main(null);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "���۽���!");
				}	
			}
		});
		btn_send.setBounds(47, 481, 131, 48);
		frame.getContentPane().add(btn_send);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setFont(new Font("���� ���", Font.BOLD, 15));
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
