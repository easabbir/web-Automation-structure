package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.DriverSetup;

public class TestFrameElement extends DriverSetup {
    By mouse_hover_section = By.xpath("//legend[normalize-space()='Mouse Hover Example']");
    By register_button = By.xpath("//a[normalize-space()='Register']");
    By iframe = By.id("courses-iframe");

    @Test
    public void testIFrame() throws InterruptedException {
        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");
        Actions actions = new Actions(getDriver());
        actions.scrollByAmount(0, 1000).build().perform();


        System.out.println(getDriver().findElement(mouse_hover_section).getText());

//        driver.switchTo().frame("courses-iframe");
//        driver.switchTo().frame("iframe-name");
//        driver.switchTo().frame(0);
        WebElement el = getElement(iframe);
        getDriver().switchTo().frame(el);
        System.out.println(getDriver().findElement(register_button).getText());
//        driver.switchTo().parentFrame();
        getDriver().switchTo().defaultContent();
        System.out.println(getDriver().findElement(mouse_hover_section).getText());

        Thread.sleep(3000);

    }
}
