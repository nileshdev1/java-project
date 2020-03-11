package org.nk.dao;

import java.util.List;


import org.nk.model.Uom;

public interface IUomDao {

	public Integer saveUom(Uom ob);

	public List<Uom> getAllUom();

	public void deleteUom(Integer id);

	public Uom getOneUom(Integer id);

	public void updateUom(Uom ob);
	
	public List<Object[]> getUomIdAndModel();
}
