package d24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver mojDriver = new ChromeDriver();
        Thread.sleep(1000);
        mojDriver.manage().window().maximize();

        mojDriver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
        for (int i = 0; i < 5; i++) {
            mojDriver.findElement(By.xpath("//button[@type = 'button']")).click();
            mojDriver.findElement(By.name("name")).sendKeys("Viliam Smith");
            mojDriver.findElement(By.name("department")).sendKeys("Biology");
            mojDriver.findElement(By.name("phone")).sendKeys("(589)63258741");
            mojDriver.findElement(By.xpath("//tr[last()]/td[4]/a[@class='add']/i")).click();
        }

        Thread.sleep(3000);
        mojDriver.quit();

    }
}
