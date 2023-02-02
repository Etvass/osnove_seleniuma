package d30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {

//        3. Zadatak
//    Napisati program koji:
//            • Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//    • Implicitno cekanje za trazenje elemenata je maksimalno 10s
//    • Implicitno cekanje za ucitavanje stranice je 5s
//    • Ucitava stranicu https://docs.katalon.com/
//            • Maksimizuje prozor
//    • Od html elementa cita data-theme atribut.
//            • Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//    • Klikce na dugme za zamenu tema
//    • Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//    • Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
//    • Ceka da se dijalog za pretragu pojavi
//    • Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//    • Zatvara pretrazivac

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver mojDrajver = new ChromeDriver();

        mojDrajver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mojDrajver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        mojDrajver.manage().window().maximize();
        mojDrajver.get("https://docs.katalon.com/");
        mojDrajver.findElement(By.tagName("html")).getAttribute("data-theme");
        if (mojDrajver.findElement(By.tagName("html")).getAttribute("data-theme").equals("light")){
            System.out.println("Aktivirana je light tema.");
        }
        mojDrajver.findElement(By.xpath("//div[contains(@class, 'toggle_S7eR')]/button")).click();
        if (mojDrajver.findElement(By.tagName("html")).getAttribute("data-theme").equals("dark")){
            System.out.println("Aktivirana je dark tema.");
        }
        new Actions(mojDrajver).keyDown(Keys.LEFT_CONTROL).sendKeys("k").perform();
        WebDriverWait wait = new WebDriverWait(mojDrajver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("docsearch-input")));
        if (mojDrajver.findElement(By.id("docsearch-input")).getAttribute("type").equals("search")){
            System.out.println("Type = search");
        } else {
            System.out.println("Type nije search");
        }

        Thread.sleep(3000);
        mojDrajver.quit();

    }
}
