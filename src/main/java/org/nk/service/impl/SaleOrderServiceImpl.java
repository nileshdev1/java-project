package org.nk.service.impl;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.nk.dao.ISaleOrderDao;
import org.nk.model.SaleOrder;
import org.nk.service.ISaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderServiceImpl implements ISaleOrderService {

	@Autowired
	private ISaleOrderDao dao;

	@Transactional
	public Integer saveSaleOrder(SaleOrder ob) {

		return dao.saveSaleOrder(ob);
	}

	@Transactional
	public List<SaleOrder> getAllSaleOrder() {
		List<SaleOrder> list=dao.getAllSaleOrder();

		Collections.sort(list,(o1,o2)->o1.getSaleOid()-o2.getSaleOid());

		return list;
	}

	@Transactional
	public void deleteSaleOrder(Integer id) {

		dao.deleteSaleOrder(id);
	}

	@Transactional
	public SaleOrder getOneSaleOrder(Integer id) {

		return dao.getOneSaleOrder(id);
	}

	@Transactional
	public void updateSaleOrder(SaleOrder ob) {

		dao.updateSaleOrder(ob);
	}

}
