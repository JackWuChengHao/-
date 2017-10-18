package com.xiaowu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;


public class ExcelFileUtilImpl extends FileUtilsImpl implements ExcelFileUtils {

	private Workbook workbook;

	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	@Override
	public void OpenFile(String file) throws FileNotFoundException, IOException {
		if(file.endsWith("xls")){
			workbook = new HSSFWorkbook(new FileInputStream( new File(file)));
			File excelfile = new File(file);
			if(!excelfile.exists()) {
				Workbook workbooktmp = null;
				workbooktmp  = new HSSFWorkbook();
				FileOutputStream fos = new FileOutputStream(file);
				workbooktmp.write(fos);
				workbooktmp.close();
				fos.flush();
				fos.close();
			}
		}else if(file.endsWith("xlsx")){
			File excelfile = new File(file);
			if(!excelfile.exists()) {
				Workbook workbooktmp = null;
				workbooktmp  = new XSSFWorkbook();
				FileOutputStream fos = new FileOutputStream(file);
				workbooktmp.write(fos);
				workbooktmp.close();
				fos.flush();
				fos.close();
			}
			workbook = new XSSFWorkbook(new FileInputStream(file));
		}else 
			throw new FileFormatException("the file is not a excel file");
	}

	private void SaveFile(String filename) throws FileNotFoundException, IOException {
		if(this.workbook != null) { 
			this.workbook.write(new FileOutputStream(new File(filename)));
			this.workbook.close();
		}
	}

	@Override
	public void UpdateCell(String filename,int SheetIndex ,int Row,int Column,Object Con) throws FileNotFoundException, IOException {
		OpenFile(filename); 
		if(this.workbook == null) 
			throw new NullPointerException("excel file is null");
		try {
			Sheet sheet=  workbook.getSheetAt(SheetIndex);
			Row row = sheet.getRow(Row);
			Cell cell = row.getCell(Column);
			String ClassName = Con.getClass().getName();
			switch(ClassName) {
			case "java.lang.Integer":
				cell.setCellValue((Integer)Con);
				cell.setCellType(CellType.NUMERIC);
				break;
			case "java.lang.Double":
				cell.setCellValue((Double)Con);
				cell.setCellType(CellType.NUMERIC);
				break;
			case "java.lang.Float":
				cell.setCellValue((Float)Con);
				cell.setCellType(CellType.NUMERIC);
				break;
			case "java.util.Calendar":
				cell.setCellValue((Calendar)Con);
				cell.setCellType(CellType.NUMERIC);
				break;
			case "java.util.Date":
				cell.setCellValue((Date)Con);
				cell.setCellType(CellType.NUMERIC);
				break;
			case "java.lang.Boolean":
				cell.setCellValue((Boolean)Con);
				cell.setCellType(CellType.BOOLEAN);
				break;
			default:
				cell.setCellValue((String)Con);
				cell.setCellType(CellType.STRING);
				break;
			}
		}finally {
			SaveFile(filename);
		}
	}

	@Override
	public void CreateCell(String filename,String SheetName ,int Row,int Column,Object Con) throws FileNotFoundException, IOException {
		OpenFile(filename); 
		if(this.workbook == null) 
			throw new NullPointerException("excel file is null");
		try {
			Sheet sheet = workbook.getSheet(SheetName);
			if(sheet == null ) 
				sheet = workbook.createSheet(SheetName);
			Row row = sheet.getRow(Row);
			if(row == null)
				row = sheet.createRow(Row);
			Cell cell = row.getCell(Column);
			if(cell == null)
				cell = row.createCell(Column);
			String ClassName = Con.getClass().getName();
			switch(ClassName) {
			case "java.lang.Integer":
				cell.setCellValue((Integer)Con);
				cell.setCellType(CellType.NUMERIC);
				break;
			case "java.lang.Double":
				cell.setCellValue((Double)Con);
				cell.setCellType(CellType.NUMERIC);
				break;
			case "java.lang.Float":
				cell.setCellValue((Float)Con);
				cell.setCellType(CellType.NUMERIC);
				break;
			case "java.util.Calendar":
				cell.setCellValue((Calendar)Con);
				cell.setCellType(CellType.NUMERIC);
				break;
			case "java.util.Date":
				// 定义Cell格式  
				CellStyle cellStyle = workbook.createCellStyle();  
				CreationHelper creationHelper = workbook.getCreationHelper();  
				cellStyle.setDataFormat(  
						creationHelper.createDataFormat().getFormat("yyyy-MM-dd  hh:mm:ss")  
						);  
				cell.setCellValue((Date)Con);
				cell.setCellStyle(cellStyle);  
				cell.setCellType(CellType.NUMERIC);
				break;
			case "java.lang.Boolean":
				cell.setCellValue((Boolean)Con);
				cell.setCellType(CellType.BOOLEAN);
				break;
			default:
				cell.setCellValue((String)Con);
				cell.setCellType(CellType.STRING);
				break;
			}
		}finally {
			SaveFile(filename);
		}

	}

	@Override
	public void deleteCell(String filename,int SheetIndex ,int Row,int Column,Object Con) throws FileNotFoundException, IOException {
		OpenFile(filename); 
		if(this.workbook == null) 
			throw new NullPointerException("excel file is null");
		try {
			Sheet sheet = workbook.getSheetAt(SheetIndex);
			Row row = sheet.getRow(Row);
			Cell cell = row.getCell(Column);
			cell.setCellType(CellType.BLANK);
		}finally {
			SaveFile(filename);
		}
	}

	@Override
	public Object getCell(String filename, int SheetIndex, int Row, int Column) throws FileNotFoundException, IOException, ParseException {
		OpenFile(filename); 
		if(this.workbook == null) 
			throw new NullPointerException("excel file is null");
		try {
			Sheet sheet = workbook.getSheetAt(SheetIndex);
			Row row = sheet.getRow(Row);
			Cell cell = row.getCell(Column);
			CellType celltype = cell.getCellTypeEnum();
			Object result = null;
			switch (celltype) {
			case BOOLEAN:
				result = (Boolean)cell.getBooleanCellValue(); 
				break;
			case NUMERIC:
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
				if(DateUtil.isCellDateFormatted(cell)) 
					result = cell.getDateCellValue();
				else
					result = (Double)cell.getNumericCellValue();
				break;
			default:
				result = (String)cell.getStringCellValue();
				break;
			}
			return result;
		}finally {
			SaveFile(filename);
		}
	}

	@Override
	public void deleteSheet(String filename, int SheetIndex) throws FileNotFoundException, IOException {
		OpenFile(filename); 
		if(this.workbook == null) 
			throw new NullPointerException("excel file is null");
		try {
			workbook.removeSheetAt(SheetIndex);
		}finally {
			SaveFile(filename);
		}
	}

}
