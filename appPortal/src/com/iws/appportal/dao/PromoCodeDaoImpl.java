package com.iws.appportal.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.security.SecureRandom;
import java.util.Date;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.iws.appportal.exceptions.DaoException;
import com.iws.appportal.utils.Md5Utils;

public class PromoCodeDaoImpl implements PromoCodeIF {

	private JdbcTemplate jdbcTemplate;
	
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public String codeGenerations(Integer noOfCodes, String fileName) throws DaoException {
		int count=0;
		BufferedWriter bufferWritter=null;
		try {
			
			FileWriter fileWritter = new FileWriter(fileName, true);	
			bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write("CODE_ID"+"|"+"INSERT_DATE"+"\n");
			for(int i=0;i<noOfCodes;i++){
				String code_ID=randomNumber(2);
             	
				/*  jdbcTemplate.update("INSERT INTO appPortal.app_codes_tbl(app_user,expire_code_date,camp_id,countOf_Codes,product_id,update_code_date,code_status,app_Code) "
     			  		+ "values ('shekar','2017-10-10',1,100,1,'2017-06-06',1,'0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz')");//, new Object[]{"shekar",'2017-10-10',1,100,1,'2017-06-06',1,'0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'});
			   */
     			 jdbcTemplate.update("INSERT INTO appPortal.app_codes_tbl(app_user,expire_code_date,camp_id,countOf_Codes,product_id,update_code_date,code_status,app_Code) "
      			  		+ "values (?,?,?,?,?,?,?,?)", new Object[]{"shekar","2017-10-10",1,noOfCodes,1,"2017-10-10",1,Md5Utils.encrypt(code_ID)});
     			 //, new Object[]{"shekar",'2017-10-10',1,100,1,'2017-06-06',1,'0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'});
     			   System.out.println("CODE ID"+code_ID);
     			 bufferWritter.write(code_ID +"|"+new Date()+"\n");
				bufferWritter.flush();
     		 count++;
			}
		}catch(DuplicateKeyException de){
			   //de.printStackTrace();
			   System.out.println("Count is ===>>"+count);
			   codeGenerations(noOfCodes-count,fileName);
		}
		catch (Exception e) {
			  e.printStackTrace();
		}
		return "SUCCESSSSSSSSSSS";
	}

	
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	//static final String AB = "012";
	
	static SecureRandom rnd = new SecureRandom();

	public static String randomNumber(int len) {

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();

	}
	
	
	public static void main(String[] args) {
		
		for(int i=0;i<100;i++){
			String code_ID=randomNumber(8);
		System.out.println(code_ID+"  "+ Md5Utils.encrypt(code_ID));
		}
		
	}
	
	
/*	CREATE TABLE `app_codes_tbl` (
			`app_id` INT(11) NOT NULL AUTO_INCREMENT,
			`Column 2` INT(11) NOT NULL DEFAULT '0',
			`app_user` VARCHAR(90) NULL DEFAULT '0',
			`create_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
			`expire_code_date` DATE NULL DEFAULT NULL,
			`camp_id` INT(11) NULL DEFAULT NULL,
			`countOf_Codes` INT(11) NULL DEFAULT NULL,
			`product_id` INT(11) NULL DEFAULT NULL,
			`update_code_date` DATE NULL DEFAULT NULL,
			`code_status` INT(10) NULL DEFAULT NULL,
			`app_Code` VARCHAR(240) NULL DEFAULT '0',
			PRIMARY KEY (`app_id`),
			UNIQUE INDEX `app_Code` (`app_Code`)
			
INSERT INTO appPortal.app_codes_tbl(app_user,expire_code_date,camp_id,countOf_Codes,
product_id,update_code_date,code_status,app_Code) values ("shekar",'2017-10-10',1,100,
1,'2017-06-06',1,'0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz')

			
		)
		COLLATE='utf8_general_ci'
		ENGINE=InnoDB
		;
*/
}
