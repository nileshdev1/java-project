package org.nk.dao.impl;

import org.nk.dao.IDocumentDao;
import org.nk.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveDocument(Document doc) {

		return (Integer)ht.save(doc) ;
	}

}
