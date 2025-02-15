
/**
 * Classe agregadora das compras inválidas lidas do ficheiro de compras
 * 
 * @author (Carlos Sá A59905, Filipe Oliveira A57816, Sérgio Caldas A57779) 
 * @version (a version number or a date)
 */

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class ComprasInvalidas implements Serializable {

  public static enum ErroParsing { 
    PRODUTO_INVALIDO, 
      PRECO_INVALIDO,
      QUANTIDADE_INVALIDA,
      TIPO_INVALIDO, 
      CLIENTE_INVALIDO,
      MES_INVALIDO,
      ERRO_NUMERO_TOKENS
  }  

  // chave: ErrosParsing , valor : Linha
  private TreeMap < ErroParsing , HashSet<String>> linhasInvalidas;
  private int numeroLinhasInvalidas;

  /**
   * Construtores
   */
  public ComprasInvalidas(){
    this.linhasInvalidas = new TreeMap <>();
    this.numeroLinhasInvalidas = 0;
  }

  public int getNumeroLinhasInvalidas(){
    return this.numeroLinhasInvalidas;
  }

  public void setNumeroLinhasInvalidas(int invalidas){
    this.numeroLinhasInvalidas = invalidas;
  }

  public void incrementaLinhasInvalidas(){
    this.numeroLinhasInvalidas++;
  }

  /**
   * Métodos
   */
  public void adicionaLinhaInvalida ( ErroParsing erro , String linhaInvalida ){
    if ( this.linhasInvalidas.containsKey(erro) ){
      HashSet < String > hashErro = this.linhasInvalidas.get(erro);
      hashErro.add( linhaInvalida );
    }
    else{
      HashSet < String > hashErro = new HashSet<>();
      hashErro.add( linhaInvalida );
      this.linhasInvalidas.put(erro, hashErro);
    }

    incrementaLinhasInvalidas();
  }

  /** Método para gravar as Compras Inválidas em ficheiro de objecto */
  public void gravaEmObjecto(String ficheiro) throws IOException {
    ObjectOutputStream objStreamOut = new ObjectOutputStream(new FileOutputStream(ficheiro));
    objStreamOut.writeObject(this);
    objStreamOut.flush();
    objStreamOut.close();
  }

  /**
   * Método para imprimir em ficheiro o total de registos de Compras Inválidas
   * Imprimir os registos completos com: Nomes e valores dos respectivos campos
   * Guardar em ficheiro de texto dado pelo Utilizador
   */
  public void gravaComprasInvalidasTXT(String ficheiro) throws IOException{
    PrintWriter impressoraParaTXT = new PrintWriter(ficheiro);
    impressoraParaTXT.println("------ LISTA DE COMPRAS INVÁLIDAS -------");
    impressoraParaTXT.println("Erro\tLinha");
    for (ErroParsing erro : this.linhasInvalidas.keySet()){
      HashSet <String> linhasErroActual = this.linhasInvalidas.get(erro);
      Iterator<String> iteradorErros=linhasErroActual.iterator();
      while(iteradorErros.hasNext()){
        String linha = iteradorErros.next();
        impressoraParaTXT.println(erro + "\t" + linha);
      }
    }
    impressoraParaTXT.println("Número de Linhas Inválidas: " + this.numeroLinhasInvalidas + "\n"); 
    impressoraParaTXT.flush();
    impressoraParaTXT.close();
  }

  /**
   * Consulta Estatística :: 1.2 P4
   * Total de registos de compras inválidos 
   * (os registos completos, com os nomes e valores dos respectivos campos, ou seja,
   * não é apenas a linha lida, deverão ser também guardados em ficheiro de texto dado pelo utilizador).
   */
  public ArrayList<String> estatisticas_1_2_P4 (){
    ArrayList <String> linhas = new ArrayList <String> ();
    for ( ErroParsing erro : this.linhasInvalidas.keySet() ){
      HashSet <String> linhasErroActual = this.linhasInvalidas.get(erro);
      StringBuilder s = new StringBuilder ();
      s.append(erro).append("\t\t").append(linhasErroActual.size());
      linhas.add ( s.toString() );
    }
    linhas.add( new String ("-------------------------------------"));
    StringBuilder s = new StringBuilder ();
    s.append("Total Compras Inválidas: ").append(numeroLinhasInvalidas).append("\n");
    linhas.add ( s.toString() );
    return linhas; 
  }

  /**
   * toString
   */
  @Override
    public String toString() {
      StringBuilder s = new StringBuilder("----- Compras Inválidas :: Módulo Relacciona ErrosParsing->Linhas Vendas -----\n");
      s.append("\nTipo Invalidez\t\t\t#Registos\n");
      s.append("-------------------------------------\n");
      int totalErros = 0;
      for ( ErroParsing erro : this.linhasInvalidas.keySet() ){
        HashSet <String> linhasErroActual = this.linhasInvalidas.get(erro);
        s.append(erro).append("\t\t").append(linhasErroActual.size()).append("\n");
      }
      s.append("-------------------------------------\n");
      s.append("Total Compras Inválidas: ").append(numeroLinhasInvalidas).append("\n");
      return s.toString();
    }
}
