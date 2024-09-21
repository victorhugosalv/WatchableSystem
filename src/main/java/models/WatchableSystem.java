package models;

import entities.Watchable;
import exception.WatchableException;

import java.util.*;

public class WatchableSystem implements WatchableSystemOptions{

    Map<String, Watchable> watchables;

    public WatchableSystem(){
        this.watchables = new HashMap<>(){
        };
    }

    @Override
    public void cadastraWatchable(String nomeDoFilme,Watchable watch) {
        watchables.put(nomeDoFilme,watch);
    }

    @Override
    public void removeWatchablePorNome(String nome) {
            watchables.remove(nome);
    }

    @Override
    public Collection<Watchable> listaWatchables() throws WatchableException{
        if (watchables.isEmpty())
            throw new WatchableException("Lista não contém assistiveis!");

        Collection<Watchable> lista = new ArrayList<>();
        lista = watchables.values();
        return lista;
    }

    @Override
    public Watchable pesquisaWatchablePeloNome(String nome){
        Collection<Watchable> ws = watchables.values();
        Watchable watch = ws.stream().filter(wa -> wa.getNomeDoConteudo().equalsIgnoreCase(nome)).findFirst().orElse(null);
        if (watch == null)
            throw new WatchableException("Não encontramos esse Assístivel!");
        return watch;
    }
}
