package org.nk.service.impl;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.nk.dao.IPartDao;
import org.nk.model.Part;
import org.nk.service.IPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl implements IPartService {

	@Autowired
	private IPartDao dao;
	
	@Transactional
	public Integer savePart(Part part) {

		return dao.savePart(part);
	}

	@Transactional
	public void deletePart(Integer id) {

		dao.deletePart(id);
	}

	@Transactional
	public void updatePart(Part part) {

		dao.updatePart(part);
	}

	@Transactional
	public Part getOnePart(Integer id) {

		return dao.getOnePart(id);
	}

	@Transactional
	public List<Part> getAllPart() {

		List<Part> list=dao.getAllPart();
		Collections.sort(list, (o1,o2)->o1.getPid()-o2.getPid());
		
		return list;
	}
	@Override
	public List<Object[]> getPartIdAndCode() {
		
		return dao.getPartIdAndCode();
	}
	
}
