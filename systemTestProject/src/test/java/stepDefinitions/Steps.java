package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.SearchResultsPage;

import java.util.concurrent.TimeUnit;

public class Steps {

    public WebDriver driver;

    public MainPage mainPage;
    public SearchResultsPage searchResultsPage;

    @Before
    public void beforeScenario(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);
        mainPage = new MainPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @After
    public void afterScenario(){
        this.driver.quit();
    }

    @Given("que um navegador da Web está na página inicial do Rental Cars")
    public void que_um_navegador_da_Web_esta_na_pagina_inicial_do_Rental_Cars() {
        mainPage.accessPage();
    }

    @When("o usuário digita Fortaleza na barra de pesquisa do local de retirada")
    public void o_usuario_digita_Fortaleza_na_barra_de_pesquisa_do_local_de_retirada() {
        mainPage.pesquisaLocalRetirada();
    }

    @Then("sugestões relacionadas com Fortaleza são exibidas logo abaixo do campo de pesquisa")
    public void sugestoes_relacionadas_com_Fortaleza_sao_exibidas_logo_abaixo_do_campo_de_pesquisa() {
        mainPage.aguardaLocalRetirada();
    }

    @Given("que os resultados de pesquisa do Rental Cars para o local Fortaleza são exibidos")
    public void que_os_resultados_de_pesquisa_do_Rental_Cars_para_o_local_Fortaleza_sao_exibidos() {
        mainPage.aguardaLocalRetirada();
    }

    @When("o usuário clica sobre a primeira sugestão que é o resultado desejado Aeroporto de Fortaleza")
    public void o_usuario_clica_sobre_a_primeira_sugestao_que_e_o_resultado_desejado_Aeroporto_de_Fortaleza() {
        mainPage.selecionaLocalRetirada();
    }

    @Then("o campo de local de retirada é preenchido automaticamente com a opção desejada")
    public void o_campo_de_local_de_retirada_e_preenchido_automaticamente_com_a_opcao_desejada() {
        Assert.assertEquals("Aeroporto de Fortaleza (FOR), Brasil", mainPage.validarPreenchimento());
    }

    @Given("que o campo de local de retirada está preenchido")
    public void que_o_campo_de_local_de_retirada_esta_preenchido() {
        mainPage.pesquisaLocalRetirada();
        mainPage.selecionaLocalRetirada();
    }

    @When("o usuário clica na opção pesquisar")
    public void o_usuario_clica_na_opcao_pesquisar() {
        mainPage.pesquisaAluguelCarro();
    }

    @Then("os resultados da pesquisa são apresentados pelo site")
    public void os_resultados_da_pesquisa_sao_apresentados_pelo_site() {
        //Assert???
    }

    @Given("que os resultados da pesquisa foram apresentados na página")
    public void que_os_resultados_da_pesquisa_foram_apresentados_na_pagina() {

    }

    @Then("o sistema exibe o local de retirada")
    public void o_sistema_exibe_o_local_de_retirada() {
        searchResultsPage.pegaLocalRetirada();
    }

    @Then("o local de devolução")
    public void o_local_de_devolucao() {
        searchResultsPage.pegaLocalDevolucao();
    }

    @Given("que o local de retirada")
    public void que_o_local_de_retirada() {
        searchResultsPage.pegaLocalRetirada();
    }

    @Given("o local de devolução foram exibidos")
    public void o_local_de_devolucao_foram_exibidos() {
        searchResultsPage.pegaLocalDevolucao();
    }

    @Then("o local deve ser o mesmo informado no campo de pesquisa")
    public void o_local_deve_ser_o_mesmo_informado_no_campo_de_pesquisa() {
        Assert.assertEquals("Aeroporto de Fortaleza (FOR)", searchResultsPage.pegaLocalRetirada());
        Assert.assertEquals("Aeroporto de Fortaleza (FOR)", searchResultsPage.pegaLocalDevolucao());
    }
}