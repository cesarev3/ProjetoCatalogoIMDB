import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // criando o objeto viewScreens e carregando a tela de Boas-vindas
        Screens screens = new Screens();
        screens.printWelcomeScreen();

        // preparando a lista de exemplo de filmes
        SampleMovieList sampleMovieList = getSampleMovieList();

        // criando objetos de acesso ao Banco de Dados
        OperacoesPessoa operacoesPessoa = new OperacoesPessoa();
        OperacoesFilme operacoesFilme = new OperacoesFilme();

        // carregando exemplo de Direção no Banco de Dados
        loadDirectorFromSampleFilmList(sampleMovieList, operacoesPessoa);

        // carregando exemplo de Artistas no Banco de Dados
        loadArtistsFromSampleFilmList(sampleMovieList, operacoesPessoa);

        // carregando exemplo de Filmes no Banco de Dados
        loadFilmsFromSampleFilmListInDB(
                sampleMovieList,
                operacoesPessoa,
                operacoesFilme);

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
                    List<String> getArtistSearchList = searchNames(
                            scanner, operacoesPessoa.getBancoDeArtistas());

                    selectAndSaveArtist(
                            scanner, getArtistSearchList, operacoesPessoa);

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 2:
                    screens.printCreateDirectorScreen();

                    System.out.print("\nConsultar Diretores já cadastrados");
                    String getDirector;
                    List<String> getDirectorsSearchList = searchNames(
                            scanner, operacoesPessoa.getBancoDeDirecao());

                    selectAndSaveDirector(
                            scanner, getDirectorsSearchList, operacoesPessoa);

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 3:
                    screens.printCreateMovieScreen();

                    // validando e recebendo nome do Filme
                    System.out.print("\nTítulo do filme");

                    List<String> getMovieTitleSearchList = searchTitles(
                            scanner, operacoesFilme.getBancoDeFilmes());

                    String getOption3a = listAndGetOption(
                            scanner, getMovieTitleSearchList);

                    String getInputMovieTitle;

                    if (getOption3a.equals("X")) {
                        scanner.reset();
                        options = loadMainScreen(screens, scanner);
                        break;
                    }

                    if (getOption3a.equals("N")) {
                        getInputMovieTitle = getAndCheckMovieTitle(scanner,
                        operacoesFilme);

                    } else {
                        int index = Integer.parseInt(getOption3a);
                        getInputMovieTitle = getMovieTitleSearchList.get(index - 1);
                    }

                    // validando e recebendo nome do Diretor
                    System.out.print("\nDireção do filme");

                    List<String> getMovieDirectorSearchList = searchNames(
                            scanner, operacoesPessoa.getBancoDeDirecao());

                    String getOption3b = listAndChooseSearchNames(
                            scanner, getMovieDirectorSearchList);

                    String getInputMovieDirector;

                    if (getOption3b.equals("X")) {
                        scanner.reset();
                        options = loadMainScreen(screens, scanner);
                        break;
                    }

                    if (getOption3b.equals("N")) {
                        getInputMovieDirector = getAndCheckPerson(scanner,
                                operacoesPessoa, 2);

                        if (!getInputMovieDirector.equals("isNull")) {
                            Pessoa director = new Direcao(getInputMovieDirector);
                            operacoesPessoa.salvarDirecao(director);
                        }

                    } else {
                        int index = Integer.parseInt(getOption3b);
                        getInputMovieDirector = getMovieDirectorSearchList.get(
                                index - 1);
                    }

                    // validando e recebendo nome dos Artistas
                    String[] getInputMovieArtists = new String[5];
                    System.out.println("\nVocê pode cadastrar até 5 artistas por filme");

                    for (int i = 0; i < 5; i++) {
                        System.out.printf("%dº Artista do filme", i + 1);
                        List<String> getMovieArtistsSearchList = searchNames(
                                scanner, operacoesPessoa.getBancoDeArtistas());

                        String getOption3c = listAndChooseSearchNames(
                                scanner, getMovieArtistsSearchList);

                        if (getOption3c.equals("X")) {
                            scanner.reset();
                            options = loadMainScreen(screens, scanner);
                            break;
                        }

                        if (getOption3c.equals("N")) {
                            getInputMovieArtists[i] = getAndCheckPerson(scanner,
                                    operacoesPessoa, 1);

                            if (!getInputMovieArtists.equals("isNull")) {
                                Pessoa artist = new Artista(getInputMovieArtists[i]);
                                operacoesPessoa.salvarArtista(artist);
                            }

                        } else {
                            int index = Integer.parseInt(getOption3c);
                            getInputMovieArtists[i] = getMovieArtistsSearchList.get(index - 1);

                        }
                    }

                    // validando e recebendo outras variáveis
                    int getInputMovieYear = getAndCheckMovieYear(scanner);
                    String getInputMovieCertification = getAndCheckMovieCertification(scanner);
                    String getInputMovieLength = getMovieLength(scanner);
                    String getInputMovieRating = getAndCheckMovieRating(scanner);
                    String getInputMovieKind = getString(scanner, UserMessage.GETMOVIEKIND);

                    // montando parametros do objeto
                    Pessoa diretor = operacoesPessoa.getDirecao(getInputMovieDirector);

                    List <Pessoa> artistas = new ArrayList<>();
                    for(String item : getInputMovieArtists){
                        Pessoa artista = operacoesPessoa.getArtista(item);
                        artistas.add(artista);
                    }

                    // criando objeto Filme e salvando no Banco de Dados
                    Filme filme = new Filme(getInputMovieTitle, getInputMovieYear,
                            getInputMovieCertification, getInputMovieLength,
                            getInputMovieRating, getInputMovieKind, diretor, artistas);

                    operacoesFilme.salvarFilmes(filme);

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 4:
                    screens.printReadTop20FilmsScreen();

                    // criando objeto de usuários salvos no DB e imprimindo
                    printSampleMovies(operacoesFilme.getBancoDeFilmes());

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 5:
                    screens.printReadByArtistScreen();

                    // criando objeto de usuários salvos no DB e imprimindo
                    List<String> getPersonSearchList = searchNames(
                            scanner, operacoesPessoa.getBancoDeArtistas());

                    listMoviesByArtist(getPersonSearchList, operacoesFilme);

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 6:
                    screens.printReadByDirectorScreen();

                    // criando objeto de usuários salvos no DB e imprimindo
                    List<String> getMovieDirectorsToPrint = searchNames(
                            scanner, operacoesPessoa.getBancoDeDirecao());

                    listMoviesByDirector(getMovieDirectorsToPrint, operacoesFilme);

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 7:
                    screens.printReadByTitleScreen();

                    // criando objeto de usuários salvos no DB e imprimindo

                    List<String> getMovieTitlesToPrint = searchMovieTitles(
                            scanner, operacoesFilme.getBancoDeFilmes());

                    listMoviesByTitle(getMovieTitlesToPrint, operacoesFilme);

                    // voltando para tela principal
                    options = loadMainScreen(screens, scanner);

                    scanner.reset();
                    break;

                case 8:
                    screens.printReadByCertificationScreen();

                    // criando objeto de usuários salvos no DB e imprimindo
                    String getMovieCertificationToPrint = getAndCheckMovieCertification(scanner);
                    listMoviesByCertification(getMovieCertificationToPrint, operacoesFilme);

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

    private static SampleMovieList getSampleMovieList() {
        SampleMovieList sampleMovieList = new SampleMovieList();
        sampleMovieList.splitToRegister();
        sampleMovieList.splitToColumns();
        sampleMovieList.buildMovieTitle();
        sampleMovieList.buildMovieDirector();
        sampleMovieList.buildMovieArtists();
        sampleMovieList.buildMovieData();
        return sampleMovieList;
    }

    private static void loadDirectorFromSampleFilmList(SampleMovieList sampleMovieList,
                                                       OperacoesPessoa operacoesPessoa) {
        for (String x: sampleMovieList.getMovieDirector()){
            boolean isRepetido = operacoesPessoa.checkDirecao(x);

            if (!isRepetido){
                Pessoa director = new Direcao(x);
                operacoesPessoa.carregarDirecao(director);
            }
        }
    }

    private static void loadArtistsFromSampleFilmList(SampleMovieList sampleMovieList,
                                                      OperacoesPessoa operacoesPessoa) {
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
    }

    private static void loadFilmsFromSampleFilmListInDB(SampleMovieList sampleMovieList,
                                                        OperacoesPessoa operacoesPessoa,
                                                        OperacoesFilme operacoesFilme) {
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

    private static String getStringOption(Scanner scanner, UserMessage message) {
        System.out.print(message.getUserMessage());
        return scanner.nextLine().toUpperCase();
    }

    private static void selectAndSaveArtist(Scanner scanner,
                                            List<String> getArtistSearchList,
                                            OperacoesPessoa operacoesPessoa) {
        String getArtist;
        String getOption1 = listAndGetOption(
                scanner,
                getArtistSearchList);

        if (getOption1.equals("N")) {
            getArtist = getAndCheckPerson(scanner,
                    operacoesPessoa, 1);

            // criando objeto e salvando no Banco de Dados
            if (!getArtist.equals("isNull")) {
                Pessoa artist = new Artista(getArtist);
                operacoesPessoa.salvarArtista(artist);
            }
        }
    }

    private static void selectAndSaveDirector(Scanner scanner,
                                              List<String> getDirectorsSearchList,
                                              OperacoesPessoa operacoesPessoa) {
        String getDirector;
        String getOption2 = listAndGetOption(scanner, getDirectorsSearchList);

        if (getOption2.equals("N")) {
            getDirector = getAndCheckPerson(scanner,
                    operacoesPessoa, 2);

            // criando objeto e salvando no Banco de Dados
            if (!getDirector.equals("isNull")) {
                Pessoa director = new Direcao(getDirector);
                operacoesPessoa.salvarDirecao(director);
            }
        }
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
                    isValid = true;
                    break;
                }
            }
        }
        return inputOption;
    }

    private static String getAndCheckMovieTitle(Scanner scanner,
                                                OperacoesFilme operacoesFilme) {
        String inputMovieTitle = "";
        boolean isRepeated = true;


        while (isRepeated) {
            inputMovieTitle = getString(scanner, UserMessage.GETMOVIETITLE);
            isRepeated = operacoesFilme.checkFilme(inputMovieTitle);

            if (isRepeated) {
                if (continueProcedure(scanner)) {
                    inputMovieTitle = "isNull";
                    break;
                }
            }
        }
        return inputMovieTitle;
    }

    private static String getAndCheckMovieCertification(Scanner scanner) {
        String[] movieCertification = {"livre", "R", "10", "12", "14", "16", "18"};
        String inputString = "";
        boolean isValid = false;

        while (!isValid) {
            inputString = getString(scanner, UserMessage.GETMOVIECERTIFICATION);
            for (String item: movieCertification){
                if (item.equals(inputString)) {
                    System.out.println(inputString);
                    isValid = true;
                    break;
                }
            }
        }
        return inputString;
    }

    private static String getMovieLength(Scanner scanner) {

        String inputHours = getString(scanner, UserMessage.GETMOVIEHOURS);
        String inputMinutes = getString(scanner, UserMessage.GETMOVIEMINUTES);
        return inputHours + "h " + inputMinutes + "min";
    }

    private static String getAndCheckMovieRating(Scanner scanner) {

        String inputString;
        while (true) try {
            inputString = getString(scanner, UserMessage.GETMOVIERATING);
            double inputMovieRating = Double.parseDouble(inputString);
            if (inputMovieRating >= 0.0 && inputMovieRating <= 10.0) break;
            System.out.println(">>> valor fora da faixa válida");

        } catch (RuntimeException e) {
            System.out.println(">>> valor inválido");
        }

        return inputString + "/10";
    }

    public static void printSampleMovies(List<Filme> sampleFilmList){
        for (Filme filme : sampleFilmList) {
            System.out.printf("%s\tDireção: %s\n",
                    filme.getTitulo(),
                    filme.getDiretor().getNome());

            System.out.printf("Ano: %s\tDuração: %s\tRating: %s\n",
                    filme.getLancamento(),
                    filme.getTempoDeDuracao(),
                    filme.getAvaliacao());

            System.out.printf("Gênero: %s\tClassificação: %s\n",
                    filme.getGenero(),
                    filme.getClassificacao());

            System.out.print("Atores: ");
            int index = 0;
            for (Pessoa artista : filme.getBancoDeArtistas()) {
                index += 1;
                if (index == 4) {
                    System.out.print("\n        ");
                    System.out.print(artista.getNome() + ", ");
                } else {
                    System.out.print(artista.getNome() + ", ");
                }
            }
            System.out.println("\n");

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

    private static boolean continueProcedure(Scanner scanner) {
        String updateUser = getStringOption(scanner, UserMessage.DUPLICATEACTION);
        return !updateUser.equals("S");
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
                    isValid = true;
                    break;
                }
            }
        }
        return inputOption;
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
                if (continueProcedure(scanner)) {
                    inputPerson = "isNull";
                    break;
                }
            }
        }
        return inputPerson;
    }

    private static List<String> searchMovieTitles(Scanner scanner,
                                             List<Filme> bancoDeFilmes) {
        List<String> inputList = new ArrayList<>();

        for (Filme filme : bancoDeFilmes) {
            inputList.add(filme.getTitulo());
        }

        String searchName = getString(scanner, UserMessage.SEARCHNAME);
        return inputList.stream().filter(nome -> nome.toLowerCase()
                .contains(searchName.toLowerCase())).toList();
    }

    private static int getAndCheckMovieYear(Scanner scanner) {
        LocalDate currentYear = LocalDate.now();
        int inputMovieYear;

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

    private static void listMoviesByTitle(List<String> inputList,
                                          OperacoesFilme operacoesFilme) {

        if (inputList.isEmpty()) System.out.println("Nome não localizado");

        List<Filme> listMoviesSelected = new ArrayList<>();
        String title;

        for (String s : inputList) {
            title = s;
            for (Filme filme : operacoesFilme.getBancoDeFilmes()) {
                if (title.equals(filme.getTitulo())) {
                    listMoviesSelected.add(filme);
                }
            }
        }
        printSampleMovies(listMoviesSelected);
    }

    private static void listMoviesByCertification(String certification,
                                                  OperacoesFilme operacoesFilme) {

        List<Filme> listMoviesSelected = new ArrayList<>();

        for (Filme filme : operacoesFilme.getBancoDeFilmes()) {
            if (certification.equals(filme.getClassificacao())) {
                    listMoviesSelected.add(filme);
            }
        }
        printSampleMovies(listMoviesSelected);
    }

    private static void listMoviesByDirector(List<String> inputList,
                                             OperacoesFilme operacoesFilme) {

        if (inputList.isEmpty()) System.out.println("Nome não localizado");

        List<Filme> listMoviesSelected = new ArrayList<>();
        String director;

        for (String s : inputList) {
            director = s;
            for (Filme filme : operacoesFilme.getBancoDeFilmes()) {
                if (director.equals(filme.getDiretor().getNome())) {
                    listMoviesSelected.add(filme);
                }
            }
        }
        printSampleMovies(listMoviesSelected);
    }

    private static void listMoviesByArtist(List<String> inputList,
                                           OperacoesFilme operacoesFilme) {

        if (inputList.isEmpty()) System.out.println("Nome não localizado");


        List<Filme> listMoviesSelected = new ArrayList<>();
        String artist;

        for (String s : inputList) {
            artist = s;
            for (Filme filme : operacoesFilme.getBancoDeFilmes()) {
                for (Pessoa artista : filme.getBancoDeArtistas()) {

                    if (artista.getNome().equals(artist)) {
                      listMoviesSelected.add(filme);
                    }
                }
            }
        }
        printSampleMovies(listMoviesSelected);
    }
}
