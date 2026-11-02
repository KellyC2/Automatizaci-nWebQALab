
package com.nttdata.stepsDefinitions;

import com.nttdata.steps.HomeSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.*;

public class LoginStepsDef {

    private WebDriver driver;

    private LoginSteps loginSteps(WebDriver driver) {
        return new LoginSteps(driver);
    }
    private HomeSteps homeSteps (WebDriver driver) {
        return new HomeSteps(driver);
    }

    @Dado("estoy en la página de la tienda")
    public void estoy_en_la_pagina_de_la_tienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @Cuando("me logueo con mi usuario: {string} y contraseña: {string}")
    public void meLogueoConMiUsuarioYContraseña(String email, String contraseña) {

        driver = getDriver();

        homeSteps(driver).clickLoginLink();
        loginSteps(driver).ingresoUsuarioYContraseña(email, contraseña);

        screenShot();
    }

    @Entonces("valido que la autenticación sea rechazada")
    public void validoQueLaAutenticaciónSeaRechazada() {
        driver = getDriver();

        loginSteps(driver).validarRechazoAutenticacion();

        screenShot();
    }


    @Y("permanezco en la pantalla de inicio de sesión")
    public void permanezcoEnLaPantallaDeInicioDeSesión() {
        driver = getDriver();

        if (!loginSteps(driver).isLoginFormDisplayed()) {
            throw new AssertionError(
                    "El usuario no permanece en la pantalla de inicio de sesión"
            );
        }

        System.out.println("Validación exitosa: permanece en login");

        screenShot();
    }
}