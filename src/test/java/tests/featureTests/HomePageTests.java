package tests.featureTests;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    private void verifyPageTitle(){
        Assert.assertEquals("Home page - IT Labs", driver.getTitle());
    }

    @Test
    private void verifySoftwareCompanyLabel(){
        Assert.assertTrue(driver.findElement(By.xpath("//h6/span")).isDisplayed());
    }
}
