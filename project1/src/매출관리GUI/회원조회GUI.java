package �������GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

import Controller.�������DAO;
import Model.�������VO;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ȸ����ȸGUI {

	private JFrame frame;
	private JTable table;
	int member_no = 0;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ȸ����ȸGUI window = new ȸ����ȸGUI();
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
	public ȸ����ȸGUI(int ȸ����ȣ) {
		member_no = ȸ����ȣ;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 32, 459, 180);
		frame.getContentPane().add(scrollPane);
		
		�������DAO dao = new �������DAO();
		String[] colNames = {"������ȣ", "ȸ����ȣ", "�ݾ�", "��¥", "��������"};
		ArrayList<�������VO> al = dao.ȸ����ȣ���ڷ�(member_no);
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
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(160, 245, 142, 39);
		frame.getContentPane().add(btnNewButton);
	}

}
