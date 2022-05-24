package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShopPage extends BasePage{
    public ShopPage() { PageFactory.initElements(Driver.get(), this);}

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/article/ul/li/div/div[2]/div/div")
    public List<WebElement> addToWishlist;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/article/ul/li/a[1]/h2")
    public List<WebElement> itemsTitle;

    public By addToWishlistLocator = By.xpath("/html/body/div[3]/div[3]/div/div/article/ul/li/div/div[2]/div/div");

    public List<String> addToWishlistFourItems(){
        List<String> allItemsNames = BrowserUtils.getElementsText(itemsTitle);
        List<String> selectedItemsNames = new ArrayList<>();
        List<WebElement> addToWishlistByBy = Driver.get().findElements(addToWishlistLocator);

        for (int i = 0; i < 4; i++) {
            int n = (int)(Math.random() * (12-i));
            selectedItemsNames.add(allItemsNames.get(n));
            addToWishlistByBy.get(n).click();
            System.out.println("addToWishlistStaticBEFORE size: " + addToWishlistByBy.size());
            System.out.println("allItemsNamesBEFORE size: " + allItemsNames.size());
            BrowserUtils.waitFor(1);
            addToWishlistByBy.remove(n);
            allItemsNames.remove(n);
            System.out.println("addToWishlistStaticAFTER size: " + addToWishlistByBy.size());
            System.out.println("allItemsNamesAFTER size: " + allItemsNames.size());
            BrowserUtils.waitFor(1);
        }

        // verify the list
        System.out.println("allItemsNames= " + allItemsNames);
        System.out.println("selectedItemsNames= " + selectedItemsNames);
        return selectedItemsNames;
    }
}
