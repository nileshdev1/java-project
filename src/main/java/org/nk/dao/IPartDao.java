package org.nk.dao;

import java.util.List;

import org.nk.model.Part;

public interface IPartDao {

	Integer savePart(Part part);
	void deletePart(Integer id);
	void updatePart(Part part);
	Part getOnePart(Integer id);
	List<Part> getAllPart();
	
}
