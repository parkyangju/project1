package ������_�ⱸGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Healthdao;
import GUI.������GUI;
import Model.Healthvo;
import java.awt.Color;
import javax.swing.JPanel;

public class ������ {

	private JFrame frame;
	private JTable table;
	int selnumber = 0;
	int ����ȸ����ȣ = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					������ window = new ������();
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
	public ������() {
		initialize();
		
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 387, 317);
		frame.getContentPane().add(scrollPane);

		Healthdao dao = new Healthdao();
		String[] colnames = { "�����ȣ","ȸ����ȣ", "�ⱸ�̸�", "��¥", "�ð�" };
		ArrayList<Healthvo> helist = dao.AllSelect();
		Object[][] data = new Object[helist.size()][5];
		for (int i = 0; i < helist.size(); i++) {
			data[i][0] = helist.get(i).getReservation_no();
			data[i][1] = helist.get(i).getMember_no();
			data[i][2] = helist.get(i).getTool();
			data[i][3] = helist.get(i).getDate1();
			data[i][4] = helist.get(i).getTime1();
		}

		table = new JTable(data, colnames);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selnumber = (int)table.getValueAt(table.getSelectedRow(), 0);
				����ȸ����ȣ = (int)table.getValueAt(table.getSelectedRow(), 1);
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("\uAD00\uB9AC\uC790\uBAA8\uB4DC");
		lblNewLabel_1.setBounds(0, 597, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JButton ���� = new JButton("\uC608\uC57D\uC218\uC815");
		����.setFont(new Font("���� ���", Font.BOLD, 16));
		����.setForeground(new Color(0, 0, 0));
		����.setBackground(new Color(255, 240, 245));
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				if(helist.size()==0) {
//					JOptionPane.showMessageDialog(null, "������ �����Ͱ� �����ϴ�.");
//					//frame.dispose();
//				}else {
//					
//					���� up = new ����(selnumber);
//					frame.dispose();
//				}
				
				���� ���� = new ����(selnumber, ����ȸ����ȣ);
				frame.dispose();
				
			}
		});
		����.setBounds(70, 437, 97, 49);
		frame.getContentPane().add(����);

		JButton ���� = new JButton("\uC608\uC57D\uC0AD\uC81C");
		����.setFont(new Font("���� ���", Font.BOLD, 16));
		����.setForeground(new Color(0, 0, 0));
		����.setBackground(new Color(255, 240, 245));
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				
					int result1 =JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION);
					if(result1 == JOptionPane.CLOSED_OPTION) {
						
					}else if(result1 == JOptionPane.YES_OPTION) {
						
						boolean result = dao.����(selnumber);
						
						if(result == true) {
							JOptionPane.showMessageDialog(null, "��������!");
							������.main(null);
							frame.dispose();
						}else {
							JOptionPane.showMessageDialog(null, "��������!");
						}
					}else {
						
					}
					
									
			}
		});
		����.setBounds(217, 437, 97, 49);
		frame.getContentPane().add(����);

		JButton �ݱ� = new JButton("\uB2EB\uAE30");
		�ݱ�.setFont(new Font("���� ���", Font.BOLD, 15));
		�ݱ�.setForeground(Color.WHITE);
		�ݱ�.setBackground(Color.DARK_GRAY);
		�ݱ�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������GUI zzz = new ������GUI();
				frame.dispose();
			}
		});
		�ݱ�.setBounds(332, 544, 65, 31);
		frame.getContentPane().add(�ݱ�);
		
		JButton �ʱ�ȭ = new JButton("\uCD08\uAE30\uD654");
		�ʱ�ȭ.setFont(new Font("���� ���", Font.BOLD, 16));
		�ʱ�ȭ.setForeground(new Color(0, 0, 0));
		�ʱ�ȭ.setBackground(new Color(255, 240, 245));
		�ʱ�ȭ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
					
				int result3 =JOptionPane.showConfirmDialog(null, "���� �ʱ�ȭ�Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION);
				if(result3 == JOptionPane.CLOSED_OPTION) {
					
				}else if(result3 == JOptionPane.YES_OPTION) {
					
					Healthdao dao = new Healthdao();
					boolean result = dao.�ʱ�ȭ(); 
					if (result == false) {
						JOptionPane.showMessageDialog(null, "�ʱ�ȭ ����");
					} else {
						JOptionPane.showMessageDialog(null, "�ʱ�ȭ ����");
						������.main(null);
						frame.dispose();
					}
				}else {
					
				}
				
								
		
					
				
			
			}
		});
		�ʱ�ȭ.setBounds(70, 508, 97, 49);
		frame.getContentPane().add(�ʱ�ȭ);
		
		JButton ���� = new JButton("\uC608\uC57D");
		����.setFont(new Font("���� ���", Font.BOLD, 16));
		����.setForeground(new Color(0, 0, 0));
		����.setBackground(new Color(255, 240, 245));
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 �����ڿ��� to = new �����ڿ���();
			 frame.dispose();
			}
		});
		����.setBounds(217, 508, 97, 49);
		frame.getContentPane().add(����);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 409, 83);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		

		JLabel lblNewLabel = new JLabel("\uAE30\uAD6C \uC608\uC57D");
		lblNewLabel.setBounds(120, 10, 159, 52);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 40));
	}
}
