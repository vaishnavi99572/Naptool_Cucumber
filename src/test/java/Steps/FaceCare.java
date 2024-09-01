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

public class FaceCare {
WebDriver driver;
	
	public void capture(WebDriver driver,int n)throws IOException{
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File image= ss.getScreenshotAs(OutputType.FILE);
		
		File img= new File("C:\\Users\\vaish\\OneDrive\\Pictures\\ss\\"+n+".png");
		
		FileUtils.copyFile(image, img);
		
		
	}

	@Given("The url of website naptool")
	public void the_url_of_website_naptool() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.naaptol.com/");
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	}

	@When("The user will click on shoping categories")
	public void the_user_will_click_on_shoping_categories() {
		Actions mouse=new Actions(driver);
		
		WebElement ele = driver.findElement(By.cssSelector("[class=\"cate_head\"]"));
		
		mouse.moveToElement(ele).build().perform();
	}

	@When("The user click on beauty and wellness category")
	public void the_user_click_on_beauty_and_wellness_category() {
		Actions mouse = new Actions(driver);
		
		WebElement elee = driver.findElement(By.linkText("Beauty & Wellness"));
		
		mouse.moveToElement(elee).build().perform();
		
		elee.click();
	}

	@When("Select beauty option")
	public void select_beauty_option() {
		driver.findElement(By.linkText("Beauty")).click();
	}

	@When("In beauty page select Facecare option")
	public void in_beauty_page_select_facecare_option() {
		driver.findElement(By.linkText("Face Care")).click();
	}

	@Given("The url of face care page")
	public void the_url_of_face_care_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get("https://www.naaptol.com/shop-online/health-beauty/beauty/face-care.html");
	}

	@When("User is applying some filters on face care page")
	public void user_is_applying_some_filters_on_face_care_page() throws InterruptedException {
		driver.findElement(By.id("iscod")).click();
		Thread.sleep(2000);
		
		 driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("brandFilterBox38467")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("discountFilterBox4")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("featureFilterBox0f2")).click();
		
		
	   
	}

	@When("select a product")
	public void select_a_product() {
		driver.findElement(By.linkText("Nutriglow Vitamin C Serum")).click();
	   
	}

	@Then("Add to cart this product")
	public void add_to_cart_this_product() {
		
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		 driver.findElement(By.cssSelector("[class=\"red_button icon chat\"]")).click();
		 
	
	   
	}

	@Then("User will navigate back")
	public void user_will_navigate_back() throws IOException {
		
		 driver.navigate().to("https://www.naaptol.com/shop-online/health-beauty/beauty/face-care.html?&featid=f2-VW5pc2V4&brand=38467-NutriGlow&discountRange=20to30");
			
		    capture(driver, 9);
		    
		    driver.quit();
	   
	}




}
