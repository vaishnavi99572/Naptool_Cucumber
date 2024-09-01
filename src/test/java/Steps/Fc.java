package Steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Fc {
	
	
	WebDriver driver;
	
	public void capture(WebDriver driver,int n)throws IOException{
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File image= ss.getScreenshotAs(OutputType.FILE);
		
		File img= new File("C:\\Users\\vaish\\OneDrive\\Pictures\\ss\\"+n+".png");
		
		FileUtils.copyFile(image, img);
		
	}

	
	@Given("The URL of naptool website")
	public void the_url_of_naptool_website() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	   
	}

	@Given("Click on the Shoping Category")
	public void click_on_the_shoping_category() {
		Actions mouse=new Actions(driver);
		
		WebElement ele = driver.findElement(By.cssSelector("[class=\"cate_head\"]"));
		
		mouse.moveToElement(ele).build().perform();
		
	   
	}

	@When("User will click on beauty and wellness category")
	public void user_will_click_on_beauty_and_wellness_category() {
		Actions mouse = new Actions(driver);
		
		WebElement elee = driver.findElement(By.linkText("Beauty & Wellness"));
		
		mouse.moveToElement(elee).build().perform();
		
		elee.click();

	}

	@When("User will click on beauty")
	public void user_will_click_on_beauty() {
		driver.findElement(By.linkText("Beauty")).click();
		
	}

	@Then("User will click on Foot care")
	public void user_will_click_on_foot_care() throws IOException {
		driver.findElement(By.linkText("Foot Care")).click();
		capture(driver, 12);
	}

	@Given("The URL of foot care")
	public void the_url_of_foot_care() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get("https://www.naaptol.com/shop-online/health-beauty/beauty/foot-care.html");

	}

	@When("User will apply brand and some other filters")
	public void user_will_apply_brand_and_some_other_filters() throws InterruptedException {
	   driver.findElement(By.id("iscod")).click();
	   Thread.sleep(2000);
	   
	   driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
	   
	   driver.findElement(By.id("brandFilterBox38964")).click();
	   Thread.sleep(2000);
	   
	   driver.findElement(By.id("discountFilterBox1")).click();
	   Thread.sleep(2000);
	   
	   
	   driver.findElement(By.id("featureFilterBox0f1")).click();
	   Thread.sleep(2000);
		
		
	}

	@When("User select the product")
	public void user_select_the_product() {
	   driver.findElement(By.linkText("Pain Free Corn Removal Lotion (FCRL)")).click();
	}

	@Then("Add the selected product to the cart")
	public void add_the_selected_product_to_the_cart() {
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		 driver.findElement(By.cssSelector("[class=\"red_button icon chat\"]")).click();
	 
	}

	@Then("User will navigate back to parent tab")
	public void user_will_navigate_back_to_parent_tab() throws IOException {
	   driver.navigate().to("https://www.naaptol.com/shop-online/health-beauty/beauty/foot-care.html?&featid=f1-Rm9vdCBUcmVhdG1lbnQ=&brand=38964-Ayurjeet&discountRange=50to80");
	   capture(driver, 13);
	   
	   driver.quit();
	
	}
	




}
