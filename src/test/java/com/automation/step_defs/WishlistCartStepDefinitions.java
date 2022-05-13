package com.automation.step_defs;

import com.automation.pages.CartPage;
import com.automation.pages.ShopPage;
import com.automation.pages.WishlistPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WishlistCartStepDefinitions {

    static List<String> expectedItems = new ArrayList<>();
    static List<String> actualItems = new ArrayList<>();
    static List<String> allPrices = new ArrayList<>();
    static int indexOfLowestPrice;
    static int lowestPrice;

    WishlistPage wishlistPage = new WishlistPage();
    ShopPage shopPage = new ShopPage();
    CartPage cartPage = new CartPage();


    @Given("I go to website")
    public void i_go_to_website() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        System.out.println("You landed on homepage");
    }

    @Given("I add four different products to my wishlist")
    public void i_add_four_different_products_to_my_wishlist() {
        shopPage.shopModule.click();
        System.out.println("You are in Shop page");
        expectedItems = shopPage.addToWishlistFourItems();
        BrowserUtils.waitFor(1);
    }

    @When("I view my wishlist table")
    public void i_view_my_wishlist_table() {
        wishlistPage.wishlistHeart.click();
        System.out.println("You are in Wishlist page");
        BrowserUtils.waitFor(1);
    }

    @Then("I find total four selected items in my wishlist")
    public void i_find_total_four_selected_items_in_my_wishlist() {
        actualItems = BrowserUtils.getElementsText(wishlistPage.wishlistElementsNames);
        Collections.reverse(actualItems);
        BrowserUtils.waitFor(1);
        List<String> actualItemsFixed = new ArrayList<>();
        for (String e: actualItems) {
            if (e.contains("'")) {
                e = e.replace("'","’");
            }
            actualItemsFixed.add(e);
        }
        Assert.assertEquals("Verify that wishlist is as expected", expectedItems, actualItemsFixed);
    }

    @Given("I search for the lowest price item")
    public void i_search_for_the_lowest_price_item() {
        BrowserUtils.waitFor(1);
        allPrices = BrowserUtils.getElementsText(wishlistPage.wishlistElementsPrices);
        System.out.println(allPrices);
        BrowserUtils.waitFor(1);
        List<Integer> allPricesValue = new ArrayList<>();

        for (String s: allPrices) {
            if (s.length() == 13) {
                allPricesValue.add(Integer. parseInt(s.substring(8,10)));
            }

            else {allPricesValue.add(Integer. parseInt(s.substring(1,3)));}
        }

        BrowserUtils.waitFor(1);
        lowestPrice = Collections.min(allPricesValue);
        System.out.println("lowestPrice = " + lowestPrice);
        indexOfLowestPrice = allPricesValue.indexOf(lowestPrice);
        System.out.println("indexOfLowestPrice = " + indexOfLowestPrice);

    }

    @When("I add the lowest price item to my cart")
    public void i_add_the_lowest_price_item_to_my_cart() {
        BrowserUtils.waitFor(1);
        wishlistPage.addToCartButton.get(indexOfLowestPrice).click();
        System.out.println("You are in Cart page ");
    }

    @Then("I verify the item in my cart")
    public void i_verify_the_item_in_my_cart() {
        BrowserUtils.waitFor(1);
        wishlistPage.cartBag.click();
        BrowserUtils.waitFor(1);
        int expectedPrice = lowestPrice;
        int actualPrice = Integer.parseInt(cartPage.priceItemInCart.getText().substring(1,3));
        Assert.assertEquals("Verify the price is the lowest one", expectedPrice, actualPrice);
    }
}
