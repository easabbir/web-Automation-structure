package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.DriverSetup;

public class HandleWebAlert extends DriverSetup {

    @Test
    public void testAlert() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Thread.sleep(2000);

        Alert alert = getDriver().switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();
        Thread.sleep(2000);

        getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        alert = getDriver().switchTo().alert();
        Thread.sleep(2000);
        System.out.println(alert.getText());

        alert.dismiss();

        Thread.sleep(2000);
        By jsPrompt = By.xpath("//button[@onclick='jsPrompt()']");
        getDriver().findElement(jsPrompt).click();
        alert = getDriver().switchTo().alert();
        Thread.sleep(2000);
        System.out.println(alert.getText());

        alert.sendKeys("Hello");

        alert.accept();

        Thread.sleep(2000);
    }
}
