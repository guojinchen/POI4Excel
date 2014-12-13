import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;


public class XlsMain {
	/**
	 * 读取excel中的数据。方法
	 * 读取xls文件
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		XlsMain sl = new XlsMain();
		List<XlsDto> list1 = sl.readXls();
		 XlsDto xls = null;
		for(int i=0;i<list1.size();i++){
			System.out.println("1"+list1.get(i));
		}
		 try {
	             XlsDto2Excel.insertInto(list1);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        for (int i = 0; i < list1.size(); i++) {
	            xls = (XlsDto) list1.get(i);
	            System.out.println(xls.getXh() + "    " + xls.getXm() + "    "
	                    + xls.getYxsmc() + "    " + xls.getKcm() + "    "
	                    + xls.getCj());
	        }
		
		
	}
	
	
	
	private List<XlsDto>  readXls() throws IOException{
		
		InputStream in =new  FileInputStream("D:\\MyEclipse 10\\POI4Excel\\POI2Excel\\a.xls");
		HSSFWorkbook hs = new HSSFWorkbook(in);
		XlsDto dto = null;
		List<XlsDto> list = new ArrayList<XlsDto>();
		//循环sheet页
		for(int i=0;i<hs.getNumberOfSheets();i++){
			HSSFSheet  	hssfsheet = hs.getSheetAt(i);
			if(hssfsheet ==null){
				continue;
			}
			//循环行行
			for(int j=1;j<=hssfsheet.getLastRowNum();j++){
				HSSFRow row = hssfsheet.getRow(j);
				if(row==null){
					continue;
				}
				
				//循环列
				//for(int k=0;k<=row.getLastCellNum();k++){
					XlsDto sd = new XlsDto();
					  HSSFCell xh  =   row.getCell(0);
					if(xh==null){
						continue;
					}
				 
					//sd.setXh(getValue(xh));
					sd.setXh(String.valueOf(xh.toString()));
					
					HSSFCell xm = row.getCell(1);
					if(xm==null){
						continue;
					}
					sd.setXm(String.valueOf(xm.toString()));
					
					HSSFCell yxsmc = row.getCell(2);
					if(yxsmc==null){
						continue;
					}
					sd.setYxsmc(String.valueOf(yxsmc.toString()));
					
					HSSFCell kcm = row.getCell(3);
					if(kcm==null){
						continue;
					}
					sd.setKcm(String.valueOf(kcm.toString()));
					
					HSSFCell cj = row.getCell(4);
					if(cj==null){
						continue;
					}
					sd.setCj(String.valueOf(cj.toString()));
					list.add(sd);
			}}
		//}
		
		return list;
	}

	  /**
     * 得到Excel表中的值
     * 
     * @param hssfCell
     *            Excel中的每一个格子
     * @return Excel中每一个格子中的值
     */
    //@SuppressWarnings("static-access")
	
	
	
	
	
	
/*
    private  String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
           
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
       
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }*/
	
	
	
}
