package org.nk.dao;

import java.util.List;

import org.nk.model.ShipmentType;

public interface IShipmentTypeDao {
	
	
	Integer saveShipmentType(ShipmentType ob);
	
	List<ShipmentType> getAllShipmentType();
	
	void deleteShipment(Integer id);
	
	ShipmentType getOneShipmentType(Integer id);
	
	void updateShipmentType(ShipmentType ob);
	

}
