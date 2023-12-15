public enum UserMessage {
    GETNAMES("\nNome do usuário\n> "),
    GETEMAILS("e-mail do usuário\n> "),
    GETOPTIONS("> "),
    CHECKDELETE("\nConfirma a exclusão <s ou n>\n> "),
    CHECKUPDATE("\nConfirma a alteração <s ou n>\n> "),
    GETBIRTHDATE("\nData de nascimento do usuário <ddMMYYYY>\n> ");

    final String userMessage;

    UserMessage(String s) {
        this.userMessage = s;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
