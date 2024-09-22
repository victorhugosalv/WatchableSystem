package GUI;

import entities.Filme;
import entities.Serie;
import entities.Watchable;
import models.WatchableSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class WatchableAddController implements ActionListener {
    private WatchableSystem watchable;
    private JFrame janelaPrincipal;

    public WatchableAddController(WatchableSystem watchable, JFrame janela){
        this.watchable = watchable;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String tipo = JOptionPane.showInputDialog(janelaPrincipal, "Qual tipo de assistível?(Serie/Filme) ");
        String nome = JOptionPane.showInputDialog(JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome?"));
        double duracao = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,"Quanto tempo de duração? "));
        LocalDate date = LocalDate.parse(JOptionPane.showInputDialog(janelaPrincipal, "Qual data de lançamento?"));
        String sinopse = JOptionPane.showInputDialog(janelaPrincipal,"Digite a sinopse do " + tipo + " :" );

        if (tipo.equalsIgnoreCase("Filme")) {
            System.out.print("Digite o nome do diretor do Filme: ");
            String diretor = JOptionPane.showInputDialog(janelaPrincipal, "Nome do Diretor:");
            if (watchable.cadastraWatchable(nome, new Filme(tipo, nome, duracao, date, sinopse, diretor))){
                JOptionPane.showMessageDialog(janelaPrincipal,"Salvo com Sucesso");
            } else {
                JOptionPane.showMessageDialog(janelaPrincipal, "Não foi possível salvar!");
            }

        }
        int episodios = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Quantidade de Episódios da Série: "));
        if (watchable.cadastraWatchable(nome, new Serie(tipo, nome, duracao, date, sinopse, episodios))){
            JOptionPane.showMessageDialog(janelaPrincipal,"Salvo com Sucesso");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi possível salvar!");
        }
    }
}
