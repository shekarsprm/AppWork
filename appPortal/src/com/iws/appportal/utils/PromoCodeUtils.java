package com.iws.appportal.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.security.SecureRandom;

public class PromoCodeUtils {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	public static String randomNumber(int len) {

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();

	}

	public static void execute(int noOfCodes, String fileName) {
		int currentCount = 0;
		BufferedWriter bufferWritter = null;
		try {
			FileWriter fileWritter = new FileWriter(fileName, true);
			bufferWritter = new BufferedWriter(fileWritter);
			for (int i = 0; i < noOfCodes; i++) {
				String promoCodeVerfication = randomNumber(8);
				bufferWritter.write(promoCodeVerfication + "\n");
				bufferWritter.flush();
				currentCount++;
			}
		} catch (Exception e) {
			execute(noOfCodes - currentCount, fileName);
		}

	}

	public static void main(String[] args) {
		execute(100, "");
	}
}
