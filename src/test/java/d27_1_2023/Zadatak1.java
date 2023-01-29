package d27_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Zadatak1 {

//    .Zadatak
//    • Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//            • Klik na svako dugme od PRIMARY do DARK
//    • Sacekati da se toasts u desnom gornjem uglu pojavi
//    • Pauza izmedju klikova 1s
//    • Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver mojDrajver = new ChromeDriver();
        mojDrajver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        mojDrajver.manage().window().maximize();
        mojDrajver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        Thread.sleep(1000);

        List<WebElement> sareniDugmici = mojDrajver.findElements
                (By.xpath("//button[contains(@id, 'basic-')]"));

        List<WebElement> baneri = mojDrajver.findElements(By.xpath("//div[contains(@id, 'basic-')]"));

        for (int i = 0; i < sareniDugmici.size(); i++) {
            Thread.sleep(2000);
            sareniDugmici.get(i).click();
            Thread.sleep(500);
            if (!baneri.get(i).isDisplayed()) {
                i=8;
                System.out.println(i+1+". baner se nije pojavio");
            }
        }

        Thread.sleep(2000);
        mojDrajver.quit();

    }
}
