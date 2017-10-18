package com.xiaowu.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class Test {
		public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
			ExcelFileUtils ex = new ExcelFileUtilImpl();
//			ex.CreateCell("C:\\123.xlsx", "xiaowu", 0, 0, new Date());
			System.out.println(ex.getCell("C:\\123.xlsx", 0, 0, 0));
			ex.UpdateCell("C:\\123.xlsx", 0, 0, 0, new Date());
		}
}
