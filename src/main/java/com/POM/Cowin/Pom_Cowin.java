package com.POM.Cowin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_Cowin {
	public static WebDriver driver;

	public Pom_Cowin(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//mat-select[@formcontrolname='state_id']")
	private WebElement state;

	@FindBy(xpath = "//div[@aria-multiselectable='false']/child::mat-option[@tabindex='0']/child::span[@class='mat-option-text']")
	private List<WebElement> list1;

	@FindBy(xpath = "//span[contains(text(),'Select District')]")
	private WebElement selectDistrict;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> allDistricts;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement search;

	@FindBy(xpath = "//label[@tabindex='0']")
	private List<WebElement> alldata;

	@FindBy(xpath = "//ul/li/span[2][@tabindex='0']")
	private List<WebElement> validation;

	@FindBy(xpath = "//h5[@class='center-name-title accessibility-plugin-ac']")
	private List<WebElement> allHospitals;



	public WebElement getState() {
		return state;
	}

	public List<WebElement> getList1() {
		return list1;
	}

	public WebElement getSelectDistrict() {
		return selectDistrict;
	}

	public List<WebElement> getAllDistricts() {
		return allDistricts;
	}

	public WebElement getSearch() {
		return search;
	}

	public List<WebElement> getAlldata() {
		return alldata;
	}

	public List<WebElement> getValidation() {
		return validation;
	}

	public List<WebElement> getAllHospitals() {
		return allHospitals;
	}
}
