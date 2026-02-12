package com.example.serenitybdd.stepdefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverHooks {

    @Before(order = 0)
    public void setupChromeDriverBinary() {
        WebDriverManager.chromedriver().setup();
    }
}
