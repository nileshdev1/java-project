package org.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchaseotab")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	@Column(name="porderid")
	private Integer poid;
	@Column(name="purchaseocode")
	private String orderCode;
	@Column(name="refcNo")
	private String refNo;
	@Column(name="qltychk")
	private String qltyCheck;
	@Column(name="status")
	private String status;
	@Column(name="descrip")
	private String description;
	
	
	
	@ManyToOne
	@JoinColumn(name="shipidfk")
	private ShipmentType shipob ;
	
	@ManyToOne
	@JoinColumn(name="whidfk")
	private WhUserType whob ;
	
	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer poid) {
		super();
		this.poid = poid;
	}

	public Integer getPoid() {
		return poid;
	}

	public ShipmentType getShipob() {
		return shipob;
	}

	public void setShipob(ShipmentType shipob) {
		this.shipob = shipob;
	}


	public void setPoid(Integer poid) {
		this.poid = poid;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getQltyCheck() {
		return qltyCheck;
	}

	public void setQltyCheck(String qltyCheck) {
		this.qltyCheck = qltyCheck;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WhUserType getWhob() {
		return whob;
	}

	public void setWhob(WhUserType whob) {
		this.whob = whob;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [poid=" + poid + ", orderCode=" + orderCode + ", refNo=" + refNo + ", qltyCheck="
				+ qltyCheck + ", status=" + status + ", description=" + description + ", shipob=" + shipob + ", whob="
				+ whob + "]";
	}

	
		
	
	
}
