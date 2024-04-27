package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Klasa koja predstavlja modal za logovanje na veb stranici.
 */
public class LoginForm {
    private final WebDriver driver;

    // Lokator za naslov modala za logovanje
    private final By loginFormTitle = By.className("LoginContent_title__Oh2DN");

    // Konstruktor
    public LoginForm(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Metoda koja proverava da li je naslov forme za logovanje prikazan.
     * @return True ako je naslov modala prikazan, False ako nije.
     */
    public boolean isLoginModalDisplayed() {
        WebElement titleElement = driver.findElement(loginFormTitle);
        return titleElement.isDisplayed();
    }
}
