package 트레이너GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Controller.TR_MemberDAO;
import Model.TR_MemberVO;

public class SelectTrainer {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();	
	String trainer_name = "";
	String mem_name = "";
	int num = 0;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public SelectTrainer(String input_name) {
		mem_name = input_name;
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TR_MemberDAO dao = new TR_MemberDAO();
		ArrayList<TR_MemberVO> memberList = dao.select();
		String[][] content = new String[memberList.size()][3];
		for (int i = 0; i < memberList.size(); i++) {
			content[i][0] = memberList.get(i).getName();
			content[i][1] = memberList.get(i).getGender();
			content[i][2] = memberList.get(i).getImage();
		}
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 601, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JLabel trainer1_gender = new JLabel("(" + content[0][1] + ")");
		trainer1_gender.setBounds(75, 400, 28, 28);
		frame.getContentPane().add(trainer1_gender);
		
		JLabel trainer2_gender = new JLabel("(" + content[1][1] + ")");
		trainer2_gender.setBounds(225, 400, 28, 28);
		frame.getContentPane().add(trainer2_gender);
		
		JLabel trainer3_gender = new JLabel("(" + content[2][1] + ")");
		trainer3_gender.setBounds(375, 400, 28, 28);
		frame.getContentPane().add(trainer3_gender);
		
		ImageIcon imageIcon_trainer1 = new ImageIcon(content[0][2]);
		Image image_trainer1 = imageIcon_trainer1.getImage();
		Image changeImg_tr1 = image_trainer1.getScaledInstance(150,  180,  Image.SCALE_SMOOTH);
		ImageIcon res_image_trainer1 = new ImageIcon(changeImg_tr1);
		JLabel lbl_image_trainer1 = new JLabel(res_image_trainer1);
		lbl_image_trainer1.setBounds(15, 175, 150, 180);
		frame.getContentPane().add(lbl_image_trainer1);
		
		ImageIcon imageIcon_trainer2 = new ImageIcon(content[1][2]);
		Image image_trainer2 = imageIcon_trainer2.getImage();
		Image changeImg_tr2 = image_trainer2.getScaledInstance(150,  180,  Image.SCALE_SMOOTH);
		ImageIcon res_image_trainer2 = new ImageIcon(changeImg_tr2);
		JLabel lbl_image_trainer2 = new JLabel(res_image_trainer2);
		lbl_image_trainer2.setBounds(165, 175, 150, 180);
		frame.getContentPane().add(lbl_image_trainer2);
		
		ImageIcon imageIcon_trainer3 = new ImageIcon(content[2][2]);
		Image image_trainer3 = imageIcon_trainer3.getImage();
		Image changeImg_tr3 = image_trainer3.getScaledInstance(150,  180,  Image.SCALE_SMOOTH);
		ImageIcon res_image_trainer3 = new ImageIcon(changeImg_tr3);
		JLabel lbl_image_trainer3 = new JLabel(res_image_trainer3);
		lbl_image_trainer3.setBounds(315, 175, 150, 180);
		frame.getContentPane().add(lbl_image_trainer3);
		
		JRadioButton rb_trainer1 = new JRadioButton(content[0][0]);
		rb_trainer1.setBackground(new Color(255, 153, 51));
		rb_trainer1.setForeground(new Color(0, 0, 0));
		buttonGroup.add(rb_trainer1);
		rb_trainer1.setBounds(40, 370, 90, 30);
		frame.getContentPane().add(rb_trainer1);
		
		JRadioButton rb_trainer2 = new JRadioButton(content[1][0]);
		rb_trainer2.setBackground(new Color(255, 153, 51));
		rb_trainer2.setForeground(new Color(0, 0, 0));
		buttonGroup.add(rb_trainer2);
		rb_trainer2.setBounds(190, 370, 90, 30);
		frame.getContentPane().add(rb_trainer2);
		
		JRadioButton rb_trainer3 = new JRadioButton(content[2][0]);
		rb_trainer3.setBackground(new Color(255, 153, 51));
		rb_trainer3.setForeground(new Color(0, 0, 0));
		buttonGroup.add(rb_trainer3);
		rb_trainer3.setBounds(340, 370, 90, 30);
		frame.getContentPane().add(rb_trainer3);
		
		JButton btn_Select = new JButton("\uD655\uC778");
		btn_Select.setForeground(Color.WHITE);
		btn_Select.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		btn_Select.setBackground(Color.DARK_GRAY);
		btn_Select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rb_trainer1.isSelected()) {
					trainer_name = rb_trainer1.getText();
					ShowTrainerInfo trainerinfo = new ShowTrainerInfo(mem_name, trainer_name);
				} else if (rb_trainer2.isSelected()) {
					trainer_name = rb_trainer2.getText();
					ShowTrainerInfo trainerinfo = new ShowTrainerInfo(mem_name, trainer_name);
				} else if (rb_trainer3.isSelected()) {
					trainer_name = rb_trainer3.getText();
					ShowTrainerInfo trainerinfo = new ShowTrainerInfo(mem_name, trainer_name);
				}
				frame.dispose();
				
			}
		});
		btn_Select.setBounds(192, 465, 113, 45);
		frame.getContentPane().add(btn_Select);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 442, 98);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title_trainerSelect = new JLabel("Trainer");
		title_trainerSelect.setForeground(Color.WHITE);
		title_trainerSelect.setBounds(130, 21, 192, 50);
		panel.add(title_trainerSelect);
		title_trainerSelect.setFont(new Font("한컴 고딕", Font.BOLD, 38));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SelectTrainer.class.getResource("/image/\uD2B8\uB808\uC774\uB108-removebg-preview.png")));
		lblNewLabel.setBounds(439, 0, 146, 586);
		frame.getContentPane().add(lblNewLabel);
		
	
		
		
	}
}
