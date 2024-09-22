package GUI;

import entities.Watchable;
import exception.WatchableException;
import models.WatchableSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WatchableSearchController implements ActionListener {
    private WatchableSystem watchable;
    private JFrame janelaPrincipal;

    public WatchableSearchController(WatchableSystem watchable, JFrame janela) {
        this.watchable = watchable;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
        String nomepesquisar = JOptionPane.showInputDialog(janelaPrincipal, "Digite o nome do assistível que deseja procurar: ");
        Watchable pesquisado = watchable.pesquisaWatchablePeloNome(nomepesquisar);
            JOptionPane.showMessageDialog(janelaPrincipal,pesquisado);
        } catch (WatchableException et){
            JOptionPane.showMessageDialog(janelaPrincipal, et.getMessage());
        }
    }

}
