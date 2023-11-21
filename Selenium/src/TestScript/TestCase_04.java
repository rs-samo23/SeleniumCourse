package TestScript;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase_04 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.linkText("Log in")).click();
		
		driver.findElement(By.id("Email")).sendKeys("sam@testing.com");
		driver.findElement(By.id("Password")).sendKeys("Sam1234");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.partialLinkText("Apparel & Shoes")).click();
		
		List<WebElement> allProducts=driver.findElements(By.xpath("//input[@value='Add to cart']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		for(WebElement product : allProducts )
		{
			product.click();	
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//a[text()='shopping cart']"))));
			Thread.sleep(3000);
		}
		
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		
//		List<WebElement> cartProducts=driver.findElements(By.xpath("//tr[@class='cart-item-row']"));
		
		
//		
//		
//		if(allProducts.size()==cartProducts.size())
//		{
//			System.out.println("AddToCart Test Case Pass");
//		}
//		else
//			System.out.println("AddToCart Test Case Fail");
//		
//		driver.close();
	}

}
