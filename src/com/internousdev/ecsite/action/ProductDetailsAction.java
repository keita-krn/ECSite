package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware{

	private int itemId;
	public Map<String,Object> session;

	public String execute(){

		String result = ERROR;
		BuyItemDAO buyItemDAO = new BuyItemDAO();
		BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo(itemId);

		session.put("productName",buyItemDTO.getItemName());
		session.put("productPrice",buyItemDTO.getItemPrice());
		List<Integer> productCountList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		session.put("productCountList", productCountList);
		result = SUCCESS;

		return result;
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
