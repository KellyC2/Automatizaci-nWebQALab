package com.nttdata.stepsDefinitions;

import com.nttdata.steps.CategorySteps;
import com.nttdata.steps.ProductSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStoreStepsDef {
    WebDriver driver;
    private CategorySteps categorySteps(WebDriver driver) {
        return new CategorySteps(driver);
    }
    private ProductSteps productSteps (WebDriver driver){
        return new ProductSteps(driver);
    }

    @Cuando("navego a la categoría: {string} y subcategoría: {string}")
    public void navegoCategoriaYSubcategoria(String categoria, String subcategoria) {

        driver = getDriver();

        categorySteps(driver).seleccionarCategoriaClothes();
        categorySteps(driver).seleccionarSubcategoriaMen();

        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        driver = getDriver();

        productSteps(driver).seleccionarPrimerProducto();

        productSteps(driver).configurarYAgregarProducto("S", cantidad);

        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        driver = getDriver();

        productSteps(driver).validarConfirmacionProductoAgregado();

        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        driver = getDriver();

        productSteps(driver).validarCalculoPrecioPopup();

        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        driver = getDriver();
        productSteps(driver).finalizarCompra();
        screenShot();
    }

    @Entonces("valido el título de la página del carrito")
    public void validoElTítuloDeLaPáginaDelCarrito() {
        driver = getDriver();
        productSteps(driver).validarTituloPaginaCarrito();
        screenShot();
    }
    @Y("vuelvo a validar el cálculo de precios en el carrito")
    public void vuelvoAValidarElCálculoDePreciosEnElCarrito() {
        driver = getDriver();
        productSteps(driver).validarCalculoPrecioCarrito();
        screenShot();
    }
}
