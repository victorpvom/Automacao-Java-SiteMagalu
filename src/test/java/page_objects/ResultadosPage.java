package page_objects;

import base_class.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadosPage extends BasePage
{
    private By txtResultado	= By.cssSelector("#__next > div > main > section:nth-child(5) > div.sc-GEbAx.hGlkHc > div > p");
    private By txtResultPescVazio = By.cssSelector("#__next > div > main > section:nth-child(6) > div:nth-child(1) > div > h1");

    public ResultadosPage(WebDriver _browser)
    {
        super(_browser);
    }

    public String verResultadoPesquisa()
    {
        waitElementVisible(txtResultado, 5);
        return browser.findElement(txtResultado).getText().substring(5,25);
    }

    public String verResultadoCampoVazio(){
        waitElementVisible(txtResultPescVazio, 5);
        return browser.findElement(txtResultPescVazio).getText();
    }

    public String verResultadoPesquisaInvalida(){
        waitElementVisible(txtResultPescVazio, 5);
        String str = browser.findElement(txtResultPescVazio).getText();
        return str.substring(str.length()-32, str.length());
    }

}
