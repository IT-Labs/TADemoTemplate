package tests.featureTests;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutPageTests extends TestBase {

    @Test
    private void verifyPageTitle(){
        driver.findElement(By.partialLinkText("ABOUT")).click();
        Assert.assertEquals("About - IT Labs", driver.getTitle());
    }
}