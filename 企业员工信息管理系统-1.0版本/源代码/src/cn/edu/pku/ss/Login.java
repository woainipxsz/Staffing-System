package cn.edu.pku.ss;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {

	/**
	 * ϵͳ��¼����
	 */
	private static final long serialVersionUID = 1L;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private Image image1 = Toolkit.getDefaultToolkit().getImage("image\\main.png");
	private JTextField userName = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JLabel  systemLabel   = new JLabel("��ҵԱ����Ϣ����ϵͳ");
	private JLabel  userNameLabel = new JLabel("�û���");
	private JLabel  passwordLabel = new JLabel("���룺");
	private JButton enterButton   = new JButton("��¼");
	private JButton cancelButton  = new JButton("���");	
	private Font font1 = new Font("������",Font.PLAIN,12);
	private Font font2 = new Font("������",Font.PLAIN,14);
	
	public Login() {
		
		setBounds(width/2-150,height/2-90,300,180);
		setIconImage(image1);
		setResizable(false);
		setTitle("��¼����");
		setVisible(true);
		
		Container container1 = this.getContentPane();
		container1.setLayout(null);	//��ղ��ֹ�����
		//��
		systemLabel.setBounds(80, 10, 200, 20);
		systemLabel.setFont(font2);
		container1.add(systemLabel);
		//
		userNameLabel.setBounds(45,40,55,20);
		userNameLabel.setFont(font1);
		container1.add(userNameLabel);
		userName.setBounds(95,40,120,20);
		container1.add(userName);
		//��
		passwordLabel.setBounds(45,70,45,20);
		passwordLabel.setFont(font1);
		container1.add(passwordLabel);
		password.setBounds(95,70,120,20);
		container1.add(password);
		//
		enterButton.setBounds(90,110,60,20);
		enterButton.setFont(font1);
		container1.add(enterButton);
		enterButtonListener();
		//
		cancelButton.setBounds(155,110,60,20);
		cancelButton.setFont(font1);
		container1.add(cancelButton);
		cancelButtonListener();
		//
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void JFClose(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void executeSQL(String sql) {
		if(Database.join()) {
			if(Database.query(sql)) {
				try {
					if(!Database.resultIsEmpty()) {
						System.out.println("��¼�ɹ�");
						this.setVisible(false);	//
						new InfManageSystem();	//
					}
					else {
						new JOptionPane();
						JOptionPane.showMessageDialog(null,"�û������������!","",JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			System.out.println("���ݿ�����ʧ��!");
		}
	}
	
	public void enterButtonListener() {
		enterButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String userName1 = userName.getText();
				String password1 = String.valueOf(password.getPassword());
				if(userName1.equals("")) {
					new JOptionPane();
					JOptionPane.showMessageDialog(null,"�û�������Ϊ��!");
				}
				else if(password1.equals("")) {
					new JOptionPane();
					JOptionPane.showMessageDialog(null,"���벻��Ϊ��!");					
				}
				else {
					String sql = "select * from UserInformation where User_Name = '"
				+ userName1 + "' and Password = '" + password1+ "'";
					executeSQL(sql);	//
				}
			}
		});
	}
	
	public void cancelButtonListener() {
		cancelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				userName.setText("");
				password.setText("");
			}
		});
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
