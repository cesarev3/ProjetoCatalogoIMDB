public enum UserMessage {
    GETARTIST("\nNome do(a) artista\n> "),
    GETDIRECTOR("\nNome do(a) diretor(a)\n> "),
    GETMOVIETITLE("\nTítulo do Filme\n> "),

    GETMOVIEYEAR("\nAno do Filme\n> "),

    GETMOVIECERTIFICATION("\nClassificação: livre, 10, 12, 14, 16 ou 18\n> "),

    GETMOVIEHOURS("\nQuantas horas de filme? (apenas horas)\n> "),

    GETMOVIEMINUTES("\nQuantos minutos de filme? (apenas minutos)\n> "),

    GETMOVIERATING("\nRating do filme de 1.0 a 10.0\n> "),

    GETMOVIEKIND("\nGenero do filme?\nSugestões:\n" +
            "Ação, Aventura, Biografia, Comédia, Drama,\n" +
            "Fantasia, Ficção Científica, Guerra, Mistério,\n" +
            "Policial, Romance, Suspense, Terror\n> "),

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
