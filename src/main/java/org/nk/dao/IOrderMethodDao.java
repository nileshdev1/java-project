package org.nk.dao;

import java.util.List;

import org.nk.model.OrderMethod;

public interface IOrderMethodDao {

	Integer saveOrderMethod(OrderMethod ob);

	List<OrderMethod> getAllOrderMethod();

	void deleteOrderMethod(Integer id);

	OrderMethod getOneOrderMethod(Integer id);

	void updateOrderMethod(OrderMethod ob);
	
	
}
