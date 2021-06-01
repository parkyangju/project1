package 관리자_메세지박스GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.Mg_MessageBoxDAO;
import Model.MemberVO;
import Model.Mg_MessageBoxVO;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Mg_Ms_Allsend {

	private JFrame frame;
	private JTextField tf_send_id;
	private JTextField tf_receive_id;
	int 관리자번호;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Mg_Ms_Allsend(int 관리자번호) {
		관리자번호 = 관리자번호;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 465, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uBCF4\uB0B4\uB294 \uC0AC\uB78C :");
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_2.setBounds(48, 161, 95, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		tf_send_id = new JTextField();
		tf_send_id.setText("0000");
		tf_send_id.setColumns(10);
		tf_send_id.setBounds(140, 158, 116, 21);
		frame.getContentPane().add(tf_send_id);
		
		JLabel lblNewLabel = new JLabel("\uBC1B\uB294\uC0AC\uB78C :");
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(64, 186, 85, 28);
		frame.getContentPane().add(lblNewLabel);
		
		tf_receive_id = new JTextField();
		tf_receive_id.setColumns(10);
		tf_receive_id.setBounds(140, 190, 116, 21);
		frame.getContentPane().add(tf_receive_id);
		tf_receive_id.setText("모두에게");
		
		JTextPane tp_content = new JTextPane();
		tp_content.setBounds(48, 264, 355, 196);
		frame.getContentPane().add(tp_content);
		
		JLabel lblNewLabel_1 = new JLabel("\u203B\uB0B4\uC6A9\u203B");
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(48, 239, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btn_send = new JButton("\uBCF4\uB0B4\uAE30");
		btn_send.setBackground(new Color(240, 255, 255));
		btn_send.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Mg_MessageBoxDAO dao = new Mg_MessageBoxDAO();
				ArrayList<MemberVO> al = dao.AllMember();
				String content1 = tp_content.getText();
				
				boolean result = false;
				for(int i=0; i<al.size(); i++) {
					int ms_no = 20;                      //메시지번호
					int send_id = 관리자번호;		          //보내는사람번호
					int receive_id = al.get(i).getMEMBER_NO();
					String content = content1;
					String ms_check = "N";
					Mg_MessageBoxVO vo = new Mg_MessageBoxVO(ms_no, send_id, receive_id, content, ms_check);
					result = dao.ALLSend(vo);
					
					
				}
				if(result == true) {
					JOptionPane.showMessageDialog(null, "전체메시지 전송성공!");
					Mg_MessageBox_Main.main(null);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "전체메시지 전송실패!");
				}
				
				
				
			}
		});
		btn_send.setBounds(69, 503, 131, 48);
		frame.getContentPane().add(btn_send);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBackground(new Color(240, 255, 255));
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mg_MessageBox_Main.main(null);
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(252, 503, 131, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Mg_Ms_Allsend.class.getResource("/image/\uADF8\uB8F9-removebg-preview.png")));
		lblNewLabel_3.setBounds(-12, 10, 461, 111);
		frame.getContentPane().add(lblNewLabel_3);
	}

}
