package com.example.tests;

import com.example.pages.MainPage;
import com.example.pages.BluzePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

/**
 * Testiranje funkcionalnosti pretrage proizvoda na sajtu KupujemProdajem.
 * Ovaj test proverava da li je broj rezultata pretrage veći od 1000 kada se koriste određeni filteri.
 */

public class CustomSearchTest {
    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp() {
        // Automatsko postavljanje ChromeDriver-a
        WebDriverManager.chromedriver().setup();

        // Inicijalizacija WebDriver-a
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Inicijalizacija Page Object-a
        mainPage = new MainPage(driver);
    }

    @Test
    public void testCustomSearch() {
        // Otvaranje početne stranice
        mainPage.open();

        // Klik na dugme "Pretražite detaljno"
        mainPage.clickDetailedSearchButton();

        // Izbor kategorije i grupe
        mainPage.selectCategoryAndGroup("Odeća | Ženska", "Bluze");

        // Unos cene
        mainPage.enterPriceFrom("100");

        // Klik na checkbox "Samo sa cenom"
        mainPage.clickOnlyWithPriceCheckbox();

        // Izbor valute
        mainPage.inputCurrency("din");

        // Izbor stanja
        mainPage.selectCondition("Novo");
        mainPage.selectCondition("Kao novo (nekorišćeno)");

        // Klik na dugme "Primeni filtere"
        mainPage.clickApplyFiltersButton();

        // Provera broja rezultata pretrage
        BluzePage bluzePage = new BluzePage(driver);
        int searchResultCount = bluzePage.extractSearchResultCount();

        // Provera da li je broj rezultata pretrage veći od 1000
        assertTrue("Broj rezultata pretrage nije veći od 1000", searchResultCount > 1000);
    }

    @After
    public void tearDown() {
        // Zatvaranje pretraživača
        driver.quit();
    }
}
