public enum UserMessage {
    GETARTIST("\nNome do(a) artista\n> "),
    GETDIRECTOR("\nNome do(a) diretor(a)\n> "),
    GETFILMTITLE("\nTítulo do Filme\n> "),

    GETFILMYEAR("\nAno do Filme\n> "),

    GETFILMCERTIFICATION("\nClassificação: livre, 10, 12, 14, 16 ou 18\n> "),

    GETFILMHOURS("\nQuantas horas de filme? (apenas horas)\n> "),

    GETFILMMINUTES("\nQuantos minutos de filme? (apenas minutos)\n> "),

    GETFILMRATING("\nRating do filme de 1.0 a 10.0\n> "),

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
