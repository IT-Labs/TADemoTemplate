package tests.webTemplateTests;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTests extends TestBase {

    @Test
    public static void verifyMenuItems(){
        Assert.assertTrue(driver.findElement(By.linkText("HOME")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("ABOUT")).isDisplayed());
    }
}
