package user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import base.DBManager;

public class UserDataDAO {

	public static  UserDataDAO getInstance(){
		return new UserDataDAO();
	}

	void MakeAccount(UserDataDTO ud) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
            st = (PreparedStatement) con.prepareStatement("INSERT INTO user_t(name,password,mail,address,total,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
			st.setString(2, ud.getPassword());
			st.setString(3, ud.getMailaddress());
			st.setString(4, ud.getAddress());
			st.setInt(5, ud.getTotalPrice());
			st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			st.execute();
		}catch(SQLException e){
			System.out.println(e.getMessage());
            throw new SQLException(e);
		}finally{
			if(con != null) {
				con.close();
			}
		}
	}

	public ArrayList<UserDataDTO> forLogin(UserDataDTO udd) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = (PreparedStatement) con.prepareStatement("SELECT * FROM user_t WHERE name = ? and password = ?");
			st.setString(1, udd.getName());
			st.setString(2, udd.getPassword());
			ResultSet rs = st.executeQuery();
			UserDataDTO resultUd = new UserDataDTO();
			ArrayList<UserDataDTO> UserData = new ArrayList<UserDataDTO>();

			while(rs.next()) {
				resultUd.setUserID(rs.getInt(1));
				resultUd.setName(rs.getString(2));
				resultUd.setPassword(rs.getString(3));
				resultUd.setMailaddress(rs.getString(4));
				resultUd.setAddress(rs.getString(5));
				resultUd.setTotalPrice(rs.getInt(6));
				resultUd.setNewDate(rs.getTimestamp(7));
				resultUd.setDeleteFlg(rs.getInt(8));
				UserData.add(resultUd);
			}

			return UserData;

		}catch(SQLException e) {
			throw new SQLException(e);
		}finally{
			if(con != null) {
				con.close();
			}
		}
	}

	public void updateTotal(UserDataDTO ud) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = (PreparedStatement) con.prepareStatement("UPDATE user_t SET total = ? WHERE userID=?");
			st.setInt(1, ud.getTotalPrice());
			st.setInt(2, ud.getUserID());
			st.executeUpdate();
		}catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			if(con != null) {
				con.close();
			}
		}
	}

	public void boughtProduct(UserDataDTO ud) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = (PreparedStatement) con.prepareStatement("INSERT INTO buy_t(userID, itemcode, type, buyDate) VALUES(?,?,?,?)");
			 System.out.print(ud.getUserID());
			st.setInt(1, ud.getUserID());
			st.setString(2, ud.getItemcode());
			st.setInt(3, ud.getType());
			st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();
		}catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			if(con != null) {
				con.close();
			}
		}
	}



}
