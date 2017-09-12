package com.herokuapp.tables;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

public class EmployerTableTest {

	static WebDriver driver;
	@BeforeClass
	public static void setUp(){
		driver=Driver.getInstance();
		driver.get((ConfigurationReader.getProperty("herokuUrl")));
	
	}
	@Test
	public void test1(){
//		//print number of in table1
		
		WebElement webTable1=driver.findElement(By.id("table1"));
		List<WebElement> rows=webTable1.findElements(By.tagName("tr"));
		System.out.println("total rows in table1 : "+rows.size());
		
//		WebElement webtable1=driver.findElement(By.id("table1"));
//	List<WebElement> rows=webtable1.findElements(By.tagName("tr"));
//	System.out.println("table1 number of rows :"+rows.size());
//	
//	//print number of in table 2
		WebElement webTable2=driver.findElement(By.id("table2"));
		List<WebElement> rows2=webTable2.findElements(By.tagName("tr"));
		System.out.println("Total number of table2 :"+rows2.size());

		
//	WebElement webtable2=driver.findElement(By.id("table2"));
//	List<WebElement> rows2=webtable2.findElements(By.tagName("tr"));
//	System.out.println("number of table2 : "+rows2.size());
//	
//	//print value of webtable 1,row 1,cell 1
		
		List<WebElement> cells=rows.get(0).findElements(By.tagName("th"));
		System.out.println(cells.get(0).getText());
		
		WebElement fiftcell=driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[1]/td[5]"));
		System.out.println("fift cell : "+fiftcell.getText());
		
		WebElement secondTable2=driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[4]/td[2]"));
		System.out.println("table two second element : "+secondTable2.getText());
		
		WebElement frank=driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[2]/td[2]"));
		System.out.println("Table 2 Frank :"+frank.getText());
//	List<WebElement> cells=rows.get(0).findElements(By.tagName("th"));
//	System.out.println("value of webtable 1,row 1,cell 1 is : "+cells.get(0).getText());
//	
//	WebElement firstcell=driver.findElement(By.xpath("//table[@id='table1']//tr[1]/th[1]"));
//	System.out.println(firstcell.getText());
	}
	
	@Test
	public void loopWebTable(){
		
		WebElement table1=driver.findElement(By.id("table1"));
		// get all rows from table 1
		List<WebElement> rows=table1.findElements(By.tagName("tr"));
		
		
//		WebElement table1=driver.findElement(By.id("table1"));
//		// get all rows from table 1
//		List<WebElement> rows=table1.findElements(By.tagName("tr"));
//		System.out.println("\nNumber of rows in table 1: "+rows.size());
		System.out.println("=============");
		for(WebElement row :rows){
			System.out.println(row.getText());
			List<WebElement> cells=row.findElements(By.tagName("td"));
			for( WebElement cell:cells){
				System.out.print(cell.getText());
			}
			System.out.println();
		}
		
//		for(WebElement row :rows){
//	//	System.out.println(row.getText());	
//		
//		List<WebElement> cells=row.findElements(By.tagName("td"));
//		for(WebElement cell :cells){
//			
//			System.out.print(cell.getText()+"|");
//		}
//		System.out.println();
//	}
	
	}
	@Test
	public void loopTableXpath(){
		List<WebElement> rowsInTable2=driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		System.out.println("number of rows table2 :"+rowsInTable2.size());
		
		for(int rowNum=1;rowNum<=4;rowNum++){
			
			for(int cellNum=1;cellNum<=6;cellNum++){
				
				String cellValue=driver.findElement(By.xpath
						("//table[@id='table2']/tbody/tr["+rowNum+"]/td["+cellNum+"]")).getText();
				System.out.print(cellValue+"|");
			}
			System.out.println();
		}
	}
}
