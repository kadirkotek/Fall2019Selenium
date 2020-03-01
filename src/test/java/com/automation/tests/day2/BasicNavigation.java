package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation  {
    public static void main(String[] args) throws Exception {
        //to start selenium script we need :
        //setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        Thread.sleep(3000);

        String title = driver.getTitle();
        String expectedTtitle = "Google";

        System.out.println("Title is "+title);

        if (expectedTtitle.equals(title)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("FAILED");
        }

        driver.navigate().to("http://amazon.com");

        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("FAILED");
        }
        driver.navigate().back();
        Thread.sleep(3000);

        verifyEquals(driver.getTitle(),"Google");


        driver.navigate().forward();

        Thread.sleep(3000);
        driver.navigate().refresh();
        System.out.println("title = "+driver.getTitle());




        driver.close();
    }
    public static void verifyEquals(String arg1 , String arg2){
        if (arg1.equals(arg2)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Failed");
        }
    }
}
