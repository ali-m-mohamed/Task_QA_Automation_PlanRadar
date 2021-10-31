package tests.cartFunc;

import BasePackage.BaseTest;
import Pages.cartFunc.addToCart;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class addToCartTest extends BaseTest {

    private static addToCart addToCart;

    @BeforeClass
    public void initialization() {
        addToCart = new addToCart();
    }


    @Test(priority = 1)
    public void addToCart(){
        addToCart.addToCart();
    }

    @Test(priority = 2)
    public void validateAddToCartSuccessfully(){
        addToCart.validateAddToCartSuccessfully();
    }

    @Test(priority = 3)
    public void deleteProductCartSuccessfully(){
        addToCart.deleteProductCartSuccessfully();
    }
}