package �Խ���GUI;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import Controller.BulletinBoardDAO;
import GUI.MenuchoiceGUI;
import Model.BulletinBoardVO;

public class ȸ���Խ���_Main {

	private JFrame frame;
	private JTable table;
	private JTextField tf_ViewNo;
//	private DefaultTableCellRenderer colrend;
//	private TableColumn column;
	String name = "";
	int num = 0;
	int ȸ����ȣ;
	/**
	 * Launch the application.	
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ȸ���Խ���_Main window = new ȸ���Խ���_Main();
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
	public ȸ���Խ���_Main(int num, String name1) {
		name = name1;
		ȸ����ȣ = num;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 585, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("\uAC8C\uC2DC\uAE00 \uC791\uC131\uD558\uAE30");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BB_write write = new BB_write(ȸ����ȣ, name);
				frame.dispose();

			}
		});
		btnNewButton.setFont(new Font("���� ���", Font.BOLD, 20));
		btnNewButton.setBounds(115, 474, 208, 46);
		frame.getContentPane().add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 182, 426, 249);
		frame.getContentPane().add(scrollPane);

		BulletinBoardDAO dao = new BulletinBoardDAO(); // �迭 �����ؼ� �ʱ�ȭ�鿡 �Խñ� ��� ����ֱ�
		String[] colNames = { "�Խñ۹�ȣ", "����", "����", "���̵�" };
		ArrayList<BulletinBoardVO> al = dao.selectBB();
		Object[][] data = new Object[al.size()][4];

		for (int i = 0; i < al.size(); i++) {
			data[i][0] = al.get(i).getBB_no();
			data[i][1] = al.get(i).getSubject();
			data[i][2] = al.get(i).getBB_content();
			data[i][3] = al.get(i).getMember_no();

		}

		DefaultTableModel model = new DefaultTableModel(data, colNames) { // ����Ŭ�� �ϸ� ���Է� ���ϰ� ����
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		table = new JTable(model) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				if ((int) table.getValueAt(row, 3) == 0) {
					component.setForeground(Color.red);
				} else {
					component.setForeground(Color.black);
				}
				return component;
			}
		};

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					TableModel data = table.getModel();
					int �Խñ۹�ȣ = (int) data.getValueAt(row, 0);

					BB_click click = new BB_click(Integer.toString(�Խñ۹�ȣ), name, ȸ����ȣ);
					frame.dispose();
				}
			}
		});

		scrollPane.setViewportView(table);

		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);

//		colrend = new DefaultTableCellRenderer();    //��ü �������
//		for(int i =0; i<=table.getColumnCount()-1;i++) {
//			column = table.getColumnModel().getColumn(i);
//			colrend.setHorizontalAlignment(JLabel.CENTER);
//			column.setCellRenderer(colrend);
//		}
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn("�Խñ۹�ȣ").setCellRenderer(celAlignCenter);

		JLabel lblNewLabel_2 = new JLabel("(\uD68C\uC6D0\uC6A9)");
		lblNewLabel_2.setBounds(5, 566, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC870\uD68C\uD560 \uAC8C\uC2DC\uAE00\uBC88\uD638 : ");
		lblNewLabel_3.setFont(new Font("���� ���", Font.BOLD, 18));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(141, 144, 156, 28);
		frame.getContentPane().add(lblNewLabel_3);

		tf_ViewNo = new JTextField();
		tf_ViewNo.setBounds(296, 149, 62, 21);
		frame.getContentPane().add(tf_ViewNo);
		tf_ViewNo.setColumns(10);

		JButton btn_�Խù���ȣ��ȸ = new JButton("\uC870\uD68C");
		btn_�Խù���ȣ��ȸ.setForeground(Color.WHITE);
		btn_�Խù���ȣ��ȸ.setFont(new Font("���� ���", Font.BOLD, 16));
		btn_�Խù���ȣ��ȸ.setBackground(Color.DARK_GRAY);
		btn_�Խù���ȣ��ȸ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ViewNo = tf_ViewNo.getText();

				if (ViewNo.equals("")) {
					JOptionPane.showMessageDialog(null, "�Խñ� ��ȣ�� �Է��ϼ���!");
				} else {
					BulletinBoardDAO dao = new BulletinBoardDAO();
					boolean result = dao.compare(ViewNo);

					if (result == false) {
						JOptionPane.showMessageDialog(null, "��ϵ� �Խñ��� �����ϴ�!");
					} else {

						BB_click click = new BB_click(ViewNo, name, ȸ����ȣ);
						frame.dispose();

					}
				}

			}
		});
		btn_�Խù���ȣ��ȸ.setBounds(367, 144, 75, 34);
		frame.getContentPane().add(btn_�Խù���ȣ��ȸ);

		JButton btnNewButton_2 = new JButton("\uB2EB\uAE30");
		btnNewButton_2.setFont(new Font("���� ���", Font.BOLD, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuchoiceGUI zc = new MenuchoiceGUI(name, ȸ����ȣ);
				frame.dispose();

			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
//		btnNewButton_2.addActionListener(new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////				MemberDAO dao = new MemberDAO();
////				//MemberVO vo
////				MenuchoiceGUI na = new MenuchoiceGUI(name, num);
////			}
//		});
		btnNewButton_2.setBounds(367, 481, 75, 34);
		frame.getContentPane().add(btnNewButton_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 442, 96);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC8C\uC2DC\uD310");
		lblNewLabel.setBounds(130, 22, 185, 52);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 40));

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ȸ���Խ���_Main.class.getResource("/image/zxc-removebg-preview.png")));
		lblNewLabel_1.setBounds(448, 10, 120, 571);
		frame.getContentPane().add(lblNewLabel_1);

	}
}
