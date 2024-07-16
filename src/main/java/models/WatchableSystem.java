package models;

import entities.Watchable;
import exception.WatchableException;

import java.util.*;

public class WatchableSystem implements WatchableSystemOptions{

    List<Watchable> watchables;

    public WatchableSystem(){
        this.watchables = new ArrayList<Watchable>();
    }

    @Override
    public void cadastraWatchable(Watchable watch) {
        watchables.add(watch);
    }

    @Override
    public void removeWatchablePorNome(String nome) {
            watchables.remove(pesquisaWatchablePeloNome(nome));
    }

    @Override
    public List<Watchable> listaWatchables(){
        try {
            if (watchables.isEmpty()) {
                throw new WatchableException("Lista não contém assistiveis!");
            }
        } catch  (WatchableException e) {
            System.err.println(e.getMessage());
        }
        Collections.sort(watchables);
        return watchables;
    }

    @Override
    public Watchable pesquisaWatchablePeloNome(String nome){
        Watchable watch = watchables.stream().filter(wa -> wa.getNomeDoConteudo().equalsIgnoreCase(nome)).findFirst().orElse(null);

        try{
        if (watch == null){
            throw new WatchableException("Não encontramos esse Assístivel!");
            }
        } catch (WatchableException e){
            System.err.println(e.getMessage());
        }
        return watch;
    }
}
