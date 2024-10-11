package com.demoshop.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demoshop.utils.PageActions;
import com.demoshop.utils.UniqueGenerator;
import com.demoshop.utils.WaitUtils;

public class CartPage extends PageActions{
private WebDriver driver;
WebElement shop;
//Actions action;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".product-title")
	private WebElement jeans;
	
    @FindBy(css=".product-name")
	private WebElement productTitle;
	
	@FindBy(xpath="//input[@class='button-1 add-to-cart-button']")
	private WebElement addToCartBtn;
	
	@FindBy(css="#bar-notification p.content")
	private WebElement confirmationMsg;
	
	
	@FindBy(css=".header-links .ico-cart")
	private WebElement shoppingCartHeader;
	
	@FindBy(xpath="//input[contains(@class,'button-1 cart-button')]")
	private WebElement goToCartButton;

	@FindBy(xpath="//select[@id='CountryId']")
	private WebElement selectCountry;
	
	@FindBy(css="#termsofservice")
	private WebElement selectAgreement;
	
	@FindBy(css="#checkout")
	private WebElement clickCheckoutbox;
	
			
	@FindBy(xpath="//div[@class='page-title']")
	private WebElement checkoutFinish;
	
	
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	private WebElement billingSelectCountry;
	
	
	@FindBy(css="#BillingNewAddress_City")
	private WebElement billingSelectCity;
	
	@FindBy(css="#BillingNewAddress_Address1")
	private WebElement billingSelectAddress;
	
	@FindBy(css="#BillingNewAddress_ZipPostalCode")
	private WebElement billingSelectZip;
	
	@FindBy(css="#BillingNewAddress_PhoneNumber")
	private WebElement billingSelectPhnNo;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement billingAddress;
	
	@FindBy(xpath="(//input[@class='button-1 new-address-next-step-button'])[2]")
	private WebElement secondContinueButton;
	
	@FindBy(xpath="//input[@class='button-1 shipping-method-next-step-button']")
	private WebElement shippingContinueButton;
	
	
	@FindBy(xpath="//input[@class='button-1 payment-method-next-step-button']")
	private WebElement paymentContinueButton;
	
	
	@FindBy(xpath="//input[@class='button-1 payment-info-next-step-button']")
	private WebElement paymentConfirmButton;
	
	@FindBy(xpath="//input[@class='button-1 confirm-order-next-step-button']")
	private WebElement finalConfirmButton;
	
	
	
	@FindBy(xpath="//div[@class='title']")
	private WebElement SuccessConfirm;
	
	public void viewJeans() {
		clickElement(jeans);
	}
	
	public String getProductTitle() {
		return getElementText(productTitle);
	}
	
	public void addProductToCart() {
		clickElement(addToCartBtn);
	}
	
	public String getConfirmationMsg() {
		WaitUtils.waitUntilVisible(confirmationMsg, driver);
		return getElementText(confirmationMsg);
		
	}

	public void navigateToCart() {
		WaitUtils.waitUntilVisible(shoppingCartHeader,driver);
		PageActions.moveToDifferentElement(driver,shoppingCartHeader,goToCartButton);
	}
	

	public String checkOutProduct(){
		handleStaticDrowpdown(selectCountry,"India");
		clickElement(selectAgreement);
		WaitUtils.waitUntilVisible(clickCheckoutbox,driver);
		return getElementText(clickCheckoutbox);
	}
	
	public void clickCheckout() {
		clickElement(clickCheckoutbox);
		}
	
	public String confirmCheckout()
	{ 
		return getElementText(checkoutFinish);
	}
	
	public void billingAddress() throws InterruptedException
	{
		handleStaticDrowpdown(billingSelectCountry,"India");
		setTextBox(billingSelectCity, UniqueGenerator.getUniqueCityName());
		setTextBox(billingSelectAddress, UniqueGenerator.getUniqueAddress());
		setTextBox(billingSelectZip, UniqueGenerator.getUniqueZipCode());
		setTextBox(billingSelectPhnNo,UniqueGenerator.getUniquePhnNumber());
		clickElement(billingAddress);
		Thread.sleep(2000);
		clickElement(secondContinueButton);
		clickElement(shippingContinueButton);
		clickElement(paymentContinueButton);
		clickElement(paymentConfirmButton);
		clickElement(finalConfirmButton);
	}
	
	public String getSuccessConfirmation() {
		return getElementText(SuccessConfirm);
	}

}



