package d24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {

//        2. Zadatak
//    • Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//            ◦ Visit Paris
//        ◦ Visit Prague
//        ◦ Visit London
//        ◦ Visit New York
//        ◦ Visit Belgrade
//    • Maksimizirati prozor
//    • Ucitati stranicu https://example.cypress.io/todo
//            • Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//        ◦ Nakon svakog unosa todo-a, unosi se enter
//    • Cekanje od 5s
//    • Zatvorite pretrazivac

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver mojDriver = new ChromeDriver();

        ArrayList<String> nizTodoA = new ArrayList<>();
        nizTodoA.add("Visit Paris");
        nizTodoA.add("Visit Prague");
        nizTodoA.add("Visit London");
        nizTodoA.add("Visit New York");
        nizTodoA.add("Visit Belgrade");

        Thread.sleep(1000);
        mojDriver.manage().window().maximize();

        mojDriver.get("https://example.cypress.io/todo");
        for (int i = 0; i < nizTodoA.size(); i++) {
            WebElement whatNeedsToBeDone = mojDriver.findElement(By.xpath("//input[@class='new-todo']"));
            whatNeedsToBeDone.sendKeys(nizTodoA.get(i));
            Thread.sleep(1000);
            whatNeedsToBeDone.sendKeys(Keys.ENTER);
        }

        Thread.sleep(5000);
        mojDriver.quit();

    }
}
