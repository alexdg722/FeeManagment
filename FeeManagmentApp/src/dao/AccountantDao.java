package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AccountantBean;
import utils.DB;


public class AccountantDao {

	
	public static int save(AccountantBean bean) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO fee_accountant"
				+ "  (firstname, lastname, email, password, address, contact) VALUES "
				+ " (?, ?, ?, ?, ?, ?);";

		int result = 0;
		try {
			Connection connection = DB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, bean.getFirstname());
			preparedStatement.setString(2, bean.getLastname());
			preparedStatement.setString(3, bean.getEmail());
			preparedStatement.setString(4, bean.getPassword());
			preparedStatement.setString(5, bean.getaddress());
			preparedStatement.setString(6, bean.getContact());

			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			DB.printSQLException(e);
		}
		return result;
	}
	
	public static boolean validate(String email,String password)
	{
		boolean status=false;
		try{
			Connection connection = DB.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from fee_accountant where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();			
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return status;
	}
	
	public static int update(AccountantBean bean)
	{
		int status=0;
		try{
			Connection connection = DB.getConnection();
			PreparedStatement ps=connection.prepareStatement("update fee_accountant set firstname=?,lastname=?,email=?,password=?,address=?,contact=? where id=?");
			ps.setString(1, bean.getFirstname());
			ps.setString(2, bean.getLastname());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPassword());
			ps.setString(5, bean.getaddress());
			ps.setString(6, bean.getContact());
			ps.setInt(7, bean.getId());
			
			status = ps.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return status;
	}	

	public static int delete(int id)
	{
		int status=0;
		try{
			Connection connection = DB.getConnection();
			PreparedStatement ps = connection.prepareStatement("delete from fee_accountant where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return status;
	}
	
	public static List<AccountantBean> getAllRecords(){
		List<AccountantBean> list = new ArrayList<AccountantBean>();
		
		try{
			Connection connection = DB.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from fee_accountant");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				AccountantBean bean = new AccountantBean();
				bean.setId(rs.getInt(1));
				bean.setFirstname(rs.getString(2));
				bean.setLastname(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setaddress(rs.getString(6));
				bean.setContact(rs.getString(7));
				list.add(bean);
			}
		}catch(Exception ex){
			System.out.println(ex);
			}
		
		return list;
	}

	public static AccountantBean getRecordById(int id)
	{
		AccountantBean bean = new AccountantBean();
		try{
			Connection connection = DB.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from fee_accountant where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setFirstname(rs.getString(2));
				bean.setLastname(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setaddress(rs.getString(6));
				bean.setContact(rs.getString(7));
			}
		}			
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return bean;
	}
}
