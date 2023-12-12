import java.time.LocalDate;

public class Direcao extends Pessoa{

  Direcao(String nome, LocalDate dataNascimento) {
    super(nome, dataNascimento);
    setDiretor(true);
  }

}
