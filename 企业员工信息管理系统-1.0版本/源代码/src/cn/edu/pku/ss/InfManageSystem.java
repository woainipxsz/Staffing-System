package cn.edu.pku.ss;

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

class InfManageSystem extends JFrame implements Runnable {
	
	/**
	 * �û�ʹ�ý���
	 */
	private static final long serialVersionUID = 1L;
	
	final int width  = Toolkit.getDefaultToolkit().getScreenSize().width;
	final int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	Container container1 = getContentPane();
	Font font1 = new Font("������", Font.PLAIN,12);
	Thread thread1 = new Thread(this);				//�ڴ����ﴴ��һ���̲߳�ʵ����
	JDesktopPane deskTopPane1 = new JDesktopPane();	//�ڴ����ｨ��һ���������沢ʵ����
	JMenuBar menuBar = new JMenuBar();				//ʵ�����˵���
	JPanel panel1 = new JPanel();					//����һ����岢ʵ����
	Label label1;									//��ӭ����ǩ
	Image img = Toolkit.getDefaultToolkit().getImage("image\\main.png");
	
	//�����˵��ϵ�ͼ�겢ʵ����
   	ImageIcon icon1  =new ImageIcon("image\\tjsc.png");
	ImageIcon icon2  =new ImageIcon("image\\cxdl.png");
	ImageIcon icon3  =new ImageIcon("image\\xgmm.png");
	ImageIcon icon4  =new ImageIcon("image\\tcxt.png");
	ImageIcon icon5  =new ImageIcon("image\\jj.png");
	ImageIcon icon6  =new ImageIcon("image\\help.png");
	ImageIcon icon7  =new ImageIcon("image\\cx.png");
	ImageIcon icon8  =new ImageIcon("image\\gl.png");
	ImageIcon icon9  =new ImageIcon("image\\xt.png");
	ImageIcon icon10 =new ImageIcon("image\\xxgl.png");
	ImageIcon icon11 =new ImageIcon("image\\xxcx.png");
	ImageIcon icon12 =new ImageIcon("image\\bz.png");
	ImageIcon icon13 =new ImageIcon("image\\gy.png");
	ImageIcon icon14 =new ImageIcon("image\\glxx.png");
	ImageIcon icon15 =new ImageIcon("image\\cxxx.png");
	
	public InfManageSystem() {

		this.setIconImage(img);
		this.setTitle("��ҵԱ����Ϣ����ϵͳ");
		this.setSize(width - 800, height - 400);
	    this.setLocation(150, 100);
		this.setVisible(true);
		this.setResizable(false);		
		
		deskTopPane1.setBackground(Color.orange);
		container1.setLayout(new BorderLayout());			//����һ������
		container1.add(deskTopPane1,BorderLayout.CENTER);	//ʵ����������Ĳ���
		
		setJMenuBar(menuBar);
		
		AddSysManageFun();
		AddInfoManageFun();
		AddInfoSearchFun();
		AddToolFun();
		AddHelpFun();
		
		
		
		label1 = new Label("     ��  ӭ  ʹ  ��  ��  ҵ  Ա  ��  ��  Ϣ  ��  ��  ϵ  ͳ !");
		label1.setBackground(Color.red);
		label1.setFont(new Font("������", Font.PLAIN, 20));
		
		
		
		panel1.setLayout(new BorderLayout());	
		panel1.add(label1,BorderLayout.EAST);
		//thread1.start();
		container1.add(label1, BorderLayout.SOUTH);		
		
		
		
	}
	
	private void AddSysManageFun() {
		JMenu sysManage = new JMenu("ϵͳ����");
		JMenu manageUser = new JMenu("�û�����");	//ϵͳ����˵�����Ķ����˵�
		
		JMenuItem addUser  = new JMenuItem("����û�");
		JMenuItem delUser  = new JMenuItem("ɾ���û�");
		JMenuItem chaUser  = new JMenuItem("�û��޸�");
		JMenuItem changePW = new JMenuItem("�޸�����");
		JMenuItem reLogin  = new JMenuItem("���µ�½");
		JMenuItem sysExit  = new JMenuItem("�˳�ϵͳ");
		
		manageUser.add(addUser);
		manageUser.add(delUser);
		manageUser.add(chaUser);
		sysManage.add(manageUser);
		sysManage.add(changePW);
		sysManage.add(reLogin);
		sysManage.add(sysExit);
		menuBar.add(sysManage);
		
		sysManage.setFont(font1);
		manageUser.setFont(font1);
		addUser.setFont(font1);
		delUser.setFont(font1);
		chaUser.setFont(font1);
		changePW.setFont(font1);
		reLogin.setFont(font1);
		sysExit.setFont(font1);
		
		sysManage.setIcon(icon9);
		changePW.setIcon(icon3);
		sysExit.setIcon(icon4);		
	}
	
	private void AddInfoManageFun() {
		JMenu infoManage = new JMenu("��Ϣ����");
		infoManage.setFont(font1);
		
		menuBar.add(infoManage);
	}
	
	private void AddInfoSearchFun() {
		JMenu infoSearch = new JMenu("��Ϣ��ѯ");
		infoSearch.setFont(font1);
		
		menuBar.add(infoSearch);
	}
	
	private void AddToolFun() {
		JMenu tools = new JMenu("��  ��  ");		
		JMenuItem calculator  = new JMenuItem("������");
		
		calculator.setFont(font1);
		tools.setFont(font1);
		
		tools.add(calculator);
		
		menuBar.add(tools);
	}
	
	private void AddHelpFun() {
		JMenu helpInfo = new JMenu("��  ��  ");
		
		JMenuItem helpUse  = new JMenuItem("ʹ�ð���");
		JMenuItem aboutInfo  = new JMenuItem("��  ��  ");
		
		helpInfo.add(helpUse);
		helpInfo.add(aboutInfo);
		
		helpInfo.setFont(font1);
		helpUse.setFont(font1);
		aboutInfo.setFont(font1);
		
		menuBar.add(helpInfo);
	}
	
	
	//�̷߳������ڻ�ӭ������ˢ��
	public void run() {
		System.out.println("�߳�������!");
		int label1_x = width;
		
		while(true) {
			if(label1_x < -600)
				label1_x = width;
			label1.repaint(label1_x, 0, 500, 20);
			label1_x -= 10;
			try {
				Thread.sleep(100);
			}catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}			
		}		
	}	
	
	public static void main(String[] args) {
		new InfManageSystem();
	}
}