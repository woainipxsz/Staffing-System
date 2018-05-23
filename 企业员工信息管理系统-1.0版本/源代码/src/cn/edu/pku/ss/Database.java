package cn.edu.pku.ss;

import java.sql.*;

public class Database {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet result = null;
	private static final String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	//导入类名
	private static final String url = "jdbc:sqlserver://localhost:1433";					//数据库url
	private static final String user = "sa";												//数据库用户名
	private static final String password = "guan8888";										//数据库密码
	private static final String catalog = "EmInfoSystem";												//数据库名称
	//连接数据库
	public static boolean join() {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, password);
			connection.setCatalog(catalog);
			System.out.println("数据库连接成功!");
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
	//执行查询语句
	public static boolean executeSQL(String sql) {
		try {
			statement.execute(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	//返回查询结果
	public static boolean query(String sql) {
		try {
			result = statement.executeQuery(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	//判断查询结果是否为空
	public static boolean resultIsEmpty() throws SQLException {
		if(result.next())
			return false;
		else
			return true;
	}

}
