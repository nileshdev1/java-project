package org.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="parttab")
public class Part {

	@Id
	@GeneratedValue
	@Column(name="pertid")
	private Integer pid;
	@Column(name="pertcode")
	private String pcode;
	@Column(name="pertwid")
	private Double dwid;
	@Column(name="pertlen")
	private Double dlen;
	@Column(name="perthig")
	private Double dhig;
	@Column(name="pertcost")
	private Double bcost;
	@Column(name="pcurrency")
	private String currency;
	@Column(name="description")
	private String discription;
	
	@ManyToOne
	@JoinColumn(name="uomidfk")
	private Uom uomob;
	
	
	@ManyToOne
	@JoinColumn(name="porderIdFk")
	private OrderMethod oPurchaseOb;
	
	@ManyToOne
	@JoinColumn(name="sorderIdFk")
	private OrderMethod oSaleOb;
	
	

	public OrderMethod getoPurchaseOb() {
		return oPurchaseOb;
	}

	public void setoPurchaseOb(OrderMethod oPurchaseOb) {
		this.oPurchaseOb = oPurchaseOb;
	}

	public OrderMethod getoSaleOb() {
		return oSaleOb;
	}

	public void setoSaleOb(OrderMethod oSaleOb) {
		this.oSaleOb = oSaleOb;
	}

	public Part() {
		super();
	}
	
	public Part(Integer pid) {
		super();
		this.pid = pid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public Double getDwid() {
		return dwid;
	}
	public void setDwid(Double dwid) {
		this.dwid = dwid;
	}
	public Double getDlen() {
		return dlen;
	}
	public void setDlen(Double dlen) {
		this.dlen = dlen;
	}
	public Double getDhig() {
		return dhig;
	}
	public void setDhig(Double dhig) {
		this.dhig = dhig;
	}
	public Double getBcost() {
		return bcost;
	}
	public void setBcost(Double bcost) {
		this.bcost = bcost;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Uom getUomob() {
		return uomob;
	}

	public void setUomob(Uom uomob) {
		this.uomob = uomob;
	}

	@Override
	public String toString() {
		return "Part [pid=" + pid + ", pcode=" + pcode + ", dwid=" + dwid + ", dlen=" + dlen + ", dhig=" + dhig
				+ ", bcost=" + bcost + ", currency=" + currency + ", discription=" + discription + ", uomob=" + uomob
				+ ", oPurchaseOb=" + oPurchaseOb + ", oSaleOb=" + oSaleOb + "]";
	}
	
		
}
