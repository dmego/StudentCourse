package cn.dmego.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**********************
 * ���ݿ����ӹ�����
 * @author dmego
 **********************/
public class JDBCUtils {
	private JDBCUtils(){} //˽�й��췽��
	static Properties prop = null;
	//Ϊ�˱�ֻ֤��ȡһ�������ļ������ļ��Ķ�ȡ������ھ�̬�������
	static{
		try{
		prop = new Properties();
		prop.load(new FileReader(JDBCUtils.class.getClassLoader().getResource("config.properties").getPath()));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//�������ṩ�����������������ݿ�/�ر����ݿ�
	/**
	 * �������ݿ�
	 * @return Connection ���Ӷ���
	 * @throws Exception
	 */
	public static Connection getConn()throws Exception{
		Class.forName(prop.getProperty("driver"));
		return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
	}
	/**
	 * �ر����ݿ�
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
