package tests.day02_driverMethodlari_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C03_driverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver(); // Selenium'un kendi webdriver'ini kullanir
        driver.manage().window().maximize(); // bunu tam ekran yapiyorum

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // sayfa basliginin "smile more" icerdigini test edin
        String expectedTitleIcerik = "smile more";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {
            System.out.println("Amazon title testi PASSED");
        } else {
            System.out.println("Amazon title testi FAILED");
        }

        // youtube anasayfaya gidin
        driver.navigate().to("https://www.youtube.com");

        // url'in "youtube" icerdigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Youtube url testi PASSED");
        } else {
            System.out.println("Youtube url testi FAILED");
        }


        driver.navigate().back(); // tekrar amazon anasayfaya donun

        String unExpectedUrlIcerik = "ramazon"; // ve url'in "ramazon" ICERMEDIGINI test edin
        actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(unExpectedUrlIcerik)) {
            System.out.println("Amazon url testi FAILED");
        } else {
            System.out.println("Amazon url testi PASSED");
        }


        driver.navigate().forward(); // tekrar youtube anasayfaya gidin

        String expectedSayfaIcerik = "music"; // sayfa kaynak kodlarinda "music" gectigini
        // test edin
        String actualSayfaKaynakKodlari = driver.getPageSource();

        if (actualSayfaKaynakKodlari.contains(expectedSayfaIcerik)) {
            System.out.println("Youtube kaynak kodu testi PASSED");
        } else {
            System.out.println("Youtube kaynak kodu testi FAILED");
        }

        driver.close(); // sayfayi kapatin
    }
}
