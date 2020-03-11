package org.nk.service;

import java.util.List;

import org.nk.model.SaleOrder;

public interface ISaleOrderService {


	Integer saveSaleOrder(SaleOrder ob);
	
	List<SaleOrder> getAllSaleOrder();
	
	void deleteSaleOrder(Integer id);
	
	SaleOrder getOneSaleOrder(Integer id);
	
	void updateSaleOrder(SaleOrder ob);
	
}
