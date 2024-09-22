package GUI;

import models.WatchableSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WatchableRemoveController implements ActionListener {
    private WatchableSystem watchable;
    private JFrame janelaPrincipal;

    public WatchableRemoveController(WatchableSystem watchable, JFrame janelaPrincipal) {
        this.watchable = watchable;
        this.janelaPrincipal = janelaPrincipal;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog("Digite o nome do assístivel que deseja remover:");
        if (watchable.removeWatchablePorNome(nome)){
            JOptionPane.showMessageDialog(janelaPrincipal, "Assistível removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Esse assístivel não está na lista");
        }
    }
}
