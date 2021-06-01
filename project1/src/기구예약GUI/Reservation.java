package 기구예약GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Healthdao;
import Model.Healthvo;
import 관리자_기구GUI.관리자예약;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Reservation {

	private JFrame frame;
	private JTable table;
	String name = "";
	int num=0;
	
	/**
	 * Create the application.
	 */
	public Reservation(String 이름, int 회원번호) {
		name = 이름;
		num = 회원번호;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 425, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 116, 357, 361);
		frame.getContentPane().add(scrollPane);
		
		Healthdao dao = new Healthdao();
		String[] colnames = { "예약번호","회원번호", "기구이름", "날짜", "시간" };
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
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(num==0000) {
					frame.dispose();
					관리자예약 a = new 관리자예약();
				}else {
					frame.dispose();
					tool a = new tool(name,num);
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		btnNewButton.setBounds(148, 511, 103, 40);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 51));
		panel.setBounds(0, 0, 409, 91);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Reservation.class.getResource("/image/\uC608\uC57D\uD45C-removebg-preview.png")));
		lblNewLabel.setBounds(43, 10, 307, 71);
		panel.add(lblNewLabel);
	}
}
