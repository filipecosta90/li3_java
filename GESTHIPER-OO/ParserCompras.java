/**
 * Classe responsável pelo parser dos ficheiros de input.
 * 
 * @author (Carlos Sá A59905, Filipe Oliveira A57816, Sérgio Caldas A57779) 
 * @version (a version number or a date)
 */

import java.io.Serializable;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;

public class ParserCompras implements Serializable{

  private String pathFicheiroCompras;
  private CatalogoProdutos apontadorCatalogoProdutos;
  private CatalogoClientes apontadorCatalogoClientes;
  private ComprasInvalidas apontadorComprasInvalidas;
  private Compras apontadorCompras;
  private Contabilidade apontadorContabilidade;


  public ParserCompras (){
    this.pathFicheiroCompras = new String();
    this.apontadorCatalogoProdutos = null;
    this.apontadorCatalogoClientes = null;
    this.apontadorComprasInvalidas = null;
    this.apontadorCompras = null;
    this.apontadorContabilidade = null;

  }

  public ParserCompras( String path , CatalogoProdutos apontadorProdutos, 
      CatalogoClientes apontadorClientes , ComprasInvalidas apontadorInvalidas,
      Compras apontadorComp, Contabilidade apontadorCont ){
    this.pathFicheiroCompras = path;
    this.apontadorCatalogoProdutos = apontadorProdutos;
    this.apontadorCatalogoClientes = apontadorClientes;
    this.apontadorComprasInvalidas = apontadorInvalidas;
    this.apontadorCompras = apontadorComp;
    this.apontadorContabilidade = apontadorCont;
  }

  public ParserCompras( ParserCompras parser ){
    this.pathFicheiroCompras = parser.getPathFicheiroCompras();
    this.apontadorCatalogoProdutos = parser.getApontadorCatalogoProdutos();
    this.apontadorCatalogoClientes = parser.getApontadorCatalogoClientes();
    this.apontadorComprasInvalidas = parser.getApontadorComprasInvalidas();
    this.apontadorCompras = parser.getApontadorCompras();
    this.apontadorContabilidade = parser.getApontadorContabilidade();
  }

  public String getPathFicheiroCompras(){
    return this.pathFicheiroCompras;
  }

  public CatalogoProdutos getApontadorCatalogoProdutos(){
    return this.apontadorCatalogoProdutos;
  }

  public CatalogoClientes getApontadorCatalogoClientes(){
    return this.apontadorCatalogoClientes;
  }

  public ComprasInvalidas getApontadorComprasInvalidas(){
    return this.apontadorComprasInvalidas;
  }

  public Compras getApontadorCompras(){
    return this.apontadorCompras;
  }

  public Contabilidade getApontadorContabilidade(){
    return this.apontadorContabilidade;
  }

   public void lerFichCompras( String pathFicheiroCompras ){
        File fich = new File( pathFicheiroCompras );
        try{
            BufferedReader br = new BufferedReader(new FileReader(fich));
            String linha;
            while( ( (linha = br.readLine()) != null ) ){
                if(parserLinhaCompras(linha)==true){
                    compValidadas++;
                }
                else{
                    compRejeitadas++;
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
  
  /**
   * Mêtodo auxiliar que faz o parser a cada linha do ficheiro de compras
   */
  private boolean parseLinhaCompras ( String linha ){
    Scanner sFile = null;
    String codigoProduto = null;
    float preco = 0;
    int quantidade = 0;
    String tipoCompra = null;
    String codigoCliente = null;
    int mes = 0;
    boolean erro = true;
    StringTokenizer st = new StringTokenizer(linha);
    int numeroCampos = st.countTokens();
    if ( numeroCampos == 6 ){
              codigoProduto=st.nextToken();
              if ( this.apontadorCatalogoProdutos.produtoValidoEExiste( codigoProduto ) ){
                          preco=Float.parseFloat(st.nextToken());
                                  if (preco > 0.0 ){
                                              quantidade=Integer.parseInt(st.nextToken());
                                              if ( quantidade > 0 ){
                                                          tipoCompra=st.nextToken();
                                                                  if( Compra.verificaTipoCompra(tipoCompra) ){
                                                                                codigoCliente=st.nextToken();
                                                                                          if ( this.apontadorCatalogoClientes.clienteValidoEExiste( codigoCliente ) ){
                                                                                            }
                                                                                            else{
                                                                                            }
                                                                    }
                                                                    else{
                                                                     this.apontadorComprasInvalidas.adicionaLinhaInvalida( ErroParsing.TIPO_INVALIDO , linha );
                                                                    }
                                                }
                                              else{
                                                  this.apontadorComprasInvalidas.adicionaLinhaInvalida( ErroParsing.QUANTIDADE_INVALIDA , linha );
                                                }
                                    }
                                    else{
                                            this.apontadorComprasInvalidas.adicionaLinhaInvalida( ErroParsing.PRECO_INVALIDO , linha );
                                    }
                          
                }
                else {
    this.apontadorComprasInvalidas.adicionaLinhaInvalida( ErroParsing.PRODUTO_INVALIDO , linha );
    }
                
    }
    else {
    this.apontadorComprasInvalidas.adicionaLinhaInvalida( ErroParsing.ERRO_NUMERO_TOKENS , linha );
    }
    









            mes=Integer.parseInt(st.nextToken());
            if(mes>=1 && mes<=12){
              erro=true;
            }
            else{
              erro=true;
            }
          }
          else{
            erro=true;
          }
        }
        else{
          erro=true;
        }
    }else {
        erro = true;
        
      }
      else{
        erro=true;
      }
    }
    
    if(erro==true){return true;}
    else{return false;}
  }
}
