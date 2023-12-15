import java.util.ArrayList;
import java.util.List;

public class OperacoesPessoa {

  private List<Pessoa> bancoDeArtistas;
  private List<Pessoa> bancoDeDirecao;

  OperacoesPessoa() {
    this.bancoDeArtistas = new ArrayList<>();
    this.bancoDeDirecao = new ArrayList<>();
  }

  public void salvarPessoa(Pessoa pessoa) {
    if (pessoa.getIsDiretor()) {
      boolean isCadastrado =  false;

      for (Pessoa direcao : bancoDeDirecao) {
        if (direcao.getNome().equals(pessoa.getNome())) {
          System.err.println("Direção já cadastrada");
          isCadastrado = true;
          break;
        }
      }
      if (!isCadastrado) {
        bancoDeDirecao.add(pessoa);
      }
    }
    if (pessoa.getIsArtista()) {
      boolean isCadastrado =  false;

      for (Pessoa artista : bancoDeArtistas) {
        if (artista.getNome().equals(pessoa.getNome())) {
          System.err.println("Artista já cadastrado");
          isCadastrado = true;
          break;
        }
      }
      if (!isCadastrado) {
        bancoDeArtistas.add(pessoa);
      }
    }
  }

  public List<Pessoa> getBancoDeDirecao() {
    return this.bancoDeDirecao;
  }

  public List<Pessoa> getBancoDeArtistas() {
    return this.bancoDeArtistas;
  }

}
