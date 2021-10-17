package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
    WebDriver driver;
    @Given("^Open the Chrome and launch the application$")
    public void open_the_chrome_and_launch_the_application() throws Throwable
    {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\P10462945\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
    }

    @When("^Enter Details$")
    public void enter_the_Username_and_Password() throws Throwable
    {
        Thread.sleep(2000);
       driver.findElement(By.cssSelector("input[aria-labelledby='q2q1']")).sendKeys("80,000");
        driver.findElement(By.cssSelector("input[aria-labelledby='q2q2']")).sendKeys("10,000");
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q1']")).sendKeys("500");
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q2']")).sendKeys("0");
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q3']")).sendKeys("100");
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q4']")).sendKeys("0");
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q5']")).sendKeys("10,000");
    }

    @When("^Work out how much i could borrow$")
    public void Work_out_how_much_i_could_borrow() throws Throwable
    {
        driver.findElement(By.id("btnBorrowCalculater")).click();
        Thread.sleep(2000);
    }
    @When("^We estimate you could borrow$")
    public void We_estimate_you_could_borrow() throws Throwable
    {
        String barrowText=driver.findElement(By.cssSelector("span[id='borrowResultTextAmount']")).getText();
    }
    @When("Clicking the 'start over' button clears the form")
    public void Clicking_the_start_over_button_clears_the_form()
    {
        driver.findElement(By.cssSelector("button[aria-label='Start over']")).click();
    }
    @When("Enter Living Expenses")
    public void Enter_Living_Expenses()
    {
        driver.findElement(By.cssSelector("input[aria-labelledby='q3q1']")).sendKeys("1");
    }
    @When("Click estimate")
    public void Click_estimate() throws InterruptedException {
        driver.findElement(By.id("btnBorrowCalculater")).click();
        Thread.sleep(2000);
    }
    @Then("Following message displays")
    public void Following_message_displays() throws InterruptedException {
        driver.findElement(By.xpath("//span[@aria-atomic='true']")).getText();
        Thread.sleep(2000);
    }
}
