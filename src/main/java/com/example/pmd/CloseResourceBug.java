package com.example.pmd;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CloseResourceBug
{

	public void falsePositive() throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		try
		{
			// do stuff, which could raise a runtime exception
		}
		finally
		{
			workbook.close();
		}

		// alternative with try-with-resources
		try (XSSFWorkbook w2 = new XSSFWorkbook())
		{
			// do stuff, which could raise a runtime exception
		}

		// wrong close without exception handling
//		XSSFWorkbook workbook = new XSSFWorkbook();
		// do stuff, which could raise a runtime exception
//		workbook.close();
	}
}
