package 관리자_기구GUI;

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
import GUI.관리자GUI;
import Model.Healthvo;
import java.awt.Color;
import javax.swing.JPanel;

public class 관리자 {

	private JFrame frame;
	private JTable table;
	int selnumber = 0;
	int 수정회원번호 = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					관리자 window = new 관리자();
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
	public 관리자() {
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selnumber = (int)table.getValueAt(table.getSelectedRow(), 0);
				수정회원번호 = (int)table.getValueAt(table.getSelectedRow(), 1);
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("\uAD00\uB9AC\uC790\uBAA8\uB4DC");
		lblNewLabel_1.setBounds(0, 597, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JButton 수정 = new JButton("\uC608\uC57D\uC218\uC815");
		수정.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		수정.setForeground(new Color(0, 0, 0));
		수정.setBackground(new Color(255, 240, 245));
		수정.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				if(helist.size()==0) {
//					JOptionPane.showMessageDialog(null, "수정할 데이터가 없습니다.");
//					//frame.dispose();
//				}else {
//					
//					수정 up = new 수정(selnumber);
//					frame.dispose();
//				}
				
				수정 수정 = new 수정(selnumber, 수정회원번호);
				frame.dispose();
				
			}
		});
		수정.setBounds(70, 437, 97, 49);
		frame.getContentPane().add(수정);

		JButton 삭제 = new JButton("\uC608\uC57D\uC0AD\uC81C");
		삭제.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		삭제.setForeground(new Color(0, 0, 0));
		삭제.setBackground(new Color(255, 240, 245));
		삭제.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				
					int result1 =JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
					if(result1 == JOptionPane.CLOSED_OPTION) {
						
					}else if(result1 == JOptionPane.YES_OPTION) {
						
						boolean result = dao.삭제(selnumber);
						
						if(result == true) {
							JOptionPane.showMessageDialog(null, "삭제성공!");
							관리자.main(null);
							frame.dispose();
						}else {
							JOptionPane.showMessageDialog(null, "삭제실패!");
						}
					}else {
						
					}
					
									
			}
		});
		삭제.setBounds(217, 437, 97, 49);
		frame.getContentPane().add(삭제);

		JButton 닫기 = new JButton("\uB2EB\uAE30");
		닫기.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		닫기.setForeground(Color.WHITE);
		닫기.setBackground(Color.DARK_GRAY);
		닫기.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				관리자GUI zzz = new 관리자GUI();
				frame.dispose();
			}
		});
		닫기.setBounds(332, 544, 65, 31);
		frame.getContentPane().add(닫기);
		
		JButton 초기화 = new JButton("\uCD08\uAE30\uD654");
		초기화.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		초기화.setForeground(new Color(0, 0, 0));
		초기화.setBackground(new Color(255, 240, 245));
		초기화.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
					
				int result3 =JOptionPane.showConfirmDialog(null, "정말 초기화하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				if(result3 == JOptionPane.CLOSED_OPTION) {
					
				}else if(result3 == JOptionPane.YES_OPTION) {
					
					Healthdao dao = new Healthdao();
					boolean result = dao.초기화(); 
					if (result == false) {
						JOptionPane.showMessageDialog(null, "초기화 실패");
					} else {
						JOptionPane.showMessageDialog(null, "초기화 성공");
						관리자.main(null);
						frame.dispose();
					}
				}else {
					
				}
				
								
		
					
				
			
			}
		});
		초기화.setBounds(70, 508, 97, 49);
		frame.getContentPane().add(초기화);
		
		JButton 예약 = new JButton("\uC608\uC57D");
		예약.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		예약.setForeground(new Color(0, 0, 0));
		예약.setBackground(new Color(255, 240, 245));
		예약.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 관리자예약 to = new 관리자예약();
			 frame.dispose();
			}
		});
		예약.setBounds(217, 508, 97, 49);
		frame.getContentPane().add(예약);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 409, 83);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		

		JLabel lblNewLabel = new JLabel("\uAE30\uAD6C \uC608\uC57D");
		lblNewLabel.setBounds(120, 10, 159, 52);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 40));
	}
}
