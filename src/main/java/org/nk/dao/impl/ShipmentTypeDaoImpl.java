package org.nk.dao.impl;

import java.util.List;

import org.nk.dao.IShipmentTypeDao;
import org.nk.model.ShipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveShipmentType(ShipmentType ob) {

		return (Integer) ht.save(ob);
	}
	
	@Override
	public List<ShipmentType> getAllShipmentType() {
		
		return ht.loadAll(ShipmentType.class);
	}
	
	@Override
	public void deleteShipment(Integer id) {

		ht.delete(new ShipmentType(id));
	}
	
	@Override
	public ShipmentType getOneShipmentType(Integer id) {

		return ht.get(ShipmentType.class, id);
	}
	
	@Override
	public void updateShipmentType(ShipmentType ob) {

		ht.update(ob);
	}

}
