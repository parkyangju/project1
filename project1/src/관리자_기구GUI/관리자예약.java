package 관리자_기구GUI;

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
import 기구예약GUI.Reservation;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class 관리자예약 {
	
String[] arrtool = { "스미스머신", "런닝머신", "벤치프레스머신", "레그프레스머신" };
	
	String[] arrtime = { "18:00~18:30", "18:30~19:00", "19:00~19:30", "19:30~20:00", "20:00~20:30", "20:30~21:00" };
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	
	Date today = new Date(System.currentTimeMillis());
	Date tomorrow = new Date(today.getTime()+(long)(1000*60*60*24));
	Date tdat = new Date(tomorrow.getTime()+(long)(1000*60*60*24));
	
	
	String[] arrdate = { format1.format(today), format1.format(tomorrow),format1.format(tdat)};

	private JFrame frame;
	private JTextField 회원번호1;
	Healthdao dao = new Healthdao();
	String name = "조권우";
	int num = 0000;

	
	/**
	 * Create the application.
	 */
	public 관리자예약() {
		
		
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
		label_1.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		label_1.setBounds(39, 185, 131, 40);
		frame.getContentPane().add(label_1);
		
		회원번호1 = new JTextField();
		회원번호1.setColumns(10);
		회원번호1.setBounds(193, 196, 128, 21);
		frame.getContentPane().add(회원번호1);
		
		JLabel label_2 = new JLabel("\uAE30\uAD6C \uC120\uD0DD : ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		label_2.setBounds(57, 235, 113, 40);
		frame.getContentPane().add(label_2);
		
		JComboBox 기구 = new JComboBox();
		기구.setModel(new DefaultComboBoxModel(arrtool));
		기구.setSelectedIndex(0);
		기구.setFont(new Font("굴림", Font.PLAIN, 14));
		기구.setBounds(193, 245, 128, 21);
		frame.getContentPane().add(기구);
		
		JLabel label_3 = new JLabel("\uB0A0\uC9DC \uC120\uD0DD : ");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		label_3.setBounds(57, 285, 113, 40);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uC2DC\uAC04 \uC120\uD0DD : ");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		label_4.setBounds(57, 335, 113, 40);
		frame.getContentPane().add(label_4);
		
		JComboBox 날짜 = new JComboBox();
		날짜.setModel(new DefaultComboBoxModel(arrdate));
		날짜.setSelectedIndex(0);
		날짜.setFont(new Font("굴림", Font.PLAIN, 14));
		날짜.setBounds(193, 295, 128, 21);
		frame.getContentPane().add(날짜);
		
		JComboBox 시간 = new JComboBox();
		시간.setModel(new DefaultComboBoxModel(arrtime));
		시간.setSelectedIndex(0);
		시간.setFont(new Font("굴림", Font.PLAIN, 14));
		시간.setBounds(193, 345, 128, 21);
		frame.getContentPane().add(시간);
		
		JButton 예약 = new JButton("\uC608\uC57D");
		예약.setBackground(new Color(240, 255, 255));
		예약.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            
				if(회원번호1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "회원번호를 입력하세요!");
				}else {
					 int 회원번호 = Integer.parseInt(회원번호1.getText());
					 
					 Healthdao dao = new Healthdao();
						int 예약번호 = dao.예약번호불러오기(회원번호);
						int reservation_no = 예약번호;
						int member_no = Integer.parseInt(회원번호1.getText());
						String tool = 기구.getSelectedItem().toString();
						String date = 날짜.getSelectedItem().toString();
						String time = 시간.getSelectedItem().toString();
						Healthvo vo = new Healthvo(reservation_no, member_no, tool, date, time);
						boolean result = dao.Reservation(vo); 					
					
						if (result == false) {
							
							JOptionPane.showMessageDialog(null, "예약실패");
						} else {							
							JOptionPane.showMessageDialog(null, "예약성공");
							관리자.main(null);
							frame.dispose();
							
						}
					 
				}
				
  
			}				
		});
		예약.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		예약.setBounds(86, 458, 84, 40);
		frame.getContentPane().add(예약);
		
		JButton 예약표 = new JButton("\uC608\uC57D\uD45C");
		예약표.setBackground(new Color(240, 255, 255));
		예약표.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation a = new Reservation(name, num);
			}
		});
		예약표.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		예약표.setBounds(214, 458, 84, 40);
		frame.getContentPane().add(예약표);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 409, 91);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\uAE30\uAD6C \uC608\uC57D");
		label.setForeground(Color.WHITE);
		label.setBounds(144, 10, 135, 76);
		panel.add(label);
		label.setFont(new Font("한컴 고딕", Font.BOLD, 30));
		
		JButton 닫기 = new JButton("\uB2EB\uAE30");
		닫기.setBounds(332, 528, 65, 34);
		frame.getContentPane().add(닫기);
		닫기.setBackground(new Color(240, 255, 255));
		닫기.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 관리자.main(null);
			 frame.dispose();
			}
		});
		닫기.setFont(new Font("한컴 고딕", Font.BOLD, 16));
	}
}
