package tests.featureTests;

import base.TestBase;
import org.testng.Assert;

public class HomePageTests extends TestBase {
    private void verifyPageTitle(){
        Assert.assertEquals("Home page - IT Labs", driver.getTitle());
    }
}
