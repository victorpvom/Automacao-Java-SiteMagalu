package steps_definition;

import base_class.BaseSteps;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import page_objects.PesquisaPage;
import page_objects.ResultadosPage;

public class GooglePesquisaSteps extends BaseSteps
{
    /**
     * Paginas necessaria
     **/
    PesquisaPage pageHome     = new PesquisaPage(BaseSteps.browser);
    ResultadosPage pageResult = new ResultadosPage(BaseSteps.browser);


    @Dado("^que eu esteja na pagina inicial da Magazine Luiza$")
    public void que_eu_esteja_na_pagina_inicial_da_Magazine_Luiza() throws Throwable {
        pageHome.abrirPagina();
        String expectedPage = pageHome.getUrl();
        String currentPage = browser.getCurrentUrl();
        Assert.assertTrue( expectedPage.equals(currentPage) );
        BaseSteps.screenShotNow();
    }

    @Quando("^eu pesquisar por um produto$")
    public void eu_pesquisar_por_um_produto() throws Throwable {
        pageHome.preencherFormPesquisa("Motorola");
        pageHome.clickBtnPesquisar();
    }

    @Entao("^a plataforma me retorna os produtos disponíveis$")
    public void a_plataforma_me_retorna_os_produtos_disponíveis() throws Throwable {
        String txtAssertPage = pageResult.verResultadoPesquisa();
        String MsgExpect = "produtos encontrados";
        System.out.println(txtAssertPage);
        System.out.println(MsgExpect);
        Assert.assertTrue(txtAssertPage.equals(MsgExpect));
    }

//    @Entao("^me retorna os resultados indexados$")
//    public void me_retorna_os_resultados_indexados()
//    {
//        String txtAssertPage = pageResult.verResultadoPesquisa();
//        Assert.assertEquals("Aproximadamente", txtAssertPage);
//        BaseSteps.screenShotNow();
//    }



    /**
     * Cenario: Pesquisa Valida
     * @pesquisaSuccess
     **/
//    @Quando("^eu pesquisar sem preencher o assunto$")
//    public void eu_pesquisar_sem_preencher_o_assunto()
//    {
//        pageHome.clickBtnPesquisar();
//        BaseSteps.screenShotNow();
//    }

//    @Entao("^continuarei na mesma pagian aguardando um assunto$")
//    public void continuarei_na_mesma_pagian_aguardando_um_assunto()
//    {
//        String expectedPage = pageHome.getUrl();
//        String currentPage = browser.getCurrentUrl();
//        Assert.assertTrue( expectedPage.equals(currentPage) );
//    }

}
