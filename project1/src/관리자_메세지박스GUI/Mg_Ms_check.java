package ������_�޼����ڽ�GUI;

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
	int �������ȸ����ȣ;
	int �޽�����ȣ;
	private JTextField tf_Ms_no;
	int �����ڹ�ȣ;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Mg_Ms_check(int sendnum, int managernum,int messagenum) {
		�������ȸ����ȣ = sendnum;
		�����ڹ�ȣ = managernum;
		�޽�����ȣ = messagenum;
	
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
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel);
		
		tf_Ms_no = new JTextField();
		tf_Ms_no.setBounds(123, 117, 60, 21);
		tf_Ms_no.setText(Integer.toString(�޽�����ȣ));
		tf_Ms_no.setColumns(10);
		frame.getContentPane().add(tf_Ms_no);
		
		tf_send_id = new JTextField();
		tf_send_id.setBounds(123, 151, 116, 21);
		frame.getContentPane().add(tf_send_id);
		tf_send_id.setColumns(10);
		tf_send_id.setText(Integer.toString(�������ȸ����ȣ));
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setBounds(26, 208, 57, 15);
		lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(26, 233, 356, 260);
		frame.getContentPane().add(tp_content);
		Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
		tp_content.setText(dao.View_Ms_content(�޽�����ȣ));
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setBounds(51, 523, 132, 33);
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.setFont(new Font("���� ���", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
				boolean result = dao.changeCheck(�޽�����ȣ);
				
				if(result == true) {
					JOptionPane.showMessageDialog(null, "Ȯ�οϷ�!");
					Mg_MessageBox_Main.main(null);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Ȯ�ν���!");
					Mg_MessageBox_Main.main(null);
					frame.dispose();
				}
				
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel(" \uBA54\uC2DC\uC9C0 \uBC88\uD638 :");
		lblNewLabel_2.setBounds(26, 113, 91, 28);
		lblNewLabel_2.setFont(new Font("���� ���", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("\uB2F5\uC7A5\uD558\uAE30");
		btnNewButton_1.setBounds(219, 523, 132, 33);
		btnNewButton_1.setBackground(new Color(240, 255, 255));
		btnNewButton_1.setFont(new Font("���� ���", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mg_answer answer = new Mg_answer(�������ȸ����ȣ, �����ڹ�ȣ);
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
