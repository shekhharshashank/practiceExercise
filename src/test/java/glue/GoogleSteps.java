package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class GoogleSteps {

	@Given("url {string} is launched")
	public void url(String url) {
		W.get().driver.get(url);
		acceptCookiesIfWarned();
	}

	private static void acceptCookiesIfWarned() {
		try {
			W.get().driver.findElement(By.cssSelector("#L2AGLb")).click();
		} catch (NoSuchElementException ignored) {
		}
	}

	@When("About page is shown")
	public void about_page_is_shown() {

		W.get().driver.findElement(By.cssSelector("a[href^='https://about'] ")).click();
	}

	@Then("page displays {string}")
	public void page_displays(String expectedtext) {

		String actualText= W.get().driver.findElement(By.cssSelector("h1[class^='modules-lib']")).getText();
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedtext));
		
	}
	
	@When("searching for {string}")
	public void searching_for(String string) {
		
		W.get().driver.findElement(By.cssSelector("[aria-label='Search']")).sendKeys(string);
		Actions action = new Actions(W.get().driver);
		action.keyDown(Keys.ENTER).build().perform();
		
	  
	}
	@Then("results contain {string}")
	public void results_contain(String string) {
		
		List<WebElement> searchResults=W.get().driver.findElements(By.cssSelector("[class='LC20lb MBeuO DKV0Md']"));
		
		Assert.assertTrue(searchResults.get(0).getText().toLowerCase().contains(string.toLowerCase()));
		
	   
	}
	@Then("result stats are displayed")
	public void result_stats_are_displayed() {
	
		
		
	}
	@Then("number of {string} is more than {int}")
	public void number_of_is_more_than(String string, Integer int1) {
	
		List<WebElement> searchResults=W.get().driver.findElements(By.cssSelector("[aria-label='Search']"));
		Assert.assertTrue(searchResults.size()>int1);
	}




}
