package com.example.tests;

import com.example.pages.BluzePage;
import com.example.pages.LoginForm;
import com.example.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

/**
 * Testiranje funkcionalnosti dodavanja oglasa iz lista oglasa u adresar na sajtu KupujemProdajem.
 * Ovaj test proverava da li se pri pokušaju dodavanja oglasa u adresar otvara forma za prijavljivanje korisnika.
 */

public class LoginFormTest {
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
    public void testLoginForm() {
        // Otvaranje početne stranice
        mainPage.open();

        // Klik na dugme "Pretražite detaljno"
        mainPage.clickDetailedSearchButton();

        // Izbor kategorije i grupe
        mainPage.selectCategoryAndGroup("Odeća | Ženska", "Bluze");

        // Klik na dugme "Primeni filtere"
        mainPage.clickApplyFiltersButton();

        // Klik na prvi oglas u listi na Bluza stranici
        BluzePage bluzePage = new BluzePage(driver);
        bluzePage.clickFirstAd();

        // Klik na "Dodaj u adresar" dugme iz oglasa
        bluzePage.clickAddToAddressBook();

        // Poziv metode za proveru da li je naslov modala za logovanje prikazan
        LoginForm loginForm = new LoginForm(driver);
        boolean isModalDisplayed = loginForm.isLoginModalDisplayed();

        // Asertacija da li je naslov modala prikazan
        assertTrue("Forma za logovanje nije prikazana", isModalDisplayed);
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
