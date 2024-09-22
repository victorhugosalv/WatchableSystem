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
    public boolean cadastraWatchable(String nomeDoFilme,Watchable watch) {
        if (watchables.containsKey(nomeDoFilme))
            return false;
        watchables.put(nomeDoFilme, watch);
        return true ;
    }

    @Override
    public boolean removeWatchablePorNome(String nome) {
        if (watchables.containsKey(nome)){
            watchables.remove(nome);
            return true;
        }
        return false;
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
        Watchable watch = watchables.get(nome);
        if (watch == null)
            throw new WatchableException("Não encontramos esse Assístivel!");
        return watch;
    }
}
