package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@title='Shop']")
    public WebElement shopModule;

    @FindBy(xpath = "(//*[@title='Wishlist'])[1]")
    public WebElement wishlistHeart;

    @FindBy(xpath = "(//*[@class='la la-shopping-bag'])[1]")
    public WebElement cartBag;
}
