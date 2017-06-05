package com.iws.appportal.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {

	public static String encrypt(String password) {
		String output = "";
		try {
				MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(password.getBytes());
			byte[] hash = digest.digest();
			for (byte b : hash) {
				int i = b + 128;
				output = output
						+ String.format("%x",
								new Object[] { Integer.valueOf(i) });
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return output;
	}
	public static void main(String[] args) {
		System.out.println(encrypt("K3L09xyS"));
	}	
}