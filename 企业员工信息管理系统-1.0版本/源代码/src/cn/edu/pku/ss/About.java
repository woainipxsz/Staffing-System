package cn.edu.pku.ss;

import java.awt.*;
import javax.swing.*;

public class About extends JInternalFrame {

	/**
	 * ���������˵��
	 */
	private static final long serialVersionUID = 1L;
	private final int width = 380;
	private final int height = 220;
		
	JLabel version        = new JLabel("�汾��1.0");
	JLabel runEnvironment = new JLabel("����ƽ̨��Windows");
	JLabel databaseType   = new JLabel("���ݿ⣺SQL Server 2012");
	JLabel developer      = new JLabel("������Ա���ؼ�־С��");
	
	public About() {
		
		setTitle("����");
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
