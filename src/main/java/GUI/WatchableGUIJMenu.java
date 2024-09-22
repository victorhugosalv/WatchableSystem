package GUI;

import models.WatchableSystem;

import javax.swing.*;
import java.awt.*;

public class WatchableGUIJMenu extends JFrame {
    JLabel linha1, linha2;
    ImageIcon locadoraImg = new ImageIcon("imgs/locadora.png");
    WatchableSystem watchable = new WatchableSystem();
    JMenuBar barraDeMenu = new JMenuBar();
    public WatchableGUIJMenu(){
        setTitle("Watchable System");
        setSize(800,600);
        setLocation(200,200);
        setResizable(true);
        setBackground(Color.WHITE);
        linha1 = new JLabel("Locadora de Filmes/Series", JLabel.CENTER);
        linha1.setForeground(Color.BLACK);
        linha1.setFont(new Font("Serif", Font.BOLD, 20));
        linha2 = new JLabel(locadoraImg, JLabel.CENTER);
        setLayout(new GridLayout(3,1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarAssistivel = new JMenuItem("Salvar Assistível");
        menuSalvar.add(menuSalvarAssistivel);
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarAssistivel = new JMenuItem("Pesquisar Assístivel");
        menuPesquisar.add(menuPesquisarAssistivel);
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverAssistivel = new JMenuItem("Remover Assistivel");
        menuRemover.add(menuRemoverAssistivel);
        menuPesquisarAssistivel.addActionListener(new WatchableSearchController(watchable,this));
        menuRemoverAssistivel.addActionListener(new WatchableRemoveController(watchable,this));
        menuSalvarAssistivel.addActionListener(new WatchableAddController(watchable,this));
        barraDeMenu.add(menuSalvar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        setJMenuBar(barraDeMenu);
    }

}
