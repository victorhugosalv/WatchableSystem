package models;

import entities.Watchable;

import java.util.Collection;
import java.util.List;

public interface WatchableSystemOptions {
    boolean cadastraWatchable(String nome,Watchable watch);
    boolean removeWatchablePorNome(String nome);
    Collection<Watchable> listaWatchables() throws Exception;
    Watchable pesquisaWatchablePeloNome(String nome);


}
