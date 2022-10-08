package Cowin.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.Cowin.Base_Class_Cowin;
import com.Cowin.gov.vaccine.Read_Cowin_Xlsx;
import com.POM.Cowin.Pom_Cowin;
import com.Property.ConfigurationHelper_Cowin;

import Cowin.Runner.Runner_Cowin;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class vaccine_stepdefinition extends Base_Class_Cowin {

	public static WebDriver driver = Runner_Cowin.driver;
	public static String state1 = "Tamil Nadu";
	public static String city = "Chennai";
	Pom_Cowin pC = new Pom_Cowin(driver);

	@Given("^Search Number of Vaccine Centers in TN$")
	public void search_Number_of_Vaccine_Centers_in_TN() throws Throwable {
		String geturl = ConfigurationHelper_Cowin.getInstance().geturl();
		getUrl(geturl);
		WebElement state = pC.getState();
		jsScrollIntoView(state);
		sleep(3000);
		jsClick(state);

		List<WebElement> list1 = pC.getList1();
		for (WebElement states : list1) {
			if (states.getText().trim().equals(state1)) {
				state1 = Read_Cowin_Xlsx.particularData("Cowin", 1, 0);
				jsClick(state);
			}
		}
		WebElement selectDistrict = pC.getSelectDistrict();
		expilicitWait(selectDistrict);
		jsClick(selectDistrict);
		List<WebElement> allDistricts = pC.getAllDistricts();
		ArrayList<String> dt = new ArrayList<String>();
		for (WebElement district : allDistricts) {
			dt.add(district.getText());
			if (dt.contains(city)) {
				jsClick(selectDistrict);
				break;
			}
		}
		WebElement search = pC.getSearch();
		jsClick(search);
		List<WebElement> alldata = pC.getAlldata();
//		expilicitWait( (WebElement) alldata);
		for (WebElement data : alldata) {
			if (data.getText().equals("18+")) {
				jsClick(data);
			}
			if (data.getText().equals("Dose 2")) {
				jsClick(data);
			}
			if (data.getText().equals("Paid")) {
				jsClick(data);
			}
			if (data.getText().equals("Covishield")) {
				jsClick(data);
			}
		}
		List<WebElement> validation = pC.getValidation();
		System.out.println("VERIFICATION OF DATAS ENTERED: ");
		for (WebElement checkData : validation) {
			if (checkData.getText().equals("18+")) {
				System.out.println("verified that the age is 18+");
			}
			if (checkData.getText().equals("2")) {
				System.out.println("verified that the dose in Dose 2");
			}
			if (checkData.getText().equals("Paid")) {
				System.out.println("verified that the filtered hospitals are Paid not free");
			}
			if (checkData.getText().equals("COVISHIELD")) {
				System.out.println("verified that the vaccine is Covishield");
			}

		}
	}

	@When("^Take The Results and Print$")
	public void take_The_Results_and_Print() throws Throwable {

		List<WebElement> allHospitals = pC.getAllHospitals();
		System.out.println("THE CENTERS ACCORDING TO REQUIRED CONDITIONS: ");
		for (WebElement hospital : allHospitals) {
			if (hospital.isDisplayed()) {
				System.out.println(hospital.getText());
			}
		}
	}
}
