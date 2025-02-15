
/**
 * Classe que agrega as descrições das opcoes dos menus de navegação
 * 
 * @author (Carlos Sá A59905, Filipe Oliveira A57816, Sérgio Caldas A57779) 
 * @version (a version number or a date)
 */

public class StringsMenu{

  private String[] opcoesMenuPrincipal;
  {
    opcoesMenuPrincipal = new String[4];
    opcoesMenuPrincipal[0] = "Carregar Ficheiros";
    opcoesMenuPrincipal[1] = "Estatísticas";
    opcoesMenuPrincipal[2] = "Queries Interativas";
    opcoesMenuPrincipal[3] = "Carregar/Guardar estado programa";
  }

  private String[] opcoesMenuCarregarFicheiros;
  {
    opcoesMenuCarregarFicheiros = new String[3];
    opcoesMenuCarregarFicheiros[0] = "Carregar ficheiro de Produtos"; 
    opcoesMenuCarregarFicheiros[1] = "Carregar ficheiro de Clientes";
    opcoesMenuCarregarFicheiros[2] = "Carregar ficheiro de Compras";
  }

  private String[] opcoesMenuEstatisticas;
  {
    opcoesMenuEstatisticas=new String[2];
    opcoesMenuEstatisticas[0] = "Estatisticas 1.1";
    opcoesMenuEstatisticas[1] = "Estatisticas 1.2";
  }

  private String[] opcoesMenuEstatisticas12;
  {
    opcoesMenuEstatisticas12 = new String[4];
    opcoesMenuEstatisticas12[0] = "Número total de compras por mês (não é a facturação)";
    opcoesMenuEstatisticas12[1] = "Facturação total por mês (valor total das compras/vendas) e total global"; 
    opcoesMenuEstatisticas12[2] = "Número de distintos clientes que compraram em cada mês (não interessa quantas vezes o cliente comprou mas apenas quem de facto comprou)";
    opcoesMenuEstatisticas12[3] = "Total de registos de compras inválidos (os registos completos, com os nomes e valores dos respectivos campos, ou seja, não é apenas a linha lida, deverão ser também guardados em ficheiro de texto dado pelo utilizador)";
  }

  private String[] opcoesMenuCarregarProdutos;
  {
    opcoesMenuCarregarProdutos = new String[2];
    opcoesMenuCarregarProdutos[0] = "Carregar ficheiro de Produtos Standard"; 
    opcoesMenuCarregarProdutos[1] = "Carregar ficheiro de Produtos com nome a indiciar";
  }

  private String[] opcoesMenuCarregarClientes;
  {
    opcoesMenuCarregarClientes = new String[2];
    opcoesMenuCarregarClientes[0] = "Carregar ficheiro de Clientes Standard"; 
    opcoesMenuCarregarClientes[1] = "Carregar ficheiro de Clientes com nome a indicar";
  }

  private String[] opcoesMenuCarregarCompras;
  {
    opcoesMenuCarregarCompras = new String[4];
    opcoesMenuCarregarCompras[0] = "Carregar ficheiro de Compras 500 000"; 
    opcoesMenuCarregarCompras[1] = "Carregar ficheiro de Compras 1 000 000";
    opcoesMenuCarregarCompras[2] = "Carregar ficheiro de Compras 3 000 000";
    opcoesMenuCarregarCompras[3] = "Carregar ficheiro de Compras com nome a indicar";

  }

  private String[] opcoesMenuQueriesInterativas;
  {
    opcoesMenuQueriesInterativas = new String[10];
    opcoesMenuQueriesInterativas[0] = "Lista ordenada com os códigos dos produtos nunca comprados e respectivo total";
    opcoesMenuQueriesInterativas[1] = "Lista ordenada com os códigos dos clientes que nunca compraram e seu total;";
    opcoesMenuQueriesInterativas[2] = "Dado um mês válido, determinar o número total de compras e o total de clientes distintos que as realizaram";
    opcoesMenuQueriesInterativas[3] = "Dado um código de cliente, determinar, para cada mês, quantas compras fez, quantos produtos distintos comprou e quanto gastou. Apresentar também o total anual facturado ao cliente";
    opcoesMenuQueriesInterativas[4] = "Dado o código de um produto existente, determinar, mês a mês, quantas vezes foi comprado, por quantos clientes diferentes e o total facturado";
    opcoesMenuQueriesInterativas[5] = "Dado o código de um produto existente, determinar, mês a mês, quantas vezes foi comprado em modo N e em modo P e respectivas facturações";
    opcoesMenuQueriesInterativas[6] = "Dado o código de um cliente determinar a lista de códigos de produtos que mais comprou (e quantos), ordenada por ordem decrescente de quantidade e, para quantidades iguais, por ordem alfabética dos códigos";
    opcoesMenuQueriesInterativas[7] = "Determinar o conjunto dos X produtos mais vendidos em todo o ano (em número de unidades vendidas) indicando o número total de distintos clientes que o compraram (X é um inteiro dado pelo utilizador)";
    opcoesMenuQueriesInterativas[8] = "Determinar os X clientes que compraram um maior número de diferentes produtos, indicando quantos, sendo o critério de ordenação igual a 7";
    opcoesMenuQueriesInterativas[9] = "Dado o código de um produto, determinar o conjunto dos X clientes que mais o compraram e qual o valor gasto (ordenação cf. 7)";
  }

  private String[] opcoesMenuCarregarGuardar;
  {
    opcoesMenuCarregarGuardar = new String[4];
    opcoesMenuCarregarGuardar[0] = "Carregar estado do programa de ficheiro Standard";
    opcoesMenuCarregarGuardar[1] = "Carregar estado do programa de ficheiro a indicar";
    opcoesMenuCarregarGuardar[2] = "Guardar estado do programa em ficheiro Standard";
    opcoesMenuCarregarGuardar[3] = "Guardar estado do programa em ficheiro a indicar";
  }

  public StringsMenu (){

  }

  public String[] getOpcoesMenuPrincipal(){
    return this.opcoesMenuPrincipal;
  }

  public String[] getOpcoesMenuCarregarFicheiros(){
    return this.opcoesMenuCarregarFicheiros;
  }

  public String[] getOpcoesMenuEstatisticas(){
    return this.opcoesMenuEstatisticas;
  }

  public String[] getOpcoesMenuEstatisticas12(){
    return this.opcoesMenuEstatisticas12;
  }

  public String[] getOpcoesMenuCarregarProdutos(){
    return this.opcoesMenuCarregarProdutos;
  }

  public String[] getOpcoesMenuCarregarClientes(){
    return this.opcoesMenuCarregarClientes;
  }

  public String[] getOpcoesMenuCarregarCompras(){
    return this.opcoesMenuCarregarCompras;
  }

  public String[] getOpcoesMenuQueriesInterativas(){
    return this.opcoesMenuQueriesInterativas;
  }

  public String[] getOpcoesMenuCarregarGuardar(){
    return this.opcoesMenuCarregarGuardar;
  }
}
