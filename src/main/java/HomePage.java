import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Stack;

public class HomePage extends BasePage {

    SearchBox searchBox ;
    By basketCountLocator = By.id("header__basket--count");
    By basketContainerLocator = By.id("header__icon -shoppingBag");
    By acceptCookiesLocator = By.id("onetrust-accept-btn-handler");

    public HomePage(WebDriver driver) {

        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getBasketCount() > 0 ;
    }

    public void goToCart() {
        click(basketContainerLocator);

    }

    private int getBasketCount(){
       String count = find(basketCountLocator).getText();
       return Integer.parseInt(count);
    }

    public void acceptCookies(){
        if(isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }
}
