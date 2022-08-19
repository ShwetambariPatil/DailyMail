package stepDefinations;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeSteps {

	WebDriver driver = null;

	@Given("I am on DailyMail website home page")
	public void i_am_on_dailymail_website_home_page() throws InterruptedException  {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver");

		//Invoke Browser and disable notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		//Provide URL and Maximize browser Window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.navigate().to("https://www.dailymail.co.uk/home/index.html");
		System.out.println(driver.getTitle());
		String ActualTitle =driver.getTitle();
		Assert.assertEquals("UK Home | Daily Mail Online", ActualTitle);

		//Accept cookies
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Got it')]")).click();
		Thread.sleep(2000);
//		System.out.println(driver.findElement(By.xpath("//*[@id='weather-wrapper']/strong")).getText());
//		System.out.println(driver.findElement(By.xpath("//*[@id='weather-wrapper']/a/span[1]")).getText());
		

	}

	@When("^I check Date and Time$")
	public void i_check_date_and_time() {

		System.out.println(driver.findElement(By.xpath("//*[@id='weather-wrapper']/strong")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id='weather-wrapper']/a/span[1]")).getText());
		System.out.println("step-2");

	}

	@Then("^I validate the current Date and Time displayed$")
	public void i_validate_the_current_date_and_time_displayed() throws Throwable {
		//		String ExpectedDate = ;
		//		String ExpectedTime = ;
		// Assert.assertEquals(ExpectedDate, ActualDate);
		// Assert.assertEquals(ExpectedTime, ActualTime);
		System.out.println("cucumber-3");
		driver.close();

	}






}
