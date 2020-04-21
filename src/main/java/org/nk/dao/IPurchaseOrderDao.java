package org.nk.dao;

import java.util.List;

import org.nk.model.PurchaseOrder;

public interface IPurchaseOrderDao {

	public Integer savePurchaseOrder(PurchaseOrder po);
	public PurchaseOrder getOnePurchaseOrder(Integer id);
	public void deletePurchaseOrder(Integer id);
	public void updatePurchaseOrder(PurchaseOrder po);
	public List<PurchaseOrder> getAllPurchaseOrder();
}
