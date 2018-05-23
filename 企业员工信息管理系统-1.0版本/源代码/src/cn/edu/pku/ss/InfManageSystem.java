package cn.edu.pku.ss;

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

class InfManageSystem extends JFrame implements Runnable {
	
	/**
	 * 用户使用界面
	 */
	private static final long serialVersionUID = 1L;
	
	final int width  = Toolkit.getDefaultToolkit().getScreenSize().width;
	final int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	Container container1 = getContentPane();
	Font font1 = new Font("新宋体", Font.PLAIN,12);
	Thread thread1 = new Thread(this);				//在窗体里创建一个线程并实例化
	JDesktopPane deskTopPane1 = new JDesktopPane();	//在窗体里建立一个虚拟桌面并实例化
	JMenuBar menuBar = new JMenuBar();				//实例化菜单栏
	JPanel panel1 = new JPanel();					//创建一个面板并实例化
	Label label1;									//欢迎语句标签
	Image img = Toolkit.getDefaultToolkit().getImage("image\\main.png");
	
	//创建菜单上的图标并实例化
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
		this.setTitle("企业员工信息管理系统");
		this.setSize(width - 800, height - 400);
	    this.setLocation(150, 100);
		this.setVisible(true);
		this.setResizable(false);		
		
		deskTopPane1.setBackground(Color.orange);
		container1.setLayout(new BorderLayout());			//创建一个布局
		container1.add(deskTopPane1,BorderLayout.CENTER);	//实例虚拟桌面的布局
		
		setJMenuBar(menuBar);
		
		AddSysManageFun();
		AddInfoManageFun();
		AddInfoSearchFun();
		AddToolFun();
		AddHelpFun();
		
		
		
		label1 = new Label("     欢  迎  使  用  企  业  员  工  信  息  管  理  系  统 !");
		label1.setBackground(Color.red);
		label1.setFont(new Font("新宋体", Font.PLAIN, 20));
		
		
		
		panel1.setLayout(new BorderLayout());	
		panel1.add(label1,BorderLayout.EAST);
		//thread1.start();
		container1.add(label1, BorderLayout.SOUTH);		
		
		
		
	}
	
	private void AddSysManageFun() {
		JMenu sysManage = new JMenu("系统管理");
		JMenu manageUser = new JMenu("用户管理");	//系统管理菜单下面的二级菜单
		
		JMenuItem addUser  = new JMenuItem("添加用户");
		JMenuItem delUser  = new JMenuItem("删除用户");
		JMenuItem chaUser  = new JMenuItem("用户修改");
		JMenuItem changePW = new JMenuItem("修改密码");
		JMenuItem reLogin  = new JMenuItem("重新登陆");
		JMenuItem sysExit  = new JMenuItem("退出系统");
		
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
		JMenu infoManage = new JMenu("信息管理");
		infoManage.setFont(font1);
		
		menuBar.add(infoManage);
	}
	
	private void AddInfoSearchFun() {
		JMenu infoSearch = new JMenu("信息查询");
		infoSearch.setFont(font1);
		
		menuBar.add(infoSearch);
	}
	
	private void AddToolFun() {
		JMenu tools = new JMenu("工  具  ");		
		JMenuItem calculator  = new JMenuItem("计算器");
		
		calculator.setFont(font1);
		tools.setFont(font1);
		
		tools.add(calculator);
		
		menuBar.add(tools);
	}
	
	private void AddHelpFun() {
		JMenu helpInfo = new JMenu("帮  助  ");
		
		JMenuItem helpUse  = new JMenuItem("使用帮助");
		JMenuItem aboutInfo  = new JMenuItem("关  于  ");
		
		helpInfo.add(helpUse);
		helpInfo.add(aboutInfo);
		
		helpInfo.setFont(font1);
		helpUse.setFont(font1);
		aboutInfo.setFont(font1);
		
		menuBar.add(helpInfo);
	}
	
	
	//线程方法用于欢迎语句滚动刷新
	public void run() {
		System.out.println("线程已启动!");
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