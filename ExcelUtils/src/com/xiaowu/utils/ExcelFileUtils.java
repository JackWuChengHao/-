package com.xiaowu.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface ExcelFileUtils extends FileUtils {
	
	   /**
	    * 更新Excel中单元格的数据
	 * @param filename
	 * @param SheetIndex
	 * @param Row
	 * @param Column
	 * @param Con
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void UpdateCell(String filename, int SheetIndex, int Row, int Column, Object Con) throws FileNotFoundException, IOException;
	   
	   /**
	    * 创建Excel中的Sheet或者Cell
	 * @param filename
	 * @param SheetName
	 * @param Row
	 * @param Column
	 * @param Con
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void CreateCell(String filename, String SheetName, int Row, int Column, Object Con) throws FileNotFoundException, IOException;
	   
	   /**
	    * 删除Excel中Cell
	 * @param filename
	 * @param SheetIndex
	 * @param Row
	 * @param Column
	 * @param Con
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void deleteCell(String filename, int SheetIndex, int Row, int Column, Object Con) throws FileNotFoundException, IOException;
	   
	 /**
	  * 获取Excel中Cell
	 * @param filename
	 * @param SheetIndex
	 * @param Row
	 * @param Column
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException 
	 */
	public Object getCell(String filename, int SheetIndex, int Row, int Column) throws FileNotFoundException, IOException, ParseException;
	
	/**
	 * 删除Excel中Sheet
	 * @param filename
	 * @param SheetIndex
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void deleteSheet(String filename, int SheetIndex) throws FileNotFoundException, IOException;
}
