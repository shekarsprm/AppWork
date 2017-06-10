package com.iws.appportal.service;

import java.util.List;

import com.iws.appportal.dto.CampaignsDTO;
import com.iws.appportal.dto.ProductsDTO;
import com.iws.appportal.exceptions.ServiceException;

public interface LoginServiceIF {

	public Integer loginVerify(String username,String password) throws ServiceException;
	public List<CampaignsDTO> getCampaigns() throws ServiceException;
	public List<ProductsDTO> getProductList() throws ServiceException;

}
