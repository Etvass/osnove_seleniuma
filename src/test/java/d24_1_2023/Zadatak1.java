package d24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

//        1. Zadatak
//    • Maksimizirati prozor
//    • Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//            • Prijavite se na sistem
//        ◦ Username: Admin
//        ◦ Password: admin123
//    • Cekanje od 5s
//    • U input za pretragu iz navigacije unesite tekst Me
//    • Kliknite na prvi rezultat pretrage (to ce biti Time)
//    • Cekanje od 1s
//    • Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//    • Klinkite na logout
//    • Cekanje od 5s
//    • Zatvorite pretrazivac

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        Thread.sleep(1000);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);

        WebElement username = driver.findElement
                (By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[2]/input"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("admin123");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(5000);

        WebElement search = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));
        search.sendKeys("Me");
        WebElement time = driver.findElement(By.xpath("//a[@class='oxd-main-menu-item']"));
        time.click();
        Thread.sleep(1000);
        WebElement avatar = driver.findElement(By.xpath("//li[@class='oxd-userdropdown']"));
        avatar.click();
        WebElement logOut = driver.findElement(By.xpath
                ("//li[@class='--active oxd-userdropdown']/ul/li[4]"));
        logOut.click();
        Thread.sleep(5000);

        driver.quit();

    }
}
