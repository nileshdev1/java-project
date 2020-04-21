package org.nk.dao;

import java.util.List;

import org.nk.model.WhUserType;

public interface IWhUserTypeDao {
	
	
	public Integer saveWhUserType(WhUserType ob);
	
	public List<WhUserType> getAllWhUserType();
	
	public void deleteWhUserType(Integer id);
	
	public WhUserType getOneWhUserType(Integer id);
	
	public void updateWhUserType(WhUserType ob);
	
	public List<Object[]> getUserType(String user);

}
