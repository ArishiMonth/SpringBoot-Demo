package io.arish.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelHelper {

	public ExcelHelper(){}
	/**
	 * 文件下载
	 * @param path:地址
	 * 
	 * */		
	public static String ExportExcel(String path,String fileName,
			Map<String, String> title,List<?> data){
		String savePath=path+fileName+".xls";
		 FileOutputStream fOut=null;
		 HSSFWorkbook book = new HSSFWorkbook();
		//sheet页对象
		 HSSFSheet sheet = (HSSFSheet)book.createSheet(fileName);
		 try{
			 HSSFRow row= sheet.createRow(0);
			 int cellIndex=0;
			 int rowIndex=1;
			 for (Entry<String, String> entry : title.entrySet()) {
				 HSSFCell cell=  row.createCell(cellIndex);
				 cell.setCellValue(entry.getValue());
				 cellIndex++;
			}			
			 for(Object temp : data){
				 cellIndex=0;
				 HSSFRow row1= sheet.createRow(rowIndex);				
				 for (Entry<String, String> entry : title.entrySet()) {
					 HSSFCell cell=  row1.createCell(cellIndex);
					 Object value= getValueByKey(temp,entry.getKey());
					 cell.setCellValue(value.toString());
					 cellIndex++;
				}
			 }
			
			 fOut = new FileOutputStream(savePath);
			 book.write(fOut);
			 fOut.flush();
		 }catch(IOException ex){
			 ex.printStackTrace();
		 }finally {
			 try {
				fOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return savePath;
	}
	/**
     * 单个对象的某个键的值
     * 
     * @param object
     *            对象
     * 
     * @param key
     *            键
     * 
     * @return Object 键在对象中所对应得值 没有查到时返回空字符串
     */
    public static Object getValueByKey(Object obj, String key) {
        // 得到类对象
        Class<? extends Object> userCla = (Class<? extends Object>) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            try {
            
                if (f.getName().endsWith(key)) {
                    System.out.println("单个对象的某个键的值==反射==" + f.get(obj));
                    return f.get(obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        // 没有查到时返回空字符串
        return "";
    }
   
}
