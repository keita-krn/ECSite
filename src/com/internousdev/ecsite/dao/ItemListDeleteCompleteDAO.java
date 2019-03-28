package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public void itemListDelete()throws SQLException{
		try{
			String sql = "DELETE FROM item_info_transaction";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}
