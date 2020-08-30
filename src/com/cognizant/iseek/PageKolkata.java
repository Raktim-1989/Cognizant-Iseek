package com.cognizant.iseek;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PageKolkata {
	static int lastrow ;
	public static FileOutputStream fos;
	static int sizebeforekol;
	static int size1kol;
	static int sizeafterkol;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	
	public static void pageKolkataTest(WebDriver driver,String filepath) throws IOException, InterruptedException
	{
		try
		{
		
			JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1000)");
		//*[@title = 'Advanced Search']/following-sibling:: span
		//String workdir = System.getProperty("user.dir");
		driver.findElement(By.xpath("//*[@class = 'advancesearchbtn']/following-sibling::span")).click();
		Thread.sleep(10000);
		String path = filepath + ".xlsx" ;
		FileInputStream fis = new FileInputStream(path);
		System.out.println("path1");
		//File file = new File(path1);
		//fos = new FileOutputStream(file);
		wb = new XSSFWorkbook(fis);
		System.out.println("done");
		sh = wb.getSheetAt(0);
	    lastrow = sh.getLastRowNum();
	    fos = new FileOutputStream(path);
		 driver.findElement(By.xpath("//*[@id='profiles-search-wrapper']/div[4]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='profiles-search-wrapper']/div[4]/div/div/ul[2]/li[8]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='profiles-search-wrapper']/div[3]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[4]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[5]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[6]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[7]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[9]/a")).click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//*[@id='profiles-search-btn']")).click();
		Thread.sleep(10000);

		List<WebElement> iseekrows = driver.findElements(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr"));
		System.out.println("Number of records in the table is " + iseekrows.size());
		sizebeforekol = iseekrows.size();
		WebElement from = driver.findElement(By.xpath("//*[@class = 'mCSB_dragger']"));
		WebElement to = driver.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[30]"));
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		Action draganddrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
		draganddrop.perform();
		Thread.sleep(10000);
		List<WebElement> iseekrowsafter = driver
				.findElements(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr"));
		size1kol = iseekrowsafter.size();
		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		System.out.println("after size " + size1kol);
		int countindex = 1;
		while (sizebeforekol != size1kol) {
			sizebeforekol = size1kol;
			WebElement toafter = driver
					.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + size1kol + "]"));
			Thread.sleep(3000);
			Actions builderafter = new Actions(driver);
			Action draganddropafter = builderafter.clickAndHold(from).moveToElement(toafter).release(toafter).build();
			Thread.sleep(3000);
			draganddropafter.perform();
			Thread.sleep(10000);
			List<WebElement> iseekrowsaftersecond = driver
					.findElements(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr"));
			size1kol = iseekrowsaftersecond.size();
			System.out.println("size1");
			countindex++;
			System.out.println(countindex);
		}
		System.out.println("final size of the table " + size1kol);
		WebElement finalassociate = driver
				.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + size1kol + "]/td[2]"));
		js.executeScript("arguments[0].scrollIntoView();", finalassociate);
		driver.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + size1kol + "]/td[2]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"associate-profile-content\"]/div/div[1]/div/button")).click();

		for (int i = 1; i <= size1kol; i++) {
			WebElement associatename = driver
					.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[2]"));
			Thread.sleep(1000);
			associatename.click();
			Thread.sleep(4000);
			List<WebElement> dynamicElement = driver.findElements(
					By.xpath("//*[@id=\"associate-profile-content\"]/div/div[2]/div[2]/div[2]/div[2]/div/span"));
			// Thread.sleep(3000);
			if (dynamicElement.size() != 0) {
				// System.out.println("Element present");
				String contactnew = driver
						.findElement(By.xpath(
								"//*[@id=\"associate-profile-content\"]/div/div[2]/div[2]/div[2]/div[2]/div/span"))
						.getText();
				// Thread.sleep(6000);
				driver.findElement(By.xpath("//*[@id=\"associate-profile-content\"]/div/div[1]/div/button")).click();
				Thread.sleep(3000);
				WebElement associatename1 = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[2]"));
				WebElement available = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[4]"));
				WebElement location = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[5]"));
				WebElement grade = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[3]"));
				WebElement skillFamily = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[7]"));
				Actions actions = new Actions(driver);
				WebElement technicalSkills = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[8]"));
				actions.moveToElement(technicalSkills).perform();
				WebElement technicalSkillstoolTip = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[8]/p"));
				WebElement domainSkills = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[9]"));
				actions.moveToElement(domainSkills).perform();
				WebElement domainSkillstoolTip = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[9]/p"));
				WebElement proposalStatus = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[10]"));

				Thread.sleep(3000);
				js.executeScript("arguments[0].scrollIntoView();", associatename1);
				js.executeScript("arguments[0].scrollIntoView();", available);
				js.executeScript("arguments[0].scrollIntoView();", location);
				js.executeScript("arguments[0].scrollIntoView();", grade);
				js.executeScript("arguments[0].scrollIntoView();", skillFamily);
				js.executeScript("arguments[0].scrollIntoView();", technicalSkills);
				js.executeScript("arguments[0].scrollIntoView();", domainSkills);
				js.executeScript("arguments[0].scrollIntoView();", proposalStatus);
				System.out.println("Associate details  is " + associatename1.getText() + " " + available.getText() + " "
						+ contactnew + " " + i);

				Row row = sh.createRow(++lastrow);
				Cell cell = row.createCell(0);
				Cell cell1 = row.createCell(2);
				Cell cell2 = row.createCell(3);
				Cell cell3 = row.createCell(1);
				Cell cell4 = row.createCell(4);

				Cell cell5 = row.createCell(5);
				Cell cell6 = row.createCell(6);
				Cell cell7 = row.createCell(7);
				Cell cell8 = row.createCell(8);
				cell.setCellValue(associatename1.getText());
				cell3.setCellValue(grade.getText());
				cell1.setCellValue(available.getText());
				cell2.setCellValue(contactnew);
				cell4.setCellValue(skillFamily.getText());
				cell5.setCellValue(technicalSkillstoolTip.getAttribute("title"));
				cell6.setCellValue(domainSkillstoolTip.getAttribute("title"));
				cell7.setCellValue(proposalStatus.getText());
				cell8.setCellValue(location.getText());

			}

			else {
				// System.out.println("Element not present");
				String contact = driver
						.findElement(By.xpath(
								"//*[@id=\"associate-profile-content\"]/div/div[3]/div[2]/div[2]/div[2]/div/span"))
						.getText();

				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"associate-profile-content\"]/div/div[1]/div/button")).click();

				Thread.sleep(3000);
				WebElement associatename1 = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[2]"));
				WebElement available = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[4]"));
				WebElement location = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[5]"));
				WebElement grade = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[3]"));
				WebElement skillFamily = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[7]"));
				Actions actions = new Actions(driver);
				WebElement technicalSkills = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[8]"));
				actions.moveToElement(technicalSkills).perform();
				WebElement technicalSkillstoolTip = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[8]/p"));
				WebElement domainSkills = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[9]"));
				actions.moveToElement(domainSkills).perform();
				WebElement domainSkillstoolTip = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[9]/p"));
				WebElement proposalStatus = driver
						.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[10]"));
				Thread.sleep(3000);
				js.executeScript("arguments[0].scrollIntoView();", associatename1);
				js.executeScript("arguments[0].scrollIntoView();", available);
				js.executeScript("arguments[0].scrollIntoView();", location);
				js.executeScript("arguments[0].scrollIntoView();", grade);
				js.executeScript("arguments[0].scrollIntoView();", skillFamily);
				js.executeScript("arguments[0].scrollIntoView();", technicalSkills);
				js.executeScript("arguments[0].scrollIntoView();", domainSkills);
				js.executeScript("arguments[0].scrollIntoView();", proposalStatus);
				System.out.println("Associate details  is " + associatename1.getText() + " " + available.getText() + " "
						+ contact + " " + i);

				Row row = sh.createRow(++lastrow);
				Cell cell = row.createCell(0);
				Cell cell1 = row.createCell(2);
				Cell cell2 = row.createCell(3);
				Cell cell3 = row.createCell(1);
				Cell cell4 = row.createCell(4);

				Cell cell5 = row.createCell(5);
				Cell cell6 = row.createCell(6);
				Cell cell7 = row.createCell(7);
				Cell cell8 = row.createCell(8);

				cell.setCellValue(associatename1.getText());
				cell3.setCellValue(grade.getText());
				cell1.setCellValue(available.getText());
				cell2.setCellValue(contact);
				cell4.setCellValue(skillFamily.getText());
				cell5.setCellValue(technicalSkillstoolTip.getAttribute("title"));
				cell6.setCellValue(domainSkillstoolTip.getAttribute("title"));
				cell7.setCellValue(proposalStatus.getText());
				cell8.setCellValue(location.getText());

			}
			
					}
		
		
		wb.write(fos);
		sh.getLastRowNum();
		System.out.println("Last row of the sheet " + sh.getLastRowNum());
		fos.close();

	}
	catch(Exception e)
	{
		wb.write(fos);
		sh.getLastRowNum();
		System.out.println("Last row of the sheet " + sh.getLastRowNum());
		fos.close();

	}
		
	}
}


