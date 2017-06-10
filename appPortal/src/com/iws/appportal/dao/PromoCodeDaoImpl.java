package com.iws.appportal.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.appportal.app.dao.DataAccessException;
import com.appportal.app.dao.ResultSetExtractor;
import com.iws.appportal.dto.CampaignsDTO;
import com.iws.appportal.dto.ProductsDTO;
import com.iws.appportal.exceptions.DaoException;
import com.iws.appportal.utils.Md5Utils;

public class PromoCodeDaoImpl implements PromoCodeIF {

	private static DataSource dataSource = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CampaignsDTO  getCampaignShortKeyCodeInformation(Integer campId)throws DaoException{
		CampaignsDTO campaignsDTO=new CampaignsDTO();
		try {
			   Object params[] = new Object[1];
	            params[0] = campId;
	            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	            List<CampaignsDTO> listOfCampigns=jdbcTemplate.query("SELECT shortcode,keyCode FROM MPCS.mpcs_campaigns where Campaign_Id=?", params,new RowMapper(){
	            	public CampaignsDTO mapRow(ResultSet rs, int arg1)
	            			throws SQLException {
	            		
	            		CampaignsDTO camp=new CampaignsDTO();
	            		camp.setShortCode(rs.getInt("shortcode"));
	            		camp.setKeyCode(rs.getString("keyCode"));
                      return camp;
                      
	            	}
	            });	
	            if(listOfCampigns != null && listOfCampigns.size() > 0)
	                return (CampaignsDTO)listOfCampigns.get(0);
		} catch (Exception e) {
	        e.printStackTrace();
		}

		return campaignsDTO;
	}

	
		
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer promoCodesExistOrNot(Integer campaignId,Integer productId)throws DaoException{
		Integer noOfPromoCodes=0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);	
			int count=jdbcTemplate.queryForInt("select count(*) as cnt from mpcs_campaign_promocodes mp where  mp.CampaignID=? and mp.Product_ID=? and Status=1", new Object[] {campaignId, productId });//
			
			noOfPromoCodes=count;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
		return noOfPromoCodes;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CampaignsDTO> getCampaigns() throws DaoException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("DAOImpl INFO ===>"+jdbcTemplate);
	List<CampaignsDTO> returnList = new ArrayList<CampaignsDTO>();
		List<Map<String, Object>> listOfCamps = jdbcTemplate.queryForList("SELECT Campaign_Id,Campaign_Name,Description,shortcode,KeyCode FROM app_campaigns where Status=1");
		for(Map row : listOfCamps){
			CampaignsDTO campaign = new CampaignsDTO();
			campaign.setCampaignId((Integer)row.get("Campaign_Id"));
			campaign.setCampaignName((String)row.get("Campaign_Name"));
			campaign.setCampDescription((String)row.get("Description"));
				campaign.setShortCode((Integer)row.get("shortcode"));
			campaign.setKeyCode((String)row.get("KeyCode"));
			returnList.add(campaign);
		}
		return returnList;
		}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductsDTO> getProductList() throws DaoException {
	List<ProductsDTO> returnList = new ArrayList<ProductsDTO>();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> listOfCamps = jdbcTemplate.queryForList("select Product_Id,Product_Name from app_products where Status=1");
		for(Map row : listOfCamps){
			ProductsDTO fullProduct = new ProductsDTO();
			fullProduct.setProductId((Integer)row.get("Product_Id"));
			fullProduct.setProductName((String)row.get("Product_Name"));
			returnList.add(fullProduct);
		}
		return returnList;
		}
	
	public String codeGenerations(Integer noOfCodes, String fileName,Integer campId,Integer productId,String createBy) throws DaoException {
		int count=0;
		BufferedWriter bufferWritter=null;
		try {
			
			FileWriter fileWritter = new FileWriter(fileName, true);	
			bufferWritter = new BufferedWriter(fileWritter);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
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


	
/*
	@SuppressWarnings({ "unchecked", "rawtypes" })
	 public Map<Integer, String> getCampignsInfo(Integer campaignID)throws DaoException{
		 
		  Map<Integer, String> map=new LinkedHashMap<Integer, String>();
		  try {
		  //SELECT p.Product_Id,FF_Product_Code mpcs_fulfillment_products,Product_Name FROM MPCS.mpcs_fulfillment_products p inner join MPCS.mpcs_product_campaigns pc on p.Product_Id=pc.Product_ID where pc.CampaignID = ?
			  map=(Map<Integer, String>)jdbcTemplate.query(FMCGPromoConstants.CAMPAIGN_LIST_BYUSING_ID_QUERY,new Object[]{campaignID},new ResultSetExtractor(){
				    public Object extractData(final ResultSet rs ) throws SQLException,
				      DataAccessException {
				    	 Map<Integer, String> map=new LinkedHashMap<Integer, String>();
				    	    while(rs.next()){
				         Integer productId=rs.getInt("p.Product_Id");
					      String productName=rs.getString("Product_Name");
					      map.put(productId, productName);
				    	    }
				    	return map;
				    };
		      });
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return map; 
		  }	
		*/

	@Override
	public String codeGenerations(Integer noOfCodes, String fileName) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
