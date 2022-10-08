package com.Base.Cowin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class_Cowin {
	public static WebDriver driver = null;

	public static WebDriver browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ANBU\\Desktop\\workspace selenium\\com.selenium\\Driver\\chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("gecko")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}

		return driver;
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static WebDriver getUrl(String url) {
		driver.get(url);
		return driver;
	}

	public static void userInput(WebElement element, String value) throws IOException {

		element.sendKeys(value);
	}

	public static void clickOnElement(WebElement element) {

		element.click();
	}

	public static void sleep(int i) throws InterruptedException {
		Thread.sleep(i);
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void expilicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void isEnabled(WebElement element) {
		boolean check = element.isEnabled();
		System.out.println("The element is :" + check);
	}

	public static void isDisplayed(WebElement element) {
		boolean checkDisplay = element.isDisplayed();
		System.out.println("The element is :" + checkDisplay);
	}

	public static void isSelected(WebElement element) {
		boolean checkSelected = element.isSelected();
		System.out.println("The element is :" + checkSelected);
	}

	public static void getTitle(String title) {
		String page = driver.getTitle();
		System.out.println("The Page title is:" + page);
	}

	public static void screenShot(String value) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File designation = new File(
				"C:\\Users\\ANBU\\Desktop\\workspace selenium\\com.selenium\\screenshot\\" + value + " .png");
		FileUtils.copyFile(source, designation);
	}

	public static void printUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The Current Url is:" + currentUrl);
	}

	public static void getBackward() {
		driver.navigate().back();
	}

	public static void getRefresh() {
		driver.navigate().refresh();
	}

	public static void getForward() {
		driver.navigate().forward();

	}

	public static void pageSource() {
		String pageSourceOf = driver.getPageSource();
		System.out.println(pageSourceOf);
	}
//alert should be written

	public static void dimensions(int x, int y) {
		Dimension d = new Dimension(x, y);
		driver.manage().window().setSize(d);

	}

	public static void setPosition(int x, int y) {
		Point p = new Point(x, y);
		driver.manage().window().setPosition(p);

	}

	public static void jsScroll(int H, int V) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(" + H + "," + V + ")");
	}

	public static void jsScrollBy(int H, int V) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + H + "," + V + ")");
	}

	public static void jsScrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void jsSendKeys(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "';", element);

	}

	public static void selectMethods(WebElement element, String options, String value) {
		Select s = new Select(element);
		if (options.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (options.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		} else if (options.equalsIgnoreCase("index")) {
			int n = Integer.parseInt(value);
			s.selectByIndex(n);
		} else {
			System.out.println("Invalid Select");
		}
	}

	public static void deSelectMethod(WebElement element, String options, String value) {
		Select s = new Select(element);
		if (options.equalsIgnoreCase("value")) {
			s.deselectByValue(value);
		} else if (options.equalsIgnoreCase("text")) {
			s.deselectByVisibleText(value);
		} else if (options.equalsIgnoreCase("index")) {
			int n = Integer.parseInt(value);
			s.deselectByIndex(n);
		} else {
			System.out.println("Invalid Select");
		}
	}

	public static void selectIsMultiple(WebElement element) {
		Select s = new Select(element);
		boolean m = s.isMultiple();
		System.out.println("Is Multiple:" + m);
	}

	public static void deSelectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public static void selectFirstSelected(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelected = s.getFirstSelectedOption();
		System.out.println("The First Selected:" + firstSelected);
	}

	public static void selectedGetOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		System.out.println("The Selected Options:" + options);
	}

	public static void getAllSelected(WebElement element, String value) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement selectAll : allSelectedOptions) {
			System.out.println("The Selected Options :" + selectAll);

		}
	}

	public static void actionDragAndDrop(WebElement element1, WebElement element2) {
		Actions a = new Actions(driver);
		a.dragAndDrop(element1, element2).perform();

	}

	public static void actionMethod(WebElement element, String value) {
		Actions a = new Actions(driver);
		if (value.equalsIgnoreCase("doubleClick")) {
			a.doubleClick(element).perform();
		} else if (value.equalsIgnoreCase("contextClick")) {
			a.contextClick(element).perform();
		} else if (value.equalsIgnoreCase("clickAndHold")) {
			a.clickAndHold(element).perform();
		} else if (value.equalsIgnoreCase("click")) {
			a.click(element).perform();
		} else if (value.equalsIgnoreCase("moveToElement")) {
			a.moveToElement(element).perform();
		} else {
			System.out.println("Invalid Actions");
		}
	}

	public static void frames(String value) {
		if (value.equalsIgnoreCase("index")) {
			int f = Integer.parseInt(value);
			driver.switchTo().frame(f);
		} else if (value.equalsIgnoreCase("name")) {
			driver.switchTo().frame(value);
		} else if (value.equalsIgnoreCase("parentFrame")) {
			driver.switchTo().parentFrame();
		} else if (value.equalsIgnoreCase("defaultContent")) {
			driver.switchTo().defaultContent();
		} else {
			System.out.println("Invalis Frame");

		}

	}

	public static void framesElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}
}


