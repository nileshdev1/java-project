package org.nk.service;

import java.util.List;

import org.nk.model.ShipmentType;

public interface IShipmentTypeService {

	public Integer saveShipmentType(ShipmentType ob);
	
	public List<ShipmentType> getAllShipmentType();
	
	public void deleteShipment(Integer id);
	
	public ShipmentType getOneShipmentType(Integer id);
	
	public void updateShipmentType(ShipmentType ob);
	
	public List<Object[]> getShipmentCount();
	
	public List<Object[]> getShipIdandCode();
}
