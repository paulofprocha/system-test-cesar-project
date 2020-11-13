package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

public class MainPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public String pageUrl = "https://www.rentalcars.com/br/";

    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.actions = new Actions(driver);
    }

    public void loadpage (int seconds) {
        try {
            sleep(TimeUnit.SECONDS.toMillis(seconds));
        } catch (InterruptedException e) {
            System.out.println("Exceção da função sleep: \n"+"Mensagem: "+e.getMessage()+"Motivo: "+e.getCause());
        }
    }

    public WebElement findwaitclick (By by){
        return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }

    public void clickable(By by){
        findwaitclick(by).click();
    }

    //Localiza elementos da página
    private By campoLocalRetirada = By.cssSelector("#fts-pickupLocation");
    private By resultadoLocalRetirada = By.cssSelector("#fts-pickupLocationResultsItem-0");
    private By preenchimentoLocalRetirada = By.cssSelector("#fts-pickupLocation");
    private By botaoPesquisar = By.cssSelector("#searchbox-submit");

    //Interações
    public MainPage accessPage(){
        driver.get(this.pageUrl);
        return this;
    }

    public void pesquisaLocalRetirada(){
        driver.findElement(campoLocalRetirada).sendKeys("Fortaleza");
    }

    public void aguardaLocalRetirada(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultadoLocalRetirada));
    }

    public void selecionaLocalRetirada(){
        driver.findElement(resultadoLocalRetirada).click();
    }

    public String validarPreenchimento(){
        return driver.findElement(preenchimentoLocalRetirada).getAttribute("value");
    }

    public void pesquisaAluguelCarro(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(botaoPesquisar));
        loadpage(10);
        clickable(botaoPesquisar);
        //actions.moveToElement(driver.findElement(By.cssSelector("#SearchResultsForm div #btn-fieldset input"))).click().perform();
    }
}