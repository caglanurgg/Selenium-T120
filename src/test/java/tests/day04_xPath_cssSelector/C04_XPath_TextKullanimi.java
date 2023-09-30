package tests.day04_xPath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_XPath_TextKullanimi {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe"); // 1.adim
        WebDriver driver = new ChromeDriver(); // 2.adim
        driver.manage().window().maximize(); // 3.adim tam ekran yapiyoruz
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 4.adim sayfanin yuklenmesi ve web elementlerinin bulunmasi icin
        // yaklasik bir bekleme degeri


        //** 1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000); // 2 saniye beklesin

        //** 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text() = 'Add Element']")).click();
        /*
        <button onclick="addElement()">Add Element</button>
        buttonla basliyor link olamaz. link olması icin a'la baslaması gerekiyordu
        ama yazisi var
        eger sizin elementinizin ister a olsun ister olmasin bir yazisi varsa
        o zaman onu kullanmak icin XPath'in de bir numarasi var
        yazi oldugunu anlatmak icin text'i Add Element olsun
        yani sadece yazisi olan elementleri de text'le locate edebilirsiniz
        */



        //** 3- Delete butonu’nun gorunur oldugunu test edin
        Thread.sleep(2000); // 2 saniye beklesin
        WebElement deleteButonu = driver.findElement(By.xpath("//*[text() = 'Delete']"));
        // "//*[text() = 'Delete']" tagi ne olursa osun yeter ki text'i Delete olsun

        if (deleteButonu.isDisplayed()){
            System.out.println("Delete buton testi PASSED");
        }else{
            System.out.println("Delete buton testi FAILED");
        }



        deleteButonu.click(); //** 4- Delete tusuna basin
        Thread.sleep(2000); // 2 saniye beklesin

        //**5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//*[text() = 'Add/Remove Elements']"));
        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add/Remove yazi testi PASSED");
        }else {
            System.out.println("Add/Remove yazi testi FAILED");
        }
        Thread.sleep(2000); // 2 saniye beklesin
        driver.close();


    }
}
