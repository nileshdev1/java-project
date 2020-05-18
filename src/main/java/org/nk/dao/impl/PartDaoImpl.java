package org.nk.dao.impl;

import java.util.List;

import org.nk.dao.IPartDao;
import org.nk.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PartDaoImpl implements IPartDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePart(Part part) {

		return (Integer) ht.save(part);
	}

	@Override
	public void deletePart(Integer id) {

		ht.delete(new Part(id));
	}

	@Override
	public void updatePart(Part part) {

		ht.update(part);
	}

	@Override
	public Part getOnePart(Integer id) {

		return ht.get(Part.class, id);
	}

	@Override
	public List<Part> getAllPart() {

		return ht.loadAll(Part.class);
	}

	@Override
	public List<Object[]> getPartIdAndCode() {

		String hql=" select pid,pcode from org.nk.model.Part ";
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		
		return list;
	}

}
