package cn.dmego.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**********************
 * 数据库连接工具类
 * @author dmego
 **********************/
public class JDBCUtils {
	private JDBCUtils(){} //私有构造方法
	static Properties prop = null;
	//为了保证只读取一次配置文件，将文件的读取步骤放在静态代码块中
	static{
		try{
		prop = new Properties();
		prop.load(new FileReader(JDBCUtils.class.getClassLoader().getResource("config.properties").getPath()));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//工具类提供两个方法，连接数据库/关闭数据库
	/**
	 * 连接数据库
	 * @return Connection 连接对象
	 * @throws Exception
	 */
	public static Connection getConn()throws Exception{
		Class.forName(prop.getProperty("driver"));
		return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
	}
	/**
	 * 关闭数据库
	 * @param rs
	 * @param stat
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement stat,Connection conn){
		if(rs !=null){
			try {					
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		if(stat !=null){
			try {					
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				stat = null;
			}
		}
		if(conn !=null){
			try {					
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}	
	}
}
