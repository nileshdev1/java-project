package org.nk.service;

import java.util.List;

import org.nk.model.Uom;

public interface IUomService {

	public Integer saveUom(Uom ob);

	public List<Uom> getAllUom();

	public void deleteUom(Integer id);

	public Uom getOneUom(Integer id);

	public void updateUom(Uom ob);
	
	public List<Object[]> getOrderIdAndModel();
}
