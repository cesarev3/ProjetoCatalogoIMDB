import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // criando o objeto viewScreens
        Screens screens = new Screens();

        // imprimindo tela de boas vindas
        screens.printWelcomeScreen();

        // preparando a lista de exemplo de filmes
        SampleFilmList sampleFilmList = new SampleFilmList();
        sampleFilmList.splitToRegister();
        sampleFilmList.splitToColumns();
        sampleFilmList.buildFilmTitle();
        sampleFilmList.buildFilmDirector();
        sampleFilmList.buildFilmArtists();
        sampleFilmList.buildFilmData();

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
        String getPerson;
        String getName;
        int[] getBirthdayDate;

        // iniciando laço While-Switch
        while (true) {
            switch (options) {
                case 1:
                    screens.printCreateArtistScreen();

                    // validando e recebendo a entrada
                    getPerson = checkArtist(scanner, operacoesPessoa);

                    // montando parametros do objeto
                    Pessoa artist = new Artista(getPerson);

                    // salvando novo usuário no DB
                    //operacoesPessoa.salvarArtista(artist);

                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 2:
                    screens.printCreateDirectorScreen();

                    // validando e recebendo a entrada *** fazer método ***
                    getPerson = checkDirector(scanner, operacoesPessoa);

                    // montando parametros do objeto
                    Pessoa director = new Direcao(getPerson);

                    // salvando novo usuário no DB
                    operacoesPessoa.salvarPessoa(director);

                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;


                case 3:
                    screens.printCreateMovieScreen();

                    // validando e recebendo a entrada *** fazer método ***


                    // recebendo os dados do cadastro nas variáveis


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
                    printSampleFilms(sampleFilmList);

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


    private static String checkArtist(Scanner scanner,
                                      OperacoesPessoa operacoesPessoa) {
        String inputPerson = "";
        boolean isRepeated = true;

        while (isRepeated) {
            inputPerson = getString(scanner, UserMessage.GETARTIST);
            isRepeated = true;
//            isRepeated = operacoesPessoa.checkArtista(inputPessoa);

            if (isRepeated) {
                System.out.println(">>> Artista duplicado. Cadastre outra pessoa\n");
                if (!continueProcedure(scanner, UserMessage.CHECKCONTINUE)) break;
            }
        }
        return inputPerson;
    }

    private static String checkDirector(Scanner scanner,
                                      OperacoesPessoa operacoesPessoa) {
        String inputPerson = "";
        boolean isRepeated = true;

        while (isRepeated) {
            inputPerson = getString(scanner, UserMessage.GETDIRECTOR);
            isRepeated = false;
//            isRepeated = operacoesPessoa.checkDiretor(inputPessoa);

            if (isRepeated) {
                System.out.println(">>> Diretor duplicado. Cadastre outra pessoa\n");
                if (!continueProcedure(scanner, UserMessage.CHECKCONTINUE)) break;
            }
        }
        return inputPerson;
    }

    public static void printSampleFilms(SampleFilmList sampleFilmList){
        for (int i = 0; i < sampleFilmList.getFilmDirector().length; i++) {
            System.out.printf("%s\tDireção: %s\n",
                    sampleFilmList.getFilmData()[i][0],
                    sampleFilmList.getFilmDirector()[i]);

            System.out.printf("Ano: %s\tDuração: %s\tRating: %s\n",
                    sampleFilmList.getFilmData()[i][1],
                    sampleFilmList.getFilmData()[i][3],
                    sampleFilmList.getFilmData()[i][4]);

            System.out.printf("Gênero: %s\tClassificação: %s\n",
                    sampleFilmList.getFilmData()[i][5],
                    sampleFilmList.getFilmData()[i][2]);

            System.out.printf("Atores: %s, %s, %s\n",
                    sampleFilmList.getFilmArtists()[i][0],
                    sampleFilmList.getFilmArtists()[i][1],
                    sampleFilmList.getFilmArtists()[i][2]);

            System.out.printf("        %s, %s\n\n",
                    sampleFilmList.getFilmArtists()[i][3],
                    sampleFilmList.getFilmArtists()[i][4]);
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
