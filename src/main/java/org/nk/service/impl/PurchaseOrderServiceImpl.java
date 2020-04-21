package org.nk.service.impl;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.nk.dao.IPurchaseOrderDao;
import org.nk.model.PurchaseOrder;
import org.nk.service.IPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private IPurchaseOrderDao dao;
	
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder po) {

		return dao.savePurchaseOrder(po);
	}

	@Transactional
	public PurchaseOrder getOnePurchaseOrder(Integer id) {

		return dao.getOnePurchaseOrder(id);
	}

	@Transactional
	public void deletePurchaseOrder(Integer id) {

		dao.deletePurchaseOrder(id);
	}

	@Transactional
	public void updatePurchaseOrder(PurchaseOrder po) {

		dao.updatePurchaseOrder(po);
	}

	@Transactional
	public List<PurchaseOrder> getAllPurchaseOrder() {

		List<PurchaseOrder> list=dao.getAllPurchaseOrder();
		Collections.sort(list,(o1,o2)->o1.getPoid()-o2.getPoid());
		
		return list;
	}

}

