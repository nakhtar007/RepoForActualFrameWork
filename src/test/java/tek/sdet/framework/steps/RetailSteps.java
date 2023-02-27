package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailSteps extends CommonUtility {
	
	private POMFactory factory = new POMFactory();
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekSchoolLogo));
		logger.info("user is on retail website");
		logger.info("Actual Title " + actualTitle + " Equals " + " ExpectedTitle " + expectedTitle);
		
	}
	
	
	
	@When("User search for {string} product")
	public void userSearchForProduct(String productValue) {
		sendText(factory.homePage().searchBar, productValue);
		click(factory.homePage().searchButton);
		logger.info("user searched for product "+ productValue );
	}
	
	@Then("The product should be displayed")
	public void theProductShouldBeDisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().pokemanProductImage));
		logger.info("the Product is displayed on home page");
		
	}
	
	@When("User click on all section")
	public void userClickOnAllSection() throws InterruptedException {
	    click(factory.homePage().sideBarButton);
	    
	    logger.info("User clicked on all department");
	}
	@Then("below options are present in shop by department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
	 // Assert.assertTrue(isElementDisplayed(factory.homePage().sidebarElectronicOption));
	//  Assert.assertTrue(isElementDisplayed(factory.homePage().sideBarComputersOption));
	//  Assert.assertTrue(isElementDisplayed(factory.homePage().sideBarSmartHomeOption));
	//  Assert.assertTrue(isElementDisplayed(factory.homePage().sideBarSportOption));
	//  Assert.assertTrue(isElementDisplayed(factory.homePage().sideBarAutomativeOption));
		List <List<String>> expectedSidebar = dataTable.asLists(String.class);
		List <WebElement> actualSidebar = factory.homePage().sidebarAllOptions;
		for(int i = 0; i<expectedSidebar.size();i++ ) {
			Assert.assertEquals(actualSidebar.get(i).getText(), expectedSidebar.get(0).get(i));
		}
	  logger.info("All the options are present");
	}

}
