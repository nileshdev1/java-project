package org.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="saletab")
public class SaleOrder {

	@Id
	@GeneratedValue
	@Column(name="saleid")
	private Integer saleOid;
	@Column(name="salecode")
	private String saleOcode;
	@Column(name="saleref")
	private String refNumber;
	@Column(name="salemode")
	private String stockMode;
	@Column(name="salesource")
	private String stockSource;
	@Column(name="salestatus")
	private String status;
	@Column(name="saledesc")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="shipidfk")
	private ShipmentType shipob ;
	
	@ManyToOne
	@JoinColumn(name="whidfk")
	private WhUserType whob ;
	
	public SaleOrder() {
		super();
	}


	public SaleOrder(Integer id) {
		this.saleOid=id;
	}


	public Integer getSaleOid() {
		return saleOid;
	}


	public void setSaleOid(Integer saleOid) {
		this.saleOid = saleOid;
	}


	public String getSaleOcode() {
		return saleOcode;
	}


	public void setSaleOcode(String saleOcode) {
		this.saleOcode = saleOcode;
	}


	public String getRefNumber() {
		return refNumber;
	}


	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}


	public String getStockMode() {
		return stockMode;
	}


	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}


	public String getStockSource() {
		return stockSource;
	}


	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
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


	public ShipmentType getShipob() {
		return shipob;
	}


	public void setShipob(ShipmentType shipob) {
		this.shipob = shipob;
	}


	public WhUserType getWhob() {
		return whob;
	}


	public void setWhob(WhUserType whob) {
		this.whob = whob;
	}


	@Override
	public String toString() {
		return "SaleOrder [saleOid=" + saleOid + ", saleOcode=" + saleOcode + ", refNumber=" + refNumber
				+ ", stockMode=" + stockMode + ", stockSource=" + stockSource + ", status=" + status + ", description="
				+ description + ", shipob=" + shipob + ", whob=" + whob + "]";
	}


	


	
	
	
	
	
	
}

