package org.nk.service.impl;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.nk.dao.IShipmentTypeDao;
import org.nk.model.ShipmentType;
import org.nk.service.IShipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;
	@Transactional
	public Integer saveShipmentType(ShipmentType ob) {

		return dao.saveShipmentType(ob);
	}

	@Transactional
	public List<ShipmentType> getAllShipmentType() {
		
		List<ShipmentType> list=dao.getAllShipmentType();
		
		Collections.sort(list,(o1,o2)->o1.getShipId()-o2.getShipId());

		return list;
	}
	
	@Transactional
	public void deleteShipment(Integer id) {

		dao.deleteShipment(id);
	}
	
	@Transactional
	public ShipmentType getOneShipmentType(Integer id) {

		return dao.getOneShipmentType(id);
	}
	
	@Transactional
	public void updateShipmentType(ShipmentType ob) {
		
		dao.updateShipmentType(ob);
	}
	@Transactional
	public List<Object[]> getShipmentCount() {

		return dao.getShipmentCount();
	}
	
	@Override
	public List<Object[]> getShipIdandCode() {

		return dao.getShipIdandCode();
	}
}
