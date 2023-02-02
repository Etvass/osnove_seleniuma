package d30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {

//        1. Zadatak
//    Napisati program koji testira infinity scroll.
//            • Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//            • Selektujte delay od 2000ms, koristeci Select klasu.
//    • Skrol do Show more dugmeta koje se nalazi na dnu stranice
//    • Sacekajte da dugme bude klikljivo
//    • Klik na Show more dugme
//    • Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//    • Sacekajte da dugme vise ne bude klikljivo
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver mojDrajver = new ChromeDriver();
        mojDrajver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(mojDrajver, Duration.ofMillis(20000));
        Thread.sleep(1000);
        mojDrajver.manage().window().maximize();
        mojDrajver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        WebElement e1 = mojDrajver.findElement(By.id("delay-select"));
        Select select = new Select(e1);
        select.selectByVisibleText("2000ms");
        new Actions(mojDrajver).scrollToElement(mojDrajver.findElement(By.id("infinite-scroll-button"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("infinite-scroll-button")));
        mojDrajver.findElement(By.id("infinite-scroll-button")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.id("sentinel"), 8));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("infinite-scroll-button")));

        Thread.sleep(3000);
        mojDrajver.quit();


    }
}
