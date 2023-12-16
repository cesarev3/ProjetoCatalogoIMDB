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

//        for (int i = 0; i < 20; i++) {
//            System.out.println(i + ": " + sampleFilmList.getFilmAll()[i]);
//        }
//
//        System.out.println("\nmudando de método\n");
//
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.println(i + ": " + sampleFilmList.getFilmByColumns()[i][j]);
//            }
//
//        }
//
//        System.out.println("\nmudando de método\n");
//
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.println(i + ": " + sampleFilmList.getFilmArtists()[i][j]);
//            }
//
//        }



        printSampleFilms(sampleFilmList);







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
                    screens.printReadByArtistScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 5:
                    screens.printReadByDirectorScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 6:
                    screens.printReadByIMDBRankingScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 7:
                    screens.printReadByCertificationScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;



                case 8:
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
            isRepeated = false;
//            isRepeated = operacoesPessoa.checkArtista(inputPessoa);

            if (isRepeated) {
                System.out.println(">>> Artista duplicado. Cadastre outra pessoa\n");
            }
        }
        return inputPerson;
    }

    private static String checkDirector(Scanner scanner,
                                      OperacoesPessoa operacoesPessoa) {
        String inputPerson = "";
        boolean isRepeated = true;

        while (isRepeated) {
            inputPerson = getString(scanner, UserMessage.GETARTIST);
            isRepeated = false;
//            isRepeated = operacoesPessoa.checkDiretor(inputPessoa);

            if (isRepeated) {
                System.out.println(">>> Diretor duplicado. Cadastre outra pessoa\n");
            }
        }
        return inputPerson;
    }



 /*
    private static String findUser(Scanner scanner,
                                   UserOperations userOperations) {
        String inputEmail = "";
        boolean hasFound = false;

        while (!hasFound) {
            inputEmail = getString(scanner, UserMessage.GETEMAILS);
            hasFound = userOperations.validarEmail(inputEmail);

            if (!hasFound) {
                System.out.println(">>> Usuário não encontrado, digite " +
                        "novamente\n");
            }
        }
        return inputEmail;
    }

/*
    private static void printOneUser(ArrayList<User> dataBaseFindUser,
                                     String inputEmail) {
        for(User item : dataBaseFindUser) {

            if (item.getUserEmail().equals(inputEmail)) {
                System.out.println("Nome: " + item.getUserName());
                System.out.println("e-mail: " + item.getUserEmail());
                System.out.println("Nascimento: " + item.getUserBirthDate());
            }
        }
    }

    private static void printAllUsers(ArrayList<User> usuariosSalvos) {
        for(User item : usuariosSalvos) {
            System.out.println("\nNome: " + item.getUserName());
            System.out.println("e-mail: " + item.getUserEmail());
            System.out.println("Nascimento: " + item.getUserBirthDate());
        }
    }

     */

    public static void printSampleFilms(SampleFilmList sampleFilmList){
        for (int i = 0; i < sampleFilmList.getFilmDirector().length; i++) {
            System.out.printf("%-30s %15s %4s %7s %17s %3s\n",
                    sampleFilmList.getFilmData()[i][0],
                    sampleFilmList.getFilmDirector()[i],
                    sampleFilmList.getFilmData()[i][1],
                    sampleFilmList.getFilmData()[i][4],
                    sampleFilmList.getFilmData()[i][5],
                    sampleFilmList.getFilmData()[i][2]);

            System.out.printf("%21s %21s %21s %21s %21s\n",
                    sampleFilmList.getFilmArtists()[i][0],
                    sampleFilmList.getFilmArtists()[i][1],
                    sampleFilmList.getFilmArtists()[i][2],
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
