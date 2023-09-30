package tests.day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_LocatorsTagName {
    public static void main(String[] args) throws InterruptedException {

        //**1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe"); // 1.adim
        WebDriver driver = new ChromeDriver(); // 2.adim
        driver.manage().window().maximize(); // 3.adim tam ekran yapiyoruz
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 4.adim sayfanin yuklenmesi ve web elementlerinin bulunmasi icin
        // yaklasik bir bekleme degeri


        //**2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //**3- Sayfada 147 adet link bulundugunu TEST EDIN.
        List<WebElement> linkListesi = driver.findElements(By.tagName("a"));
        int actualLinkSayisi = linkListesi.size();
        int expectedLinkSayisi = 147;

        if (actualLinkSayisi == expectedLinkSayisi){
            System.out.println("Link sayisi testi PASSED");
        }else{
            System.out.println("Link sayisi testi FAILED");
        }

        //**4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();

        //**5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElementi = driver.findElement(By.id("sale_image"));

        if (specialOfferElementi.isDisplayed()){
            System.out.println("Special Offer testi PASSED");
        }else{
            System.out.println("Special Offer testi FAILED");
        }

        //**6- Sayfayi kapatin
        Thread.sleep(5000);
        driver.close();
    }
}
