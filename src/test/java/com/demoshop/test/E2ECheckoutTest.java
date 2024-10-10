package com.demoshop.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.pageObjects.CartPage;
import com.demoshop.utils.DataUtils;

public class E2ECheckoutTest extends BaseTest {
	@Test(groups="Smoke")
	public void verifyNewUserRegistersAndCheckoutProduct() throws InterruptedException  {
		
		//RegisteringNew user
		DataUtils.initUserData();
	    loginPage.navigateToRegisterationSection();
		registerPage.setUserData(DataUtils.firstName, DataUtils.lastName, DataUtils.uniqueEmail, DataUtils.password);
	    String expectedEmail = loginPage.getLoggedEmail();
		Assert.assertEquals(DataUtils.uniqueEmail, expectedEmail, "Registered email is differents");
		
		//Searching product
		loginPage.searchProduct("Jeans");
		cartPage.viewJeans();
		 String actualProduct= cartPage.getProductTitle();
		 Assert.assertEquals(prop.getProperty("expectedProduct"), actualProduct, "Product does not match");
		
		
		//Addcart
		cartPage.addProductToCart();
		String actualText=cartPage.getConfirmationMsg();
	    Assert.assertEquals(prop.getProperty("expectedText"), actualText, "Message does not match");
	   
	    
	    //NavigateCart
		cartPage.navigateToCart();
		 String actualCartHeading= cartPage.checkOutProduct();
		 Assert.assertEquals(prop.getProperty("expectedCheckOutTitle"),actualCartHeading, "Not in cartpage");
	
		//Checkout product
		cartPage.clickCheckout();
		 String actualCheckoutTitle= cartPage.confirmCheckout();
		 Assert.assertEquals(prop.getProperty("expectedCheckOutTitle"),actualCheckoutTitle, "Could not Checkout");
		
		
		//Billing
		cartPage.billingAddress();
		 String actualConfirmation= cartPage.getSuccessConfirmation();
		 Assert.assertEquals(prop.getProperty("expectedConfirmation"),actualConfirmation, "Order not Confirmed");
		
		
	}
}
