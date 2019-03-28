package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	//private BuyItemDAO buyItemDAO = new BuyItemDAO();
	//次ページで商品一覧を表示する
	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",loginDTO);
		try{
			if(loginDTO.getAdminFlg().isEmpty() || loginDTO.getAdminFlg() == null){
				result = ERROR;
			}
			//ログインユーザーが管理者の場合(admin_flgカラムの値がaの場合)
			else if(loginDTO.getAdminFlg().equals("a")){
				result = "admin";
				return result;
			}
			//ログインが成功した場合
			if(((LoginDTO)session.get("loginUser")).getLoginFlg() && loginDTO.getAdminFlg().equals("b")){
				result = SUCCESS;
				itemList = itemListDAO.getItemInfo();
				session.put("itemList",itemList);
				//セッションにitemテーブルから情報を入れていく
				/*
				BuyItemDAO buyItemDAO = new BuyItemDAO();
				BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
				session.put("login_user_id",loginDTO.getLoginId());
				session.put("userName",loginDTO.getUserName()); //個人で追加
				session.put("id",buyItemDTO.getId());
				session.put("buyItem_name",buyItemDTO.getItemName());
				session.put("buyItem_price",buyItemDTO.getItemPrice()); */
			}
			if(loginDTO.getAdminFlg().isEmpty() || loginDTO.getAdminFlg() == null){
				result = ERROR;
			}
		}catch (NullPointerException e){
			result = ERROR;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	//商品一覧表示
	public ArrayList<ItemInfoDTO> getItemList(){
		return this.itemList;
	}

}
