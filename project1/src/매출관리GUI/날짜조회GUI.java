package �������GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.�������DAO;
import Model.�������VO;

public class ��¥��ȸGUI {

	private JFrame frame;
	private JTable table;
	private JButton btnNewButton;
	String year;
	String month;
	String day;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					��¥��ȸGUI window = new ��¥��ȸGUI();
//					window.
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ��¥��ȸGUI(String ��, String ��, String ��) {
		year = ��;
		month = ��;
		day = ��;
		
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 575, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 144, 532, 275);
		frame.getContentPane().add(scrollPane);
		
		�������DAO dao = new �������DAO();
		String[] colNames = {"������ȣ", "ȸ����ȣ", "�ݾ�", "��¥", "��������"};
		ArrayList<�������VO> al = dao.��¥���ڷ�(year, month, day);
		Object[][] data = new Object[al.size()][5];
		
		
		for(int i=0; i<al.size(); i++) {
			data[i][0] = al.get(i).getPay_no();
			data[i][1] = al.get(i).getMember_no();
			data[i][2] = al.get(i).getMoney();
			data[i][3] = al.get(i).getPay_date();
			data[i][4] = al.get(i).getPay_method();
		}
		
		table = new JTable(data, colNames);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setFont(new Font("���� ���", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(206, 463, 113, 37);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("\uB0A0\uC9DC\uBCC4 \uC870\uD68C");
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 36, 441, 75);
		frame.getContentPane().add(lblNewLabel);
	}
}
