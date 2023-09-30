package tests.day04_xPath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locators {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe"); // 1.adim
        WebDriver driver = new ChromeDriver(); // 2.adim
        driver.manage().window().maximize(); // 3.adim tam ekran yapiyoruz
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 4.adim sayfanin yuklenmesi ve web elementlerinin bulunmasi icin
        // yaklasik bir bekleme degeri

        //**  1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com/");

        //**  2- Arama kutusuna “city bike” yazip aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        // once arama kutusunu findElement() ve Locator ile driver'a tanitip
        // o webelementi bu class'da kullanabilecegim sekilde kaydetmeliyim


        aramaKutusu.sendKeys("city bike" + Keys.ENTER);
        //**  3- Görüntülenen sonuçların sayısını yazdırın
        WebElement sonucYaziElementi = driver.findElement(By.className("sg-col-inner"));
        System.out.println(sonucYaziElementi.getText());

        //**  4- Listeden ilk urunun resmine tıklayın.
        List<WebElement> urunlerListesi = driver.findElements(By.className("s-image"));
        urunlerListesi.get(12).click();


        Thread.sleep(5000);
        driver.close();
    }
}
