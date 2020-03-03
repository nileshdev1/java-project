package org.nk.service;

import java.util.List;

import org.nk.model.ShipmentType;

public interface IShipmentTypeService {

	Integer saveShipmentType(ShipmentType ob);
	
	List<ShipmentType> getAllShipmentType();
	
	void deleteShipment(Integer id);
	
	ShipmentType getOneShipmentType(Integer id);
	
	void updateShipmentType(ShipmentType ob);
	
	public List<Object[]> getShipmentCount();
}
