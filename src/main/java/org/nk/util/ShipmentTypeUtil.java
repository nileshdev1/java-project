package org.nk.util;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtil {
	
	public void generatePie(String path,List<Object[]> data) {
		
		DefaultPieDataset dataset=new DefaultPieDataset();
		
		for(Object[] arr: data) {
			
			dataset.setValue(arr[0].toString(),
			Double.valueOf(arr[1].toString()));
		}
		
		JFreeChart chart=ChartFactory.createPieChart3D("ShipmentTypeModes", dataset, true, true, false);
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/image/shipmentA.jpg"), chart, 400, 400);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void generateBar(String path,List<Object[]> data) {
		
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		
		for(Object[] arr: data) {
			
			dataset.setValue(Double.valueOf(arr[1].toString()), arr[0].toString(), " ");
		}
		
		JFreeChart chart=ChartFactory.createBarChart("ShipmentTypeMode", "Modes", "Count", dataset);
	
	
	
	try {
	
		ChartUtils.saveChartAsJPEG(new File(path+"/resources/image/shipmentB.jpg"), chart, 400, 400);
		
	}catch (Exception e) {

		e.printStackTrace();
	}
		
		
	}
	

}
