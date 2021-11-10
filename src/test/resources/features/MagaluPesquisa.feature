#language: pt
@pesquisaMagazine
Funcionalidade: Magazine Luiza Pesquisa

  @pesquisaSucesso
  Cenario: Pesquisa Válida
    Dado que eu esteja na pagina inicial da Magazine Luiza
    Quando eu pesquisar por um produto
    Entao a plataforma me retorna os produtos disponíveis

  @pesquisaCampoVazio
  Cenario: Buscar por produto - Campo de pesquisa vazio
    Dado que eu esteja na pagina inicial da Magazine Luiza
    Quando o usuario busca sem preencher o campo de pesquisa
    Entao o sistema me informa que nao encontrou resultados

  @pesquisaInvalida
  Cenario: Busca produto inválida
    Dado que eu esteja na pagina inicial da Magazine Luiza
    Quando eu pesquisar por um produto invalido
    Entao o sistema me informa que nao encontrou resultados para a busca