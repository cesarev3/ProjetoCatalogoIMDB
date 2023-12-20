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

    public List<Filme> getBancoDeFilmes() {
        return this.bancoDeFilmes;
    }
}