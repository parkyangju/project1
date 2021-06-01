package 관리자_메세지박스GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Mg_MessageBoxDAO;
import GUI.관리자GUI;
import Model.Mg_MessageBoxVO;

public class Mg_MessageBox_Main {

	private JFrame frame;
	private JTable table;
	int 관리자번호 = 0000;
	int 보낸사람회원번호;
	String content;
	String receive = "";
	int 메시지번호;

	private JTextField tf_receive_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mg_MessageBox_Main window = new Mg_MessageBox_Main();
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
	public Mg_MessageBox_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 585, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("(\uAD00\uB9AC\uC790\uC6A9)");
		lblNewLabel_1.setBounds(0, 577, 69, 15);
		frame.getContentPane().add(lblNewLabel_1);

		tf_receive_id = new JTextField();
		tf_receive_id.setText(Integer.toString(관리자번호));
		tf_receive_id.setBounds(77, 99, 80, 21);
		frame.getContentPane().add(tf_receive_id);
		tf_receive_id.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 130, 410, 329);
		frame.getContentPane().add(scrollPane);

		Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
		String[] colNames = { "보낸사람", "내용", "상태확인", "메시지번호" };
		ArrayList<Mg_MessageBoxVO> al = dao.selectMs(관리자번호);
		Object[][] data = new Object[al.size()][5];

		for (int i = 0; i < al.size(); i++) {

			data[i][0] = al.get(i).getSend_id();
			data[i][1] = al.get(i).getMs_content();
			data[i][2] = al.get(i).getMs_check();
			data[i][3] = al.get(i).getMs_no();
		}

		DefaultTableModel model = new DefaultTableModel(data, colNames) { // 더블클릭 하면 값입력 못하게 방지
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				보낸사람회원번호 = (int)table.getValueAt(table.getSelectedRow(), 0);
				메시지번호 = (int)table.getValueAt(table.getSelectedRow(), 3);
				
				if(e.getClickCount()==2) {
					TableModel data = table.getModel();
					Mg_Ms_check check = new Mg_Ms_check(보낸사람회원번호, 관리자번호,메시지번호);
					frame.dispose();
				}
			}
		});

		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("\uBA54\uC2DC\uC9C0 \uBCF4\uB0B4\uAE30");
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				receive = tf_receive_id.getText();

				Mg_Ms_send send = new Mg_Ms_send(관리자번호);
				frame.dispose();

			}
		});
		btnNewButton.setBounds(54, 469, 123, 41);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uBA54\uC2DC\uC9C0 \uD655\uC778");
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mg_Ms_check check = new Mg_Ms_check(보낸사람회원번호, 관리자번호, 메시지번호);
				frame.dispose();

			}
		});
		btnNewButton_1.setBounds(226, 469, 123, 41);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uC804\uCCB4 \uBCF4\uB0B4\uAE30");
		btnNewButton_2.setBackground(new Color(255, 240, 245));
		btnNewButton_2.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Mg_Ms_Allsend allsend = new Mg_Ms_Allsend(관리자번호);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(54, 526, 123, 41);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\uBA54\uC2DC\uC9C0 \uC0AD\uC81C");
		btnNewButton_3.setBackground(new Color(255, 240, 245));
		btnNewButton_3.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {

				} else if (result == JOptionPane.YES_OPTION) {
					Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
					boolean result1 = dao.delete_Ms(메시지번호);

					if (result1 == true) {
						JOptionPane.showMessageDialog(null, "삭제성공!");
						Mg_MessageBox_Main.main(null);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "삭제실패!");
					}
				} else {

				}
			}
		});
		btnNewButton_3.setBounds(226, 526, 123, 41);
		frame.getContentPane().add(btnNewButton_3);

		JLabel lblNewLabel_2 = new JLabel("\uD68C\uC6D0\uBC88\uD638 :");
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 102, 69, 15);
		frame.getContentPane().add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 449, 83);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uBA54\uC2DC\uC9C0\uD568");
		lblNewLabel.setBounds(150, 10, 165, 63);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 38));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3
				.setIcon(new ImageIcon(Mg_MessageBox_Main.class.getResource("/image/aptpwl-removebg-preview.png")));
		lblNewLabel_3.setBounds(422, 0, 147, 592);
		frame.getContentPane().add(lblNewLabel_3);

		JButton btnNewButton_4 = new JButton("\uB2EB\uAE30");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(361, 546, 61, 23);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.setFont(new Font("한컴 고딕", Font.BOLD, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				관리자GUI asdasd = new 관리자GUI();
				frame.dispose();
			}
		});

	}
}
