import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestAddProductToCart extends BaseTest {

    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;


    @Test
    @Order(1)
    //@Disabled("Burada ki bug sebebiyle disable durumunda")
    public  void searchProduct(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productPage = new ProductPage(driver);
        homePage.searchBox().search("ceket");
        Assertions.assertTrue(productPage.isOnProductPage() ,
                "Not on products page");

    }

    @Test
    @Order(2)
    public  void selectProduct(){
        productDetailPage = new ProductDetailPage(driver);
        productPage.selectProduct(2);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage() ,
                "Not on product detail page");

    }

    @Test
    @Order(3)
    public  void addProductToBasket(){
        productDetailPage.addToBasket();
        Assertions.assertTrue(homePage.isProductCountUp() ,
                "Product count did not increase");

    }

    @Test
    @Order(4)
    public  void goToBasket(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded() ,
                "Product was not added to basket");

    }

}
