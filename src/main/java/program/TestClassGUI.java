package program;

import GUI.WatchableGUI;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestClassGUI extends JFrame {
    public static void main(String[] args) {
        JFrame janelatest = new WatchableGUI();
        janelatest.setVisible(true);
        janelatest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


