package 기구예약GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Healthdao;
import GUI.MenuchoiceGUI;
import Model.Healthvo;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class tool {

	String[] arrtool = { "스미스머신", "런닝머신", "벤치프레스머신", "레그프레스머신" };
	
	String[] arrtime = { "18:00~18:30", "18:30~19:00", "19:00~19:30", "19:30~20:00", "20:00~20:30", "20:30~21:00" };
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	
	Date today = new Date(System.currentTimeMillis());
	Date tomorrow = new Date(today.getTime()+(long)(1000*60*60*24));
	Date tdat = new Date(tomorrow.getTime()+(long)(1000*60*60*24));
	String name = "";
	int num=0;
	
	String[] arrdate = { format1.format(today), format1.format(tomorrow),format1.format(tdat)};

	private JFrame frame;
	private JTextField 회원번호;
	private JTextField 회원번호1;
	Healthdao dao = new Healthdao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					tool window = new tool();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public tool(String in_name,int mem_no) {
		name = in_name;
		num = mem_no;
		initialize();
		frame.setVisible(true);
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 629);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 51));
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JComboBox 기구 = new JComboBox();
		기구.setBounds(213, 246, 128, 21);
		기구.addMouseListener(new MouseAdapter() {

		});
		panel.setLayout(null);
		기구.setFont(new Font("굴림", Font.PLAIN, 14));
		기구.setModel(new DefaultComboBoxModel(arrtool));
		기구.setSelectedIndex(0);
		panel.add(기구);

		JLabel lblNewLabel_1 = new JLabel("\uAE30\uAD6C \uC120\uD0DD : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(90, 236, 101, 40);
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		panel.add(lblNewLabel_1);

		JLabel label = new JLabel("\uB0A0\uC9DC \uC120\uD0DD : ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setBounds(90, 286, 101, 40);
		label.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		panel.add(label);

		JComboBox 날짜 = new JComboBox();
		날짜.setBounds(213, 296, 128, 21);
		날짜.setFont(new Font("굴림", Font.PLAIN, 14));
		날짜.setModel(new DefaultComboBoxModel(arrdate));
		날짜.setSelectedIndex(0);
		panel.add(날짜);
		
		회원번호1 = new JTextField(Integer.toString(num));
		회원번호1.setBounds(213, 197, 128, 21);
		panel.add(회원번호1);
		회원번호1.setColumns(10);
		
		JLabel 회원번호2 = new JLabel();
		회원번호2.setBounds(244, 100, 57, 15);
		panel.add(회원번호2);

		JLabel label_1 = new JLabel("\uC2DC\uAC04 \uC120\uD0DD : ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(90, 336, 101, 40);
		label_1.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		panel.add(label_1);

		JComboBox 시간 = new JComboBox();
		시간.setBounds(213, 346, 128, 21);
		시간.setModel(new DefaultComboBoxModel(arrtime));
		시간.setSelectedIndex(0);
		시간.setFont(new Font("굴림", Font.PLAIN, 14));
		panel.add(시간);

		JButton 예약 = new JButton("\uC608\uC57D");
		예약.setForeground(Color.WHITE);
		예약.setBackground(Color.DARK_GRAY);
		예약.setBounds(42, 438, 91, 48);
		예약.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
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
						
						
					}
				}
				
				

			}
		});
		예약.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		panel.add(예약);

		JButton 닫기 = new JButton("\uB2EB\uAE30");
		닫기.setForeground(Color.WHITE);
		닫기.setBackground(Color.DARK_GRAY);
		닫기.setBounds(302, 438, 91, 48);
		닫기.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuchoiceGUI zza = new MenuchoiceGUI(name,num);
				frame.dispose();
			}
		});
		닫기.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		panel.add(닫기);

	

		JButton 예약표확인 = new JButton("\uC608\uC57D \uD655\uC778");
		예약표확인.setForeground(Color.WHITE);
		예약표확인.setBackground(Color.DARK_GRAY);
		예약표확인.setBounds(158, 438, 121, 48);
		예약표확인.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation re = new Reservation(name, num);
				frame.dispose();
			}
		});
		예약표확인.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		panel.add(예약표확인);
		
		JLabel label_2 = new JLabel("\uD68C\uC6D0 \uBC88\uD638 : ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(90, 186, 101, 40);
		label_2.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 442, 96);
		panel_1.setBackground(Color.DARK_GRAY);
		panel.add(panel_1);
						panel_1.setLayout(null);
				
						JLabel lblNewLabel = new JLabel("\uAE30\uAD6C \uC608\uC57D");
						lblNewLabel.setBounds(124, 27, 165, 59);
						panel_1.add(lblNewLabel);
						lblNewLabel.setForeground(Color.WHITE);
						lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 40));
						
						JLabel lblNewLabel_2 = new JLabel("New label");
						lblNewLabel_2.setIcon(new ImageIcon(tool.class.getResource("/image/\uB9AC\uC808-removebg-preview.png")));
						lblNewLabel_2.setBounds(440, 0, 129, 580);
						panel.add(lblNewLabel_2);
		
		

	}
}
