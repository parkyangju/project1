package ������_�ⱸGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Controller.Healthdao;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ���� {
	
	String[] arrtool = { "���̽��ӽ�", "���׸ӽ�", "��ġ�������ӽ�", "�����������ӽ�" };
	
	String[] arrtime = { "18:00~18:30", "18:30~19:00", "19:00~19:30", "19:30~20:00", "20:00~20:30", "20:30~21:00" };
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	Date today = new Date(System.currentTimeMillis());
	Date tomorrow = new Date(today.getTime()+(long)(1000*60*60*24));
	Date tdat = new Date(tomorrow.getTime()+(long)(1000*60*60*24));
	String[] arrdate = { format1.format(today), format1.format(tomorrow),format1.format(tdat)};
	
	private JFrame frame;
	private JTextField ȸ����ȣ;
	Healthdao dao = new Healthdao();
	int ���������ȣ = 0;
	private JTextField �����ȣ;
	int ����ȸ����ȣ = 0;
	
	/**
	 * Create the application.
	 */
	public ����(int selnumber, int ������ȸ����ȣ) {
		����ȸ����ȣ = ������ȸ����ȣ;
		���������ȣ = selnumber;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 585, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton �ݱ� = new JButton("\uB2EB\uAE30");
		�ݱ�.setBackground(new Color(240, 248, 255));
		�ݱ�.setFont(new Font("���� ���", Font.BOLD, 15));
		�ݱ�.setForeground(new Color(0, 0, 0));
		�ݱ�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������.main(null);
				frame.dispose();
				
			}
		});
		�ݱ�.setBounds(265, 464, 105, 50);
		frame.getContentPane().add(�ݱ�);
		
		JLabel tool11 = new JLabel("\uAE30\uAD6C :");
		tool11.setFont(new Font("���� ���", Font.BOLD, 18));
		tool11.setBounds(108, 255, 78, 31);
		frame.getContentPane().add(tool11);
		
		JLabel date11 = new JLabel("\uB0A0\uC9DC :");
		date11.setFont(new Font("���� ���", Font.BOLD, 18));
		date11.setBounds(108, 309, 78, 31);
		frame.getContentPane().add(date11);
		
		JLabel time11 = new JLabel("\uC2DC\uAC04 :");
		time11.setFont(new Font("���� ���", Font.BOLD, 18));
		time11.setBounds(108, 370, 78, 31);
		frame.getContentPane().add(time11);
		
		JLabel number11 = new JLabel("\uD68C\uC6D0\uBC88\uD638 :");
		number11.setFont(new Font("���� ���", Font.BOLD, 18));
		number11.setBounds(80, 199, 78, 31);
		frame.getContentPane().add(number11);
		
		ȸ����ȣ = new JTextField();
		ȸ����ȣ.setBounds(198, 205, 127, 21);
		frame.getContentPane().add(ȸ����ȣ);
		ȸ����ȣ.setColumns(10);
		ȸ����ȣ.setText(Integer.toString(����ȸ����ȣ));
		
		JComboBox �ⱸ = new JComboBox(arrtool);
		�ⱸ.setBounds(198, 261, 127, 21);
		frame.getContentPane().add(�ⱸ);
		
		JComboBox ��¥ = new JComboBox(arrdate);
		��¥.setBounds(198, 315, 127, 21);
		frame.getContentPane().add(��¥);
		
		JComboBox �ð� = new JComboBox(arrtime);
		�ð�.setBounds(198, 376, 127, 21);
		frame.getContentPane().add(�ð�);
		
		�����ȣ = new JTextField();
		�����ȣ.setText(Integer.toString(���������ȣ));
		�����ȣ.setColumns(10);
		�����ȣ.setBounds(198, 151, 127, 21);
		frame.getContentPane().add(�����ȣ);
		
		
		
		JButton �Ϸ� = new JButton("\uC644\uB8CC");
		�Ϸ�.setBackground(new Color(240, 248, 255));
		�Ϸ�.setFont(new Font("���� ���", Font.BOLD, 15));
		�Ϸ�.setForeground(new Color(0, 0, 0));
		�Ϸ�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               
				
				
					int reservation_no = ���������ȣ;
					int member_no = ����ȸ����ȣ;
					String tool = �ⱸ.getSelectedItem().toString();
					String date = ��¥.getSelectedItem().toString();
					String time = �ð�.getSelectedItem().toString();

					
					boolean result = dao.����(reservation_no, member_no, tool, date, time); 
					if (result == false) {
						JOptionPane.showMessageDialog(null, "��������");
						
					} else {
						JOptionPane.showMessageDialog(null, "��������");
						������.main(null);
						frame.dispose();
					}
				
				
				frame.dispose();
				
			}
		});
		�Ϸ�.setBounds(105, 464, 105, 50);
		frame.getContentPane().add(�Ϸ�);
		
		JLabel ���� = new JLabel("\uC608\uC57D\uBC88\uD638 :");
		����.setFont(new Font("���� ���", Font.BOLD, 18));
		����.setBounds(80, 145, 78, 31);
		frame.getContentPane().add(����);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 440, 87);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("\uC608\uC57D \uC218\uC815");
		lblNewLabel_2.setForeground(new Color(245, 255, 250));
		lblNewLabel_2.setFont(new Font("���� ���", Font.BOLD, 46));
		lblNewLabel_2.setBounds(109, 10, 200, 52);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(����.class.getResource("/image/\uC218\uC815-removebg-preview.png")));
		lblNewLabel.setBounds(417, 0, 140, 591);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
