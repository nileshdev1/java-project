package org.nk.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nk.model.ShipmentType;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=shipment.pdf");
		
		Paragraph p=new Paragraph("WELCOME TO SHIPMENT TYPE");
		
		document.add(p);
		
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>)model.get("list");
		
		PdfPTable t=new PdfPTable(6);
		
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("GRADE");
		t.addCell("MODE");
		t.addCell("ENABLE");
		t.addCell("NOTE");
		
		for(ShipmentType st:list) {
			
			t.addCell(st.getShipId().toString());
			t.addCell(st.getShipMode());
			t.addCell(st.getShipCode());
			t.addCell(st.getEnbShip());
			t.addCell(st.getShipGrade());
			t.addCell(st.getShipDesc());
		}
		
		document.add(t);
		
		document.add(new Paragraph(new Date().toString()));
	}
}
