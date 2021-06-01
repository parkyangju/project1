package �ⱸ����GUI;

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

	String[] arrtool = { "���̽��ӽ�", "���׸ӽ�", "��ġ�������ӽ�", "�����������ӽ�" };
	
	String[] arrtime = { "18:00~18:30", "18:30~19:00", "19:00~19:30", "19:30~20:00", "20:00~20:30", "20:30~21:00" };
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	
	Date today = new Date(System.currentTimeMillis());
	Date tomorrow = new Date(today.getTime()+(long)(1000*60*60*24));
	Date tdat = new Date(tomorrow.getTime()+(long)(1000*60*60*24));
	String name = "";
	int num=0;
	
	String[] arrdate = { format1.format(today), format1.format(tomorrow),format1.format(tdat)};

	private JFrame frame;
	private JTextField ȸ����ȣ;
	private JTextField ȸ����ȣ1;
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

		JComboBox �ⱸ = new JComboBox();
		�ⱸ.setBounds(213, 246, 128, 21);
		�ⱸ.addMouseListener(new MouseAdapter() {

		});
		panel.setLayout(null);
		�ⱸ.setFont(new Font("����", Font.PLAIN, 14));
		�ⱸ.setModel(new DefaultComboBoxModel(arrtool));
		�ⱸ.setSelectedIndex(0);
		panel.add(�ⱸ);

		JLabel lblNewLabel_1 = new JLabel("\uAE30\uAD6C \uC120\uD0DD : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(90, 236, 101, 40);
		lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 18));
		panel.add(lblNewLabel_1);

		JLabel label = new JLabel("\uB0A0\uC9DC \uC120\uD0DD : ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setBounds(90, 286, 101, 40);
		label.setFont(new Font("���� ���", Font.BOLD, 18));
		panel.add(label);

		JComboBox ��¥ = new JComboBox();
		��¥.setBounds(213, 296, 128, 21);
		��¥.setFont(new Font("����", Font.PLAIN, 14));
		��¥.setModel(new DefaultComboBoxModel(arrdate));
		��¥.setSelectedIndex(0);
		panel.add(��¥);
		
		ȸ����ȣ1 = new JTextField(Integer.toString(num));
		ȸ����ȣ1.setBounds(213, 197, 128, 21);
		panel.add(ȸ����ȣ1);
		ȸ����ȣ1.setColumns(10);
		
		JLabel ȸ����ȣ2 = new JLabel();
		ȸ����ȣ2.setBounds(244, 100, 57, 15);
		panel.add(ȸ����ȣ2);

		JLabel label_1 = new JLabel("\uC2DC\uAC04 \uC120\uD0DD : ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(90, 336, 101, 40);
		label_1.setFont(new Font("���� ���", Font.BOLD, 18));
		panel.add(label_1);

		JComboBox �ð� = new JComboBox();
		�ð�.setBounds(213, 346, 128, 21);
		�ð�.setModel(new DefaultComboBoxModel(arrtime));
		�ð�.setSelectedIndex(0);
		�ð�.setFont(new Font("����", Font.PLAIN, 14));
		panel.add(�ð�);

		JButton ���� = new JButton("\uC608\uC57D");
		����.setForeground(Color.WHITE);
		����.setBackground(Color.DARK_GRAY);
		����.setBounds(42, 438, 91, 48);
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
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
						
						
					}
				}
				
				

			}
		});
		����.setFont(new Font("���� ���", Font.BOLD, 19));
		panel.add(����);

		JButton �ݱ� = new JButton("\uB2EB\uAE30");
		�ݱ�.setForeground(Color.WHITE);
		�ݱ�.setBackground(Color.DARK_GRAY);
		�ݱ�.setBounds(302, 438, 91, 48);
		�ݱ�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuchoiceGUI zza = new MenuchoiceGUI(name,num);
				frame.dispose();
			}
		});
		�ݱ�.setFont(new Font("���� ���", Font.BOLD, 19));
		panel.add(�ݱ�);

	

		JButton ����ǥȮ�� = new JButton("\uC608\uC57D \uD655\uC778");
		����ǥȮ��.setForeground(Color.WHITE);
		����ǥȮ��.setBackground(Color.DARK_GRAY);
		����ǥȮ��.setBounds(158, 438, 121, 48);
		����ǥȮ��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation re = new Reservation(name, num);
				frame.dispose();
			}
		});
		����ǥȮ��.setFont(new Font("���� ���", Font.BOLD, 19));
		panel.add(����ǥȮ��);
		
		JLabel label_2 = new JLabel("\uD68C\uC6D0 \uBC88\uD638 : ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(90, 186, 101, 40);
		label_2.setFont(new Font("���� ���", Font.BOLD, 18));
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
						lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 40));
						
						JLabel lblNewLabel_2 = new JLabel("New label");
						lblNewLabel_2.setIcon(new ImageIcon(tool.class.getResource("/image/\uB9AC\uC808-removebg-preview.png")));
						lblNewLabel_2.setBounds(440, 0, 129, 580);
						panel.add(lblNewLabel_2);
		
		

	}
}
