package com.demoshop.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends BaseTest{	
	@Test
	
	public void verifyUserisAbleToAddCart()  {
	
	loginPage.searchProduct(prop.getProperty("productToSearch"));
	      cartPage.viewJeans();
	     String actualProduct= cartPage.getProductTitle();
	Assert.assertEquals(prop.getProperty("expectedProduct"), actualProduct, "Product does not match");
			cartPage.addProductToCart();
			String actualText=cartPage.getConfirmationMsg();
		    Assert.assertEquals(prop.getProperty("expectedText"), actualText, "Message does not match");
	
		
	}
}
		
		
	
	
	

