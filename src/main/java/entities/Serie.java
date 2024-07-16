package entities;

import java.time.LocalDate;

public class Serie extends Watchable{
    private int episodios;

    public Serie(String tipoDoConteudo, String nomeDoConteudo, Double duracao, LocalDate dataDeLancamento, String sinopse, int episodios) {
        super(tipoDoConteudo, nomeDoConteudo, duracao, dataDeLancamento, sinopse);
        this.episodios = episodios;
    }

    public Serie() {
        super();
        this.episodios = 0;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public String toString(){
        return super.toString()
                + "Quantidade de Episódios: " + episodios + "\n";
    }
}
