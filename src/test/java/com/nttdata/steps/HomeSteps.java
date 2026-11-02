package com.nttdata.steps;

import com.nttdata.page.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomeSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void clickLoginLink() {

        wait.until(ExpectedConditions.elementToBeClickable(HomePage.loginLink))
                .click();

        wait.until(ExpectedConditions.urlContains("iniciar-sesion"));
    }

    public void buscarCategoria(String categoria) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.searchInput))
                .sendKeys(categoria);

        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.searchInput))
                .sendKeys(Keys.ENTER);
    }

    public void validarTituloResultadosBusqueda() {

        String tituloObtenido = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        HomePage.searchResultsTitle
                )
        ).getText().trim();

        String tituloEsperado = "RESULTADOS DE LA BÚSQUEDA";

        if(!tituloObtenido.equalsIgnoreCase(tituloEsperado)){
            throw new AssertionError(
                    "El título de resultados no es el esperado. " +
                            "Título obtenido: " + tituloObtenido
            );
        }

        System.out.println("Validación exitosa: " + tituloObtenido);
    }

    public void validarMensajeSinResultados(String mensajeEsperado) {

        String mensajeObtenido = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        HomePage.noSearchResultsMessage
                )
        ).getText().trim();

        if (!mensajeObtenido.equals(mensajeEsperado)) {
            throw new AssertionError(
                    "El mensaje no es el esperado. " +
                            "Mensaje obtenido: " + mensajeObtenido
            );
        }

        System.out.println("Validación exitosa: " + mensajeObtenido);
    }

    public void validarQueNoExistanProductos() {

        int cantidadProductos = driver.findElements(HomePage.productList).size();

        if (cantidadProductos > 0) {
            throw new AssertionError(
                    "Se encontraron productos cuando la búsqueda no debería mostrar resultados. " +
                            "Cantidad encontrada: " + cantidadProductos
            );
        }

        System.out.println("Validación exitosa: no existen productos en los resultados de búsqueda.");
    }
}