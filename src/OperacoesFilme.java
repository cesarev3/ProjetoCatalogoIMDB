import java.util.ArrayList;
import java.util.List;

public class OperacoesFilme {
    private List<Filme> bancoDeFilmes;

    OperacoesFilme() {
        this.bancoDeFilmes = new ArrayList<>();
    }

    public boolean checkFilme(String titulo) {
        for (Filme filme : bancoDeFilmes) {
            if (filme.getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false;
    }

    public void carregarFilmes(Filme filme){
        bancoDeFilmes.add(filme);
    }

    public void salvarFilmes(Filme filme){
        bancoDeFilmes.add(filme);
        System.out.printf("%s salvo com sucesso no cadastro de Filmes\n", filme.getTitulo());
    }

    public List<Filme> getBancoDeFilmes() {
        return this.bancoDeFilmes;
    }
}