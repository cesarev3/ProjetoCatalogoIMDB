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

        // criar objetos de acesso ao Banco de Dados
        OperacoesPessoa operacoesPessoa = new OperacoesPessoa();
        OperacoesFilme operacoesFilme = new OperacoesFilme();

        // carregar exemplo de Direção no Banco de Dados
        for (String x: sampleMovieList.getMovieDirector()){
            boolean isRepetido = operacoesPessoa.checkDirecao(x);

            if (!isRepetido){
                Pessoa director = new Direcao(x);
                operacoesPessoa.carregarDirecao(director);
            }
        }

        // carregar exemplo de Artistas no Banco de Dados
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                String pessoa = sampleMovieList.getMovieArtists()[i][j];
                boolean isRepetido = operacoesPessoa.checkArtista(pessoa);

                if (!isRepetido){
                    Pessoa artista = new Artista(pessoa);
                    operacoesPessoa.carregarArtista(artista);
                }
            }
        }

        // carregar exemplo de Filmes no Banco de Dados
        for (int i = 0; i < 20; i++) {
            String titulo = sampleMovieList.getMovieData()[i][0];
            int lancamento = Integer.parseInt(sampleMovieList.getMovieData()[i][1]);
            String classificacao = sampleMovieList.getMovieData()[i][2];
            String tempoDeDuracao = sampleMovieList.getMovieData()[i][3];
            String avaliacao = sampleMovieList.getMovieData()[i][4];
            String genero = sampleMovieList.getMovieData()[i][5];
            Pessoa diretor = operacoesPessoa.getDirecao(sampleMovieList.getMovieDirector()[i]);

            List <Pessoa> artistas = new ArrayList<>();

            for(String item : sampleMovieList.getMovieArtists()[i]){
                Pessoa artista = operacoesPessoa.getArtista(item);
              artistas.add(artista);
            }

            Filme filme = new Filme(titulo, lancamento, classificacao,
                    tempoDeDuracao, avaliacao, genero, diretor, artistas);

            operacoesFilme.carregarFilmes(filme);
        }

        // criando o objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // imprimindo tela de menu e recebendo opção
        int options = loadMainScreen(screens, scanner);

        // iniciando laço While-Switch
        while (true) {
            switch (options) {
                case 1:
                    screens.printCreateArtistScreen();

                    System.out.print("\nConsultar Artistas já cadastrados");
                    String getArtist;
                    List<String> getSearchList = searchNames(scanner,
                            operacoesPessoa.getBancoDeArtistas());
                    String getOption = listAndGetOption(scanner, getSearchList);

                    if (getOption.equals("N")) {
                        getArtist = getAndCheckPerson(scanner,
                                operacoesPessoa, 1);
                        // criando objeto e salvando no Banco de Dados
                        Pessoa artist = new Artista(getArtist);
                        operacoesPessoa.salvarArtista(artist);
                    }

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 2:
                    screens.printCreateDirectorScreen();

                    System.out.print("\nConsultar Diretores já cadastrados");
                    String getDirector;
                    getSearchList = searchNames(scanner, operacoesPessoa.getBancoDeDirecao());
                    getOption = listAndGetOption(scanner, getSearchList);

                    if (getOption.equals("N")) {
                        getDirector = getAndCheckPerson(scanner,
                                operacoesPessoa, 2);
                        // criando objeto e salvando no Banco de Dados
                        Pessoa director = new Direcao(getDirector);
                        operacoesPessoa.salvarDirecao(director);
                    }

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 3:
                    screens.printCreateMovieScreen();

                    // validando e recebendo nome do Filme
                    System.out.print("\nTítulo do filme");
                    getSearchList = searchTitles(scanner, operacoesFilme.getBancoDeFilmes());
                    getOption = listAndGetOption(scanner, getSearchList);
                    String getMovieTitle = null;

                    if (getOption.equals("X")) {
                        scanner.reset();
                        options = loadMainScreen(screens, scanner);
                        break;
                    }

                    if (getOption.equals("N")) {
                        getMovieTitle = getAndCheckMovieTitle(scanner,
                        operacoesFilme);

                    } else {
                        int index = Integer.parseInt(getOption);
                        getMovieTitle = getSearchList.get(index - 1);
                    }



                    // validando e recebendo nome do Diretor
                    System.out.print("\nDireção do filme");
                    getSearchList = searchNames(scanner, operacoesPessoa.getBancoDeDirecao());
                    getOption = listAndChooseSearchNames(scanner, getSearchList);
                    String getMovieDirector = null;

                    if (getOption.equals("X")) {
                        scanner.reset();
                        options = loadMainScreen(screens, scanner);
                        break;
                    }

                    if (getOption.equals("N")) {
                        getMovieDirector = getAndCheckPerson(scanner,
                                operacoesPessoa, 2);
                        Pessoa director = new Direcao(getMovieDirector);
                        operacoesPessoa.salvarDirecao(director);

                    } else {
                        int index = Integer.parseInt(getOption);
                        getMovieDirector = getSearchList.get(index - 1);
                    }

                    // validando e recebendo nome dos Artistas
                    String[] getMovieArtists = new String[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("\nArtistas do filme");
                        getSearchList = searchNames(scanner, operacoesPessoa.getBancoDeArtistas());
                        getOption = listAndChooseSearchNames(scanner, getSearchList);

                        if (getOption.equals("X")) {
                            scanner.reset();
                            //options = loadMainScreen(screens, scanner);
                            break;
                        }

                        if (getOption.equals("N")) {
                            getMovieArtists[i] = getAndCheckPerson(scanner,
                                    operacoesPessoa, 1);
                            Pessoa artist = new Artista(getMovieArtists[i]);
                            operacoesPessoa.salvarArtista(artist);

                        } else {
                            int index = Integer.parseInt(getOption);
                            getMovieDirector = getSearchList.get(index - 1);

                        }
                    }

                    // validando e recebendo outras variáveis
                    int getMovieYear = getAndCheckMovieYear(scanner);
                    String getMovieCertification = getAndCheckMovieCertification(scanner);
                    String getMovieLength = getMovieLength(scanner);
                    String getMovieRating = getAndCheckMovieRating(scanner);
                    String getMovieKind = getString(scanner, UserMessage.GETMOVIEKIND);

                    // montando parametros do objeto
                    String titulo = getMovieTitle;
                    int lancamento = getMovieYear;
                    String classificacao = getMovieCertification;
                    String tempoDeDuracao = getMovieLength;
                    String avaliacao = getMovieRating;
                    String genero = getMovieKind;
                    Pessoa diretor = operacoesPessoa.getDirecao(getMovieDirector);

                    List <Pessoa> artistas = new ArrayList<>();
                    for(String item : getMovieArtists){
                        Pessoa artista = operacoesPessoa.getArtista(item);
                        artistas.add(artista);
                    }

                    // criando objeto Filme e salvando no Banco de Dados
                    Filme filme = new Filme(titulo, lancamento, classificacao,
                            tempoDeDuracao, avaliacao, genero, diretor, artistas);
                    operacoesFilme.salvarFilmes(filme);

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 4:
                    screens.printReadTop20FilmsScreen();

                    // criando objeto de usuários salvos no DB e imprimindo
                    printSampleMovies(sampleMovieList);

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 5:
                    screens.printReadByArtistScreen();

                    // criando objeto de usuários salvos no DB e imprimindo




                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 6:
                    screens.printReadByDirectorScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 7:
                    screens.printReadByTitleScreen();

                    // criando objeto de usuários salvos no DB e imprimindo

                    getSearchList = searchMovieTitles(scanner,
                            operacoesFilme.getBancoDeFilmes());
                    listMovies(scanner, getSearchList, operacoesFilme);

//                    if (getOption.equals("N")) {
//                        getArtist = getAndCheckPerson(scanner,
//                                operacoesPessoa, 1);
//                        // criando objeto e salvando no Banco de Dados
//                        Pessoa artist = new Artista(getArtist);
//                        operacoesPessoa.salvarArtista(artist);
//                    }

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 8:
                    screens.printReadByCertificationScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

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

    private static int loadMainScreen(Screens screens, Scanner scanner) {
        screens.printMainScreen();
        return getAndCheckMenuOption(
                scanner, UserMessage.GETOPTIONS, screens);
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
                                                OperacoesFilme operacoesFilme) {
        String inputMovieTitle = "";
        boolean isRepeated = true;


        while (isRepeated) {
                inputMovieTitle = getString(scanner, UserMessage.GETMOVIETITLE);
                isRepeated = operacoesFilme.checkFilme(inputMovieTitle);

            if (isRepeated) {
                if (!continueProcedure(scanner, UserMessage.DUPLICATEACTION)) break;
            }
        }
        return inputMovieTitle;
    }

    private static List<String> searchNames(Scanner scanner,
                                            List<Pessoa> bancoDeArtista) {
        List<String> inputList = new ArrayList<>();

        for (Pessoa artista : bancoDeArtista) {
            inputList.add(artista.getNome());
        }

        String searchName = getString(scanner, UserMessage.SEARCHNAME);
        return inputList.stream().filter(nome -> nome.toLowerCase()
            .contains(searchName.toLowerCase())).toList();
    }

    private static List<String> searchTitles(Scanner scanner,
                                             List<Filme> bancoDeFilmes) {
        List<String> inputList = new ArrayList<>();

        for (Filme filme : bancoDeFilmes) {
            inputList.add(filme.getTitulo());
        }

        String searchName = getString(scanner, UserMessage.SEARCHNAME);
        return inputList.stream().filter(nome -> nome.toLowerCase()
            .contains(searchName.toLowerCase())).toList();
    }

    private static List<String> searchMovieTitles(Scanner scanner,
                                             List<Filme> bancoDeFilmes) { // >>> Opção 7
        List<String> inputList = new ArrayList<>();

        for (Filme filme : bancoDeFilmes) {
            inputList.add(filme.getTitulo());
        }

        String searchName = getString(scanner, UserMessage.SEARCHNAME);
        return inputList.stream().filter(nome -> nome.toLowerCase()
                .contains(searchName.toLowerCase())).toList();
    }

    private static String listAndGetOption(Scanner scanner,
                                                   List<String> inputList) {

        if (inputList.isEmpty()) System.out.println("Nome não localizado");

        List<String> checkList = new ArrayList<>();
        checkList.add("N");
        checkList.add("X");

        for (int i = 0; i < inputList.size(); i++) {
            System.out.println((i + 1) + "- " + inputList.get(i));
        }

        String inputOption = "";
        boolean isValid = false;
        while (!isValid) {
            inputOption = getStringOption(scanner, UserMessage.LOADOPTION);
            for (String item: checkList){
                if (item.equals(inputOption)) {
                    isValid = true;;
                    break;
                }
            }
        }
        return inputOption;
    }

    private static void listMovies(Scanner scanner,
                                   List<String> inputList, OperacoesFilme operacoesFilme) { // >>> Opção 7

        if (inputList.isEmpty()) System.out.println("Nome não localizado");

        for (int i = 0; i < inputList.size(); i++) {
            String titulo = inputList.get(i);

        }

        //System.out.println(operacoesFilme.getBancoDeFilmes());


//        String inputOption = "";
//        boolean isValid = false;
//        while (!isValid) {
//            inputOption = getStringOption(scanner, UserMessage.LOADOPTION);
//            for (String item: checkList){
//                if (item.equals(inputOption)) {
//                    isValid = true;;
//                    break;
//                }
//            }
//        }
        //return inputOption;
    }


    private static String listAndChooseSearchNames(Scanner scanner,
                                                 List<String> inputList) {

        if (inputList.isEmpty()) {
            System.out.println("Nome não localizado");
            //return "N";
        }

        List<String> checkList = new ArrayList<>();
        checkList.add("N");
        checkList.add("X");

        for (int i = 0; i < inputList.size(); i++) {
            System.out.println((i + 1) + "- " + inputList.get(i));
            checkList.add(String.valueOf(i + 1));
        }

        String inputOption = "";
        boolean isValid = false;
        while (!isValid) {
            if (inputList.isEmpty()) inputOption = getStringOption(scanner,
                    UserMessage.LOADOPTION);
            else inputOption = getStringOption(scanner, UserMessage.SEARCHOPTION);

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
