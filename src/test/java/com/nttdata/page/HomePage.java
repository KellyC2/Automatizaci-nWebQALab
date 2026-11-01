package com.nttdata.page;

import org.openqa.selenium.By;

public class HomePage {
    public static By loginLink = By.xpath(
            "//a[contains(@href, '/iniciar-sesion') and @title='Acceda a su cuenta de cliente']"
    );
}
