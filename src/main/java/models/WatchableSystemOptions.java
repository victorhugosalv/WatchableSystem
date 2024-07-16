package models;

import entities.Watchable;

import java.util.List;

public interface WatchableSystemOptions {
    void cadastraWatchable(Watchable watch);
    void removeWatchablePorNome(String nome);
    List<Watchable> listaWatchables() throws Exception;
    Watchable pesquisaWatchablePeloNome(String nome);


}
