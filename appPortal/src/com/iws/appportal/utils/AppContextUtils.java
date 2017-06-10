package com.iws.appportal.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iws.appportal.dao.HomeDaoIF;
import com.iws.appportal.dao.HomeDaoImpl;
import com.iws.appportal.dao.LoginDaoIF;
import com.iws.appportal.dao.LoginDaoImpl;
import com.iws.appportal.dao.PromoCodeDaoImpl;
import com.iws.appportal.dao.PromoCodeIF;
import com.iws.appportal.dto.UserDTO;
import com.iws.appportal.exceptions.DaoException;

public class AppContextUtils {


	public static ApplicationContext getContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		return context;
	}
	
	public static void callLoginDaoImpl(){
		
		LoginDaoIF loginDao=(LoginDaoImpl)getContext().getBean("loginDaoImpl");
		
		UserDTO userDTO=loginDao.getUserInfo("shekar");	
	}
	
	public static void callAppCodesDaoImpl(){
			try{
			PromoCodeIF promoCode=(PromoCodeDaoImpl)getContext().getBean("promoCode");
			
			promoCode.codeGenerations(15, "E:/nit/codes_10.txt");
	        
			}catch(DaoException dao){
				dao.printStackTrace();
			}
	}

	public static void callHomeDaoImpl(){
		HomeDaoIF homeDaoIF	=(HomeDaoImpl)getContext().getBean("homeDaoImpl");
		try{
		// Calling List Of Campaigns Info
		homeDaoIF.listOfCampaigns();
		
		// Calling List Of Products Info
		
		homeDaoIF.listOfProducts();
		}catch(DaoException dao){
		          dao.printStackTrace();	
		}
	}
	public static void main(String[] args) {
		
		/*
		*/
		
		
		
			
	}
}
