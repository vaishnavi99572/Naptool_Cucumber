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

public class Eyecare {
	
	
		WebDriver driver;
	
		public void capture(WebDriver driver,int n)throws IOException{
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File image= ss.getScreenshotAs(OutputType.FILE);
		
		File img= new File("C:\\Users\\vaish\\OneDrive\\Pictures\\ss\\"+n+".png");
		
		FileUtils.copyFile(image, img);
		
		
		}
	
	
	@Given("The URL of naptool Website")
	public void the_url_of_naptool_website() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	}

	@When("User will click on shoiping category")
	public void user_will_click_on_shoiping_category() {
		Actions mouse=new Actions(driver);
		
		WebElement ele = driver.findElement(By.cssSelector("[class=\"cate_head\"]"));
		
		mouse.moveToElement(ele).build().perform();
			
	}

	@When("User will click on beauty and wellness")
	public void user_will_click_on_beauty_and_wellness() {
		Actions mouse = new Actions(driver);
		
		WebElement elee = driver.findElement(By.linkText("Beauty & Wellness"));
		
		mouse.moveToElement(elee).build().perform();
		
		elee.click();
	    	
	}

	@When("User will click on beauty option")
	public void user_will_click_on_beauty_option() {
		driver.findElement(By.linkText("Beauty")).click();
		
	   
	}

	@Then("User will click on Eye care")
	public void user_will_click_on_eye_care() throws IOException {
		driver.findElement(By.linkText("Eye Care")).click();
		capture(driver, 14);
	}

	@Given("The url of Eye care")
	public void the_url_of_eye_care() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naaptol.com/shop-online/health-beauty/beauty/eye-care.html");
	
		
	}

	@When("The user is applying brand and discout filter")
	public void the_user_is_applying_brand_and_discout_filter() throws InterruptedException {
		
		
		 driver.findElement(By.id("iscod")).click();
		    Thread.sleep(2000);
		    
		    driver.findElement(By.id("isexoutStock")).click();
		    Thread.sleep(2000);
		    
		    driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
		    Thread.sleep(2000);
		    
		    
		    driver.findElement(By.id("brandFilterBox8313")).click();
		    Thread.sleep(2000);
		    
		    
		    driver.findElement(By.id("discountFilterBox1")).click();
		    Thread.sleep(2000);
		    
	
		
	}

	@When("Select the product according to filter")
	public void select_the_product_according_to_filter() {
	   driver.findElement(By.linkText("Kids Glasses For Mobile & TV Protection Zero Power Buy 1 Get")).click();
	}

	@When("Add to cart the product")
	public void add_to_cart_the_product() {
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		driver.findElement(By.cssSelector("[class=\"red_button icon chat\"]")).click();
	}

	@Then("Navigate back to the current tab")
	public void navigate_back_to_the_current_tab() throws IOException {
		 	driver.navigate().to("https://www.naaptol.com/shop-online/health-beauty/beauty/eye-care.html?&brand=8313-Branded&discountRange=50to86");
			
		    capture(driver, 15);
		    
		    driver.quit();
			
	}

	
}
