package AutomationDataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class myData {

	// Global variables
	
	WebDriver driver = new EdgeDriver();

	String myWebsite = "https://automationteststore.com/";

	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

	Connection con;

	Statement stmt;

	ResultSet rs;
	
	Random rand = new Random();
	
	int randomNumberForTheEmail1 = rand.nextInt(54789);
	int randomNumberForTheEmail2 = rand.nextInt(5472);
	int randomNumberForTheEmail3 = rand.nextInt(1600);
	
	int randomNumberForTheEmail = randomNumberForTheEmail1*randomNumberForTheEmail2 -randomNumberForTheEmail3; 
	
	String ExpectedTextforTheSignUp = "YOUR ACCOUNT HAS BEEN CREATED!";
	
	String TheLogoutMessage = "You have been logged off your account. It is now safe to leave the computer.";
	
	// The Data inside my Database
	String CustomerFirstNameInDataBase;
	String CustomerLastNameInDataBase;
	String email;
	String password = "123!@#P@ssw0rd";
	// I declared the password here (hard coded) because we don't get it from the database
	String CustomerCountryInDataBase;
	
	String address;
	String PostalCode;
	
	String loginName;
	

	String WelcomeMessage = "Welcome back " +CustomerFirstNameInDataBase;

}
