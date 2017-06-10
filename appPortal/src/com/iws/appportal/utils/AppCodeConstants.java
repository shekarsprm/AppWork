package com.iws.appportal.utils;

public class AppCodeConstants {

	public static String INSERT_QUERY=PropertiesUtility.getPropertiesValue("INSERT_CODES_QUERY");
	
	public static String SELECT_LIST_CAMPAIGNS=PropertiesUtility.getPropertiesValue("SELECT_LIST_CAMPAIGNS");
	
	public static String SELECT_LIST_PRODUCTS=PropertiesUtility.getPropertiesValue("SELECT_LIST_PRODUCTS");
	
	public static String SELECT_CAMPAIGN_KEY_SHORT_CODE_INFO=PropertiesUtility.getPropertiesValue("SELECT_CAMPAIGN_KEY_SHORT_CODE_INFO");
	
	public static String SELECT_COUNT_CAMP_PRODUCT=PropertiesUtility.getPropertiesValue("SELECT_COUNT_CAMP_PRODUCT");
	
	
	public static void main(String[] args) {
		
		System.out.println(SELECT_CAMPAIGN_KEY_SHORT_CODE_INFO);
	}
}
