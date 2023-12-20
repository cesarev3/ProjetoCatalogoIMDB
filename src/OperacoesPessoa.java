import java.util.ArrayList;
import java.util.List;

public class OperacoesPessoa {

  private List<Pessoa> bancoDeArtistas;
  private List<Pessoa> bancoDeDirecao;

  OperacoesPessoa() {
    this.bancoDeArtistas = new ArrayList<>();
    this.bancoDeDirecao = new ArrayList<>();
  }

  public boolean checkArtista(String nome) {
    for (Pessoa artista : bancoDeArtistas) {
      if (artista.getNome().equals(nome)) {
        return true;
      }
    }
    return false;
  }

  public boolean checkDirecao(String nome) {
    for (Pessoa direcao : bancoDeDirecao) {
      if (direcao.getNome().equals(nome)) {
        return true;
      }
    }
    return false;
  }
  public void salvarArtista(Pessoa pessoa) {
    bancoDeArtistas.add(pessoa);
    System.out.printf("%s salvo com sucesso no cadastro de Artista", pessoa.getNome());
  }

  public void salvarDirecao(Pessoa pessoa) {
    bancoDeDirecao.add(pessoa);
    System.out.printf("%s salvo com sucesso no cadastro de Direção", pessoa.getNome());
  }
  public void carregarArtista(Pessoa pessoa) {
    bancoDeArtistas.add(pessoa);
  }
  public void carregarDirecao(Pessoa pessoa) {
    bancoDeDirecao.add(pessoa);
  }
  public List<Pessoa> getBancoDeDirecao() {
    return this.bancoDeDirecao;
  }

  public List<Pessoa> getBancoDeArtistas() {
    return this.bancoDeArtistas;
  }

  public Pessoa getArtista(String nome) {
    for (Pessoa artista : bancoDeArtistas) {
      if (artista.getNome().equals(nome)) {
        return artista;
      }
    }
    return null;
  }

  public Pessoa getDirecao(String nome) {
    for (Pessoa direcao : bancoDeDirecao) {
      if (direcao.getNome().equals(nome)) {
        return direcao;
      }
    }
    return null;
  }

}
