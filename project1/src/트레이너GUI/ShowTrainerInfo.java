package Æ®·¹ÀÌ³ÊGUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.TR_MemberDAO;
import Model.TR_MemberVO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ShowTrainerInfo {

	private JFrame frame;
	String mem_name = "";
	String trainer_name = "";
	int get_num = 0;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShowTrainerInfo window = new ShowTrainerInfo();
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
	public ShowTrainerInfo(String member_name, String trainer) {
		mem_name = member_name;
		trainer_name = trainer;
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		TR_MemberDAO dao = new TR_MemberDAO();
		ArrayList<TR_MemberVO> memberList = dao.select();
		String[] content = new String[6];

		for (int i = 0; i < memberList.size(); i++) {
			if (trainer_name.equals(memberList.get(i).getName())) {
				content[0] = memberList.get(i).getName();
				content[1] = memberList.get(i).getGender();
				content[2] = memberList.get(i).getPhone();
				content[3] = memberList.get(i).getKakaotalkId();
				content[4] = memberList.get(i).getImage();
				content[5] = Integer.toString(memberList.get(i).getNum());
			}
		}

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 425, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ImageIcon imageIcon_trainer = new ImageIcon(content[4]);
		Image image_trainer = imageIcon_trainer.getImage();
		Image changeImg_tr = image_trainer.getScaledInstance(140, 160, Image.SCALE_SMOOTH);
		ImageIcon res_image_trainer = new ImageIcon(changeImg_tr);
		JLabel lbl_image_trainer = new JLabel(res_image_trainer);
		lbl_image_trainer.setBounds(146, 133, 140, 160);
		frame.getContentPane().add(lbl_image_trainer);

		JLabel trainer_name = new JLabel("\uC774\uB984 : ");
		trainer_name.setHorizontalAlignment(SwingConstants.RIGHT);
		trainer_name.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 16));
		trainer_name.setBounds(92, 329, 58, 28);
		frame.getContentPane().add(trainer_name);

		JLabel trainer_gender = new JLabel("\uC131\uBCC4 : ");
		trainer_gender.setHorizontalAlignment(SwingConstants.RIGHT);
		trainer_gender.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 16));
		trainer_gender.setBounds(92, 356, 58, 34);
		frame.getContentPane().add(trainer_gender);

		JLabel trainer_phone = new JLabel("\uC804\uD654\uBC88\uD638 : ");
		trainer_phone.setHorizontalAlignment(SwingConstants.RIGHT);
		trainer_phone.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 16));
		trainer_phone.setBounds(53, 389, 97, 34);
		frame.getContentPane().add(trainer_phone);

		JLabel trainer_katalk = new JLabel("\uCE74\uD1A1\uC544\uC774\uB514 : ");
		trainer_katalk.setHorizontalAlignment(SwingConstants.RIGHT);
		trainer_katalk.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 16));
		trainer_katalk.setBounds(53, 420, 97, 34);
		frame.getContentPane().add(trainer_katalk);

		JLabel name_db = new JLabel(content[0]);
		name_db.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 16));
		name_db.setBounds(162, 329, 112, 25);
		frame.getContentPane().add(name_db);

		JLabel gender_db = new JLabel(content[1]);
		gender_db.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 16));
		gender_db.setBounds(162, 359, 112, 25);
		frame.getContentPane().add(gender_db);

		JLabel phone_db = new JLabel(content[2]);
		phone_db.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 16));
		phone_db.setBounds(162, 392, 134, 25);
		frame.getContentPane().add(phone_db);

		JLabel katalk_db = new JLabel(content[3]);
		katalk_db.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 16));
		katalk_db.setBounds(162, 424, 112, 25);
		frame.getContentPane().add(katalk_db);

		JButton btn_select = new JButton("\uC2E0\uCCAD\uD558\uAE30");
		btn_select.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 14));
		btn_select.setForeground(Color.WHITE);
		btn_select.setBackground(Color.DARK_GRAY);
		btn_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TR_MemberDAO dao = new TR_MemberDAO();
				TR_MemberVO vo = new TR_MemberVO(Integer.parseInt(content[5]), mem_name);

				int cnt = dao.update_mem(vo);

				if (cnt > 0) {
					JOptionPane.showMessageDialog(null, "½ÅÃ»µÇ¾ú½À´Ï´Ù.");
					SelectTrainer select_trainer = new SelectTrainer(mem_name);
				}

				frame.dispose();
			}
		});
		btn_select.setBounds(80, 509, 97, 23);
		frame.getContentPane().add(btn_select);

		JButton btn_back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btn_back.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 14));
		btn_back.setForeground(Color.WHITE);
		btn_back.setBackground(Color.DARK_GRAY);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectTrainer select_trainer = new SelectTrainer(mem_name);
				frame.dispose();
			}
		});
		btn_back.setBounds(199, 509, 97, 23);
		frame.getContentPane().add(btn_back);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(
				ShowTrainerInfo.class.getResource("/image/\uD2B8\uB808\uC774\uB10C\u3134-removebg-preview.png")));
		lblNewLabel.setBounds(23, 10, 374, 111);
		frame.getContentPane().add(lblNewLabel);
	}
}
