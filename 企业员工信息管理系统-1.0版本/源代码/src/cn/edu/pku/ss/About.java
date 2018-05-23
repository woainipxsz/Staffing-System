package cn.edu.pku.ss;

import java.awt.*;
import javax.swing.*;

public class About extends JInternalFrame {

	/**
	 * 关于软件的说明
	 */
	private static final long serialVersionUID = 1L;
	private final int width = 380;
	private final int height = 220;
		
	JLabel version        = new JLabel("版本：1.0");
	JLabel runEnvironment = new JLabel("运行平台：Windows");
	JLabel databaseType   = new JLabel("数据库：SQL Server 2012");
	JLabel developer      = new JLabel("开发人员：关家志小组");
	
	public About() {
		
		setTitle("关于");
		Container container1 = getContentPane();
		container1.setLayout(new GridLayout(4,1));
		container1.add(version);
		container1.add(runEnvironment);
		container1.add(databaseType);
		container1.add(developer);
		container1.setBackground(Color.WHITE);
		
		setResizable(false);
		setSize(width,height);
		setVisible(true);
		setClosable(true);		
	}	
}
