package cn.edu.pku.ss;

import java.sql.*;

public class Database {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet result = null;
	private static final String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	//��������
	private static final String url = "jdbc:sqlserver://localhost:1433";					//���ݿ�url
	private static final String user = "sa";												//���ݿ��û���
	private static final String password = "guan8888";										//���ݿ�����
	private static final String catalog = "EmInfoSystem";												//���ݿ�����
	//�������ݿ�
	public static boolean join() {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, password);
			connection.setCatalog(catalog);
			System.out.println("���ݿ����ӳɹ�!");
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	//ִ�в�ѯ���
	public static boolean executeSQL(String sql) {
		try {
			statement.execute(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	//���ز�ѯ���
	public static boolean query(String sql) {
		try {
			result = statement.executeQuery(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	//�жϲ�ѯ����Ƿ�Ϊ��
	public static boolean resultIsEmpty() throws SQLException {
		if(result.next())
			return false;
		else
			return true;
	}

}
