package Pages.cartFunc;

import BasePackage.BasePage;
import Utilities.ObjectRepositoryJsonParser;
import Utilities.TimeUtils;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class addToCart extends BasePage {

    SoftAssert softAssert = new SoftAssert();

    public void addToCart() {

        //Click on Hamburger Menu
        WebElement hamburgerMenu = ObjectRepositoryJsonParser.getObjectLocator("$.homePage.hamburgerMenu");
        elementClick(hamburgerMenu);
        TimeUtils.mediumWait();

        //Click on Computer Button
        WebElement computerTab = ObjectRepositoryJsonParser.getObjectLocator("$.menuItems.computerTab");
        elementClick(computerTab);
        TimeUtils.mediumWait();

        //Click on Computer & Tablets Button
        WebElement computerAndTabletsTab = ObjectRepositoryJsonParser.getObjectLocator("$.menuItems.computerAndTabletsTab");
        elementClick(computerAndTabletsTab);
        TimeUtils.mediumWait();

        //Choose Samsung Electronics
        WebElement samsungElectronicsCheckBox = ObjectRepositoryJsonParser.getObjectLocator("$.menuItems.samsungElectronicsCheckBox");
        elementClick(samsungElectronicsCheckBox);
        TimeUtils.mediumWait();

        //Click to any product and add it to the cart
        WebElement samsungProduct = ObjectRepositoryJsonParser.getObjectLocator("$.menuItems.samsungProduct");
        elementClick(samsungProduct);
        TimeUtils.mediumWait();
        WebElement addToCartButton = ObjectRepositoryJsonParser.getObjectLocator("$.menuItems.addToCartButton");
        elementClick(addToCartButton);
        TimeUtils.mediumWait();
    }

    public void validateAddToCartSuccessfully(){

        //Check Success text and cart count
        WebElement successText = ObjectRepositoryJsonParser.getObjectLocator("$.cartPage.successText");
        String successMessage = successText.getText();
        softAssert.assertEquals("Added to Cart",successMessage,"Product Not Added Successfully ");
        WebElement cartCount = ObjectRepositoryJsonParser.getObjectLocator("$.cartPage.cartCount");
        String cartNumber = cartCount.getText();
        softAssert.assertEquals("1",cartNumber,"Number of cart counter should be zero (1)");
        TimeUtils.mediumWait();
    }

    public void deleteProductCartSuccessfully(){

        //Click on Cart Container
        WebElement cartContainer = ObjectRepositoryJsonParser.getObjectLocator("$.cartPage.cartContainer");
        elementClick(cartContainer);

        //Click on Delete Button
        WebElement deleteButton = ObjectRepositoryJsonParser.getObjectLocator("$.cartPage.deleteButton");
        elementClick(deleteButton);

        //Check delete text and cart count
        WebElement deleteText = ObjectRepositoryJsonParser.getObjectLocator("$.cartPage.deleteText");
        String deleteMessage = deleteText.getText();
        softAssert.assertTrue(deleteMessage.contains("removed from Shopping Cart"),"Product Not Deleted Successfully");
        WebElement cartCount = ObjectRepositoryJsonParser.getObjectLocator("$.cartPage.cartCount");
        String cartNumber = cartCount.getText();
        softAssert.assertEquals("0",cartNumber,"Number of cart counter should be zero (0)");
        TimeUtils.mediumWait();
    }
}