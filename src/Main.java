import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // criando o objeto viewScreens
        Screens screens = new Screens();

        // imprimindo tela de boas vindas
        screens.printWelcomeScreen();

        // preparando a lista de exemplo de filmes
        SampleMovieList sampleMovieList = new SampleMovieList();
        sampleMovieList.splitToRegister();
        sampleMovieList.splitToColumns();
        sampleMovieList.buildMovieTitle();
        sampleMovieList.buildMovieDirector();
        sampleMovieList.buildMovieArtists();
        sampleMovieList.buildMovieData();

        // *************************************************
        // preparando ambiente de teste para programa
        List<String> testeListaDirecao = new ArrayList<>();
        List<String> testeListaArtistas = new ArrayList<>();
        List<String> testeListaFilmes = new ArrayList<>();

        //System.out.println("diretores");
        for (String x: sampleMovieList.getMovieDirector()){
                testeListaDirecao.add(x);
                //System.out.println(x);
        }

        //System.out.println("\nfilmes");
        for (int i = 0; i < 20; i++) {
            testeListaFilmes.add(sampleMovieList.getMovieData()[i][0]);
            //System.out.println(testeListaFilmes.get(i));
        }

        //System.out.println("\nartistas");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                testeListaArtistas.add(sampleMovieList.getMovieArtists()[i][j]);
            }
        }

        for (String x: testeListaArtistas) {
            //System.out.println(x);
        }

        // **********************************************************************

        // criando o objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // criar os demais objetos
        OperacoesPessoa operacoesPessoa = new OperacoesPessoa();
//        OperacoesFilme operacoesFilme = new OperacoesFilme();

        // imprimindo tela de menu e recebendo opção
        screens.printMainScreen();
        int options = getAndCheckMenuOption(
                scanner, UserMessage.GETOPTIONS, screens
        );

        // inicializando variáveis para bloco While-Switch


        // iniciando laço While-Switch
        while (true) {
            switch (options) {
                case 1:
                    screens.printCreateArtistScreen();

                    System.out.print("\nArtistas");
                    String getArtist;
                    List<String> getSearchList = searchNames(scanner, testeListaArtistas);
                    String getOption = listAndChooseSearchNames(scanner, getSearchList);

                    if (getOption.equals("X")) {
                        getArtist = getAndCheckPerson(scanner,
                                operacoesPessoa, 1);
                    } else {
                        int index = Integer.parseInt(getOption);
                        getArtist = getSearchList.get(index - 1);
                    }

                    // montando parametros do objeto
                    Pessoa artist = new Artista(getArtist);

                    // salvando novo usuário no DB
                    operacoesPessoa.salvarArtista(artist);

                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 2:
                    screens.printCreateDirectorScreen();

                    System.out.print("\nDireção");
                    String getDirector;
                    getSearchList = searchNames(scanner, testeListaDirecao);
                    getOption = listAndChooseSearchNames(scanner, getSearchList);

                    if (getOption.equals("X")) {
                        getDirector = getAndCheckPerson(scanner,
                                operacoesPessoa, 2);
                    } else {
                        int index = Integer.parseInt(getOption);
                        getDirector = getSearchList.get(index - 1);
                    }

                    // montando parametros do objeto
                    Pessoa director = new Direcao(getDirector);

                    // salvando novo usuário no DB
                    operacoesPessoa.salvarDirecao(director);

                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;


                case 3:
                    screens.printCreateMovieScreen();

                    // validando e recebendo nome do Filme *** trocar operacoesPessoa ela respectiva em filmes ***
                    System.out.print("\nTítulo do filme");
                    getSearchList = searchNames(scanner, testeListaFilmes);
                    getOption = listAndChooseSearchNames(scanner, getSearchList);
                    String getMovieTitle;

                    if (getOption.equals("X")) {
                        getMovieTitle = getAndCheckMovieTitle(scanner,
                                operacoesPessoa);
                    } else {
                        int index = Integer.parseInt(getOption);
                        getMovieTitle = getSearchList.get(index - 1);
                    }

                    // validando e recebendo nome do Diretor
                    System.out.print("\nDireção do filme");
                    getSearchList = searchNames(scanner, testeListaDirecao);
                    getOption = listAndChooseSearchNames(scanner, getSearchList);
                    String getMovieDirector;

                    if (getOption.equals("X")) {
                        getMovieDirector = getAndCheckPerson(scanner,
                                operacoesPessoa, 2);
                    } else {
                        int index = Integer.parseInt(getOption);
                        getMovieDirector = getSearchList.get(index - 1);
                    }

                    // validando e recebendo nome dos Artistas
                    String[] getMovieArtists = new String[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("\nArtistas do filme");
                        getSearchList = searchNames(scanner, testeListaArtistas);
                        getOption = listAndChooseSearchNames(scanner, getSearchList);

                        if (getOption.equals("X")) {
                            getMovieArtists[i] = getAndCheckPerson(scanner,
                                    operacoesPessoa, 1);
                        } else {
                            int index = Integer.parseInt(getOption);
                            getMovieArtists[i] = getSearchList.get(index - 1);
                        }
                    }

                    // apenas teste
                    for (int i = 0; i < 5; i++) {
                        System.out.println(getMovieArtists[i]);
                    }

                    // validando e recebendo outras variáveis
                    int getMovieYear = getAndCheckMovieYear(scanner);
                    String getMovieCertification = getAndCheckMovieCertification(scanner);
                    String getMovieLength = getMovieLength(scanner);
                    String getMovieRating = getAndCheckMovieRating(scanner);
                    String getMovieKind = getString(scanner, UserMessage.GETMOVIEKIND);


                    // montando parametros do objeto


                    // salvando novo usuário no DB


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 4:
                    screens.printReadTop20FilmsScreen();

                    // criando objeto de usuários salvos no DB e imprimindo
                    printSampleMovies(sampleMovieList);

                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 5:
                    screens.printReadByArtistScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 6:
                    screens.printReadByDirectorScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 7:
                    screens.printReadByIMDBRankingScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 8:
                    screens.printReadByCertificationScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;



                case 9:
                    screens.printGoodbyeScreen();
                    // fechando Scanner e saindo do programa
                    scanner.close();
                    System.exit(0);

                default:
                    break;
            }
        }


    }
    private static String getString(Scanner scanner, UserMessage message) {
        System.out.print(message.getUserMessage());
        return scanner.nextLine();
    }

    private static String getStringOption(Scanner scanner, UserMessage message) {
        System.out.print(message.getUserMessage());
        return scanner.nextLine().toUpperCase();
    }

    private static String getAndCheckPerson(Scanner scanner,
                                            OperacoesPessoa operacoesPessoa,
                                            int options) {
        String inputPerson = "";
        boolean isRepeated = true;

        while (isRepeated) {
            if (options == 1) {
                inputPerson = getString(scanner, UserMessage.GETARTIST);
                isRepeated = operacoesPessoa.checkArtista(inputPerson);
            } else if (options == 2) {
                inputPerson = getString(scanner, UserMessage.GETDIRECTOR);
                isRepeated = operacoesPessoa.checkDirecao(inputPerson);
            }

            if (isRepeated) {
                if (!continueProcedure(scanner, UserMessage.DUPLICATEACTION)) break;
            }
        }
        return inputPerson;
    }


    private static String getAndCheckMovieTitle(Scanner scanner,
                                                OperacoesPessoa operacoesPessoa) {
        String inputMovieTitle = "";
        boolean isRepeated = true;


        while (isRepeated) {
                inputMovieTitle = getString(scanner, UserMessage.GETMOVIETITLE);
                isRepeated = false;
//                isRepeated = operacoesFilme.checkFilme(inputFilmTitle);

            if (isRepeated) {
                if (!continueProcedure(scanner, UserMessage.DUPLICATEACTION)) break;
            }
        }
        return inputMovieTitle;
    }

    private static List<String> searchNames(Scanner scanner,
                                            List<String> inputList) {

        String searchName = getString(scanner, UserMessage.SEARCHNAME);
        List<String> getReturn = inputList.stream().filter(nome -> {
            return nome.toLowerCase().contains(searchName.toLowerCase());
        }).toList();
        return getReturn;
    }

    private static String listAndChooseSearchNames(Scanner scanner,
                                                 List<String> inputList) {

        if (inputList.isEmpty()) {
            System.out.println("Nome não localizado");
            return "X";
        }

        List<String> checkList = new ArrayList<>();
        checkList.add("P");
        checkList.add("X");

        for (int i = 0; i < inputList.size(); i++) {
            System.out.println((i + 1) + "- " + inputList.get(i));
            checkList.add(String.valueOf(i + 1));
        }

        String inputOption = "";
        boolean isValid = false;
        while (!isValid) {
            inputOption = getStringOption(scanner, UserMessage.SEARCHOPTION);
            for (String item: checkList){
                if (item.equals(inputOption)) {
                    isValid = true;;
                    break;
                }
            }
        }
        return inputOption;
    }

    private static int getAndCheckMovieYear(Scanner scanner) {
        LocalDate currentYear = LocalDate.now();
        int inputMovieYear = 0;

        while (true) try {
            String inputString = getString(scanner, UserMessage.GETMOVIEYEAR);
            inputMovieYear = Integer.parseInt(inputString);
            if (inputMovieYear >= 1895 && inputMovieYear <= currentYear.getYear()) break;
            System.out.println(">>> ano fora de período válido");

        } catch (RuntimeException e) {
            System.out.println(">>> ano inválido");
        }
        return inputMovieYear;
    }

    private static String getAndCheckMovieCertification(Scanner scanner) {
        String[] movieCertification = {"livre", "10", "12", "14", "16", "18"};
        String inputString = "";
        boolean isValid = false;

        while (!isValid) {
            inputString = getString(scanner, UserMessage.GETMOVIECERTIFICATION);
            for (String item: movieCertification){
                if (item.equals(inputString)) {
                    System.out.println(inputString);
                    isValid = true;;
                    break;
                }
            }
        }
        return inputString;
    }

    private static String getMovieLength(Scanner scanner) {

        String inputHours = getString(scanner, UserMessage.GETMOVIEHOURS);
        String inputMinutes = getString(scanner, UserMessage.GETMOVIEMINUTES);
        String movieLength = inputHours + "h " + inputMinutes + "min";
        return movieLength;
    }

    private static String getAndCheckMovieRating(Scanner scanner) {
        String inputString = "";

        while (true) try {
            inputString = getString(scanner, UserMessage.GETMOVIERATING);
            Double inputMovieRating = Double.parseDouble(inputString);
            if (inputMovieRating >= 0.0 && inputMovieRating <= 10.0) break;
            System.out.println(">>> valor fora da faixa válida");

        } catch (RuntimeException e) {
            System.out.println(">>> valor inválido");
        }

        String movieRating = inputString + "/10";
        return movieRating;
    }

    public static void printSampleMovies(SampleMovieList sampleFilmList){
        for (int i = 0; i < sampleFilmList.getMovieDirector().length; i++) {
            System.out.printf("%s\tDireção: %s\n",
                    sampleFilmList.getMovieData()[i][0],
                    sampleFilmList.getMovieDirector()[i]);

            System.out.printf("Ano: %s\tDuração: %s\tRating: %s\n",
                    sampleFilmList.getMovieData()[i][1],
                    sampleFilmList.getMovieData()[i][3],
                    sampleFilmList.getMovieData()[i][4]);

            System.out.printf("Gênero: %s\tClassificação: %s\n",
                    sampleFilmList.getMovieData()[i][5],
                    sampleFilmList.getMovieData()[i][2]);

            System.out.printf("Atores: %s, %s, %s\n",
                    sampleFilmList.getMovieArtists()[i][0],
                    sampleFilmList.getMovieArtists()[i][1],
                    sampleFilmList.getMovieArtists()[i][2]);

            System.out.printf("        %s, %s\n\n",
                    sampleFilmList.getMovieArtists()[i][3],
                    sampleFilmList.getMovieArtists()[i][4]);
        }
    }

    public static int getAndCheckMenuOption(Scanner scanner,
                                            UserMessage message,
                                            Screens screens) {
        String inputString;

        while (true) {
            try {
                inputString = getStringOption(scanner, message);
                boolean isMenuOptionOk = screens.checkMenuOption(inputString);

                if (isMenuOptionOk) break;
                else System.out.println(">>> opção inválida");

            } catch(RuntimeException e){
                System.out.println(">>> opção inválida");
            }
        }
        return Integer.parseInt(inputString);
    }

    private static boolean continueProcedure(Scanner scanner,
                                             UserMessage message) {
        String updateUser = getStringOption(scanner, message);
        return updateUser.equals("S");
    }
}
