package Testcases;

import org.testng.annotations.Test;

import PageObject.Productpage;
import TestBase.BaseClass;

public class ProductTest extends BaseClass{

	@Test
	public void PrintProduct() throws InterruptedException {
		Productpage pp = new Productpage(driver);
		pp.ClickElectronic();
		pp.AllProduct();
		Thread.sleep(3000);
		pp.AllWatches();
		Thread.sleep(3000);
		pp.SearchBar();
		pp.ClickSubmit();
	}
}
