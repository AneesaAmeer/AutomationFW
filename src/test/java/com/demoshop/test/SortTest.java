package com.demoshop.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest extends BaseTest {

@Test
	
	public void verifyUserisAbleToSort()  {
	
	sortView.navigateToBooks();
	String actualSortText=sortView.getPageTitle();
    Assert.assertEquals(prop.getProperty("expectedBookText"), actualSortText, "Navigated to Books");
	sortView.sortByNameAtoZ();
	List<String> bookTitles = sortView.getBookTitles();
    // Verify that the books are sorted
    Assert.assertTrue(sortView.isSorted(bookTitles));
    sortView.selectListViewMode();
    
		
	}
}
