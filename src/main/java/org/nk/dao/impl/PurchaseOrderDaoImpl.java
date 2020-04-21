package org.nk.dao.impl;

import java.util.List;

import org.nk.dao.IPurchaseOrderDao;
import org.nk.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {

		return (Integer) ht.save(po);
	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer id) {

		return ht.get(PurchaseOrder.class, id);
	}

	@Override
	public void deletePurchaseOrder(Integer id) {

		ht.delete(new PurchaseOrder(id));
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder po) {

		ht.update(po);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrder() {

		return ht.loadAll(PurchaseOrder.class);
	}

}
