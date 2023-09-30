package tests.day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_driverObjesi {

    public static void main(String[] args) throws InterruptedException {

        // 1.adıim
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // 2.adim

        driver.manage().window().maximize(); // tam ekran yapmak istiyorsak
        driver.get("https://www.amazon.com");
        // URL yazarken www demesek de istenen URL'e gider
        // ANCAK https:// yazmazsak gitmez

        Thread.sleep(3000);
        driver.close();

    }
}
