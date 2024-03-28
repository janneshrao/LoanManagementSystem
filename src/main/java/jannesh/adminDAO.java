package jannesh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class adminDAO {

	public String retriveAdmin(String uname) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from lms_admin where uname=?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String password = rs.getString(3);
				return password;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public ArrayList<User> getAllUsers() {
		try {
			ArrayList<User> list = new ArrayList<User>();
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from lms_users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User obj = new User();
				obj.setName(rs.getString(1));
				obj.setUname(rs.getString(2));
				obj.setPword(rs.getString(3));
				list.add(obj);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
