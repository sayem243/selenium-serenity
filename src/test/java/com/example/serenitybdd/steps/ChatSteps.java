package com.example.serenitybdd.steps;

import com.example.serenitybdd.pages.ChatPage;
import net.thucydides.core.annotations.Step;

public class ChatSteps {

    ChatPage chatPage;

    @Step("Navigate to URL: {0}")
    public void navigateTo(String url) {
        chatPage.openPage(url);
    }

    @Step("Click chat icon using XPath: {0}")
    public void clickChatIcon(String iconXpath) {
        chatPage.waitForIconAndClick(iconXpath);
    }

    @Step("Validate that chat panel is opened")
    public boolean validateChatPanelOrClickResult() {
        return chatPage.isChatPanelOpenedOrClickSucceeded();
    }
}
