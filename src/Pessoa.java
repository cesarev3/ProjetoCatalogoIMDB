import java.time.LocalDate;

public abstract class Pessoa {

  private String nome;
  private LocalDate dataNascimento;
  private boolean isDiretor = false;
  private boolean isArtista = false;

  Pessoa(String nome, LocalDate dataNascimento) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public boolean isDiretor() {
    return isDiretor;
  }

  public void setDiretor(boolean diretor) {
    isDiretor = diretor;
  }

  public boolean isArtista() {
    return isArtista;
  }

  public void setArtista(boolean artista) {
    isArtista = artista;
  }
}
