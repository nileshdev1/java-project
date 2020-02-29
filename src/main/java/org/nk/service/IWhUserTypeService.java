package org.nk.service;

import java.util.List;

import org.nk.model.WhUserType;

public interface IWhUserTypeService {

Integer saveWhUserType(WhUserType ob);
	
	List<WhUserType> getAllWhUserType();
	
	void deleteWhUserType(Integer id);
	
	WhUserType getOneWhUserType(Integer id);
	
	void updateWhUserType(WhUserType ob);
}
