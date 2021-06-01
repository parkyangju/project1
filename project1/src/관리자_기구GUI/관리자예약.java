package ������_�ⱸGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;

import Controller.Healthdao;
import Model.Healthvo;
import �ⱸ����GUI.Reservation;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class �����ڿ��� {
	
String[] arrtool = { "���̽��ӽ�", "���׸ӽ�", "��ġ�������ӽ�", "�����������ӽ�" };
	
	String[] arrtime = { "18:00~18:30", "18:30~19:00", "19:00~19:30", "19:30~20:00", "20:00~20:30", "20:30~21:00" };
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	
	Date today = new Date(System.currentTimeMillis());
	Date tomorrow = new Date(today.getTime()+(long)(1000*60*60*24));
	Date tdat = new Date(tomorrow.getTime()+(long)(1000*60*60*24));
	
	
	String[] arrdate = { format1.format(today), format1.format(tomorrow),format1.format(tdat)};

	private JFrame frame;
	private JTextField ȸ����ȣ1;
	Healthdao dao = new Healthdao();
	String name = "���ǿ�";
	int num = 0000;

	
	/**
	 * Create the application.
	 */
	public �����ڿ���() {
		
		
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 425, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\uD68C\uC6D0 \uBC88\uD638 \uC785\uB825 : ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("���� ���", Font.BOLD, 18));
		label_1.setBounds(39, 185, 131, 40);
		frame.getContentPane().add(label_1);
		
		ȸ����ȣ1 = new JTextField();
		ȸ����ȣ1.setColumns(10);
		ȸ����ȣ1.setBounds(193, 196, 128, 21);
		frame.getContentPane().add(ȸ����ȣ1);
		
		JLabel label_2 = new JLabel("\uAE30\uAD6C \uC120\uD0DD : ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("���� ���", Font.BOLD, 18));
		label_2.setBounds(57, 235, 113, 40);
		frame.getContentPane().add(label_2);
		
		JComboBox �ⱸ = new JComboBox();
		�ⱸ.setModel(new DefaultComboBoxModel(arrtool));
		�ⱸ.setSelectedIndex(0);
		�ⱸ.setFont(new Font("����", Font.PLAIN, 14));
		�ⱸ.setBounds(193, 245, 128, 21);
		frame.getContentPane().add(�ⱸ);
		
		JLabel label_3 = new JLabel("\uB0A0\uC9DC \uC120\uD0DD : ");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("���� ���", Font.BOLD, 18));
		label_3.setBounds(57, 285, 113, 40);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uC2DC\uAC04 \uC120\uD0DD : ");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("���� ���", Font.BOLD, 18));
		label_4.setBounds(57, 335, 113, 40);
		frame.getContentPane().add(label_4);
		
		JComboBox ��¥ = new JComboBox();
		��¥.setModel(new DefaultComboBoxModel(arrdate));
		��¥.setSelectedIndex(0);
		��¥.setFont(new Font("����", Font.PLAIN, 14));
		��¥.setBounds(193, 295, 128, 21);
		frame.getContentPane().add(��¥);
		
		JComboBox �ð� = new JComboBox();
		�ð�.setModel(new DefaultComboBoxModel(arrtime));
		�ð�.setSelectedIndex(0);
		�ð�.setFont(new Font("����", Font.PLAIN, 14));
		�ð�.setBounds(193, 345, 128, 21);
		frame.getContentPane().add(�ð�);
		
		JButton ���� = new JButton("\uC608\uC57D");
		����.setBackground(new Color(240, 255, 255));
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            
				if(ȸ����ȣ1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ȸ����ȣ�� �Է��ϼ���!");
				}else {
					 int ȸ����ȣ = Integer.parseInt(ȸ����ȣ1.getText());
					 
					 Healthdao dao = new Healthdao();
						int �����ȣ = dao.�����ȣ�ҷ�����(ȸ����ȣ);
						int reservation_no = �����ȣ;
						int member_no = Integer.parseInt(ȸ����ȣ1.getText());
						String tool = �ⱸ.getSelectedItem().toString();
						String date = ��¥.getSelectedItem().toString();
						String time = �ð�.getSelectedItem().toString();
						Healthvo vo = new Healthvo(reservation_no, member_no, tool, date, time);
						boolean result = dao.Reservation(vo); 					
					
						if (result == false) {
							
							JOptionPane.showMessageDialog(null, "�������");
						} else {							
							JOptionPane.showMessageDialog(null, "���༺��");
							������.main(null);
							frame.dispose();
							
						}
					 
				}
				
  
			}				
		});
		����.setFont(new Font("���� ���", Font.BOLD, 16));
		����.setBounds(86, 458, 84, 40);
		frame.getContentPane().add(����);
		
		JButton ����ǥ = new JButton("\uC608\uC57D\uD45C");
		����ǥ.setBackground(new Color(240, 255, 255));
		����ǥ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation a = new Reservation(name, num);
			}
		});
		����ǥ.setFont(new Font("���� ���", Font.BOLD, 16));
		����ǥ.setBounds(214, 458, 84, 40);
		frame.getContentPane().add(����ǥ);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 409, 91);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\uAE30\uAD6C \uC608\uC57D");
		label.setForeground(Color.WHITE);
		label.setBounds(144, 10, 135, 76);
		panel.add(label);
		label.setFont(new Font("���� ���", Font.BOLD, 30));
		
		JButton �ݱ� = new JButton("\uB2EB\uAE30");
		�ݱ�.setBounds(332, 528, 65, 34);
		frame.getContentPane().add(�ݱ�);
		�ݱ�.setBackground(new Color(240, 255, 255));
		�ݱ�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 ������.main(null);
			 frame.dispose();
			}
		});
		�ݱ�.setFont(new Font("���� ���", Font.BOLD, 16));
	}
}
