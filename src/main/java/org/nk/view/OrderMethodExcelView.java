package org.nk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.nk.model.OrderMethod;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class OrderMethodExcelView extends AbstractXlsxView{

	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Discription", "attachment;filename=ordermethod.xlsx");
		
		Sheet s=workbook.createSheet("OrderMethod");
		
		setHeader(s);
		
		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>)model.get("list");
		setdBody(s,list);
	}
	private void setHeader(Sheet s) {

		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("MODE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("ACCEPT");
		r.createCell(4).setCellValue("NOTE");
		
	}

	private void setdBody(Sheet s, List<OrderMethod> list) {

		int count=1;
		for(OrderMethod st:list) {
			
			Row r=s.createRow(count++);
			
			r.createCell(0).setCellValue(st.getOrderId());
			r.createCell(1).setCellValue(st.getOrderMode());
			r.createCell(2).setCellValue(st.getOrderCode());
		//	r.createCell(3).setCellValue(st.getOrderAccept());
			r.createCell(4).setCellValue(st.getDescription());
		}
	}
}
