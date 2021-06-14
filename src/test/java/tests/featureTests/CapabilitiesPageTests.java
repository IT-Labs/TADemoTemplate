package tests.featureTests;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CapabilitiesPageTests extends TestBase {

    @Test
    private void verifyPageTitle(){
        driver.findElement(By.partialLinkText("CAPABILITIES")).click();
        Assert.assertEquals("Capabilities - IT Labs", driver.getTitle());
    }
}