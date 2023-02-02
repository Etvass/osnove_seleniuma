package d31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {

//    Zadatak
//    Napisati program koji:
//            • Ucitava stranu https://itbootcamp.rs/
//            • Misem prelazi preko Vesti iz navigacionog menija
//    • Ceka da se prikaze padajuci meni za Vesti
//    • Misem prelazi preko Kursevi iz navigacionog menija
//    • Ceka da se prikaze padajuci meni za Kursevi
//    • Misem prelazi preko Prijava i pravilnik iz navigacionog menija
//    • Ceka da se prikaze padajuci meni za Prijava i pravilnik
//    • Koristan link. Mouse over preko
//    seleniuma https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver mojDrajver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(mojDrajver, Duration.ofSeconds(10));
        mojDrajver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mojDrajver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        mojDrajver.manage().window().maximize();
        mojDrajver.get("https://itbootcamp.rs/");

        WebElement vesti = mojDrajver.findElement(By.id("menu-item-6408"));
        WebElement kursevi = mojDrajver.findElement(By.id("menu-item-5362"));
        WebElement prijava = mojDrajver.findElement(By.id("menu-item-5453"));

        new Actions(mojDrajver).moveToElement(vesti).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li[@id='menu-item-6408']/ul[@role='menu']")));
        new Actions(mojDrajver).moveToElement(kursevi).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li[@id='menu-item-5362']/ul[@role='menu']")));
        new Actions(mojDrajver).moveToElement(prijava).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li[@id='menu-item-5453']/ul[@role='menu']")));

        Thread.sleep(3000);
        mojDrajver.quit();

    }
}
