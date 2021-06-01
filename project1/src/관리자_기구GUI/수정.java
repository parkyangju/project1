package 관리자_기구GUI;

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

public class 수정 {
	
	String[] arrtool = { "스미스머신", "런닝머신", "벤치프레스머신", "레그프레스머신" };
	
	String[] arrtime = { "18:00~18:30", "18:30~19:00", "19:00~19:30", "19:30~20:00", "20:00~20:30", "20:30~21:00" };
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	Date today = new Date(System.currentTimeMillis());
	Date tomorrow = new Date(today.getTime()+(long)(1000*60*60*24));
	Date tdat = new Date(tomorrow.getTime()+(long)(1000*60*60*24));
	String[] arrdate = { format1.format(today), format1.format(tomorrow),format1.format(tdat)};
	
	private JFrame frame;
	private JTextField 회원번호;
	Healthdao dao = new Healthdao();
	int 수정예약번호 = 0;
	private JTextField 예약번호;
	int 수정회원번호 = 0;
	
	/**
	 * Create the application.
	 */
	public 수정(int selnumber, int 수정할회원번호) {
		수정회원번호 = 수정할회원번호;
		수정예약번호 = selnumber;
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
		
		JButton 닫기 = new JButton("\uB2EB\uAE30");
		닫기.setBackground(new Color(240, 248, 255));
		닫기.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		닫기.setForeground(new Color(0, 0, 0));
		닫기.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				관리자.main(null);
				frame.dispose();
				
			}
		});
		닫기.setBounds(265, 464, 105, 50);
		frame.getContentPane().add(닫기);
		
		JLabel tool11 = new JLabel("\uAE30\uAD6C :");
		tool11.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		tool11.setBounds(108, 255, 78, 31);
		frame.getContentPane().add(tool11);
		
		JLabel date11 = new JLabel("\uB0A0\uC9DC :");
		date11.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		date11.setBounds(108, 309, 78, 31);
		frame.getContentPane().add(date11);
		
		JLabel time11 = new JLabel("\uC2DC\uAC04 :");
		time11.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		time11.setBounds(108, 370, 78, 31);
		frame.getContentPane().add(time11);
		
		JLabel number11 = new JLabel("\uD68C\uC6D0\uBC88\uD638 :");
		number11.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		number11.setBounds(80, 199, 78, 31);
		frame.getContentPane().add(number11);
		
		회원번호 = new JTextField();
		회원번호.setBounds(198, 205, 127, 21);
		frame.getContentPane().add(회원번호);
		회원번호.setColumns(10);
		회원번호.setText(Integer.toString(수정회원번호));
		
		JComboBox 기구 = new JComboBox(arrtool);
		기구.setBounds(198, 261, 127, 21);
		frame.getContentPane().add(기구);
		
		JComboBox 날짜 = new JComboBox(arrdate);
		날짜.setBounds(198, 315, 127, 21);
		frame.getContentPane().add(날짜);
		
		JComboBox 시간 = new JComboBox(arrtime);
		시간.setBounds(198, 376, 127, 21);
		frame.getContentPane().add(시간);
		
		예약번호 = new JTextField();
		예약번호.setText(Integer.toString(수정예약번호));
		예약번호.setColumns(10);
		예약번호.setBounds(198, 151, 127, 21);
		frame.getContentPane().add(예약번호);
		
		
		
		JButton 완료 = new JButton("\uC644\uB8CC");
		완료.setBackground(new Color(240, 248, 255));
		완료.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		완료.setForeground(new Color(0, 0, 0));
		완료.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               
				
				
					int reservation_no = 수정예약번호;
					int member_no = 수정회원번호;
					String tool = 기구.getSelectedItem().toString();
					String date = 날짜.getSelectedItem().toString();
					String time = 시간.getSelectedItem().toString();

					
					boolean result = dao.수정(reservation_no, member_no, tool, date, time); 
					if (result == false) {
						JOptionPane.showMessageDialog(null, "수정실패");
						
					} else {
						JOptionPane.showMessageDialog(null, "수정성공");
						관리자.main(null);
						frame.dispose();
					}
				
				
				frame.dispose();
				
			}
		});
		완료.setBounds(105, 464, 105, 50);
		frame.getContentPane().add(완료);
		
		JLabel 예약 = new JLabel("\uC608\uC57D\uBC88\uD638 :");
		예약.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		예약.setBounds(80, 145, 78, 31);
		frame.getContentPane().add(예약);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 440, 87);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("\uC608\uC57D \uC218\uC815");
		lblNewLabel_2.setForeground(new Color(245, 255, 250));
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 46));
		lblNewLabel_2.setBounds(109, 10, 200, 52);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(수정.class.getResource("/image/\uC218\uC815-removebg-preview.png")));
		lblNewLabel.setBounds(417, 0, 140, 591);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
