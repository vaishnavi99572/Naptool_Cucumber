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

public class Hc {
	
	WebDriver driver;
	
	public void capture(WebDriver driver,int n)throws IOException{
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File image= ss.getScreenshotAs(OutputType.FILE);
		
		File img= new File("C:\\Users\\vaish\\OneDrive\\Pictures\\ss\\"+n+".png");
		
		FileUtils.copyFile(image, img);
		
		
	}
	
	@Given("website Url")
	public void website_url() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Given("Navigate the shoping category")
	public void navigate_the_shoping_category() {
		Actions mouse=new Actions(driver);
		
		WebElement ele = driver.findElement(By.cssSelector("[class=\"cate_head\"]"));
		
		mouse.moveToElement(ele).build().perform();
		
	    
	}

	@When("Click on Beauty & wellness option")
	public void click_on_beauty_wellness_option() {
		Actions mouse = new Actions(driver);
		
		WebElement elee = driver.findElement(By.linkText("Beauty & Wellness"));
		
		mouse.moveToElement(elee).build().perform();
		
		elee.click();
  
	}

	@When("select beauty option")
	public void select_beauty_option() {
		driver.findElement(By.linkText("Beauty")).click();
	   
	}

	@Then("select Hair care option")
	public void select_hair_care_option() throws IOException {
		
		
		driver.findElement(By.linkText("Hair Care")).click();
		capture(driver, 11);
	   
	}

	@Given("The URL of hair care page")
	public void the_url_of_hair_care_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get("https://www.naaptol.com/shop-online/health-beauty/beauty/hair-care.html");
	
	}

	@When("User perform some slection on checkbok")
	public void user_perform_some_slection_on_checkbok() throws InterruptedException {
		
	     driver.findElement(By.id("iscod")).click();
		   Thread.sleep(2000);
		
		 driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
		 Thread.sleep(2000);
		
		driver.findElement(By.id("brandFilterBox8313")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("discountFilterBox4")).click();
		Thread.sleep(2000);
		
		
		
		
	    
	}

	@Then("User slect the product")
	public void user_slect_the_product() {
		driver.findElement(By.linkText("Instant Hair Colour Touch-up - Pick Any 1")).click();
	   
	}

	@Then("User will add to cart the product")
	public void user_will_add_to_cart_the_product() {
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		 driver.findElement(By.cssSelector("[class=\"red_button icon chat\"]")).click();
		
		
		
	    
	}

	@Then("Naviagates back to parent tab")
	public void naviagates_back_to_parent_tab() throws IOException {
		
		 driver.navigate().to("https://www.naaptol.com/shop-online/health-beauty/beauty/hair-care.html?&brand=8313-Branded&discountRange=50to70");
			
		    capture(driver, 12);
		    
		    driver.quit();
	  
	}



	
	

}
