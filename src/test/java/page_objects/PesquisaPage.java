package page_objects;

import base_class.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PesquisaPage extends BasePage
{
    private String url			= "https://www.magazineluiza.com.br/";
    private By inputPesrquisar	= By.cssSelector("[data-testid='input-search'");
    private By optionsPesrquisa = By.cssSelector("ul[role='listbox'] > li:nth-child(1)");
    private By btnPesquisar		= By.cssSelector("[data-testid='search-submit'");


    public PesquisaPage(WebDriver _browser)
    {
        super(_browser);
    }

    public void abrirPagina()
    {
        browser.get(url);
    }

    public void preencherFormPesquisa(String pesquisa)
    {
        waitElementVisible(inputPesrquisar, 5);
        browser.findElement(inputPesrquisar).sendKeys(pesquisa);
    }

    public void clickBtnPesquisar() throws InterruptedException
    {
        waitElementVisible(btnPesquisar, 5);
        browser.findElement(btnPesquisar).click();
        Thread.sleep(5000);
    }

    public String getUrl()
    {
        return url;
    }
}
