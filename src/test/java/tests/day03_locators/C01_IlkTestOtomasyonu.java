package tests.day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_IlkTestOtomasyonu {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe"); // 1.adim
        WebDriver driver = new ChromeDriver(); // 2.adim
        driver.manage().window().maximize(); // 3.adim tam ekran yapiyoruz
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 4.adim sayfanin yuklenmesi ve web elementlerinin bulunmasi icin
        // yaklasik bir bekleme degeri

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusuna "Nutella" yazdirip aratin
        // arama kutusu bir web element
        // arama kutusuna gondermek istedigimiz bizim driver'imiz


        // once arama kutusunu findElement() ve Locator ile driver'a tanitip
        // o webelementi bu class'da kullanabilecegim sekilde kaydetmeliyim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));


        /*
        33.satir aciklamasi
        benim driver'im (By.id("twotabsearchtextbox")) locator'ini kullanarak
        findElement methodu sayesinde gitti web sayfasindaki arama kutusunun
        web elementini buldu. onu benim class'ima getirdi bende onu
        - WebElement aramaKutusu - kaydettim.Artik bu classta benim bir daha
        bunun icin locator bulmama bu methodu calistirmama gerek yok cunku artik
        ben Amazon sayfasindaki arama kutusunun web elementini kendi class'imda
        bir variable olarak kaydettim. artik o bende var.
         */


         /*
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();
        web element ile islem yaparken EENTER tusuna basma islemini yapar.
        bu islemi 2 satirda yapmak yerine isterseniz
        asagidaki gibi de yapabilirsiniz
         */

        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // arama sonuclarinin "Nutella" icerdigini test edin


        // By.className locator'i class attribute'unun degeri bosluk icerdiginde
        // saglikli CALISMAZ
        // Cogunlukla class ismi ayni ozelliklerdeki webelementleri
        // gruplandirmak icin kullanilir
        // Biz de class degeri sg-col-inner arattigimizda 73 tane webelement buldu

// WebElement aramaSonucElementi= driver.findElement(By.className("sg-col-inner"));

        List<WebElement> elementlerListesi = driver.findElements(By.className("sg-col-inner"));
        String actualAramaSonucu = elementlerListesi.get(0).getText();
        String expectedIcerik = "Nutella";

        if (actualAramaSonucu.contains("Nutella")) {
            System.out.println("Ilk otomasyon testi PASSED");
        } else {
            System.out.println("Ilk otomasyon testi FAILED");
        }


        driver.close();
    }
}

        /*
        bu class'tan neler ogrendik
        1- bir webelementi driver'a tanitmak icin findElement methodu kullanilir.
        2- eger bizim findElement methodu bir tane degilde 70 tane sonuc donduruyorsa o zaman findElements
           deriz ve bunu bir listeye kaydederiz.Listeden istedigimiz index'teki webelementi alabiliriz.
        3-By.className kullandigimiz zaman eger class attribute'unun degeri bosluk iceriyorsa
          saglikli calismiyordu.

          class isimleri benzer ozelliklerdeki elemanlari bir araya toplamak icin kullanilir.
         */



