package org.nk.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nk.model.WhUserType;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=whuser.pdf");
		
		Paragraph p=new Paragraph("WELCOME TO WhUserType");
		
		document.add(p);
		
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>)model.get("list");
		
		PdfPTable t=new PdfPTable(9);
		
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("FOR");
		t.addCell("EMAIL");
		t.addCell("CONTECT");
		t.addCell("IDTYPE");
		t.addCell("OTHER");
		t.addCell("IDNUMBER");
		
		for(WhUserType st:list) {
			
			t.addCell(st.getWhUserId().toString());
			t.addCell(st.getUserType());
			t.addCell(st.getUserCode());
			t.addCell(st.getUserFor());
			t.addCell(st.getUserEmail());
			t.addCell(st.getUserContect());
			t.addCell(st.getUserIdType());
			t.addCell(st.getOther());
			t.addCell(st.getIdNumber());
		}
		
		document.add(t);
		
		document.add(new Paragraph(new Date().toString()));
	}
}
