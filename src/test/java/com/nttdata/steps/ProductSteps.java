
package com.nttdata.steps;

import com.nttdata.page.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

public class ProductSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public ProductSteps productSteps(WebDriver driver) {
        return new ProductSteps(driver);
    }

    public void seleccionarPrimerProducto() {

        int cantidad = driver.findElements(ProductPage.firstProduct).size();

        System.out.println("Productos encontrados: " + cantidad);

        wait.until(ExpectedConditions.elementToBeClickable(ProductPage.firstProduct))
                .click();
    }

    public void seleccionarTalla(String talla) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.sizeSelector));

        Select size = new Select(driver.findElement(ProductPage.sizeSelector));
        size.selectByVisibleText(talla);
    }

    public void seleccionarColorNegro() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductPage.blackColor))
                .click();
    }

    public void seleccionarCantidad(int cantidad) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.quantityInput))
                .clear();

        driver.findElement(ProductPage.quantityInput)
                .sendKeys(String.valueOf(cantidad));
    }

    public void agregarAlCarrito() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductPage.addToCartButton))
                .click();
    }

    public void configurarYAgregarProducto(String talla, int cantidad) {
        seleccionarTalla(talla);
        //seleccionarColorNegro();
        seleccionarCantidad(cantidad);
        agregarAlCarrito();
    }

    public void validarConfirmacionProductoAgregado() {

        String mensajeObtenido = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ProductPage.confirmationMessage
                )
        ).getText().trim();

        String mensajeEsperado =
                "Producto añadido correctamente a su carrito de compra";

        if (!mensajeObtenido.contains(mensajeEsperado)) {
            throw new AssertionError(
                    "El mensaje de confirmación no es el esperado. " +
                            "Mensaje obtenido: " + mensajeObtenido
            );
        }

        System.out.println("Validación exitosa: " + mensajeObtenido);
    }

    public void validarCalculoPrecioPopup() {

        // Obtener el precio unitario
        String precioTexto = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ProductPage.unitPrice
                )
        ).getText();

        // Obtener la cantidad agregada
        String cantidadTexto = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ProductPage.productQuantity
                )
        ).getText();

        // Obtener el monto total mostrado
        String totalTexto = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ProductPage.productTotal
                )
        ).getText();

        // Convertir los valores a formatos numéricos
        BigDecimal precioUnitario = convertirPrecio(precioTexto);
        int cantidad = Integer.parseInt(cantidadTexto.trim());
        BigDecimal totalObtenido = convertirPrecio(totalTexto);

        // Calcular el total esperado
        BigDecimal totalEsperado = precioUnitario.multiply(
                BigDecimal.valueOf(cantidad)
        );

        // Comparar el total esperado con el mostrado
        if (totalEsperado.compareTo(totalObtenido) != 0) {

            throw new AssertionError(
                    "El cálculo del precio es incorrecto. " +
                            "Total esperado: " + totalEsperado +
                            " | Total obtenido: " + totalObtenido
            );
        }

        System.out.println("Validación del cálculo exitosa");
        System.out.println("Precio unitario: " + precioUnitario);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total esperado: " + totalEsperado);
        System.out.println("Total obtenido: " + totalObtenido);
    }

    private BigDecimal convertirPrecio(String precioTexto) {

        String precioLimpio = precioTexto
                .replace("S/", "")
                .replace("\u00A0", "")
                .trim()
                .replace(",", ".");

        return new BigDecimal(precioLimpio);
    }

    public void finalizarCompra() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        ProductPage.finishPurchaseButton
                )
        ).click();
    }

    public void validarTituloPaginaCarrito() {
        String tituloObtenido = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ProductPage.cartTitle
                )
        ).getText().trim();

        String tituloEsperado = "CARRITO";

        if (!tituloObtenido.equals(tituloEsperado)) {
            throw new AssertionError(
                    "El título de la página no es el esperado. " +
                            "Título obtenido: " + tituloObtenido
            );
        }

        System.out.println("Validación exitosa: " + tituloObtenido);
    }
    public void validarCalculoPrecioCarrito() {

        // Obtener precio unitario
        String precioTexto = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ProductPage.cartUnitPrice
                )
        ).getText();

        // Obtener cantidad desde el atributo value
        String cantidadTexto = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ProductPage.cartQuantity
                )
        ).getAttribute("value");

        // Obtener total de la compra
        String totalTexto = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ProductPage.cartTotal
                )
        ).getText();

        // Convertir los valores
        BigDecimal precioUnitario = convertirPrecio(precioTexto);
        int cantidad = Integer.parseInt(cantidadTexto.trim());
        BigDecimal totalObtenido = convertirPrecio(totalTexto);

        // Calcular total esperado
        BigDecimal totalEsperado = precioUnitario.multiply(
                BigDecimal.valueOf(cantidad)
        );

        // Comparar resultados
        if (totalEsperado.compareTo(totalObtenido) != 0) {
            throw new AssertionError(
                    "El cálculo del precio en el carrito es incorrecto. " +
                            "Total esperado: " + totalEsperado +
                            " | Total obtenido: " + totalObtenido
            );
        }

        System.out.println("Validación del carrito exitosa");
        System.out.println("Precio unitario: " + precioUnitario);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total esperado: " + totalEsperado);
        System.out.println("Total obtenido: " + totalObtenido);
    }


}
