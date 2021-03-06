package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
import in.nit.service.IUomService;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Service
public class UomServiceImpl implements IUomService {
	@Autowired
	private IUomDao dao;

	@Override
	@Transactional
	public Integer saveUom(Uom uom) {
		return dao.saveUom(uom);
	}

	@Override
	@Transactional
	public void updateUom(Uom uom) {
		dao.updateUom(uom);
	}

	@Override
	@Transactional
	public void deleteUom(Integer id) {
		dao.deleteUom(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Uom getOneUom(Integer id) {
		return dao.getOneUom(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Uom> getAllUoms() {
		return dao.getAllUoms();
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getUomIdAndUomModel() {
		return dao.getUomIdAndUomModel();
	}
	
	
	
	
}
