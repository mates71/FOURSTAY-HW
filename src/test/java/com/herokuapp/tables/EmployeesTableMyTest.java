package com.herokuapp.tables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.Driver;

public class EmployeesTableMyTest {
	static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
	
		driver=Driver.getInstance();
	//	driver.get(ConfigurationReader.getProperty("herokuUrl"));
		
		
	}
	
/*	@Test
	public void test() {
		WebElement webtable=driver.findElement(By.id("table1"));
		List<WebElement> rows=webtable.findElements(By.tagName("tr"));
		System.out.println("web table 1 rows count :"+rows.size());
		
		//print number of in table 2
		WebElement webtable2=driver.findElement(By.id("table2"));
		List<WebElement> rows2=webtable2.findElements(By.tagName("tr"));
		System.out.println("web table 2 rows count :"+rows2.size());

		//print value of webtable 1,row 1,cell 1
		List<WebElement> cells=rows.get(0).findElements(By.tagName("th"));
		
		System.out.println(cells.get(2).getText());
		
		//Driver --> WebTable --> tr --> td|th
				//table[@id='table1']/thead/tr/th[1]
				WebElement firstCell=driver.findElement(By.xpath("//table[@id='table1']//tr[1]/th[1]"));
				//table[@id='table1']//tr[1]/th[1]
				System.out.println(firstCell.getText());
		
	}*/
	
//	@Test
	public void loopWebTable(){
		WebElement table2=driver.findElement(By.id("table2"));
		List<WebElement> rows=table2.findElements(By.tagName("tr"));
		System.out.println("rows :"+rows.size());
		
		for(WebElement row :rows){
			//System.out.println(row.getText()+"|");
			List<WebElement> cells=row.findElements(By.tagName("td"));
			for(WebElement cel :cells){
				
			System.out.print(cel.getText()+" | ");
			
			}
			System.out.println();
		}
		System.out.println("==================");
	}

	//@Test
	public void loopTable(){
		WebElement table1=driver.findElement(By.id("table1"));
		List<WebElement> rows=table1.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		for(WebElement row :rows){
			System.out.println(row.getText());
			
			List<WebElement> cells=row.findElements(By.tagName("td"));
			for(WebElement cel :cells){
				System.out.print(cel.getText()+" | ");
			}
			System.out.println();
		}
	}
	
	
	/*@Test
	public void loopWebTable(){
		WebElement table1=driver.findElement(By.id("table1"));
		// get all rows from table 1
		List<WebElement> rows=table1.findElements(By.tagName("tr"));
		System.out.println("\nNumber of rows in table 1: "+rows.size());
		
		for(WebElement row :rows){
		//System.out.println(row.getText());	
			
			List<WebElement> cells=row.findElements(By.tagName("td"));
			for(WebElement cell :cells){
				System.out.print(cell.getText()+" | ");
			}
		System.out.println();
		}
	}*/
	
//	@Test
	public void LoopTableXpath(){
		for(int rowNum=1;rowNum<=4;rowNum++){
			
			for(int celNum=1;celNum<=6;celNum++){
				
				String cellValue=driver.findElement(By.xpath("//table[@id='table2']/tbody/tr["+rowNum+"]/td["+celNum+"]")).getText();
				System.out.print(cellValue+"||");
			}
			System.out.println();
		}
	}
	
	@Test
	public void GreyHoundCalendar(){
		
		driver.get("https://.www.greyhound.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement Dc=driver.findElement(By.id("fromLocation"));
		Dc.sendKeys("Washington,DC");
	
	     driver.findElement(By.id("toLocation")).sendKeys("New York,NY");
		
		
		
		driver.findElement(By.id("datepicker-from")).click();
		
		WebElement august=driver.findElement(By.xpath("//div[@id='datefrom-datepicker']//table//td[@data-speak-value="
				+ "'Thursday August 31 2017']"));
		august.click();
		
		WebElement returnSept=driver.findElement(By.id("datepicker-to"));
		returnSept.click();
		
		WebElement september8=driver.findElement(By.xpath("//div[@id='dateto-datepicker']//table//td[@data-speak-value='Friday September 8 2017']"));
		september8.click();
		driver.findElement(By.id("fare-search-btn")).click();
		
	}
/*	@Test
	public void loopTableXpath(){
		List<WebElement> rowsInTable2=
				driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		System.out.println("number of rows table 2 ::"+rowsInTable2.size());
		
for(int rowNum=1;rowNum <= 4; rowNum++){
			
			for(int cellNum=1;cellNum<=6;cellNum++){
				String cellValue=driver.findElement(
						By.xpath("//table[@id='table2']/tbody/tr["+rowNum+"]/td["+cellNum+"]"))
						.getText();
				System.out.print(cellValue+"|");
			}
			System.out.println();
		}

			
		}*/
		
	}

