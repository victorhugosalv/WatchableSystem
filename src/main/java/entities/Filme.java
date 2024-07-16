package entities;

import java.time.LocalDate;

public class Filme extends Watchable{

    private String diretor;

    public Filme(String tipoDoConteudo, String nomeDoConteudo, Double duracao, LocalDate dataDeLancamento, String sinopse, String diretor) {
        super(tipoDoConteudo, nomeDoConteudo, duracao, dataDeLancamento, sinopse);
        this.diretor = diretor;
    }

    public Filme(){
        super();
        this.diretor = null;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString(){
        return super.toString()
                + "Diretor: " + diretor + "\n";
    }
}
