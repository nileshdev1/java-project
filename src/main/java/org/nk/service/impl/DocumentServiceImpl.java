package org.nk.service.impl;

import javax.transaction.Transactional;

import org.nk.dao.IDocumentDao;
import org.nk.model.Document;
import org.nk.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	private IDocumentDao dao;
	
	@Transactional
	public Integer saveDocument(Document doc) {

		return dao.saveDocument(doc);
	}

}
