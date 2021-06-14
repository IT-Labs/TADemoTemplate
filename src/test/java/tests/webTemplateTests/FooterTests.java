package tests.webTemplateTests;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTests extends TestBase {

    @Test
    private void verifyFooterSection(){
        Assert.assertTrue(driver.findElement(By.id("colophon")).isDisplayed());
    }

    @Test
    private void verifySocialSection(){
        Assert.assertTrue(driver.findElement(By.id("row-142718")).isDisplayed());
    }

    @Test
    private void verifySignUpForm(){
        Assert.assertTrue(driver.findElement(By.id("mc_embed_signup")).isDisplayed());
    }
}
