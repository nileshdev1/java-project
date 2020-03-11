package org.nk.service.impl;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.nk.dao.IOrderMethodDao;
import org.nk.model.OrderMethod;
import org.nk.service.IOrderMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;
	
	@Transactional
	public Integer saveOrderMethod(OrderMethod ob) {

		return dao.saveOrderMethod(ob);
	}

	@Transactional
	public List<OrderMethod> getAllOrderMethod() {

		List<OrderMethod> list=dao.getAllOrderMethod();
		Collections.sort(list,(o1,o2)->o1.getOrderId()-o2.getOrderId());

		return list;

	}

	@Transactional
	public void deleteOrderMethod(Integer id) {

		dao.deleteOrderMethod(id);
	}

	@Transactional
	public OrderMethod getOneOrderMethod(Integer id) {

		return dao.getOneOrderMethod(id);
	}

	@Transactional
	public void updateOrderMethod(OrderMethod ob) {

		dao.updateOrderMethod(ob);
	}
	
	@Transactional
	public List<Object[]> getOrderIdAndCode(String mode) {

		return dao.getOrderIdAndCode(mode);
	}

}
