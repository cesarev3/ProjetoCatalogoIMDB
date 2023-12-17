public enum UserMessage {
    GETARTIST("\nNome do(a) artista\n> "),
    GETDIRECTOR("\nNome do(a) diretor(a)\n> "),
    DUPLICATEACTION("""
            >>> Já está salva em nosso cadastro
            Deseja cadastrar outra pessoa? <'s' ou 'n'>
            >\s"""),
    GETOPTIONS("> "),
    CHECKDELETE("\nConfirma a exclusão <'s' ou 'n'>\n> "),
    CHECKUPDATE("\nConfirma a alteração <'s' ou 'n'>\n> ");

    final String userMessage;

    UserMessage(String s) {
        this.userMessage = s;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
