package org.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whusertab")
public class WhUserType {

	@Id
	@GeneratedValue
	@Column(name="whuid")
	private Integer whUserId;
	@Column(name="whutype")
	private String userType;
	@Column(name="whucode")
	private String userCode;
	@Column(name="whufor")
	private String userFor;
	@Column(name="whuemail")
	private String userEmail;
	@Column(name="whucontect")
	private String userContect;
	@Column(name="whuidtype")
	private String userIdType;
	@Column(name="whuother")
	private String other;
	@Column(name="whuidnumber")
	private String idNumber;
	
	public WhUserType() {
		super();
	}

	public WhUserType(Integer id) {

		this.whUserId=id;
	}

	public Integer getWhUserId() {
		return whUserId;
	}

	public void setWhUserId(Integer whUserId) {
		this.whUserId = whUserId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContect() {
		return userContect;
	}

	public void setUserContect(String userContect) {
		this.userContect = userContect;
	}

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "WhUserType [whUserId=" + whUserId + ", userCode=" + userCode + ", userType=" + userType + ", userFor="
				+ userFor + ", userEmail=" + userEmail + ", userContect=" + userContect + ", userIdType=" + userIdType
				+ ", other=" + other + ", idNumber=" + idNumber + "]";
	}
	
	
	
}
