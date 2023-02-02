package d31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak3 {

//    Zadatak
//    Napisati program koji:
//            • Ucitava stranicu https://itbootcamp.rs/
//            • Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//    • Cita sve linkove slika iz slajdera
//    • Proverava url svake slike, i za sve slike koje imaju status veci i
//    jednak od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
//    • Azurirajte gitignore da ignorise itbootcamp_slider folder


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver mojDrajver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(mojDrajver, Duration.ofSeconds(10));
        mojDrajver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mojDrajver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        mojDrajver.manage().window().maximize();
        mojDrajver.get("https://itbootcamp.rs/");
        new Actions(mojDrajver).scrollToElement(mojDrajver.findElement(By.className("slider_bkgd"))).perform();
        List<WebElement> lista = mojDrajver.findElements(By.xpath("//div[contains(@class, 'owl-item')]/div/img"));

        for (int i = 0; i < lista.size(); i++) {
            if (new Helper().getHTTPResponseStatusCode(lista.get(i).getAttribute("src")) >= 200 &&
                    new Helper().getHTTPResponseStatusCode(lista.get(i).getAttribute("src")) < 300
            ) {
                new Helper().downloadUsingStream
                        (lista.get(i).getAttribute("src"), "itbootcamp_slider/slika"+i+".jpg");
            } else {
                System.out.println("Element HTTP Status Code is not valid!");
            }
        }

        Thread.sleep(5000);
        mojDrajver.quit();

    }
}
