package org.nk.service;

import java.util.List;

import org.nk.model.Part;

public interface IPartService {


	Integer savePart(Part part);
	void deletePart(Integer id);
	void updatePart(Part part);
	Part getOnePart(Integer id);
	List<Part> getAllPart();
	
}
