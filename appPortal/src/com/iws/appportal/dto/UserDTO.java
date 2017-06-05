package com.iws.appportal.dto;

public class UserDTO {

	/*
	 * -- Dumping structure for table MPCS.mpcs_user_details CREATE TABLE IF NOT
	 * EXISTS `mpcs_user_details` ( `User_Id` int(11) NOT NULL AUTO_INCREMENT,
	 * `User_Name` varchar(55) DEFAULT NULL, `Password` varchar(1000) NOT NULL,
	 * `Created_By` int(11) NOT NULL, `Created_Date` datetime NOT NULL,
	 * `Modified_By` int(11) NOT NULL, `Modified_Date` datetime NOT NULL,
	 * PRIMARY KEY (`User_Id`), UNIQUE KEY `User_Name` (`User_Name`) )
	 * ENGINE=InnoDB DEFAULT CHARSET=utf8;
	 */

	private Integer id;
	private String userName;
	private String password;
	private Integer createBy;
	private Integer role;
	private boolean status;
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + "| userName=" + userName + "| password=" + password + "| createBy=" + createBy
				+ "| role=" + role + "| status=" + status + "]";
	}
	
	

}
