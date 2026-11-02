package com.nttdata.page;

import org.openqa.selenium.By;

public class HomePage {
    public static By loginLink = By.xpath(
            "//a[contains(@href, '/iniciar-sesion') and @title='Acceda a su cuenta de cliente']"
    );
    public static By searchInput = By.cssSelector(
            "#search_widget input[name='s']"
    );

    public static final By searchResultsTitle =
            By.id("js-product-list-header");

    public static final By noSearchResultsMessage =
            By.id("product-search-no-matches");
    public static final By productList =
            By.cssSelector("#js-product-list .product");


}
