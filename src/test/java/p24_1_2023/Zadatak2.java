package p24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/login");

        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='userName']"));
        userNameInput.sendKeys("itbootcamp");
        userNameInput.sendKeys(Keys.ENTER);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordInput.sendKeys("ITBootcamp2021!");
        passwordInput.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath
                ("//form[@id='userForm']/div[@class='mt-2 buttonWrap row']/div/button"))
                .click();

    }
}
