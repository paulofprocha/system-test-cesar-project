package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {

    private WebDriver driver;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    //Localiza elementos da página
    private By localRetirada = By.cssSelector(".ss_pickup .ss_pickup_location");
    private By localDevolucao = By.cssSelector(".ss_dropoff .ss_pickup_location");

    //Interações
    public String pegaLocalRetirada(){
        return driver.findElement(localRetirada).getText();
    }

    public String pegaLocalDevolucao(){
        return driver.findElement(localDevolucao).getText();
    }
}