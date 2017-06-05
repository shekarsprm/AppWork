package com.iws.appportal.dao;

import com.iws.appportal.exceptions.DaoException;

public interface PromoCodeIF {
	public String codeGenerations(Integer noOfCodes, String fileName) throws DaoException;
}
