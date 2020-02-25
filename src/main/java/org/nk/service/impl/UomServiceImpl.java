package org.nk.service.impl;

import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import org.nk.dao.IUomDao;
import org.nk.model.Uom;
import org.nk.service.IUomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private IUomDao dao;
	

	@Transactional
	public Integer saveUom(Uom ob) {

		return dao.saveUom(ob);
	}

	@Transactional
	public List<Uom> getAllUom() {

		List<Uom> list=dao.getAllUom();
		Collections.sort(list,(o1,o2)->o1.getUomId()-o2.getUomId());

		return list;
	}

	@Transactional
	public void deleteUom(Integer id) {
		
		dao.deleteUom(id);
	}

	@Transactional
	public Uom getOneUom(Integer id) {

		return dao.getOneUom(id);
	}

	@Transactional
	public void updateUom(Uom ob) {

		dao.updateUom(ob);
	}

}
