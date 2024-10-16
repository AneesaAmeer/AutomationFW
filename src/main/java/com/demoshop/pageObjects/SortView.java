package com.demoshop.pageObjects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demoshop.utils.PageActions;

public class SortView extends PageActions{
	
	private WebDriver driver;

		
		public SortView(WebDriver driver) {
			super(driver);
			this.driver= driver;
			PageFactory.initElements(driver, this);
			
		}

		@FindBy(xpath = "//ul[@class='top-menu']//a[@href='/books']")
		WebElement booksLink;
		
		@FindBy(id = "products-orderby")
	    private WebElement sortByDropdown;
		
		  @FindBy(id = "products-viewmode")
		   private WebElement viewModeDropdown;
		  
		  @FindBy(xpath = "//div[@class='page-title']/h1")
		    private WebElement pageTitle;
		  
		  @FindBy(xpath = "//h2[@class='product-title']/a")
		    private List<WebElement> bookTitles;
		
		public void navigateToBooks() {
			clickElement(booksLink);
		}
		
		public String getPageTitle() {
	        return pageTitle.getText();
	    }
		
		 public void sortByNameAtoZ() {
		        Select dropdown = new Select(sortByDropdown);
		        dropdown.selectByVisibleText("Name: A to Z");
		    }
		
		 public void selectListViewMode() {
		        Select dropdown = new Select(viewModeDropdown);
		        dropdown.selectByVisibleText("List");
		    }
		 
		 public String getListViewMode() {
		        Select dropdown = new Select(viewModeDropdown);
		        return dropdown.getFirstSelectedOption().getText();
		        
		    }
		 
		 public List<String> getBookTitles() {
		        List<String> titles = new ArrayList<>();
		        for (WebElement title : bookTitles) {
		            titles.add(title.getText());
		        }
		        return titles;
		    }

		    // Method to check if the list is sorted
		    public boolean isSorted(List<String> list) {
		        List<String> sortedList = new ArrayList<>(list);
		        Collections.sort(sortedList);
		        return list.equals(sortedList);
		    }
}
