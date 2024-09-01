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

public class Makeups {
	WebDriver driver;
	
	public void capture(WebDriver driver,int n)throws IOException{
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File image= ss.getScreenshotAs(OutputType.FILE);
		
		File img= new File("C:\\Users\\vaish\\OneDrive\\Pictures\\ss\\"+n+".png");
		
		FileUtils.copyFile(image, img);
		
		
	}

	@Given("URL of website")
	public void url_of_website() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	}

	@When("I click on shoping categries")
	public void i_click_on_shoping_categries() {
		Actions mouse=new Actions(driver);
		
		WebElement ele = driver.findElement(By.cssSelector("[class=\"cate_head\"]"));
		
		mouse.moveToElement(ele).build().perform();
			
	}

	@When("I find beauty and wellness and click on it")
	public void i_find_beauty_and_wellness_and_click_on_it() {
		Actions mouse = new Actions(driver);
		
		WebElement elee = driver.findElement(By.linkText("Beauty & Wellness"));
		
		mouse.moveToElement(elee).build().perform();
		
		elee.click();
	}

	@When("I click on a beauty category")
	public void i_click_on_a_beauty_category() {
		driver.findElement(By.linkText("Beauty")).click();
	}

	@Then("I find makeup option and click on it")
	public void i_find_makeup_option_and_click_on_it() {
		driver.findElement(By.linkText("Makeup")).click();
	}

	@Given("URL of makeup")
	public void url_of_makeup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/shop-online/health-beauty/beauty/make-up.html");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}

	@When("User is applying some filters")
	public void user_is_applying_some_filters() throws InterruptedException, IOException {
	   driver.findElement(By.id("iscod")).click();
	   Thread.sleep(2000);
	   
	    driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("brandFilterBox8313")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("discountFilterBox3")).click();
	    Thread.sleep(2000);
	    
	    
	    driver.findElement(By.id("featureFilterBox0f1")).click();
	    Thread.sleep(2000);
	    capture(driver, 7);
	    
	}

	@When("User is add the product in cart")
	public void user_is_add_the_product_in_cart() {
		driver.findElement(By.linkText("Quick & Easy Beard & Eyebrow Pen")).click();
		
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		 driver.findElement(By.cssSelector("[class=\"red_button icon chat\"]")).click();

	}

	@Then("User is switch back to parent tab")
	public void user_is_switch_back_to_parent_tab() throws IOException {
		 driver.navigate().to("https://www.naaptol.com/shop-online/health-beauty/beauty/make-up.html?&featid=f1-Q29tYmluYXRpb24gUGFjaw==&brand=8313-Branded&discountRange=40to50");
			
		  capture(driver, 8);
		    
		    driver.quit();
	}

}
