package com.example.pmd;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CloseResourceBug
{

	public void falsePositive() throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();

		workbook.close();
	}
}
