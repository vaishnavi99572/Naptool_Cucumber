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

public class Bodys {
	WebDriver driver;
	
	public void capture(WebDriver driver,int n)throws IOException{
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File image= ss.getScreenshotAs(OutputType.FILE);
		
		File img= new File("C:\\Users\\vaish\\OneDrive\\Pictures\\ss\\"+n+".png");
		
		FileUtils.copyFile(image, img);
		
		
	}
	
	

	@Given("The website URL of naptool")
	public void the_website_url_of_naptool() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("The user click on shoping categories")
	public void the_user_click_on_shoping_categories() {
		Actions mouse=new Actions(driver);
		
		WebElement ele = driver.findElement(By.cssSelector("[class=\"cate_head\"]"));
		
		mouse.moveToElement(ele).build().perform();
			
	}

	@When("The user clicks on beauty and wellness option")
	public void the_user_clicks_on_beauty_and_wellness_option() {
		Actions mouse = new Actions(driver);
		
		WebElement elee = driver.findElement(By.linkText("Beauty & Wellness"));
		
		mouse.moveToElement(elee).build().perform();
		
		elee.click();
	    	
	}

	@When("The user will click on beauty option")
	public void the_user_will_click_on_beauty_option() {
		driver.findElement(By.linkText("Beauty")).click();
	}

	@Then("The user click on body shaper and slimmer option")
	public void the_user_click_on_body_shaper_and_slimmer_option() {
		driver.findElement(By.linkText("Body Shaper & Slimmers")).click();
	}

	@Given("The url of body shaper and slimmer page")
	public void the_url_of_body_shaper_and_slimmer_page() throws IOException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/shop-online/health-beauty/beauty/slimming-products.html");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		capture(driver, 5);
	    
	}

	@Then("The user will apply the filters")
	public void the_user_will_apply_the_filters() throws InterruptedException {
		
		driver.findElement(By.id("iscod")).click();
		Thread.sleep(2000);
		
		 driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("brandFilterBox38614")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("priceFilterBox3")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("discountFilterBox1")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("featureFilterBox0f1")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("featureFilterBox1f2")).click();
		 Thread.sleep(2000);
		 
		
		
	   
	}

	@Then("Add to cart")
	public void add_to_cart() throws IOException {
	   driver.findElement(By.linkText("Fat Reducing Fitness Belt - BOGO")).click();
	   
	   
	   driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
	   driver.findElement(By.cssSelector("[class=\"red_button icon chat\"]")).click();
		 
		driver.navigate().to("https://www.naaptol.com/shop-online/health-beauty/beauty/slimming-products.html?&featid=f1-V2Fpc3QgJiBUdW1teQ==&featid=f2-VW5pc2V4&brand=38614-Get%20In%20Shape&discountRange=50to75");
		
	    capture(driver, 6);
	    
	    driver.quit();
		
	
	}




}
