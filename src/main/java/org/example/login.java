package org.example;
import org.junit.Assert;
import org.checkerframework.dataflow.qual.AssertMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class login {
    WebDriver driver ;

  public void setup(){
      driver =new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  public void teardown(){
      driver.quit();
  }
  public void testlogin() throws InterruptedException {
    WebElement username = driver.findElement(By.name("username"));
      WebElement pasword =driver.findElement(By.name("password"));

    username.sendKeys("Admin");
    pasword.sendKeys("admin123");
    driver.findElement(By.cssSelector("[class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
    Thread.sleep(2000);
    String actualresult = driver.findElement(By.tagName("h6")).getText();
    String expectresult ="Dashboard";
    Assert.assertNotEquals(actualresult,expectresult);

  }
}
