package org.nk.dao.impl;

import java.util.List;

import org.nk.dao.IWhUserTypeDao;
import org.nk.model.WhUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveWhUserType(WhUserType ob) {

		return (Integer) ht.save(ob);
	}

	@Override
	public List<WhUserType> getAllWhUserType() {

		return ht.loadAll(WhUserType.class);
	}

	@Override
	public void deleteWhUserType(Integer id) {

		ht.delete(new WhUserType(id));
	}

	@Override
	public WhUserType getOneWhUserType(Integer id) {

		return ht.get(WhUserType.class, id);
	}

	@Override
	public void updateWhUserType(WhUserType ob) {

		ht.update(ob);
	}
	
	@Override
	public List<Object[]> getUserType(String user) {
		
		String hql=" SELECT whUserId,userCode from org.nk.model.WhUserType where userType=?0  ";
		
		List<Object[]> list=(List<Object[]>) ht.find(hql, user);

		return list;
	}

}
