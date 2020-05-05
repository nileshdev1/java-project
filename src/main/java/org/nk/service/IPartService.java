package org.nk.service;

import java.util.List;

import org.nk.model.Part;

public interface IPartService {


	public Integer savePart(Part part);
	public void deletePart(Integer id);
	public void updatePart(Part part);
	public Part getOnePart(Integer id);
	public List<Part> getAllPart();
	public List<Object[]> getPartIdAndCode();
}
