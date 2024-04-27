Automatizacija Testiranja sa Java i Selenium WebDriver-om

Ovaj projekat demonstrira automatizaciju testiranja funkcionalnosti pretrage proizvoda i dodavanja oglasa u adresar na web stranici KupujemProdajem. 
Korišćena je Java zajedno sa Selenium WebDriver-om za pisanje i izvršavanje automatskih testova.

Preduslovi:

Pre pokretanja ovog projekta, potrebno je instalirati sledeće alate:
Java Development Kit (JDK),
Maven,
WebDriverManager.

Instalacija:

Klonirajte ovaj repozitorijum na lokalnu mašinu.
Otvorite projekat u razvojnom okruženju (npr. IntelliJ IDEA, Eclipse).
U terminalu, izvršite sledeću Maven komandu radi instalacije neophodnih zavisnosti: 

mvn clean install

Struktura Projekta

U projektu se nalaze sledeće komponente:

Page Klase
BluzePage: Predstavlja stranicu sa funkcionalnostima za pretragu bluza.
LoginPage: Predstavlja stranicu za prijavljivanje.
MainPage: Predstavlja početnu stranicu sa glavnim funkcionalnostima.

Test Klase
CustomSearchTest: Automatski testovi koji pokrivaju funkcionalnost pretrage proizvoda.
LoginFormTest: Automatski testovi koji pokrivaju funkcionalnost prijavljivanja na stranici.

Pokretanje Testova

Da biste pokrenuli automatske testove, sledite ove korake:
U razvojnom okruženju otvorite na primer klasu CustomSearchTest.java, koja se nalazi u paketu com.example.tests.
Pokrenite test metodom testCustomSearch() koja pokriva scenario pretrage proizvoda.
Nakon završetka testa, proverite rezultate izvršavanja i potvrdu da su testovi uspešno prošli.

Maven Zavisnosti

Informacije iz pom.xml fajla o Maven zavisnostima neophodnim za izvršavanje projekta:
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.20.0</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.8.0</version>
    </dependency>
</dependencies>
