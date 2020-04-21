package org.nk.dao;

import java.util.List;

import org.nk.model.SaleOrder;

public interface ISaleOrderDao {

	public Integer saveSaleOrder(SaleOrder ob);
	
	public List<SaleOrder> getAllSaleOrder();
	
	public void deleteSaleOrder(Integer id);
	
	public SaleOrder getOneSaleOrder(Integer id);
	
	public void updateSaleOrder(SaleOrder ob);
	
}
