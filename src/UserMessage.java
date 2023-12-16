public enum UserMessage {
    GETARTIST("\nNome do(a) artista\n> "),
    GETDIRECTOR("\nNome do(a) diretor(a)\n> "),
    CHECKCONTINUE("\nDeseja continuar? <'s' ou 'n'>\n> "),
    GETOPTIONS("> "),
    CHECKDELETE("\nConfirma a exclusão <'s' ou 'n'>\n> "),
    CHECKUPDATE("\nConfirma a alteração <'s' ou 'n'>\n> "),
    GETBIRTHDATE("\nData de nascimento do usuário <ddMMYYYY>\n> ");

    final String userMessage;

    UserMessage(String s) {
        this.userMessage = s;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
