package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Klasa koja predstavlja formu za logovanje na web stranici.
 */
public class LoginForm {
    private final WebDriver driver;

    // Lokator za naslov forme za logovanje
    private final By loginFormTitle = By.className("LoginContent_title__Oh2DN");

    // Konstruktor
    public LoginForm(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Metoda koja proverava da li je naslov forme za logovanje prikazan.
     * @return True ako je naslov forme prikazan, False ako nije.
     */
    public boolean isLoginFormDisplayed() {
        WebElement titleElement = driver.findElement(loginFormTitle);
        return titleElement.isDisplayed();
    }
}
