package d31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {

//    Zadatak
//    Napisati program koji:
//            • Podesava:
//            ◦ implicitno cekanje za trazenje elemenata od 10s
//        ◦ implicitno cekanje za ucitavanje stranice od 10s
//        ◦ eksplicitno cekanje podeseno na 10s
//    • Podaci:
//            ◦ Potrebno je u projektu ukljuciti 4 slike:
//            ▪ front.jpg
//            ▪ left.jpg
//            ▪ right.jpg
//            ▪ back.jpg
//    • Koraci:
//            ◦ Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//            ◦ Maksimizuje prozor
//        ◦ Klik na edit ikonicu
//        ◦ Klik na delete iz iskacuceg dijaloga
//        ◦ Klik na Add Image dugme
//        ◦ Sacekajte da se pojavi desni meni
//        ◦ Uploadujte front.jpg sliku
//        ◦ Sacekajte da je ispod uploada slike, broj slika 1.
//            ◦ Klik na sliku
//        ◦ Klik na Done dugme
//        ◦ Sacekajte 2s
//        ◦ Klik na Add Image dugme
//        ◦ Sacekajte da se pojavi desni meni
//        ◦ Uploadujte right.jpg sliku
//        ◦ Sacekajte da je ispod uploada slike, broj slika 2.
//            ◦ Klik na sliku
//        ◦ Klik na Done dugme
//        ◦ Sacekajte 2s
//        ◦ Klik na Add Image dugme
//        ◦ Sacekajte da se pojavi desni meni
//        ◦ Uploadujte back.jpg sliku
//        ◦ Sacekajte da je ispod uploada slike, broj slika 3.
//            ◦ Klik na sliku
//        ◦ Klik na Done dugme
//        ◦ Sacekajte 2s
//        ◦ Klik na Add Image dugme
//        ◦ Sacekajte da se pojavi desni meni
//        ◦ Uploadujte back.jpg sliku
//        ◦ Sacekajte da je ispod uploada slike, broj slika 3.
//            ◦ Klik na sliku
//        ◦ Klik na Done dugme
//        ◦ Sacekajte 2s
//        ◦ Sacekajte da Next dugme bude klikljivo
//        ◦ Klik na Next dugme
//        ◦ Unesite tekst
//        ◦ Klik na Next
//        ◦ Klik na Preview
//        ◦ Klik na Add to cart
//        ◦ Sacekajte 5s
//        ◦ Quit

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver mojDrajver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(mojDrajver, Duration.ofSeconds(10));
        mojDrajver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mojDrajver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        mojDrajver.manage().window().maximize();
        mojDrajver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        mojDrajver.findElement(By.className("edit-image")).click();
        Thread.sleep(500);
        mojDrajver.findElement(By.id("image-option-remove")).click();
        Thread.sleep(500);
        String img1 = new File("downloads/guster.jpeg").getAbsolutePath();
        String img2 = new File("downloads/majmun.jpeg").getAbsolutePath();
        String img3 = new File("downloads/medved.jpeg").getAbsolutePath();
        String img4 = new File("downloads/tigar.jpeg").getAbsolutePath();

        mojDrajver.findElement(By.className("edit-image")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'sc-eGugkK brCFVr')]")));
        mojDrajver.findElement(By.id("imageUpload")).sendKeys(img1);
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.id("image-option-0")));
        mojDrajver.findElement(By.id("image-option-0")).click();
        mojDrajver.findElement(By.xpath("//button[contains(@class, 'sc-eDWCr kmMZjW')]")).click();
        Thread.sleep(2000);

        mojDrajver.findElement(By.className("edit-image")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'sc-eGugkK brCFVr')]")));
        mojDrajver.findElement(By.id("imageUpload")).sendKeys(img2);
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.id("image-option-1")));
        mojDrajver.findElement(By.id("image-option-0")).click();
        mojDrajver.findElement(By.xpath("//button[contains(@class, 'sc-eDWCr kmMZjW')]")).click();
        Thread.sleep(2000);

        mojDrajver.findElement(By.className("edit-image")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'sc-eGugkK brCFVr')]")));
        mojDrajver.findElement(By.id("imageUpload")).sendKeys(img3);
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.id("image-option-2")));
        mojDrajver.findElement(By.id("image-option-0")).click();
        mojDrajver.findElement(By.xpath("//button[contains(@class, 'sc-eDWCr kmMZjW')]")).click();
        Thread.sleep(2000);

        mojDrajver.findElement(By.className("edit-image")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'sc-eGugkK brCFVr')]")));
        mojDrajver.findElement(By.id("imageUpload")).sendKeys(img4);
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.id("image-option-3")));
        mojDrajver.findElement(By.id("image-option-0")).click();
        mojDrajver.findElement(By.xpath("//button[contains(@class, 'sc-eDWCr kmMZjW')]")).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button")));
        mojDrajver.findElement(By.id("next-button")).click();
        mojDrajver.findElement(By.id("textareaID")).sendKeys("Tekst");
        mojDrajver.findElement(By.id("next-button")).click();
        mojDrajver.findElement(By.id("next-button")).click();
        mojDrajver.findElement(By.id("next-button")).click();

        Thread.sleep(5000);
        mojDrajver.quit();

    }
}
