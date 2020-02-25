package org.nk.dao;

import java.util.List;


import org.nk.model.Uom;

public interface IUomDao {

	Integer saveUom(Uom ob);

	List<Uom> getAllUom();

	void deleteUom(Integer id);

	Uom getOneUom(Integer id);

	void updateUom(Uom ob);

}
