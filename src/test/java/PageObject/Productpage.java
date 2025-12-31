package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Productpage extends Basepage {
	
	public List<WebElement> allLinks = new ArrayList<WebElement>();
	String productName;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchbar;
	
	@FindBy(xpath="//a[@data-csa-c-content-id='nav_cs_electronics']")
	WebElement clickelectronicbtn;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement clicknavsubmit;

	public Productpage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickElectronic() {
		clickelectronicbtn.click();
	}
	
	public void AllProduct() {
		allLinks= driver.findElements(By.xpath("//div[@id='anonCarousel1']//span[@class='dcl-truncate dcl-product-title']"));
		
		int count= allLinks.size();
		System.out.println(count);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", allLinks.get(0));
		
		for(WebElement link: allLinks) {
			System.out.println(link.getText());
		}
		productName = allLinks.getFirst().getText();
		System.out.println("====================================================================================");
	}
	
	public void AllWatches() {
		List<WebElement> allwatchs= driver.findElements(By.xpath("//div[@id='anonCarousel2']//span[@class='dcl-truncate dcl-product-title']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", allwatchs.get(0));
		
	    for(WebElement links: allwatchs) {
		System.out.println(links.getText());
	}
		
	}
	
	public void SearchBar() {
		System.out.println("======= This is testing =========");
		searchbar.click();
		
		System.out.println(productName);
		searchbar.sendKeys(productName);
		
	}
	
	public void ClickSubmit() {
		clicknavsubmit.click();
	}
}
