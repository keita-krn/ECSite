package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public void userListDelete()throws SQLException{
		try{
			String sql = "DELETE FROM login_user_transaction where admin_flg='b'";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}
