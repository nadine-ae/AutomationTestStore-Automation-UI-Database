package AutomationDataBase;

import static org.testng.Assert.assertEquals;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases extends myData {

	@BeforeTest
	public void myBeforeTest() throws SQLException {

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "Root@01");

		driver.get(myWebsite);
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		

	}

	@Test(priority = 1,enabled = true)
	
	public void AddNewRecord() throws SQLException {

		String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, postalCode, country, salesRepEmployeeNumber, creditLimit) VALUES (999, 'Abc Company', 'ali', 'ahmad', '962797700235', '123 Main St', 'Los Angeles',69541, 'Spain', 1370, 50000.00)";

		stmt = con.createStatement();

		stmt.executeUpdate(query);

	}


	@Test(priority = 2,enabled = true)
	
	public void readData() throws SQLException {
		
		String query = "select * from customers where customerNumber =999 ";
		
		stmt = con.createStatement();

		rs = stmt.executeQuery(query);
		
		System.out.println(rs);


		while (rs.next()) {

			CustomerFirstNameInDataBase = rs.getString("contactFirstName").toString().trim();
// 			the "contactFirstName" here is copied from the database column

		    WelcomeMessage = "Welcome back " + CustomerFirstNameInDataBase; // recompute here

			
			CustomerLastNameInDataBase = rs.getString("contactLastName").toString().trim();
// 			the "contactLastName" here is copied from the database column
	
			CustomerCountryInDataBase = rs.getString("country").toString().trim();
// 			the "country" here is copied from the database column

			address = rs.getString("addressLine1").toString().trim();
//			the "addressLine1" here is copied from the database column			
			
			PostalCode = rs.getString("postalCode").toString().trim();
//			the "postalCode" here is copied from the database column			

			loginName = CustomerFirstNameInDataBase+CustomerLastNameInDataBase+randomNumberForTheEmail;
			
			
			email = CustomerFirstNameInDataBase + CustomerLastNameInDataBase + randomNumberForTheEmail + "@gmail.com";
			

	}
		
		
	}

	@Test(priority = 3,enabled = true)
	
	public void updateData() throws SQLException {
		
		String query = "UPDATE customers SET contactLastName = 'asaad' WHERE customerNumber = 999;";

		stmt = con.createStatement();

		stmt.executeUpdate(query);
		
		
	}

	@Test(priority = 4,enabled = true)
	
	public void deleteData() throws SQLException {
		
		String query = "delete from customers where customerNumber =999";

		stmt = con.createStatement();

		stmt.executeUpdate(query);
		
	}

	@Test(priority = 5, enabled = true)
	public void SignupTest() throws InterruptedException {

		
		driver.navigate().to(SignupPage);

		// WebElements
		WebElement FirstName = driver.findElement(By.id("AccountFrm_firstname"));

		WebElement LastName = driver.findElement(By.id("AccountFrm_lastname"));

		WebElement Email = driver.findElement(By.id("AccountFrm_email"));

		WebElement AddressOne = driver.findElement(By.id("AccountFrm_address_1"));

		WebElement TheCountry = driver.findElement(By.id("AccountFrm_country_id"));

		WebElement TheState = driver.findElement(By.id("AccountFrm_zone_id"));

		Select mySelectElementForCountry = new Select(TheCountry);
		Select mySelectElementForState = new Select(TheState);

		mySelectElementForCountry.selectByVisibleText(CustomerCountryInDataBase);

		Thread.sleep(2000);

		// To Select State

		mySelectElementForState.selectByIndex(1);
		// In our database, there is no state for Spain, so we used index
	
		// Write Address
		List<WebElement> AlltheStates = TheState.findElements(By.tagName("option"));

		String theCity = AlltheStates.get(1).getText();

		WebElement TheCityInput = driver.findElement(By.id("AccountFrm_city"));

		WebElement ThePostalCode = driver.findElement(By.id("AccountFrm_postcode"));

		WebElement LoginName = driver.findElement(By.id("AccountFrm_loginname"));

		WebElement ThePassword = driver.findElement(By.id("AccountFrm_password"));

		WebElement TheConfirmPassword = driver.findElement(By.id("AccountFrm_confirm"));

		WebElement AgreeCheckBox = driver.findElement(By.id("AccountFrm_agree"));

		WebElement ContinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));
//
//		// Actions
		FirstName.sendKeys(CustomerFirstNameInDataBase);
		LastName.sendKeys(CustomerLastNameInDataBase);
		Email.sendKeys(email);
//
//		Telephone.sendKeys("Telephone");
//		Fax.sendKeys(TheFaxNumber);
		AddressOne.sendKeys(address);

		TheCityInput.sendKeys(theCity);

		ThePostalCode.sendKeys(PostalCode);

		LoginName.sendKeys(loginName);

		ThePassword.sendKeys(password);

		TheConfirmPassword.sendKeys(password);

		AgreeCheckBox.click();

		ContinueButton.click();

		Thread.sleep(5000);

		String ActualSignUpMessage = driver.findElement(By.className("maintext")).getText();

//		// This is a test case that compares the actual result with the expected result
//		// and works like the if
		Assert.assertEquals(ActualSignUpMessage, ExpectedTextforTheSignUp);


	}

	@Test(priority = 6, enabled = true)
	public void LogoutTest() throws InterruptedException {

		Thread.sleep(3000);

		// Link text Method
		driver.findElement(By.linkText("Logoff")).click();

		// Partial link text method
		//driver.findElement(By.partialLinkText("Logo")).click();

		System.out.println(driver.getPageSource());

		boolean ActualValueForLogout = driver.getPageSource().contains(TheLogoutMessage);

		Assert.assertEquals(ActualValueForLogout, true);

	}

	@Test(priority = 7, enabled = true)

	public void Login() throws InterruptedException {

		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Login or register")).click();
		

		WebElement LoginNameInput = driver.findElement(By.id("loginFrm_loginname"));

		WebElement LoginPassword = driver.findElement(By.id("loginFrm_password"));

		WebElement LoginButton = driver.findElement(By.cssSelector("button[title='Login']"));

		LoginNameInput.sendKeys(loginName);

		LoginPassword.sendKeys(password);

		Thread.sleep(3000);

		LoginButton.click();

		// Now we are logged in

		boolean ActualValue = driver.getPageSource().contains(WelcomeMessage);
		boolean ExpectedValue = true;

		assertEquals(ActualValue, ExpectedValue);

	}

	@Test(priority = 8, invocationCount = 5,enabled =false )
	public void AddItemToTheCart() {

		driver.navigate().to(myWebsite);

		Random rand = new Random();

		for (int i = 0; i < 10; i++) { // max 10 attempts here we can increase
			// pick a random item and open it
			List<WebElement> items = driver.findElements(By.className("prdocutname"));
			int randomItem = rand.nextInt(items.size());
			items.get(randomItem).click();

			// check availability
			boolean outOfStock = driver.getPageSource().contains("Out of Stock");
			boolean blockedProduct = driver.getCurrentUrl().contains("product_id=116");

			if (!outOfStock && !blockedProduct) {
				driver.findElement(By.cssSelector(".cart")).click();
				System.out.println("Added to cart: " + driver.getCurrentUrl());
				return; // success
			}

			driver.navigate().back(); // try again
		}

		throw new RuntimeException("No in-stock item found after 10 attempts.");


	}

	@AfterTest

	public void AfterMyTest() {

		//driver.close();

		driver.quit();
	}
	
	}

