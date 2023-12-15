import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // criando o objeto viewScreens
        Screens screens = new Screens();

        // imprimindo tela de boas vindas
        screens.printWelcomeScreen();

        // criando o objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // criar os demais objetos
        // **** IMPORTANTE ****

        // imprimindo tela de menu e recebendo opção
        screens.printMainScreen();
        int options = getAndCheckMenuOption(
                scanner, UserMessage.GETOPTIONS, screens
        );

        // inicializando variáveis para bloco While-Switch
        String getEmail;
        String getName;
        int[] getBirthdayDate;

        // iniciando laço While-Switch
        while (true) {
            switch (options) {
                case 1:
                    screens.printCreateScreen();

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

                case 2:
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

                case 3:
                    screens.printReadByArtistScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 4:
                    screens.printReadByDirectorScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 5:
                    screens.printReadByIMDBRankingScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;

                case 6:
                    screens.printReadByCertificationScreen();

                    // criando objeto de usuários salvos no DB e imprimindo


                    // voltando para tela principal
                    screens.printMainScreen();
                    options = getAndCheckMenuOption(
                            scanner, UserMessage.GETOPTIONS, screens
                    );

                    scanner.reset();
                    break;



                case 7:
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

    /*
    private static String checkEntry(Scanner scanner,
                                     UserOperations userOperations) {
        String inputEmail = "";
        boolean isRepeated = true;

        while (isRepeated) {
            inputEmail = getString(scanner, UserMessage.GETEMAILS);
//            isRepeated = userOperations.validarEmail(inputEmail);

            if (isRepeated) {
                System.out.println(">>> Usuário duplicado. Dados não serão" +
                        " salvos\n");
            }
        }
        return inputEmail;
    }

     */

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
