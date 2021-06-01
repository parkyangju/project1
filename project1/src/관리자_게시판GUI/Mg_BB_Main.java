package 관리자_게시판GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Controller.BulletinBoardDAO;
import GUI.관리자GUI;
import Model.BulletinBoardVO;

public class Mg_BB_Main {

	private JFrame frame;
	private JTable table;
	int selectBB;
	String selsubject;
	String selcontent;
	int selmember_no;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mg_BB_Main window = new Mg_BB_Main();
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
	public Mg_BB_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 585, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("(\uAD00\uB9AC\uC790\uC6A9)");
		lblNewLabel_2.setBounds(0, 576, 70, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uCCB4 \uAC8C\uC2DC\uAE00");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblNewLabel_1.setBounds(27, 101, 156, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 147, 385, 295);
		frame.getContentPane().add(scrollPane);
		
		BulletinBoardDAO dao = new BulletinBoardDAO();             //배열 생성해서 초기화면에 게시글 목록 띄워주기
		String[] colNames = {"게시글번호", "주제", "내용", "회원번호"};
		ArrayList<BulletinBoardVO> al = dao.selectBB();
		Object[][] data = new Object[al.size()][4];
		
		for(int i=0; i<al.size(); i++) {
			data[i][0] = al.get(i).getBB_no();
			data[i][1] = al.get(i).getSubject();
			data[i][2] = al.get(i).getBB_content();
			data[i][3] = al.get(i).getMember_no();
			
		}
		DefaultTableModel model = new DefaultTableModel(data, colNames) {       //더블클릭 하면 값입력 못하게 방지
	           public boolean isCellEditable(int rowIndex, int mColIndex) {
	                   return false;
	               }
	           };
		table = new JTable(model) {
	         public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	            JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);            
	            if((int)table.getValueAt(row, 3)==0) {
	               component.setForeground(Color.red);
	            }else {
	               component.setForeground(Color.black);
	            }            
	            return component;                     
	         }         
	      };
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn("게시글번호").setCellRenderer(celAlignCenter);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			

				
				selectBB = (int)table.getValueAt(table.getSelectedRow(), 0);
				selsubject = (String)table.getValueAt(table.getSelectedRow(), 1);
				selcontent = (String)table.getValueAt(table.getSelectedRow(), 2);
				selmember_no = (int)table.getValueAt(table.getSelectedRow(), 3);
				
				
		
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\uACF5\uC9C0\uAE00 \uC791\uC131\uD558\uAE30");
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mg_BB_write mgwrite = new Mg_BB_write();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(27, 452, 156, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uAC8C\uC2DC\uAE00 \uC218\uC815\uD558\uAE30");
		btnNewButton_1.setFont(new Font("한컴 고딕", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(240, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Mg_BB_Modify modify = new Mg_BB_Modify(selectBB,selsubject,selcontent,selmember_no);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(237, 452, 156, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\uAC8C\uC2DC\uAE00 \uC0AD\uC81C\uD558\uAE30");
		btnNewButton_1_1.setFont(new Font("한컴 고딕", Font.BOLD, 13));
		btnNewButton_1_1.setBackground(new Color(240, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "해당 게시글을 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.CLOSED_OPTION) {
					
				}else if(result == JOptionPane.YES_OPTION) {
					BulletinBoardDAO dao = new BulletinBoardDAO();
					boolean answer = dao.delete(selectBB);
					
					if(answer!=true) {
						JOptionPane.showMessageDialog(null, "삭제에 실패했습니다!");
					}else {
						JOptionPane.showMessageDialog(null, "삭제되었습니다!");
						Mg_BB_Main.main(null);
						frame.dispose();
					}
					
				}else {
					
				}
			}
		});
		btnNewButton_1_1.setBounds(237, 493, 156, 31);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("\uB2EB\uAE30");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("한컴 고딕", Font.BOLD, 12));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				관리자GUI asds = new 관리자GUI();
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(424, 542, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 439, 91);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC8C\uC2DC\uD310");
		lblNewLabel.setBounds(113, 10, 226, 59);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 40));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(102, 204, 255));
		lblNewLabel_3.setIcon(new ImageIcon(Mg_BB_Main.class.getResource("/image/\uB9E4\uB2C8\uC800-removebg-preview.png")));
		lblNewLabel_3.setBounds(435, 0, 134, 591);
		frame.getContentPane().add(lblNewLabel_3);
	}

}
