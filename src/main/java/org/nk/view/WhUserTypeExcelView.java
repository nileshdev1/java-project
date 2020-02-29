package org.nk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.nk.model.WhUserType;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class WhUserTypeExcelView extends AbstractXlsxView{
	

	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Discription", "attachment;filename=whuser.xlsx");
		
		Sheet s=workbook.createSheet("WhUserType");
		
		setHeader(s);
		
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>)model.get("list");
		setdBody(s,list);
	}
	
	
	private void setHeader(Sheet s) {

		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("FOR");
		r.createCell(4).setCellValue("EMAIL");
		r.createCell(5).setCellValue("CONTACT");
		r.createCell(6).setCellValue("IDTYPE");
		r.createCell(7).setCellValue("OTHER");
		r.createCell(8).setCellValue("IDNUMBER");
	}

	private void setdBody(Sheet s, List<WhUserType> list) {

		int count=1;
		for(WhUserType st:list) {
			
			Row r=s.createRow(count++);
			
			r.createCell(0).setCellValue(st.getWhUserId());
			r.createCell(1).setCellValue(st.getUserType());
			r.createCell(2).setCellValue(st.getUserCode());
			r.createCell(3).setCellValue(st.getUserFor());
			r.createCell(4).setCellValue(st.getUserEmail());
			r.createCell(5).setCellValue(st.getUserContect());
			r.createCell(6).setCellValue(st.getUserIdType());
			r.createCell(7).setCellValue(st.getOther());
			r.createCell(8).setCellValue(st.getIdNumber());
		}
	}

	
	

}
