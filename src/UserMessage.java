public enum UserMessage {
    GETARTIST("\nNome do(a) artista\n> "),
    GETDIRECTOR("\nNome do(a) diretor(a)\n> "),
    GETMOVIETITLE("\nTítulo do Filme\n> "),

    SEARCHNAME("\nDigite parte do nome para verificar em nosso cadastro\n> "),

    SEARCHOPTION("\nOpções:\n" +
            "NÚMERO para usar um nome da lista ou\n" +
            "'N' para cadastrar um novo nome\n" +
            "'X' para sair do cadastro\n> "),

    LOADOPTION("\nOpções:\n" +
            "'N' para cadastrar um novo nome ou\n" +
            "'X' para sair do cadastro\n> "),

    GETMOVIEYEAR("\nAno do Filme\n> "),

    GETMOVIECERTIFICATION("\nClassificação: 'livre', 'R', '10', '12', '14'," +
            " '16' ou '18'\n> "),

    GETMOVIEHOURS("\nQuantas horas de filme? (apenas horas)\n> "),

    GETMOVIEMINUTES("\nQuantos minutos de filme? (apenas minutos)\n> "),

    GETMOVIERATING("\nRating do filme de '1.0' a '10.0'\n> "),

    GETMOVIEKIND("\nGenero do filme?\nSugestões:\n" +
            "Ação, Aventura, Biografia, Comédia, Drama,\n" +
            "Fantasia, Ficção Científica, Guerra, Mistério,\n" +
            "Policial, Romance, Suspense, Terror\n> "),

    DUPLICATEACTION("""
            >>> Já está em nossos servidores e não pode ser duplicado(a)
            Deseja efetuar um novo cadastro? <'S' ou 'N'>
            >\s"""),
    GETOPTIONS("> "),
    CHECKDELETE("\nConfirma a exclusão <'S' ou 'N'>\n> "),
    CHECKUPDATE("\nConfirma a alteração <'S' ou 'N'>\n> ");

    final String userMessage;

    UserMessage(String s) {
        this.userMessage = s;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
