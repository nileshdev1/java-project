/**
 * 
 */
package org.nk.service.impl;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.nk.dao.IWhUserTypeDao;
import org.nk.model.WhUserType;
import org.nk.service.IWhUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Test
 *
 */
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;

	@Transactional
	public Integer saveWhUserType(WhUserType ob) {

		return dao.saveWhUserType(ob);
	}

	@Transactional
	public List<WhUserType> getAllWhUserType() {

		List<WhUserType> list=dao.getAllWhUserType();

		Collections.sort(list,(o1,o2)->o1.getWhUserId()-o2.getWhUserId());

		return list;
	}

	@Transactional
	public void deleteWhUserType(Integer id) {

		dao.deleteWhUserType(id);
	}

	@Transactional
	public WhUserType getOneWhUserType(Integer id) {

		return dao.getOneWhUserType(id);
	}

	@Transactional
	public void updateWhUserType(WhUserType ob) {

		dao.updateWhUserType(ob);
	}
	
	@Transactional
	public List<Object[]> getUserType(String user) {

		return dao.getUserType(user);
	}

}
