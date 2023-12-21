public class Screens {

    public void printWelcomeScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|                                                      |");
        System.out.println("|        Catálogo IMDB de Filmes Ser Mais Tech         |");
        System.out.println("|                                                      |");
        System.out.println("|          *****    Seja bem-vindo!    *****           |");
        System.out.println("|                                                      |");
        System.out.println("|------------------------------------------------------|\n");
    }


    public void printMainScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|                  Opções do programa                  |");
        System.out.println("|------------------------------------------------------|");
        System.out.println("|              1- Cadastrar Artista                    |");
        System.out.println("|              2- Cadastrar Diretor                    |");
        System.out.println("|              3- Cadastrar Filme                      |");
        System.out.println("|              4- Listar Filmes                        |");
        System.out.println("|              5- Listar Filme por Artista             |");
        System.out.println("|              6- Listar Filme por Diretor             |");
        System.out.println("|              7- Listar Filme por Título              |");
        System.out.println("|              8- Listar Filme por Classificação       |");
        System.out.println("|              9- Sair do programa                     |");
        System.out.println("|------------------------------------------------------|");
    }

    public boolean checkMenuOption(String inputString) {
        int inputOption = Integer.parseInt(inputString);
        int numberOfOptions = 9;
        return inputOption >= 1 && inputOption <= numberOfOptions;
    }

    public void printCreateDirectorScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|             Tela de cadastro de Diretor              |");
        System.out.println("|------------------------------------------------------|");
    }

    public void printCreateArtistScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|             Tela de cadastro de Artistas             |");
        System.out.println("|------------------------------------------------------|");
    }

    public void printCreateMovieScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|              Tela de cadastro de Filmes              |");
        System.out.println("|------------------------------------------------------|");
    }

    public void printReadTop20FilmsScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|   Tela com os 20 melhores Filmes de todos os tempos  |");
        System.out.println("|------------------------------------------------------|\n");
    }

    public void printReadByArtistScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|       Tela de pesquisa de Filmes por Artistas        |");
        System.out.println("|------------------------------------------------------|");
    }

    public void printReadByDirectorScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|        Tela de pesquisa de Filmes por Diretor        |");
        System.out.println("|------------------------------------------------------|");
    }

    public void printReadByTitleScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|         Tela de pesquisa de Filmes por Título        |");
        System.out.println("|------------------------------------------------------|");
    }

    public void printReadByRatingScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|    Tela de pesquisa de Filmes por Classificação      |");
        System.out.println("|------------------------------------------------------|");
    }

    public void printGoodbyeScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|                                                      |");
        System.out.println("|        Obrigado por utilizar nosso aplicativo        |");
        System.out.println("|                                                      |");
        System.out.println("|            *****    Volte Sempre!    *****           |");
        System.out.println("|                                                      |");
        System.out.println("|                                                      |");
        System.out.println("|      *****    Equipe de Desenvolvimento    *****     |");
        System.out.println("|                   (ordem alfabética)                 |");
        System.out.println("|                                                      |");
        System.out.println("|                        Cesar                         |");
        System.out.println("|                        Fabio                         |");
        System.out.println("|                        Oliver                        |");
        System.out.println("|                        Paty                          |");
        System.out.println("|                                                      |");
        System.out.println("|------------------------------------------------------|");
    }

}
