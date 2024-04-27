package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;
    private static final String HOMEPAGE_URL = "https://www.kupujemprodajem.com/";

    // Lokatori
    private final By detailedSearchButtonLocator = By.xpath("//button[@aria-label='Pretražite detaljno ']");
    private final By categoryDropdownLocator = By.id("react-select-categoryId-input");
    private final By groupDropdownLocator = By.id("react-select-groupId-input");
    private final By priceFromInputLocator = By.id("priceFrom");
    private final By currencyInputLocator = By.id("react-select-currency-input");
    private final By conditionInputLocator = By.id("react-select-condition-input");
    private final By onlyWithPriceCheckboxLocator = By.xpath("//span[contains(text(), 'Samo sa cenom')]");
    private final By applyFiltersButtonLocator = By.xpath("//button[@aria-label='Primeni filtere']");

    // Konstruktor metoda
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metod koji otvara početnu stranicu sa definisanom URL adresom koristeci WebDriver
    public void open() {
        driver.get(HOMEPAGE_URL);
    }

    // Metod koji pronalazi dugme "Pretražite detaljno" i izvršava klik na njega
    public void clickDetailedSearchButton() {
        WebElement button = driver.findElement(detailedSearchButtonLocator);
        button.click();
    }

    // Metod koji bira kategoriju i grupu proizvoda iz padajućih menija
    public void selectCategoryAndGroup(String category, String group) {
        // Klik na padajući meni kategorije
        WebElement categoryDropdownElement = driver.findElement(categoryDropdownLocator);
        categoryDropdownElement.click();

        // Unos teksta kategorije
        categoryDropdownElement.sendKeys(category);
        categoryDropdownElement.sendKeys(Keys.ENTER);

        // Klik na padajući meni grupe
        WebElement groupDropdownElement = driver.findElement(groupDropdownLocator);
        groupDropdownElement.click();

        // Unos teksta grupe
        groupDropdownElement.sendKeys(group);
        groupDropdownElement.sendKeys(Keys.ENTER);
    }

    // Metod koji unosi cenu u polje "Cena od"
    public void enterPriceFrom(String price) {
        WebElement priceFromInputField = driver.findElement(priceFromInputLocator);
        priceFromInputField.clear();
        priceFromInputField.sendKeys(price);
    }

    // Metod koji pronalazi checkbox "Samo sa cenom" i izvršava klik na njega
    public void clickOnlyWithPriceCheckbox() {
        WebElement checkbox = driver.findElement(onlyWithPriceCheckboxLocator);
        checkbox.click();
    }

    // Metod koji unosi valutu u odgovarajuće polje
    public void inputCurrency(String currency) {
        WebElement currencyInputField = driver.findElement(currencyInputLocator);
        currencyInputField.clear();
        currencyInputField.sendKeys(currency);
        currencyInputField.sendKeys(Keys.ENTER);
    }

    // Metod koji bira uslov iz padajućeg menija
    public void selectCondition(String condition) {
        WebElement conditionInputField = driver.findElement(conditionInputLocator);
        conditionInputField.click();

        // Brisanje postojeće vrednosti
        conditionInputField.clear();

        // Unos novog uslova
        conditionInputField.sendKeys(condition);
        conditionInputField.sendKeys(Keys.ENTER);
    }

    // Metod koji pronalazi dugme "Primeni filtere" i izvršava klik na njega
    public void clickApplyFiltersButton() {
        WebElement button = driver.findElement(applyFiltersButtonLocator);
        button.click();
    }

}
