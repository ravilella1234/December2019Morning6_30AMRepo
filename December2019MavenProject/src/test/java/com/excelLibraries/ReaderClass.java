package com.excelLibraries;

public class ReaderClass 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		System.out.println(e1.getCellData("login", 1, 4));
		
		System.out.println(e1.getCellData("login", "Password", 3));
		
		e1.setCellData("login", 4, 1, "passed");
	}

}
