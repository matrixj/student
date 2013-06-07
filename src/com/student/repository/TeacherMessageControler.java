package DataBaseControler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用于操作存储教师信息的数据库
 * @author Hunter
 *
 */
public class TeacherMessageControler {
	
	private Connection connection;	//用于连接数据库
	private PreparedStatement SearchStatment;	//查找预处理语句
	private PreparedStatement InsertStatment;	//插入预处理语句
	private PreparedStatement DeleteStatment;	//删除预处理语句
	private ResultSet resultSet;	//数据集
	
	public TeacherMessageControler(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsystem","root","a359712032");
			SearchStatment = connection.prepareStatement("select * from Teacher where Tid like ? and Name like ? and Password like ?");	//查询语句
			InsertStatment = connection.prepareStatement("insert into teacher values(?,?,?)");	//插入语句
			DeleteStatment = connection.prepareStatement("delete from teacher where Tid = ?");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询指定老师信息
	 */
	public void SearchTeacher(String Tid,String Name,String Password){
		try {
			if(Password==null)Password = "%";
			if(Name==null)Name = "%";
			if(Tid==null)	SearchStatment.setString(1, "%");
			else SearchStatment.setInt(1, Integer.parseInt(Tid));
			SearchStatment.setString(2, Name);
			SearchStatment.setString(3, Password);
			resultSet = SearchStatment.executeQuery();
			SearchStatment.clearParameters();
			while(resultSet.next()){
				System.out.println(resultSet.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 插入老师信息到数据库
	 */
	public Boolean InsertTeacher(String Tid,String Name,String Password){
		try {
			InsertStatment.setInt(1, Integer.parseInt(Tid));
			InsertStatment.setString(2, Name);
			InsertStatment.setString(3, Password);
			InsertStatment.executeQuery();
			InsertStatment.clearParameters();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 从数据库删除指定老师信息
	 */
	public Boolean DeleteTeacher(String Tid){
		try {
			DeleteStatment.setInt(1, Integer.parseInt(Tid));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 关闭数据库连接
	 */
	public void Close(){
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
