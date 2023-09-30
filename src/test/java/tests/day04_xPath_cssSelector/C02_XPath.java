package tests.day04_xPath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XPath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe"); // 1.adim
        WebDriver driver = new ChromeDriver();  // 2.adim
        driver.manage().window().maximize(); // 3.adim tam ekran yapiyoruz
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 4.adim sayfanin yuklenmesi ve web elementlerinin bulunmasi icin
        // yaklasik bir bekleme degeri

        //**1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000); // 2 saniye beklesin

        //**2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@*='addElement()']")).click();
        /*
        25.satir icin
        Relative Xpath bu 3 bilesenin belirlenen sekilde birlikte kullanilmasi ile olusur.
        Her Xpath ile unique bir sonuc elde edilemeyebilir ancak unique bir deger mutlaka
        bulunur.
        //tagName[@attributeIsmi=‘attributeValue']
       "//button[@*='addElement()']"
        tagi button herhangi bir attribute'unun degeri de addElement olan webelementi bul dedik
        o da unique olarak buldu
         */
        Thread.sleep(2000);

        //**3- Delete butonu’nun gorunur oldugunu TEST EDIN
        WebElement deleteButonu = driver.findElement(By.xpath("//button[@*='deleteElement()']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("Delete butonu testi PASSED");
        }else{
            System.out.println("Delete butonu testi FAILED");
        }
        //**4- Delete tusuna basin
        deleteButonu.click();
        Thread.sleep(2000);


        //5- “Add/Remove Elements” yazisinin gorunur oldugunu TEST EDIN
        // WebElement addRemoveYaziElementi = driver.findElement(By.tagName("h3"));
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h3"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add remove yazi testi PASSED");
        }else{
            System.out.println("Add remove yazi testi FAILED");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
