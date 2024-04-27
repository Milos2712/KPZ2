package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BluzePage {
    private final WebDriver driver;

    // Lokator za element koji prikazuje broj rezultata pretrage
    private final By searchResultCount = By.cssSelector(".BreadcrumbHolder_breadcrumbHolder__riFtq span > div > span");
    // Lokator za prvi oglas u listi na Bluza stranici
    private final By firstAdLocator = By.cssSelector(".AdItem_adOuterHolder__lACeh:nth-child(1) .Link_link__2iGTE[aria-label='link']");
    // Locator za "Dodaj u adresar" dugme
    private final By addContactButton = By.xpath("//button[@aria-label='Dodaj u adresar']");


    // Konstruktor
    public BluzePage(WebDriver driver) {
        this.driver = driver;
    }

    // Metod za izdvajanje broja rezultata pretrage
    public int extractSearchResultCount() {
        // Pronalaženje elementa koji sadrži broj rezultata pretrage
        WebElement searchResultCountElement = driver.findElement(searchResultCount);

        // Dobijanje teksta elementa
        String searchResultCountText = searchResultCountElement.getText();

        // Izdvajanje broja iz teksta
        return Integer.parseInt(searchResultCountText.replaceAll("[^0-9]", ""));
    }

    // Klik na prvi oglas u listi na Bluza stranici
    public void clickFirstAd() {
        WebElement firstAd = driver.findElement(firstAdLocator);
        firstAd.click();
    }

    // Klik na "Dodaj u adresar" dugme
    public void clickAddToAddressBook() {
        WebElement addToAddressElement = driver.findElement(addContactButton);
        addToAddressElement.click();
    }
}