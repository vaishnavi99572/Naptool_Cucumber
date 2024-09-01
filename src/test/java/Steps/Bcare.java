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

public class Bcare {
	WebDriver driver;
	
	public void capture(WebDriver driver,int n)throws IOException{
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File image= ss.getScreenshotAs(OutputType.FILE);
		
		File img= new File("C:\\Users\\vaish\\OneDrive\\Pictures\\ss\\"+n+".png");
		
		FileUtils.copyFile(image, img);
		
	}
	

	@Given("The URL of naptool e commerce website")
	public void the_url_of_naptool_e_commerce_website() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	}

	@When("The user is navigate to shoping category")
	public void the_user_is_navigate_to_shoping_category() {
		Actions mouse=new Actions(driver);
		
		WebElement ele = driver.findElement(By.cssSelector("[class=\"cate_head\"]"));
		
		mouse.moveToElement(ele).build().perform();
	}

	@When("User is click on beauty & wellness option")
	public void user_is_click_on_beauty_wellness_option() {
		Actions mouse = new Actions(driver);
		
		WebElement elee = driver.findElement(By.linkText("Beauty & Wellness"));
		
		mouse.moveToElement(elee).build().perform();
		
		elee.click();
		
	}

	@When("yet user  will click on Beauty option")
	public void yet_user_will_click_on_beauty_option() {
		driver.findElement(By.linkText("Beauty")).click();
	}

	@When("User will click on bodycare option")
	public void user_will_click_on_bodycare_option() {
		
		driver.findElement(By.linkText("Body Care")).click();
	   
	}

	@Given("The url of body care page url")
	public void the_url_of_body_care_page_url() throws IOException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naaptol.com/shop-online/health-beauty/beauty/body-care.html");
	    capture(driver, 8);
	}

	@When("then user is aplying some filter")
	public void then_user_is_aplying_some_filter() throws InterruptedException {
	    driver.findElement(By.id("isfreeship")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
	    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("isfreeship")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("brandFilterBox8313")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("discountFilterBox4")).click();
	    
	
	    
	}
	@Then("User is add to cart the product")
	public void user_is_add_to_cart_the_product() throws IOException {
	    driver.findElement(By.linkText("Knee and Elbow Tan Removal")).click();
	    driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		 driver.findElement(By.cssSelector("[class=\"red_button icon chat\"]")).click();
		 
		 capture(driver, 9);
	    
	}

	@Then("user will be able to navigate the parent tab")
	public void user_will_be_able_to_navigate_the_parent_tab() {
	    driver.navigate().to("https://www.naaptol.com/shop-online/health-beauty/beauty/body-care.html?&brand=8313-Branded&discountRange=40to50");
	    
	    driver.quit();
	}




}
