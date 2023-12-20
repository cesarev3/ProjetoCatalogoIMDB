import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String titulo;
    private int lancamento;
    private String classificacao;
    private String tempoDeDuracao;
    private String avaliacao;
    private String genero;
    private Pessoa diretor;
    private List<Pessoa> bancoDeArtistas;

    public Filme(String titulo, int lancamento, String classificacao,
                 String tempoDeDuracao, String avaliacao, String genero,
                 Pessoa diretor, List <Pessoa> bancoDeArtistas){
        this.titulo = titulo;
        this.lancamento = lancamento;
        this.classificacao = classificacao;
        this.tempoDeDuracao = tempoDeDuracao;
        this.genero = genero;
        this.diretor = diretor;
        this.bancoDeArtistas = bancoDeArtistas;

    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getLancamento() {
        return lancamento;
    }

    public void setLancamento(int lancamento) {
        this.lancamento = lancamento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getTempoDeDuracao() {
        return tempoDeDuracao;
    }

    public void setTempoDeDuracao(String tempoDeDuracao) {
        this.tempoDeDuracao = tempoDeDuracao;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Pessoa getDiretor() {
        return diretor;
    }

    public void setDiretor(Pessoa diretor) {
        this.diretor = diretor;
    }

    public List<Pessoa> getBancoDeArtistas() {
        return bancoDeArtistas;
    }

    public void setBancoDeArtistas(List<Pessoa> bancoDeArtistas) {
        this.bancoDeArtistas = bancoDeArtistas;
    }

}
