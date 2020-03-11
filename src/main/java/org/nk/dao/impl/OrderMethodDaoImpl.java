package org.nk.dao.impl;

import java.util.List;

import org.nk.dao.IOrderMethodDao;
import org.nk.model.OrderMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveOrderMethod(OrderMethod ob) {
		
		return (Integer) ht.save(ob);
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {

		return ht.loadAll(OrderMethod.class);
	}

	@Override
	public void deleteOrderMethod(Integer id) {

		ht.delete(new OrderMethod(id));
	}

	@Override
	public OrderMethod getOneOrderMethod(Integer id) {

		return ht.get(OrderMethod.class,id);
	}
	

	@Override
	public void updateOrderMethod(OrderMethod ob) {

		ht.update(ob);
	}
	
	@Override
	public List<Object[]> getOrderIdAndCode(String mode) {

		String hql=" select orderId, orderCode from org.nk.model.OrderMethod where orderMode=?0 ";

		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>) ht.find(hql, mode);

		return list;

		
	}

}
