package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public Properties prop;
	public List<List<String>> dt;
	
	

	public void launchApp() throws Exception
	{		
		ReadProperties();
		dt = readExcelData();
		if(System.getProperty("browser").equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}		
		else if(prop.getProperty("browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("globaltimeout"))));
	}
	
	public void ReadProperties() throws Exception
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/vtiger/config/configuration.properties");
		prop.load(fis);
	}
	
	public List<List<String>> readExcelData()
	{
		List<List<String>> DataList = new ArrayList<List<String>>();
		Xls_Reader xr = new Xls_Reader(System.getProperty("user.dir")+"/src/test/resources/testdata/Data.xlsx");
		int rowcount = xr.getRowCount("Sheet1");
		int colcount = xr.getColumnCount("Sheet1");
		for(int i=2;i<=rowcount;i++)
		{
			List<String> rowlist = new ArrayList<String>();
			for(int j=0;j<colcount;j++)
			{
				String data = xr.getCellData("Sheet1", j, i);
				rowlist.add(data);
			}
			DataList.add(rowlist);
		}
		
		return DataList;
	}
	
	
	

	public void closeApp()
	{
		driver.quit();
	}

}
