import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By addToBasketButtonLocator = By.id("product__button -addToCart btn -black");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToBasketButtonLocator);
    }

    public void addToBasket() {
        click(addToBasketButtonLocator);
    }
}
