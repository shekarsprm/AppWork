package com.iws.appportal.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iws.appportal.dao.PromoCodeDaoImpl;
import com.iws.appportal.dao.PromoCodeIF;
import com.iws.appportal.exceptions.DaoException;

public class AppContextUtils {


	public static ApplicationContext getContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		return context;
	}
	
	
	public static void main(String[] args) {
		
		/*LoginDaoIF loginDao=(LoginDaoImpl)getContext().getBean("loginDaoImpl");
			
		UserDTO userDTO=loginDao.getUserInfo("shekar");
		*/
		//promoCode
	
		try{
		PromoCodeIF promoCode=(PromoCodeDaoImpl)getContext().getBean("promoCode");
		
		promoCode.codeGenerations(15, "E:/nit/codes_10.txt");
        
		}catch(DaoException dao){
			
		}
			
		
	}
}
