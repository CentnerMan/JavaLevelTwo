package ru.lebedev.se.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainClass {
    public static void main(String[] args) {
        new MyWindow();
    }
}

class MyWindow extends JFrame {
    public MyWindow() throws HeadlessException {
        setTitle("Java GUI");
        setBounds(800,300,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        centerPanel.setBackground(Color.gray);
        bottomPanel.setBackground(Color.darkGray);

        bottomPanel.setPreferredSize(new Dimension(1,40));

        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
        bottomPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new BorderLayout());

        JButton jb = new JButton("Send");

        final JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        centerPanel.add(jsp, BorderLayout.CENTER);

        final JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(300, 28));

        jta.setEditable(false);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
                jtf.grabFocus();
            }
        });

        bottomPanel.add(jtf);
        bottomPanel.add(jb);


        setVisible(true);
    }
}















//    setTitle("Java GUI");
//    setBounds(800,300,500,400);
//    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//    int sizeW = 600;
//    int sizeH = 500;
//
//    int locationX = (screenSize.width - sizeW) / 2;
//    int locationY = (screenSize.height - sizeH) / 2;
//
//    setBounds(locationX, locationY, sizeW, sizeH);
//
//    // setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//    setLayout(new FlowLayout());
//
//        JButton jbt1 = new JButton("btn1");
//
//        jbt1.setPreferredSize(new Dimension(200,100));
//
//        JButton jbt2 = new JButton("btn2");
//        JButton jbt3 = new JButton("btn3");
//        JButton jbt4 = new JButton("btn4");
//
//        add(jbt1);
//        add(jbt2);
//        add(jbt3);
//        add(jbt4);
//
//        jbt1.addActionListener(new ActionListener() {
//@Override
//public void actionPerformed(ActionEvent e) {
//        System.out.println(getClass().getName());
//        }
//        });
//
//        jbt1.addKeyListener(new KeyAdapter() {
//@Override
//public void keyPressed(KeyEvent e) {
//        //super.keyPressed(e);
//        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
//        System.out.println(1);
//        }
//        }
//        });
//
//        jbt2.addKeyListener(new KeyAdapter() {
//@Override
//public void keyPressed(KeyEvent e) {
//        //super.keyPressed(e);
//        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
//        System.out.println(2);
//        }
//        }
//        });
//
////        JPanel panel = new JPanel(new GridLayout(1,2));
////
////        JButton jbt1 = new JButton("btn1");
////        JButton jbt2 = new JButton("btn2");
////
////        JButton jbt3 = new JButton("btn3");
////        JButton jbt4 = new JButton("btn4");
////        panel.add(jbt3);
////        panel.add(jbt4);
////
////        add(jbt1, BorderLayout.EAST);
////        add(jbt2, BorderLayout.WEST);
////        add(panel, BorderLayout.NORTH);
////        setSize(500,400);
////        setLocation(800,300);
//        // JPanel panel = new JPanel();
//
//        setVisible(true);
