package com.nttdata.page;

import org.openqa.selenium.By;

public class CategoryPage {
    public static By clothesCategory = By.id("category-3");

    public static By menSubcategory = By.xpath(
            "//li[@id='category-4']/a"
    );
}
