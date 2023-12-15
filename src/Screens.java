public class Screens {

    public void printWelcomeScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|                                                      |");
        System.out.println("|        Catálogo IMDB de Filmes Ser Mais Tech         |");
        System.out.println("|                                                      |");
        System.out.println("|          *****    Seja bem-vindo!    *****           |");
        System.out.println("|                                                      |");
        System.out.println("|------------------------------------------------------|");
    }


    public void printMainScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|                  Opções do programa                  |");
        System.out.println("|------------------------------------------------------|");
        System.out.println("|              1- Cadastrar Artista / Diretor          |");
        System.out.println("|              2- Cadastrar Filme                      |");
        System.out.println("|              3- Listar Filme por Artista             |");
        System.out.println("|              4- Listar Filme por Diretor             |");
        System.out.println("|              5- Listar Filme por IMDB                |");
        System.out.println("|              6- Listar Filme por Classificação       |");
        System.out.println("|              7- Sair do programa                     |");
        System.out.println("|------------------------------------------------------|");
    }

    public boolean checkMenuOption(String inputString) {
        int inputOption = Integer.parseInt(inputString);
        int numberOfOptions = 7;
        return inputOption >= 1 && inputOption <= numberOfOptions;
    }

    public void printCreateScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|        Tela de cadastro de Artistas / Diretor        |");
        System.out.println("|------------------------------------------------------|");
    }

    public void printCreateMovieScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|              Tela de cadastro de Filmes              |");
        System.out.println("|------------------------------------------------------|");
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

    public void printReadByIMDBRankingScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|         Tela de pesquisa de Filmes por IMDB          |");
        System.out.println("|------------------------------------------------------|");
    }

    public void printReadByCertificationScreen() {
        System.out.println("\n|------------------------------------------------------|");
        System.out.println("|     Tela de pesquisa de Filmes por Classificação     |");
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
