package �޽����ڽ�GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import Controller.MessageBoxDAO;
import GUI.MenuchoiceGUI;
import Model.MessageBoxVO;

public class MessageBox_Main {

	private JFrame frame;
	private JTable table;
	int ȸ����ȣ;
	int number;
	String content;
	String receive = "";
	int �޽�����ȣ;
	String name = "";
	int num = 0;
	String ȸ���̸� = "";

	private JTextField tf_receive_id;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MessageBox_Main window = new MessageBox_Main();
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
	public MessageBox_Main(String name, int num1) {
		ȸ���̸� = name;
		ȸ����ȣ = num1;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 585, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("(\uD68C\uC6D0\uC6A9)");
		lblNewLabel_1.setBounds(12, 568, 69, 15);
		frame.getContentPane().add(lblNewLabel_1);

		tf_receive_id = new JTextField();
		tf_receive_id.setText(Integer.toString(ȸ����ȣ)); // ���Ⱑ ȸ����ȣ �Է±���
		tf_receive_id.setBounds(93, 127, 80, 21);
		frame.getContentPane().add(tf_receive_id);
		tf_receive_id.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 162, 401, 309);
		frame.getContentPane().add(scrollPane);

		MessageBoxDAO dao = new MessageBoxDAO();
		String[] colNames = { "�������", "����", "����Ȯ��", "�޽�����ȣ" };
		ArrayList<MessageBoxVO> al = dao.selectMs(ȸ����ȣ);
		Object[][] data = new Object[al.size()][5];

		for (int i = 0; i < al.size(); i++) {

			data[i][0] = al.get(i).getSend_id();
			data[i][1] = al.get(i).getMs_content();
			data[i][2] = al.get(i).getMs_check();
			data[i][3] = al.get(i).getMs_no();
		}

		DefaultTableModel model = new DefaultTableModel(data, colNames) { // ����Ŭ�� �ϸ� ���Է� ���ϰ� ����
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		table = new JTable(model) {   //�����ڰ͸� ���� ��ũ������
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				if ((int) table.getValueAt(row, 0) == 0) {
					component.setBackground(Color.PINK);
				} else {
					component.setForeground(Color.black);
				}
				return component;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				number = (int)table.getValueAt(table.getSelectedRow(), 0);
				�޽�����ȣ = (int)table.getValueAt(table.getSelectedRow(), 3);

				if (arg0.getClickCount() == 2) {
					int row = table.getSelectedRow();
					TableModel data = table.getModel();
					//int �޽�����ȣ = (int) data.getValueAt(row, 0);

					Ms_check che = new Ms_check(number, �޽�����ȣ, ȸ����ȣ, name);
					frame.dispose();
				}

			}
		});

		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("\uBA54\uC2DC\uC9C0 \uBCF4\uB0B4\uAE30");
		btnNewButton.setFont(new Font("���� ���", Font.BOLD, 18));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receive = tf_receive_id.getText();

				Ms_send send = new Ms_send(receive, ȸ����ȣ, ȸ���̸�);
				frame.dispose();

			}
		});
		btnNewButton.setBounds(26, 502, 147, 41);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uBA54\uC2DC\uC9C0 \uD655\uC778");
		btnNewButton_1.setFont(new Font("���� ���", Font.BOLD, 16));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ms_check check = new Ms_check(number, �޽�����ȣ, ȸ����ȣ, ȸ���̸�); // �Խñ۹�ȣ�� �Ѱ���
				frame.dispose();

			}
		});
		btnNewButton_1.setBounds(183, 502, 113, 41);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("\uBA54\uC2DC\uC9C0 \uC0AD\uC81C");
		btnNewButton_3.setFont(new Font("���� ���", Font.BOLD, 16));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {

				} else if (result == JOptionPane.YES_OPTION) {
					MessageBoxDAO dao = new MessageBoxDAO();
					boolean result1 = dao.delete_Ms(�޽�����ȣ);

					if (result1 == true) {
						JOptionPane.showMessageDialog(null, "��������!");
						MessageBox_Main mb = new MessageBox_Main(ȸ���̸�, ȸ����ȣ);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "��������!");
					}
				} else {

				}
			}
		});
		btnNewButton_3.setBounds(308, 502, 113, 41);
		frame.getContentPane().add(btnNewButton_3);

		JLabel lblNewLabel_2 = new JLabel("\uD68C\uC6D0\uBC88\uD638 :");
		lblNewLabel_2.setFont(new Font("���� ���", Font.BOLD, 15));
		lblNewLabel_2.setBounds(26, 130, 69, 15);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton_2 = new JButton("\uB2EB\uAE30");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("���� ���", Font.BOLD, 14));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuchoiceGUI aaa = new MenuchoiceGUI(ȸ���̸�, ȸ����ȣ);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(343, 553, 80, 23);
		frame.getContentPane().add(btnNewButton_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 442, 96);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uBA54\uC2DC\uC9C0\uD568");
		lblNewLabel.setBounds(160, 27, 112, 39);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 30));

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(MessageBox_Main.class.getResource("/image/aptpwl-removebg-preview.png")));
		lblNewLabel_3.setBounds(422, 24, 147, 547);
		frame.getContentPane().add(lblNewLabel_3);

	}
}
