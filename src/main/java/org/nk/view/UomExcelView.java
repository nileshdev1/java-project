package org.nk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.nk.model.Uom;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class UomExcelView extends AbstractXlsxView{
	
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Discription", "attachment;filename=uom.xlsx");
		
		Sheet s=workbook.createSheet("Uom");
		
		setHeader(s);
		
		@SuppressWarnings("unchecked")
		List<Uom> list=(List<Uom>)model.get("list");
		setdBody(s,list);
	}
	private void setHeader(Sheet s) {

		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("MODEL");
		r.createCell(3).setCellValue("NOTE");
	}

	private void setdBody(Sheet s, List<Uom> list) {

		int count=1;
		for(Uom st:list) {
			
			Row r=s.createRow(count++);
			
			r.createCell(0).setCellValue(st.getUomId());
			r.createCell(1).setCellValue(st.getUomType());
			r.createCell(2).setCellValue(st.getUomModel());
			r.createCell(3).setCellValue(st.getUomDesc());
		}
	}

}
