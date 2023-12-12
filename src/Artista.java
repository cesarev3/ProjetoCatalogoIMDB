import java.time.LocalDate;

public class Artista extends Pessoa {

  Artista(String nome, LocalDate dataNascimento) {

    super(nome, dataNascimento);
    setArtista(true);

  }

}
