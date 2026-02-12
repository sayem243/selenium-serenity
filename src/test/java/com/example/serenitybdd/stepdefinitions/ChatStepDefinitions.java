package com.example.serenitybdd.stepdefinitions;

import com.example.serenitybdd.steps.ChatSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class ChatStepDefinitions {

    @Steps
    ChatSteps chatSteps;

    @Given("the user navigates to {string}")
    public void userNavigatesTo(String url) {
        chatSteps.navigateTo(url);
    }

    @And("the user clicks the chat icon using xpath {string}")
    public void userClicksTheChatIconUsingXpath(String chatIconXpath) {
        chatSteps.clickChatIcon(chatIconXpath);
        Assert.assertTrue("Chat panel should open or click interaction should succeed",
                chatSteps.validateChatPanelOrClickResult());
    }
}
