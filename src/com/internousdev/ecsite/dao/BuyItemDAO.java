package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

		private DBConnector dbConnector = new DBConnector();
		private Connection connection = dbConnector.getConnection();
		private BuyItemDTO buyItemDTO = new BuyItemDTO();

		public BuyItemDTO getBuyItemInfo(int itemId){

			String sql = "SELECT item_name,item_price FROM item_info_transaction WHERE id=?";

			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1,itemId);
				ResultSet resultSet = preparedStatement.executeQuery();

				if(resultSet.next()){
					buyItemDTO.setItemName(resultSet.getString("item_name"));
					buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return buyItemDTO;
		}
		public BuyItemDTO getBuyItemDTO(){
			return buyItemDTO;
		}

}
