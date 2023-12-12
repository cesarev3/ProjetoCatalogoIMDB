import java.time.LocalDate;

public class TestePessoa {

  public static void main(String[] args) {
    Artista artista1 = new Artista("Hugh Grant",
        LocalDate.of(1960,9,9));
    Artista artista2 = new Artista("Jason Statham",
        LocalDate.of(1967,7,26));
    Direcao direcao1 = new Direcao("Ben Wheatley",
        LocalDate.of(1972,5,26));

    System.out.println(artista1.getNome());
    System.out.println(artista1.getDataNascimento());
    System.out.println(artista1.isArtista());
    System.out.println(artista1.isDiretor());
    System.out.println(artista2.getNome());
    System.out.println(artista2.getDataNascimento());
    System.out.println(artista2.isArtista());
    System.out.println(artista2.isDiretor());
    System.out.println(direcao1.getNome());
    System.out.println(direcao1.getDataNascimento());
    System.out.println(direcao1.isArtista());
    System.out.println(direcao1.isDiretor());
  }

}
