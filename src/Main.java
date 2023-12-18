import java.time.LocalDate;
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
        sampleMovieList.buildFilmTitle();
        sampleMovieList.buildFilmDirector();
        sampleMovieList.buildFilmArtists();
        sampleMovieList.buildFilmData();

        // criando o objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // criar os demais objetos
        OperacoesPessoa operacoesPessoa = new OperacoesPessoa();

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

                    // validando e recebendo a entrada
                    String getArtist = getAndCheckPerson(scanner,
                            operacoesPessoa, options);

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

                    // validando e recebendo a entrada
                    String getDirector = getAndCheckPerson(scanner,
                            operacoesPessoa, options);

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

                    // validando e recebendo a entrada *** trocar operacoesPessoa ela respectiva em filmes ***
                    String getFilmTitle = getAndCheckMovieTitle(scanner,
                            operacoesPessoa, options);

                    // recebendo os dados do cadastro nas variáveis
                    int getFilmYear = getAndCheckMovieYear(scanner);
                    String getFilmCertification = getAndCheckMovieCertification(scanner);
                    String getFilmLength = getMovieLength(scanner);
                    String getFilmRating = getAndCheckMovieRating(scanner);
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
                                                OperacoesPessoa operacoesPessoa,
                                                int options) {
        String inputMovieTitle = "";
        boolean isRepeated = true;


        while (isRepeated) {
                inputMovieTitle = getString(scanner, UserMessage.GETMOVIETITLE);
                isRepeated = false;
//                isRepeated = operacoesPessoa.checkArtista(inputFilmTitle);

            if (isRepeated) {
                if (!continueProcedure(scanner, UserMessage.DUPLICATEACTION)) break;
            }
        }
        return inputMovieTitle;
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
        String[] movieCertification = {"Livre", "10", "12", "14", "16", "18"};
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
                                            Screens viewScreens) {
        String inputString;

        while (true) {
            try {
                inputString = getString(scanner, message);
                boolean isMenuOptionOk = viewScreens.checkMenuOption(inputString);

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
        String updateUser = getString(scanner, message);
        return updateUser.equals("S") || updateUser.equals("s");
    }
}
