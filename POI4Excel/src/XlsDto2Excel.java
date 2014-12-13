
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XlsDto2Excel {
	public  static void  insertInto(List<XlsDto> list) throws IOException{
		 int clom =5;
		 HSSFWorkbook hw = new HSSFWorkbook();
		 HSSFSheet hs = hw.createSheet();
		 HSSFRow row  = hs.createRow(0);
		 HSSFCell[] cell= new HSSFCell[5];
		 String[] names = new String[clom];
		 names[0] ="学号";
		 names[1]="姓名";
		 names[2]="学院";
		 names[3]="课程";
		 names[4]="成绩";
		 for(int i=0;i<clom;i++){
			                cell[i] =row.createCell(i);
			                cell[i].setCellValue(names[i]);
		 }
		 
		 for(int j=0;j<list.size();j++){
			    HSSFRow row1 =hs.createRow(j+1);
			    
			   XlsDto xd = list.get(j);
			    HSSFCell xh =	           row1.createCell(0);
			    	xh.setCellValue(xd.getXh());
			    	   HSSFCell xm =	           row1.createCell(1);
			    	   xm.setCellValue(xd.getXm());
			    	   
				    	   HSSFCell Yxsmc =	           row1.createCell(2);
				    	   Yxsmc.setCellValue(xd.getYxsmc());
			   
					    	   HSSFCell Kcm =	           row1.createCell(3);
					    	   Kcm.setCellValue(xd.getKcm());
						    	   HSSFCell CJ =	           row1.createCell(4);
							    	CJ.setCellValue(xd.getCj());
		 
		 }
		  OutputStream  os = new FileOutputStream("e:\\c.xls");
		  hw.write(os);
		  os.close();
		  System.out.println("插入数据正确");
		 
	}
	
}