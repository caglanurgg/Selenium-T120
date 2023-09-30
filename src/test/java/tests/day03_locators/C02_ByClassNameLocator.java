package tests.day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassNameLocator {

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


        //**3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryList = driver.findElements(By.className("panel-title"));


        //**4- Category bolumunde 3 element oldugunu TEST EDIN
        int expectedCategorySayisi= 3;
        int actualCategorySayisi = categoryList.size();
        if (expectedCategorySayisi == actualCategorySayisi){
            System.out.println("Category sayisi testi PASSED");
        }else{
            System.out.println("Category sayisi testi FAILED");
        }

        //**5- Category isimlerini yazdirin

        // System.out.println(categoryList);
        // Webelement'lerden olusan bir listeyi, direkt yazdiramayiz
        // WebElementler uzerindeki yazilari yazdirmak istersek
        // for-each loop ile her WebElementi ele alip
        // uzerindeki yaziyo yazdirabiliriz

        for (WebElement each:categoryList
        ) {
            System.out.println(each.getText());
        }

        //**6- Sayfayi kapatin
        Thread.sleep(5000);
        driver.close();
    }
}
