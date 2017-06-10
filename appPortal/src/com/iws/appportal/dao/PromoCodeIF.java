package com.iws.appportal.dao;

import java.util.List;

import com.iws.appportal.dto.CampaignsDTO;
import com.iws.appportal.dto.ProductsDTO;
import com.iws.appportal.exceptions.DaoException;

public interface PromoCodeIF {
	public String codeGenerations(Integer noOfCodes, String fileName) throws DaoException;
	public List<CampaignsDTO> getCampaigns() throws DaoException;
	public List<ProductsDTO> getProductList() throws DaoException;
}
