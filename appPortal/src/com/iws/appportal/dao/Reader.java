package com.iws.appportal.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reader {

	public static void main(String[] args) {
		
		try{
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		int x=Integer.parseInt(br.readLine());
		System.out.println(x);
		}catch(Exception e){
			
		}
	}
}
