package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Watchable implements Comparable<Watchable> {
    private String tipoDoConteudo;
    private String nomeDoConteudo;
    private Double duracao;
    private LocalDate dataDeLancamento;
    private String sinopse;


    DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Watchable(String tipoDoConteudo, String nomeDoConteudo, Double duracao, LocalDate dataDeLancamento, String sinopse){
        this.tipoDoConteudo = tipoDoConteudo;
        this.nomeDoConteudo = nomeDoConteudo;
        this.duracao = duracao;
        this.dataDeLancamento = dataDeLancamento;
        this.sinopse = sinopse;
    }

    public Watchable(){
        this(null,null,0.0,null,null);
    }

    public String getTipoDoConteudo() {
        return tipoDoConteudo;
    }

    public void setTipoDoConteudo(String tipoDoConteudo) {
        this.tipoDoConteudo = tipoDoConteudo;
    }

    public String getNomeDoConteudo() {
        return nomeDoConteudo;
    }

    public void setNomeDoConteudo(String nomeDoConteudo) {
        this.nomeDoConteudo = nomeDoConteudo;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Watchable watchable = (Watchable) o;
        return Objects.equals(nomeDoConteudo, watchable.nomeDoConteudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDoConteudo);
    }

    public String toString(){
        return "Tipo do Conteúdo: " + tipoDoConteudo + "\n"
                + "Nome Do " + tipoDoConteudo + ": " + nomeDoConteudo + "\n"
                + "Tempo de Duração: " + duracao + "\n"
                + "Data de Lançamento: " + dataDeLancamento.format(fm1) + "\n"
                + "Sinopse: " + sinopse + "\n";
    }


    @Override
    public int compareTo(Watchable other) {
        return dataDeLancamento.compareTo(other.getDataDeLancamento());
    }
}
