package com.nttdata.steps;

import com.nttdata.page.CategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategorySteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public CategorySteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void seleccionarCategoriaClothes() {

        Actions actions = new Actions(driver);

        actions.moveToElement(
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        CategoryPage.clothesCategory
                ))
        ).perform();
    }

    public void seleccionarSubcategoriaMen() {

        wait.until(ExpectedConditions.elementToBeClickable(
                CategoryPage.menSubcategory
        )).click();
    }
}
