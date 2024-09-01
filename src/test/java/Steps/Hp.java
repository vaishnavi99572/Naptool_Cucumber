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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Hp {
	WebDriver driver;
	WebDriverWait wait;
	
	public void capture(WebDriver driver,int n)throws IOException{
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File image= ss.getScreenshotAs(OutputType.FILE);
		
		File img= new File("C:\\Users\\vaish\\OneDrive\\Pictures\\ss\\"+n+".png");
		
		FileUtils.copyFile(image, img);
		
		
	}
	
	
	
	
	@Given("Naptool website url")
	public void naptool_website_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	}

	@When("User go to website and click on shoping categories")
	public void user_go_to_website_and_click_on_shoping_categories() {
		Actions mouse=new Actions(driver);
		
		WebElement ele = driver.findElement(By.cssSelector("[class=\"cate_head\"]"));
		
		mouse.moveToElement(ele).build().perform();
			
	   
	}

	@When("click on beauty & wellness")
	public void click_on_beauty_wellness() {
		Actions mouse = new Actions(driver);
		
		WebElement elee = driver.findElement(By.linkText("Beauty & Wellness"));
		
		mouse.moveToElement(elee).build().perform();
		
		elee.click();
	    
	}

	@Then("click on beauty")
	public void click_on_beauty() {
		driver.findElement(By.linkText("Beauty")).click();
	    
	}

	@Then("click on hand and nail care")
	public void click_on_hand_and_nail_care() throws IOException {
		driver.findElement(By.linkText("Hand & Nail Care")).click();
		capture(driver, 1);
	}


	@Given("I am on hand and nail care page")
	public void i_am_on_hand_and_nail_care_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naaptol.com/shop-online/health-beauty/beauty/hand-nail-care.html");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}
	
	
	@When("I click on checkbox freeship and out of stock")
	public void i_click_on_checkbox_freeship_and_out_of_stock() throws InterruptedException {
		
		driver.findElement(By.id("iscod")).click();
		
		Thread.sleep(2000);
		
		//wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("isexoutStock"))));
		
		driver.findElement(By.id("isexoutStock")).click();
		
	
	}
		
	@When("I click on set button")
		public void i_click_on_set_button() throws InterruptedException {
		  
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
		
		WebElement ac= driver.findElement(By.cssSelector("[id=\"catalog_head\"]"));
		
		Assert.assertTrue(ac.isDisplayed());
	  
	}

	@Then("I appli all the filters")
	public void i_appli_all_the_filters() throws InterruptedException {
		
		//wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("brandFilterBox6302"))));
		
		Thread.sleep(2000);
		driver.findElement(By.id("brandFilterBox6302"));
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("discountFilterBox1"))));
		driver.findElement(By.id("discountFilterBox1")).click();
	   
	}

	@Then("add to cart  the item")
	public void add_to_cart_the_item() throws IOException {
		

		driver.findElement(By.linkText("Pack of 10 Nail Paint Kit with Free UV LED Nail Dryer")).click();
		 driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		 driver.findElement(By.cssSelector("[class=\"red_button icon chat\"]")).click();
		 
		 driver.navigate().to("https://www.naaptol.com/shop-online/health-beauty/beauty/hand-nail-care.html?&discountRange=50to62");
		
	    capture(driver, 2);
	    
	    driver.quit();
	}
}


