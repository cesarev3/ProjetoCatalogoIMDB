import java.time.LocalDate;

public abstract class Pessoa {

  private String nome;
  private boolean isDiretor = false;
  private boolean isArtista = false;

  Pessoa(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public boolean getIsDiretor() {
    return isDiretor;
  }

  public void setDiretor(boolean diretor) {
    isDiretor = diretor;
  }

  public boolean getIsArtista() {
    return isArtista;
  }

  public void setArtista(boolean artista) {
    isArtista = artista;
  }
}
