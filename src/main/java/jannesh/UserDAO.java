package jannesh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	public int saveUser(User obj) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into lms_users values(?,?,?)");
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getUname());
			ps.setString(3, obj.getPword());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public User retriveUser(String username) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from lms_users where uname=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User obj = new User();
				obj.setName(rs.getString(1));
				obj.setUname(rs.getString(2));
				obj.setPword(rs.getString(3));
				return obj;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

}
