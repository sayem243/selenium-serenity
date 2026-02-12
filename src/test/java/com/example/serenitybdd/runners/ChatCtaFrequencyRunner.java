package com.example.serenitybdd.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/chat_cta_frequency.feature",
        glue = "com.example.serenitybdd.stepdefinitions"
)
public class ChatCtaFrequencyRunner {
}
