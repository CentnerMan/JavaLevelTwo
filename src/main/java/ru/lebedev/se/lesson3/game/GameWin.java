package ru.lebedev.se.lesson3.game;

import javax.swing.*;

public class GameWin {
    public static void main(String[] args) throws Exception {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        final Fighting window = new Fighting();
    }
}

