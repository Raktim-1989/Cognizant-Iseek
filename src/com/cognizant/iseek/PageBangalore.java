package com.cognizant.iseek;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utilities.TestUtil;

public class PageBangalore {

	static int size1;
	static int sizebefore;
	static int rowindex = 1;
	//public static XSSFWorkbook wb;
	public static XSSFWorkbook wb; 
	public static XSSFSheet sh;
	public static FileOutputStream fos;
	
   	public static void pageBangaloreTest(WebDriver driver,String filepath) throws InterruptedException, AWTException, IOException {
	   
		try{
			/*dc = DesiredCapabilities.chrome();
		
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.merge(dc);*/
		wb = new XSSFWorkbook();
		sh = wb.createSheet("TalentMarketPlace");
		/*String timestamp = new Timestamp(System.currentTimeMillis()).toString();
		timestamp = timestamp.substring(0, timestamp.length() - 6).replaceAll(":", "");
		String filestamp = "./" + "\\iseekReport" + " " + timestamp;*/
		File file = new File(filepath + ".xlsx");
		 fos = new FileOutputStream(file);
		Row rowheader = sh.createRow(0);
		Cell celldate = rowheader.createCell(0);
		celldate.setCellValue("ASSOCIATE_NAME");
		Cell cellping = rowheader.createCell(1);
		cellping.setCellValue("DESIGNATION");
		Cell celldwnld = rowheader.createCell(2);
		celldwnld.setCellValue("AVAILABLE_FROM");
		Cell cellupld = rowheader.createCell(3);
		cellupld.setCellValue("CONTACT_NUMBER");
		Cell cellsrvr = rowheader.createCell(4);
		cellsrvr.setCellValue("SKILL_FAMILY");
		Cell cellprvdr = rowheader.createCell(5);
		cellprvdr.setCellValue("TECHNICAL_SKILLS");
		Cell cellprvdr1 = rowheader.createCell(6);
		cellprvdr1.setCellValue("DOMAIN_SKILLS");
		Cell cellprvdr2 = rowheader.createCell(7);
		cellprvdr2.setCellValue("PROPOSAL_STATUS");
		Cell cellprvdr3 = rowheader.createCell(8);
		cellprvdr3.setCellValue("LOCATION");

		CellStyle style1 = wb.createCellStyle();
		style1.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style1.setFillPattern(FillPatternType.BIG_SPOTS);
		Font font = wb.createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		style1.setFont(font);

		celldate.setCellStyle(style1);
		cellping.setCellStyle(style1);
		celldwnld.setCellStyle(style1);
		cellupld.setCellStyle(style1);
		cellsrvr.setCellStyle(style1);
		cellprvdr.setCellStyle(style1);
		cellprvdr1.setCellStyle(style1);
		cellprvdr2.setCellStyle(style1);
		cellprvdr3.setCellStyle(style1);

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://onecognizant.cognizant.com/");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("313814@cognizant.com");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(TestUtil.decodeString("Q2VkIzIwMjQ="));
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@type='button']")).click();
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id = 'txtPlatformBarSearch']")).sendKeys("iseek");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id = 'btnsearch']")).click();
		Thread.sleep(3000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Thread.sleep(3000);
		driver.switchTo().frame(1);
		Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement iseek = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id = 'searchResultData']/div/ul/li/div/img")));
		iseek.click();
		Thread.sleep(30000);
		Set<String> allwindows = driver.getWindowHandles();
		int count = allwindows.size();
		System.out.println("Number of windows are " + count);
		ArrayList<String> tabs = new ArrayList<>(allwindows);
		driver.switchTo().window(tabs.get(1));
		System.out.println("child tab" + tabs.get(1));

		// certification handling
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		System.out.println("a");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@id='profiles-search-wrapper']/div[4]/div/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='profiles-search-wrapper']/div[4]/div/div/ul[2]/li[1]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='profiles-search-wrapper']/div[3]/div/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[1]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[5]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[6]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[7]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"profiles-search-wrapper\"]/div[3]/div/div/ul[2]/li[9]/a")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='profiles-search-btn']")).click();
		// driver.close();
		Thread.sleep(10000);
		List<WebElement> iseekrows = driver.findElements(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr"));
		System.out.println("Number of records in the table is " + iseekrows.size());
		sizebefore = iseekrows.size();
		WebElement from = driver.findElement(By.xpath("//*[@id=\"mCSB_2_dragger_vertical\"]"));
		WebElement to = driver.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[30]"));
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		Action draganddrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
		draganddrop.perform();
		Thread.sleep(10000);
		List<WebElement> iseekrowsafter = driver
				.findElements(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr"));
		size1 = iseekrowsafter.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("after size " + size1);
		int countindex = 1;
		while (sizebefore != size1) {
			sizebefore = size1;
			WebElement toafter = driver
					.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + size1 + "]"));
			Thread.sleep(3000);
			Actions builderafter = new Actions(driver);
			Action draganddropafter = builderafter.clickAndHold(from).moveToElement(toafter).release(toafter).build();
			Thread.sleep(3000);
			draganddropafter.perform();
			Thread.sleep(10000);
			List<WebElement> iseekrowsaftersecond = driver
					.findElements(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr"));
			size1 = iseekrowsaftersecond.size();
			System.out.println("size1");
			countindex++;
			System.out.println(countindex);
		}
		System.out.println("final size of the table " + size1);
		WebElement finalassociate = driver
				.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + size1 + "]/td[2]"));
		js.executeScript("arguments[0].scrollIntoView();", finalassociate);
		driver.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + size1 + "]/td[2]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"associate-profile-content\"]/div/div[1]/div/button")).click();

		for (int i = 1; i <= size1; i++) {
			WebElement associatename = driver
					.findElement(By.xpath("//*[@class='mCSB_container']/div/table/tbody/tr[" + i + "]/td[2]"));
			Thread.sleep(1000);
			associatename.click();
			Thread.sleep(3000);
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

				Row row = sh.createRow(rowindex++);
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

				Row row = sh.createRow(rowindex++);
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
		//
		wb.write(fos);
		sh.getLastRowNum();
		System.out.println("Last row of the sheet " + sh.getLastRowNum());
		fos.close();
		}
	}

}
