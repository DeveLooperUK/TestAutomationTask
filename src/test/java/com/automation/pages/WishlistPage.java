package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WishlistPage extends BasePage{

    public WishlistPage() { PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/article/div/div/div[1]/form/table/tbody/tr/td[3]/a")
    public List<WebElement> wishlistElementsNames;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/article/div/div/div[1]/form/table/tbody/tr/td[4]")
    public List<WebElement> wishlistElementsPrices;

    @FindBy(xpath = "//form/table/tbody/tr/td[6]/a")
    public List<WebElement> addToCartButton;
}
