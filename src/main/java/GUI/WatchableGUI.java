package GUI;

import models.WatchableSystem;

import javax.swing.*;
import java.awt.*;

public class WatchableGUI extends JFrame {
    JLabel linha1,linha2;
    ImageIcon locadoraImg = new ImageIcon("imgs/locadora.png");
    ImageIcon saveImg = new ImageIcon("imgs/salvar.png");
    ImageIcon searchImg = new ImageIcon("imgs/search.png");
    ImageIcon deleteImg = new ImageIcon("imgs/delete.png");
    JButton botaoSalvar, botaoPesquisar, botaoRemover;
    WatchableSystem watchable = new WatchableSystem();
    public WatchableGUI(){
        setTitle("Locadora de Assistíveis");
        setSize(1200,800);
        setLocation(0,0);
        setResizable(true);
        getContentPane().setBackground(Color.lightGray);
        linha1 = new JLabel("Lista de Assistíveis Disponíveis", JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Serif",Font.BOLD,20));
        linha2 = new JLabel(locadoraImg, JLabel.CENTER);
        botaoSalvar = new JButton("Salvar", saveImg);
        botaoSalvar.addActionListener(new WatchableAddController(watchable, this));
        botaoPesquisar = new JButton("Pesquisar", searchImg);
        botaoPesquisar.addActionListener(new WatchableSearchController(watchable, this));
        botaoRemover = new JButton("Remover",deleteImg);
        botaoRemover.addActionListener(new WatchableRemoveController(watchable, this));
        getContentPane().setLayout(new GridLayout(3,2));
        getContentPane().add(linha1);
        getContentPane().add(botaoSalvar);
        getContentPane().add(linha2);
        getContentPane().add(botaoPesquisar);
        getContentPane().add(new JLabel());
        getContentPane().add(botaoRemover);
    }
}
