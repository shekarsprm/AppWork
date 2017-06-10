package com.iws.appportal.factory;

import com.iws.appportal.dao.LoginDaoIF;
import com.iws.appportal.dao.PromoCodeDaoImpl;
import com.iws.appportal.dao.PromoCodeIF;

public class DaoFactory {

	private static LoginDaoIF loginDaoIF = null;
	private static PromoCodeIF promoCodeDaoIF = null;

	static {

		promoCodeDaoIF = new PromoCodeDaoImpl();
	}

	public static PromoCodeIF promoCode() {
		return promoCodeDaoIF;
	}

}
