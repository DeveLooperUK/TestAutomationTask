package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
//    public BasePage() {
//        PageFactory.initElements(Driver.get(), this);
//    }
//
//    @FindBy(xpath = "//*[@title='Shop']")
//    public WebElement shopModule;
//
//    @FindBy(xpath = "(//*[@title='Wishlist'])[1]")
//    public WebElement wishlistHeart;
//
//    @FindBy(xpath = "(//*[@class='la la-shopping-bag'])[1]")
//    public WebElement cartBag;

    // By class is more stable than PagFactory class above although either can be used in this framework
    public By shopModule1 = By.xpath("//*[@title='Shop']");
    public By wishlistHeart1 = By.xpath("(//*[@title='Wishlist'])[1]");
    public By cartBag1 = By.xpath("(//*[@class='la la-shopping-bag'])[1]");
}
