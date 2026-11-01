package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductPage {

    public static By firstProduct = By.cssSelector(
            "a.product-thumbnail"
    );
    public static By sizeSelector = By.id("group_1");

    public static By blackColor = By.cssSelector(
            "input[name='group[2]'][value='11']"
    );

    public static By quantityInput = By.id("quantity_wanted");

    public static By addToCartButton = By.cssSelector(
            "button[data-button-action='add-to-cart']"
    );

    public static By confirmationMessage = By.id("myModalLabel");

    // Datos del producto en el popup
    public static By unitPrice = By.cssSelector("p.product-price");

    public static By productQuantity = By.cssSelector(
            "span.product-quantity strong"
    );

    // Total del producto en el popup
    public static By productTotal = By.cssSelector(
            "p.product-total .value"
    );

    public static By finishPurchaseButton = By.cssSelector(
            "a.btn.btn-primary[href*='carrito?action=show']"
    );

    public static By cartTitle = By.cssSelector("h1.h1");

    // Precio unitario del producto en el carrito
    public static By cartUnitPrice = By.cssSelector(
            "div.current-price span.price"
    );

    // Cantidad del producto en el carrito
    public static By cartQuantity = By.cssSelector(
            "input.js-cart-line-product-quantity"
    );

    // Total de la compra con impuestos incluidos
    public static By cartTotal = By.cssSelector(
            "div.cart-summary-line.cart-total span.value"
    );

}
