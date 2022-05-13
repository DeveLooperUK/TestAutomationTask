package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
    public CartPage() { PageFactory.initElements(Driver.get(), this);}

    @FindBy(xpath = "//tbody/tr[1]/td[4]/span/bdi")
    public WebElement priceItemInCart;
}
