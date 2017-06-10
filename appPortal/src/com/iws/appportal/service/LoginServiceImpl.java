package com.iws.appportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iws.appportal.dao.PromoCodeIF;
import com.iws.appportal.dto.CampaignsDTO;
import com.iws.appportal.dto.ProductsDTO;
import com.iws.appportal.exceptions.DaoException;
import com.iws.appportal.exceptions.ServiceException;
import com.iws.appportal.factory.DaoFactory;

@Service
public class LoginServiceImpl implements LoginServiceIF {

	
	
	private PromoCodeIF promoCode=null;	
	public Integer loginVerify(String username, String password) throws ServiceException {

		
		// LDAP Service Information (WS Call)
		
		// Connect to Database (If not LDAP)
		
		
		return null;
	}
	
	
	public List<CampaignsDTO> getCampaigns() throws ServiceException{
		
		promoCode=DaoFactory.promoCode();
			
		System.out.println("Service PromoCode INFO ===>>"+promoCode);
		try {
			return promoCode.getCampaigns();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public List<ProductsDTO> getProductList() throws ServiceException{
		
		promoCode=DaoFactory.promoCode();
		
		try {
			return promoCode.getProductList();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
