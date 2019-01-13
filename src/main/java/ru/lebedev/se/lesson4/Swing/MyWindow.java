/*
 * Copyright (c) 2019. Created by Anatoly Lebedev
 */

package ru.lebedev.se.lesson4;

import javax.swing.*;
import java.awt.*;

/**
 * @author Anatoly Lebedev
 * @version 1.0
 */
public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Chat");
        setBounds(800,300,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton btnSend = new JButton("Send");

        JTextField jtfMessage = new JTextField();

        JPanel panelChat = new JPanel();
        JPanel panelDown = new JPanel();

        JTextArea areaChat = new JTextArea(" ");
        areaChat.setEditable(false);

        JScrollPane jspChat = new JScrollPane();

        panelDown.setLayout(new BorderLayout());
        panelDown.add(jtfMessage);
        panelDown.add(btnSend);

        jspChat.add(areaChat);
        panelChat.add(jspChat);

        add(panelChat, BorderLayout.CENTER);
        add(panelDown, BorderLayout.SOUTH);


        setVisible(true);
    }

}
