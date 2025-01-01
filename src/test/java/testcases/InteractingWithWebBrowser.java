package testcases;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import utilities.DriverSetup;

import java.util.ArrayList;
import java.util.List;

public class InteractingWithWebBrowser extends DriverSetup {
    @Test
    public void testInteractionWithBrowser() throws InterruptedException {
        getDriver().get("https://www.google.com");
        String title = getDriver().getTitle();
        System.out.println(title);
        String url = getDriver().getCurrentUrl();
        System.out.println(url);
        getDriver().manage().window().fullscreen();
        Thread.sleep(2000);
        getDriver().manage().window().minimize();
        Thread.sleep(2000);
        getDriver().manage().window().maximize();
        Thread.sleep(2000);
        getDriver().navigate().to("https://www.facebook.com");
        Thread.sleep(2000);
        getDriver().navigate().back();
        Thread.sleep(2000);
        getDriver().navigate().forward();
        Thread.sleep(2000);
        getDriver().navigate().refresh();
        Thread.sleep(2000);

        getDriver().switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        getDriver().switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(2000);

        String windowHandle = getDriver().getWindowHandle();
        System.out.println(windowHandle);

        List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());

        for (String handle: windowHandles){
            getDriver().switchTo().window(handle);
            if (getDriver().getTitle().equals("Facebook – log in or sign up")){
                break;
            }
            System.out.println(handle);
        }


        Thread.sleep(2000);
        getDriver().close();

    }
}
