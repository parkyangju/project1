package 관리자_회원조회GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.MemberSearchDAO;
import GUI.관리자GUI;
import Model.MemberSearchVO;

public class MemberSearch {

	private JFrame frame;
	private JTextField tf_search;
	private JTable table;
	private JLabel lbl_memList;
	private JLabel lbl_listName;
	private JLabel lbl_memInfo;
	private JLabel lbl_memNo;
	private JLabel lbl_memName;
	private JTextField tf_inputName;
	private JLabel lbl_memPhone;
	private JLabel lbl_memPeriod;
	private JLabel lbl_memTrainer;
	private JRadioButton rdbtn_male;
	private JRadioButton rdbtn_female;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tf_inputPhone;
	MemberSearchDAO dao = new MemberSearchDAO();
	private JTextField tf_inputMemNo;
	private JTable table1;
	private JButton btn_close;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSearch window = new MemberSearch();
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
	public MemberSearch() {
		initialize();
	}

	public void size_control() {
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
	}

	public void table_view() {
		ArrayList<MemberSearchVO> memberList = dao.mem_join_trainer();
		String[] header = { "회원번호", "이름", "전화번호", "잔여기간", "트레이너" };
		String[][] content = new String[memberList.size()][5];
		for (int i = 0; i < memberList.size(); i++) {
			content[i][0] = Integer.toString(memberList.get(i).getMember_no());
			content[i][1] = memberList.get(i).getName();
			// content[i][2] = memberList.get(i).getGender();
			content[i][2] = memberList.get(i).getPhone();
			content[i][3] = memberList.get(i).getPeriod();
			// content[i][4] = Integer.toString(memberList.get(i).getTrainer_no());
			content[i][4] = memberList.get(i).getTrainer_name();
		}

		DefaultTableModel model = new DefaultTableModel(content, header) { // 더블클릭 하면 값입력 못하게 방지
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		table = new JTable(model);
	}

	public void table_fixation() {
		int row = table.getSelectedRow();
		TableModel data = table.getModel();
		String mem_no = (String) data.getValueAt(row, 0);

		ArrayList<MemberSearchVO> memberList1 = dao.select_correctmem(mem_no);
		String[] member_info = new String[6];

		for (int i = 0; i < memberList1.size(); i++) {
			member_info[0] = Integer.toString(memberList1.get(i).getMember_no());
			member_info[1] = memberList1.get(i).getName();
			member_info[2] = memberList1.get(i).getGender();
			member_info[3] = memberList1.get(i).getPhone();
			member_info[4] = memberList1.get(i).getPeriod();
			member_info[5] = Integer.toString(memberList1.get(i).getTrainer_no());
		}

		tf_inputMemNo.setText(member_info[0]);
		tf_inputName.setText(member_info[1]);
		if (member_info[2].equals(rdbtn_male.getText())) {
			rdbtn_male.doClick();
		} else if (member_info[2].equals(rdbtn_female.getText())) {
			rdbtn_female.doClick();
		}
		tf_inputPhone.setText(member_info[3]);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

//		ArrayList<MemberSearchVO> memberList = dao.mem_join_trainer();
//		String[] header = { "회원번호", "이름", "전화번호", "잔여기간", "트레이너" };
//		String[][] content = new String[memberList.size()][5];
//		for (int i = 0; i < memberList.size(); i++) {
//			content[i][0] = Integer.toString(memberList.get(i).getMember_no());
//			content[i][1] = memberList.get(i).getName();
//			// content[i][2] = memberList.get(i).getGender();
//			content[i][2] = memberList.get(i).getPhone();
//			content[i][3] = memberList.get(i).getPeriod();
//			//content[i][4] = Integer.toString(memberList.get(i).getTrainer_no());
//			content[i][4] = memberList.get(i).getTrainer_name();
//		}
//		
//		DefaultTableModel model = new DefaultTableModel(content, header) { // 더블클릭 하면 값입력 못하게 방지
//			public boolean isCellEditable(int rowIndex, int mColIndex) {
//				return false;
//			}
//		};

//		table_view();

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 711, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 720, 87);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel title = new JLabel("\uD68C\uC6D0 \uC870\uD68C");
		title.setBounds(268, 10, 200, 52);
		panel.add(title);
		title.setFont(new Font("한컴 고딕", Font.BOLD, 46));
		title.setForeground(new Color(245, 255, 250));

		JScrollPane mem_list = new JScrollPane();
		mem_list.setBounds(298, 170, 385, 297);
		frame.getContentPane().add(mem_list);

		// table = new JTable(model);
		table_view();
		size_control();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouse) {
				if (mouse.getClickCount() == 2) {
					table_fixation();
				}
			}

		});
//		table.setBounds(298, 149, 385, 297);
//		frame.getContentPane().add(table);
		mem_list.setViewportView(table);

		tf_search = new JTextField();
		tf_search.setBounds(337, 127, 116, 22);
		frame.getContentPane().add(tf_search);
		tf_search.setColumns(10);

		JButton btn_search = new JButton("\uAC80\uC0C9");
		btn_search.setBounds(460, 126, 65, 25);
		btn_search.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btn_search.setForeground(new Color(0, 0, 0));
		btn_search.setBackground(new Color(255, 228, 225));
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_search.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "회원의 이름을 입력하세요.", "회원 검색", JOptionPane.ERROR_MESSAGE);
				} else {
					String member_name = tf_search.getText();

					ArrayList<MemberSearchVO> memberList = dao.search_memName(member_name);
					String[] header = { "회원번호", "이름", "전화번호", "잔여기간", "트레이너" };
					String[][] content = new String[memberList.size()][5];
					for (int i = 0; i < memberList.size(); i++) {
						content[i][0] = Integer.toString(memberList.get(i).getMember_no());
						content[i][1] = memberList.get(i).getName();
						// content[i][2] = memberList.get(i).getGender();
						content[i][2] = memberList.get(i).getPhone();
						content[i][3] = memberList.get(i).getPeriod();
						// content[i][4] = Integer.toString(memberList.get(i).getTrainer_no());
						content[i][4] = memberList.get(i).getTrainer_name();
					}

					DefaultTableModel model = new DefaultTableModel(content, header) { // 더블클릭 하면 값입력 못하게 방지
						public boolean isCellEditable(int rowIndex, int mColIndex) {
							return false;
						}
					};

					table = new JTable(model);
					size_control();
					mem_list.setViewportView(table);
					tf_search.setText("");
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent mouse) {
							if (mouse.getClickCount() == 2) {
								table_fixation();

							}
						}

					});
				}
			}
		});
		frame.getContentPane().add(btn_search);

		lbl_memInfo = new JLabel("\uD68C\uC6D0 \uC815\uBCF4 \uC785\uB825");
		lbl_memInfo.setFont(new Font("한컴 고딕", Font.BOLD, 12));
		lbl_memInfo.setBounds(27, 97, 99, 15);
		frame.getContentPane().add(lbl_memInfo);

		lbl_memList = new JLabel("\uD68C\uC6D0 \uB9AC\uC2A4\uD2B8");
		lbl_memList.setFont(new Font("한컴 고딕", Font.BOLD, 12));
		lbl_memList.setBounds(298, 97, 80, 15);
		frame.getContentPane().add(lbl_memList);

		lbl_listName = new JLabel("\uC774\uB984");
		lbl_listName.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lbl_listName.setBounds(298, 127, 42, 22);
		frame.getContentPane().add(lbl_listName);

		lbl_memNo = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		lbl_memNo.setBounds(27, 149, 57, 22);
		lbl_memNo.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		frame.getContentPane().add(lbl_memNo);

		tf_inputMemNo = new JTextField();
		tf_inputMemNo.setBounds(91, 149, 116, 22);
		tf_inputMemNo.setColumns(10);
		frame.getContentPane().add(tf_inputMemNo);

		lbl_memName = new JLabel("\uC774\uB984");
		lbl_memName.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lbl_memName.setBounds(27, 199, 42, 22);
		frame.getContentPane().add(lbl_memName);

		tf_inputName = new JTextField();
		tf_inputName.setBounds(91, 199, 116, 22);
		frame.getContentPane().add(tf_inputName);
		tf_inputName.setColumns(10);

		lbl_memPhone = new JLabel("\uC804\uD654\uBC88\uD638");
		lbl_memPhone.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lbl_memPhone.setBounds(27, 259, 62, 22);
		frame.getContentPane().add(lbl_memPhone);

		lbl_memPeriod = new JLabel("\uC774\uC6A9\uAE30\uAC04");
		lbl_memPeriod.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lbl_memPeriod.setBounds(27, 309, 57, 22);
		frame.getContentPane().add(lbl_memPeriod);

		lbl_memTrainer = new JLabel("\uD2B8\uB808\uC774\uB108");
		lbl_memTrainer.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lbl_memTrainer.setBounds(27, 359, 57, 22);
		frame.getContentPane().add(lbl_memTrainer);

		rdbtn_male = new JRadioButton("\uB0A8");
		rdbtn_male.setBounds(91, 229, 42, 22);
		buttonGroup.add(rdbtn_male);
		frame.getContentPane().add(rdbtn_male);

		rdbtn_female = new JRadioButton("\uC5EC");
		rdbtn_female.setBounds(148, 229, 42, 22);
		buttonGroup.add(rdbtn_female);
		frame.getContentPane().add(rdbtn_female);

		tf_inputPhone = new JTextField();
		tf_inputPhone.setBounds(91, 259, 116, 22);
		frame.getContentPane().add(tf_inputPhone);
		tf_inputPhone.setColumns(10);

		JComboBox cb_period = new JComboBox();
		cb_period.setBounds(91, 309, 106, 22);
		cb_period.setEditable(true);
		cb_period.setModel(new DefaultComboBoxModel(
				new String[] { "3\uAC1C\uC6D4", "6\uAC1C\uC6D4", "9\uAC1C\uC6D4", "12\uAC1C\uC6D4" }));
		cb_period.setSelectedIndex(0);
		cb_period.setFont(new Font("굴림", Font.PLAIN, 12));
		frame.getContentPane().add(cb_period);

		JComboBox cb_trainer = new JComboBox();
		cb_trainer.setBounds(91, 359, 106, 22);
		cb_trainer.setMaximumRowCount(5);
		cb_trainer.setFont(new Font("굴림", Font.PLAIN, 12));
		cb_trainer.setModel(new DefaultComboBoxModel(new String[] { "\uC120\uD0DD\uC548\uD568", "\uAE40\uB3D9\uC6D0",
				"\uAE40\uBBF8\uD76C", "\uCD5C\uC131\uC6B0" }));
		cb_trainer.setSelectedIndex(0);
		cb_trainer.setEditable(true);
		frame.getContentPane().add(cb_trainer);

		JButton btn_register = new JButton("\uB4F1\uB85D");
		btn_register.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btn_register.setForeground(new Color(0, 0, 0));
		btn_register.setBackground(new Color(255, 240, 245));
		btn_register.setBounds(50, 415, 65, 30);
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_inputMemNo.getText().equals("") || tf_inputName.getText().equals("")
						|| tf_inputPhone.getText().equals("")
						|| (!rdbtn_male.isSelected() && !rdbtn_female.isSelected())
						|| cb_period.getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸을 모두 채워주세요.", "회원등록", JOptionPane.ERROR_MESSAGE);
				} else {

					int mem_no = Integer.parseInt(tf_inputMemNo.getText());
					String name = tf_inputName.getText();
					String phone = tf_inputPhone.getText();
					String gender = "";
					if (rdbtn_male.isSelected()) {
						gender = rdbtn_male.getText();
					} else if (rdbtn_female.isSelected()) {
						gender = rdbtn_female.getText();
					}

					String period = cb_period.getSelectedItem().toString();
					String trainer_name = cb_trainer.getSelectedItem().toString();
					int trainer_no = 9999;

					ArrayList<MemberSearchVO> memberList1 = dao.trainer_name_select(trainer_name);
					String[] trainer_info = new String[6];

					for (int i = 0; i < memberList1.size(); i++) {
						System.out.println(trainer_name + "==================");
						trainer_info[0] = Integer.toString(memberList1.get(i).getMember_no());
						trainer_info[1] = memberList1.get(i).getName();
						trainer_info[2] = memberList1.get(i).getGender();
						trainer_info[3] = memberList1.get(i).getPhone();
						trainer_info[4] = memberList1.get(i).getPeriod();
						trainer_info[5] = Integer.toString(memberList1.get(i).getTrainer_no());
						System.out.println(trainer_info[i]);
					}
					trainer_no = Integer.parseInt(trainer_info[5]);

					MemberSearchVO vo = new MemberSearchVO(mem_no, name, gender, phone, period, trainer_no);
					int cnt = dao.member_register(vo);

					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "회원등록 성공");

//						ArrayList<MemberSearchVO> memberList = dao.mem_join_trainer();
//						String[] header = { "회원번호", "이름", "전화번호", "잔여기간", "트레이너" };
//						String[][] content = new String[memberList.size()][5];
//						for (int i = 0; i < memberList.size(); i++) {
//							content[i][0] = Integer.toString(memberList.get(i).getMember_no());
//							content[i][1] = memberList.get(i).getName();
//							// content[i][2] = memberList.get(i).getGender();
//							content[i][2] = memberList.get(i).getPhone();
//							content[i][3] = memberList.get(i).getPeriod();
//							//content[i][4] = Integer.toString(memberList.get(i).getTrainer_no());
//							content[i][4] = memberList.get(i).getTrainer_name();
//						}
//						DefaultTableModel model = new DefaultTableModel(content, header) { // 더블클릭 하면 값입력 못하게 방지
//							public boolean isCellEditable(int rowIndex, int mColIndex) {
//								return false;
//							}
//						};
//						table = new JTable(model);
						table_view();
						size_control();
						mem_list.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent mouse) {
								if (mouse.getClickCount() == 2) {
									table_fixation();
								}
							}

						});
					} else {
						JOptionPane.showMessageDialog(null, "회원등록 실패", "회원등록", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		frame.getContentPane().add(btn_register);

		JButton btn_update = new JButton("\uC218\uC815");
		btn_update.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btn_update.setForeground(new Color(0, 0, 0));
		btn_update.setBackground(new Color(255, 240, 245));
		btn_update.setBounds(120, 415, 65, 30);
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tf_inputMemNo.getText().equals("") || tf_inputName.getText().equals("")
						|| tf_inputPhone.getText().equals("")
						|| (!rdbtn_male.isSelected() && !rdbtn_female.isSelected())
						|| cb_period.getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "수정할 빈칸을 모두 채워주세요.", "회원수정", JOptionPane.ERROR_MESSAGE);
				} else {
					int mem_no = Integer.parseInt(tf_inputMemNo.getText());
					String name = tf_inputName.getText();
					String gender = "";
					if (rdbtn_male.isSelected()) {
						gender = rdbtn_male.getText();
					} else if (rdbtn_female.isSelected()) {
						gender = rdbtn_female.getText();
					}
					String phone = tf_inputPhone.getText();
					String period = cb_period.getSelectedItem().toString();
					String trainer_name = cb_trainer.getSelectedItem().toString();
					int trainer_no = 9999;

					ArrayList<MemberSearchVO> memberList1 = dao.trainer_name_select(trainer_name);
					String[] trainer_info = new String[6];

					for (int i = 0; i < memberList1.size(); i++) {
						System.out.println(trainer_name + "==================");
						trainer_info[0] = Integer.toString(memberList1.get(i).getMember_no());
						trainer_info[1] = memberList1.get(i).getName();
						trainer_info[2] = memberList1.get(i).getGender();
						trainer_info[3] = memberList1.get(i).getPhone();
						trainer_info[4] = memberList1.get(i).getPeriod();
						trainer_info[5] = Integer.toString(memberList1.get(i).getTrainer_no());
						System.out.println(trainer_info[i]);
					}
					trainer_no = Integer.parseInt(trainer_info[5]);

//					if (dao.trainer_no_select(trainer_name)) {
//						ArrayList<MemberSearchVO> trainerList = dao.trainer_select();
//						String[] trainer_info = new String[6];
//						//System.out.println(trainer_name + "==================");
//						for (int i = 0; i < trainerList.size(); i++) {
//							System.out.println(trainer_name + "==================");
//							trainer_info[0] = trainerList.get(i).getTrainer_name();
//							trainer_info[1] = trainerList.get(i).getTrainer_gender();
//							trainer_info[2] = trainerList.get(i).getTrainer_phone();
//							trainer_info[3] = trainerList.get(i).getTrainer_sns();
//							trainer_info[4] = trainerList.get(i).getTrainer_image();
//							trainer_info[5] = Integer.toString(trainerList.get(i).getTrainer_no());
//							System.out.println(trainer_info[i]);
//						}
//						trainer_no = Integer.parseInt(trainer_info[5]);
//						//System.out.println(trainer_info[0]);
//					}

					boolean result = dao.update_memName(mem_no, name);
					boolean result1 = dao.update_memGender(mem_no, gender);
					boolean result2 = dao.update_memPhone(mem_no, phone);
					boolean result3 = dao.update_memPeriod(mem_no, period);
					boolean result4 = dao.update_memTrainerNo(mem_no, trainer_no);

//					ArrayList<MemberSearchVO> memberList = dao.mem_join_trainer();
//					String[][] temp = new String[memberList.size()][5];
//					for(int i=0; i<memberList.size(); i++) {
//						temp[i][0] = Integer.toString(memberList.get(i).getMember_no());
//						temp[i][1] = memberList.get(i).getName();
//						//temp[i][2] = memberList.get(i).getGender();
//						temp[i][2] = memberList.get(i).getPhone();
//						temp[i][3] = memberList.get(i).getPeriod();
//						//temp[i][4] = Integer.toString(memberList.get(i).getTrainer_no());
//						temp[i][4] = memberList.get(i).getTrainer_name(); 
//					}

					if (result == true || result1 == true || result2 == true || result3 == true || result4 == true) {
						System.out.println(trainer_no);
						JOptionPane.showMessageDialog(null, "수정하였습니다.");
//						ArrayList<MemberSearchVO> memberList = dao.mem_join_trainer();
//						String[] header = { "회원번호", "이름", "전화번호", "잔여기간", "트레이너" };
//						String[][] content = new String[memberList.size()][5];
//						for (int i = 0; i < memberList.size(); i++) {
//							content[i][0] = Integer.toString(memberList.get(i).getMember_no());
//							content[i][1] = memberList.get(i).getName();
//							// content[i][2] = memberList.get(i).getGender();
//							content[i][2] = memberList.get(i).getPhone();
//							content[i][3] = memberList.get(i).getPeriod();
//							//content[i][4] = Integer.toString(memberList.get(i).getTrainer_no());
//							content[i][4] = memberList.get(i).getTrainer_name();
//						}
//						DefaultTableModel model = new DefaultTableModel(content, header) { // 더블클릭 하면 값입력 못하게 방지
//							public boolean isCellEditable(int rowIndex, int mColIndex) {
//								return false;
//							}
//						};
//						table = new JTable(model);
						table_view();
						size_control();
						mem_list.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent mouse) {
								if (mouse.getClickCount() == 2) {
									table_fixation();

								}
							}

						});
					} else {
						JOptionPane.showMessageDialog(null, "수정 실패", "회원수정", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		frame.getContentPane().add(btn_update);

		JButton btn_delete = new JButton("\uC0AD\uC81C");
		btn_delete.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btn_delete.setForeground(new Color(0, 0, 0));
		btn_delete.setBackground(new Color(255, 240, 245));
		btn_delete.setBounds(190, 415, 65, 30);
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int member_no = Integer.parseInt(tf_inputMemNo.getText());

				int result1 = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?", "회원삭제", JOptionPane.YES_NO_OPTION);
				if (result1 == JOptionPane.CLOSED_OPTION) {

				} else if (result1 == JOptionPane.YES_OPTION) {

					boolean result = dao.delete_mem(member_no);

					if (result == true) {
						JOptionPane.showMessageDialog(null, "삭제성공!");
//						ArrayList<MemberSearchVO> memberList = dao.mem_join_trainer();
//						String[] header = { "회원번호", "이름", "전화번호", "잔여기간", "트레이너" };
//						String[][] content = new String[memberList.size()][5];
//						for (int i = 0; i < memberList.size(); i++) {
//							content[i][0] = Integer.toString(memberList.get(i).getMember_no());
//							content[i][1] = memberList.get(i).getName();
//							// content[i][2] = memberList.get(i).getGender();
//							content[i][2] = memberList.get(i).getPhone();
//							content[i][3] = memberList.get(i).getPeriod();
//							//content[i][4] = Integer.toString(memberList.get(i).getTrainer_no());
//							content[i][4] = memberList.get(i).getTrainer_name();
//						}
//						DefaultTableModel model = new DefaultTableModel(content, header) { // 더블클릭 하면 값입력 못하게 방지
//							public boolean isCellEditable(int rowIndex, int mColIndex) {
//								return false;
//							}
//						};
//						table = new JTable(model);
						table_view();
						size_control();
						mem_list.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent mouse) {
								if (mouse.getClickCount() == 2) {
									table_fixation();

								}
							}

						});
						// frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "삭제실패!");
					}
				} else {

				}

			}
		});
		frame.getContentPane().add(btn_delete);

		JButton clear = new JButton("\uCD08\uAE30\uD654");
		clear.setFont(new Font("한컴 고딕", Font.BOLD, 13));
		clear.setForeground(new Color(0, 0, 0));
		clear.setBackground(new Color(255, 240, 245));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ArrayList<MemberSearchVO> memberList = dao.mem_join_trainer();
//				String[] header = { "회원번호", "이름", "전화번호", "잔여기간", "트레이너" };
//				String[][] content = new String[memberList.size()][5];
//				for (int i = 0; i < memberList.size(); i++) {
//					content[i][0] = Integer.toString(memberList.get(i).getMember_no());
//					content[i][1] = memberList.get(i).getName();
//					// content[i][2] = memberList.get(i).getGender();
//					content[i][2] = memberList.get(i).getPhone();
//					content[i][3] = memberList.get(i).getPeriod();
//					//content[i][4] = Integer.toString(memberList.get(i).getTrainer_no());
//					content[i][4] = memberList.get(i).getTrainer_name();
//				}
//				DefaultTableModel model = new DefaultTableModel(content, header) { // 더블클릭 하면 값입력 못하게 방지
//					public boolean isCellEditable(int rowIndex, int mColIndex) {
//						return false;
//					}
//				};
//				table = new JTable(model);
				table_view();
				size_control();
				mem_list.setViewportView(table);
				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent mouse) {
						if (mouse.getClickCount() == 2) {
							table_fixation();

						}
					}

				});
			}
		});
		clear.setBounds(536, 126, 74, 25);
		frame.getContentPane().add(clear);

		btn_close = new JButton("\uB2EB\uAE30");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				관리자GUI as = new 관리자GUI();
			}
		});
		btn_close.setForeground(Color.BLACK);
		btn_close.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btn_close.setBackground(new Color(255, 240, 245));
		btn_close.setBounds(618, 469, 65, 30);
		frame.getContentPane().add(btn_close);

	}
}
