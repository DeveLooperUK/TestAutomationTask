package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
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

    public ArrayList<String> addToWishlistFourItems(){
        List<String> allItemsNames = BrowserUtils.getElementsText(itemsTitle);
        ArrayList<String> selectedItemsNames = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int n = (int)(Math.random() * (12));
            if (addToWishlist.get(n).getText().equals("Product added! Browse wishlist")) {
                n = (int)(Math.random() * (12));
                if (addToWishlist.get(n).getText().equals("Product added! Browse wishlist")) {
                    n = (int)(Math.random() * (12));
                    selectedItemsNames.add(allItemsNames.get(n));
                    addToWishlist.get(n).click();
                    BrowserUtils.waitFor(1);
                }
                else{
                    selectedItemsNames.add(allItemsNames.get(n));
                    addToWishlist.get(n).click();
                    BrowserUtils.waitFor(1);
                }
            }
            else {
                selectedItemsNames.add(allItemsNames.get(n));
                addToWishlist.get(n).click();
                BrowserUtils.waitFor(1);
            }
        }

        // verify the list
        System.out.println("allItemsNames= " + allItemsNames);
        System.out.println("selectedItemsNames= " + selectedItemsNames);
        return selectedItemsNames;
    }
}
