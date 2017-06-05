package com.iws.appportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.iws.appportal.dto.UserDTO;

public class LoginDaoImpl implements LoginDaoIF{

	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
		

	public UserDTO getUserInfo(String username) {

		UserDTO userDTO=null;
		
		try {
			userDTO=(UserDTO)jdbcTemplate.queryForObject("select * from app_user_details where User_Name=?",
					new Object[]{username}, 
					new RowMapper<UserDTO>(){

				public UserDTO mapRow(ResultSet rs, int arg1) throws SQLException {
					UserDTO userDTO=new UserDTO();
					userDTO.setUserName(rs.getString("User_Name"));
					userDTO.setId(rs.getInt("User_Id"));
					userDTO.setStatus(rs.getBoolean("status"));
					return userDTO;
				}
				
					
			});
		} catch(org.springframework.dao.EmptyResultDataAccessException es){
			userDTO=null;
		}
		
		catch (Exception e) {
			  e.printStackTrace();
		}
		return userDTO;
	}

	
	

}

/*	

List<CampaignsDTO> listOfCampaignsList=new ArrayList<CampaignsDTO>();	
try{
	listOfCampaignsList=jdbcTemplate.query(FMCGPromoConstants.SELECT_CAMPAIGN_LIST, new RowMapper(){

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {

		CampaignsDTO campaignsDTO=new CampaignsDTO();
		campaignsDTO.setCampaignId(rs.getInt("mc.Campaign_Id"));
		campaignsDTO.setCampaignName(rs.getString("mc.Campaign_Name"));
		campaignsDTO.setKeyCode(rs.getString("mc.KeyCode"));
		campaignsDTO.setShortCode(rs.getInt("mc.ShortCode"));
		campaignsDTO.setStartTime(rs.getTimestamp("mc.StartDate"));
		campaignsDTO.setEndTime(rs.getTimestamp("mc.EndDate"));
		campaignsDTO.setStatus(rs.getBoolean("mc.Status"));
		campaignsDTO.setCreateDateTime(rs.getTimestamp("mc.CreatedDate"));
		campaignsDTO.setPartnerName(rs.getString("mpd.Partner_Name"));
		campaignsDTO.setPartnerId(rs.getInt("mc.Partner_Id"));
		campaignsDTO.setAllowedPids(rs.getString("mc.Allowed_Pids"));
		campaignsDTO.setStatus(rs.getBoolean("Status"));
		
		return campaignsDTO;
	}
});
LOGGER.debug("The size of listOfCampaign()=["+listOfCampaignsList.size());
*/