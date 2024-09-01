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

public class personalcare {
	
	WebDriver driver;
	
	public void capture(WebDriver driver,int n)throws IOException{
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File image= ss.getScreenshotAs(OutputType.FILE);
		
		File img= new File("C:\\Users\\vaish\\OneDrive\\Pictures\\ss\\"+n+".png");
		
		FileUtils.copyFile(image, img);
		
		
	}

	@Given("The url of napttol website")
	public void the_url_of_napttol_website() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	}

	@When("User go  website and click on shoping categories")
	public void user_go_website_and_click_on_shoping_categories() {
		Actions mouse=new Actions(driver);
		
		WebElement ele = driver.findElement(By.cssSelector("[class=\"cate_head\"]"));
		
		mouse.moveToElement(ele).build().perform();
			
	   
	}

	@Then("click on beauty & wellness category")
	public void click_on_beauty_wellness_category() {
		Actions mouse = new Actions(driver);
		
		WebElement elee = driver.findElement(By.linkText("Beauty & Wellness"));
		
		mouse.moveToElement(elee).build().perform();
		
		elee.click();
	    	
	}

	@Then("Click on beauty category")
	public void click_on_beauty_category() {
		driver.findElement(By.linkText("Beauty")).click();
	}

	@Then("Click on personal care")
	public void click_on_personal_care() throws IOException {
		driver.findElement(By.linkText("Personal Care")).click();
		capture(driver, 3);
	}

	@Given("Persona care page of naptool website")
	public void persona_care_page_of_naptool_website() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get("https://www.naaptol.com/shop-online/health-beauty/beauty/personal-care.html");
	
	
	}

	@When("User is applying filters")
	public void user_is_applying_filters() throws InterruptedException {
	    driver.findElement(By.id("iscod")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("isexoutStock")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
	    
	    driver.findElement(By.id("brandFilterBox8313")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("priceFilterBox3")).click();
	    Thread.sleep(2000);
	   
	    
	}

	@Then("user is compare the product")
	public void user_is_compare_the_product() throws InterruptedException {
	    
		driver.findElement(By.id("cpid12610939")).click();
		driver.findElement(By.id("cpid12612096")).click();
		
		driver.findElement(By.cssSelector("[class=\"button_1 compareFancyBox\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class=\"fancybox-item fancybox-close\"]")).click();
		
		
	}

	@Then("add to cart the product")
	public void add_to_cart_the_product() throws IOException {
		
		driver.findElement(By.linkText("Men's Hair Trimmer")).click();
		
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		 driver.findElement(By.cssSelector("[class=\"red_button icon chat\"]")).click();
		 
		 driver.navigate().to("https://www.naaptol.com/shop-online/health-beauty/beauty/personal-care.html?&priceRange=401to600&brand=8313-Branded");
		
	    capture(driver, 4);
	    
	    driver.quit();
		
	
	}



}