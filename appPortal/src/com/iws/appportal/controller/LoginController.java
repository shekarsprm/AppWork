package com.iws.appportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iws.appportal.utils.PropertiesUtility;

@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/")
	public String index(HttpServletRequest req, HttpServletResponse res) {

		return "index";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login(HttpServletRequest req, HttpServletResponse res) {
		String replyPage = "promocodegenerate";
		logger.info("##### Enter into the login() ####");
		System.out.println("Login ::::>>>>>>>>>>>....");
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");

		String validateCheck = ValidationUtils.loginValidation(username, password);
		if ("0".equalsIgnoreCase(validateCheck)) {

		} else {

			String value = PropertiesUtility.getPropertiesValue(validateCheck);
		}
		Integer loginVerficationId = 10;

		logger.info("##### Exit into the login() ####");

		return replyPage;
	}

	/*
	 * try { loginVerficationId=loginServiceIF.loginVerification(username,
	 * password); } catch (ServiceException e) {
	 * replyPage=appportalPromoConstants.DEFAULT_PAGE; e.printStackTrace(); }
	 * if(loginVerficationId==0){
	 * replyPage=appportalPromoConstants.DEFAULT_PAGE; }else
	 * if(loginVerficationId==1){ try { UserDTO
	 * userDTO=loginServiceIF.userPromoUserProfile(username); HttpSession
	 * session = req.getSession(); session.setAttribute("username",
	 * userDTO.getUsername()); } catch (ServiceException e) {
	 * e.printStackTrace(); } replyPage=appportalPromoConstants.HOME_PAGE; }else
	 * if(loginVerficationId==2){
	 * replyPage=appportalPromoConstants.DEFAULT_PAGE; }else{
	 * replyPage=appportalPromoConstants.DEFAULT_PAGE; }
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse res) {
		logger.info("##### Enter into the login() ####");
		String replyView = "login";
		request.getSession().removeAttribute("username");
		request.getSession().invalidate();
		logger.info("##### Enter into the login() ####");
		return replyView;
	}

	public static void main(String[] args) {

		String username = "aaa";
		String password = "xxx";

		String validateCheck = ValidationUtils.loginValidation(username, password);
		String response = "";
		if ("0".equalsIgnoreCase(validateCheck)) {
			// Service Layer
			response = "SUCCESS";
		} else {
			response = PropertiesUtility.getPropertiesValue(validateCheck);
		}
		
		System.out.println(response);

	}
}
