package steps_definition;

import base_class.BaseSteps;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import page_objects.PesquisaPage;
import page_objects.ResultadosPage;

public class MagaluPesquisaSteps extends BaseSteps
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
        Assert.assertTrue(txtAssertPage.equals(MsgExpect));
    }

    /**
     * Cenario: Pesquisa Campo Vazio
     * @pesquisaSuccess
     **/

    @Quando("^o usuario busca sem preencher o campo de pesquisa$")
    public void o_usuario_busca_sem_preencher_o_campo_de_pesquisa() throws Throwable {
        pageHome.preencherFormPesquisa(" ");
        pageHome.clickBtnPesquisar();
    }

    @Entao("^o sistema me informa que nao encontrou resultados$")
    public void o_sistema_me_informa_que_nao_encontrou_resultados() {
        String MensagemNaTela = pageResult.verResultadoCampoVazio();
        String MensagemEsperada = "Sua busca não encontrou resultado algum :(";
        Assert.assertTrue(MensagemNaTela.equals(MensagemEsperada));
    }

    /**
     * Cenario: Busca produto inválida
     * @pesquisaInvalida
     **/

    @Quando("^eu pesquisar por um produto invalido$")
    public void eu_pesquisar_por_um_produto_invalido() throws Throwable {
        pageHome.preencherFormPesquisa("oiudsiudvpisudo");
        pageHome.clickBtnPesquisar();
    }

    @Entao("^o sistema me informa que nao encontrou resultados para a busca$")
    public void o_sistema_me_informa_que_nao_encontrou_resultados_para_a_busca() throws Throwable {
        System.out.println(pageResult.verResultadoPesquisaInvalida());
    }

}
