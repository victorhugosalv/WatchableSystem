package models;

import entities.Watchable;

import java.util.Collection;
import java.util.List;

public interface WatchableSystemOptions {
    void cadastraWatchable(String nome,Watchable watch);
    void removeWatchablePorNome(String nome);
    Collection<Watchable> listaWatchables() throws Exception;
    Watchable pesquisaWatchablePeloNome(String nome);


}
