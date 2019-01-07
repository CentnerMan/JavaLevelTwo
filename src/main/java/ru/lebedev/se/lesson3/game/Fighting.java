package ru.lebedev.se.lesson3.game;

import ru.lebedev.se.lesson3.game.heroes.Assasin;
import ru.lebedev.se.lesson3.game.heroes.Doctor;
import ru.lebedev.se.lesson3.game.heroes.Hero;
import ru.lebedev.se.lesson3.game.heroes.Warrior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ru.lebedev.se.lesson3.game.Tools.rnd;

public class Fighting extends JFrame {
    private JPanel panelka;
    private JComboBox comboBox1;
    private JButton button1;
    private JTextArea command1;
    private JComboBox comboBox2;
    private JButton button2;
    private JTextArea command2;
    private JButton start;
    public JTextArea logging;

    // Первичная инициализация
    // счетчик раундов
    int round = 1;
    int commandCount = 3; // Количество участников команды

    // создаюстся две команды

    Hero[] leftTeam = new Hero[commandCount];
    int leftTeamCount = 0; // текущее количество героев в левой команде
    int leftTeamSumHealth = 0; // общее здоровье команды
    Hero[] rightTeam = new Hero[commandCount];
    int rightTeamCount = 0; // текущее количество героев в правой команде
    int rightTeamSumHealth = 0;


    void fightBegin() {
        int randomStep = rnd(1, 2);
        int randomAct;
        do {
            logging.append("------------- Round " + (round) + " ----------------\n");
            // проходим по всем участникам команды
            for (int i = 0; i < commandCount; i++) {
                // рандомно выбираем кто будет первый ходить
                if (randomStep == 1) {
                    // если персонаж не доктор, то он может ударить
                    // если доктор, то он лечит
                    if (leftTeam[i] instanceof Doctor) {
                        randomAct = rnd(0, leftTeam.length - 1);
                        logging.append(leftTeam[i].healingStr(leftTeam[randomAct]));
                    } else {
                        randomAct = rnd(0, rightTeam.length - 1);
                        logging.append(leftTeam[i].hitStr(rightTeam[randomAct]));
                    }
                } else {
                    if (rightTeam[i] instanceof Doctor) {
                        randomAct = rnd(0, rightTeam.length - 1);
                        logging.append(rightTeam[i].healingStr(rightTeam[randomAct]));
                    } else {
                        randomAct = rnd(0, leftTeam.length - 1);
                        logging.append(rightTeam[i].hitStr(leftTeam[randomAct]));
                    }
                }
            }
            if (randomStep == 1) randomStep = 2; // Передаем ход другой команде
            else randomStep = 1;
            // Считаем суммарное здоровье команды
            leftTeamSumHealth = 0;
            rightTeamSumHealth = 0;
            for (int k = 0; k < commandCount; k++) {
                leftTeamSumHealth += leftTeam[k].getHealth();
                rightTeamSumHealth += rightTeam[k].getHealth();
            }
            round++; // next round
        } while (leftTeamSumHealth > 0 && rightTeamSumHealth > 0); // while have live heroes

        logging.append("-----------------------------------------\n");
        if (leftTeamSumHealth > 0) logging.append("Победила 1 команда\n");
        else logging.append("Победила 2 команда\n");
        logging.append("-----------------------------------------\n");

        for (Hero t1 : leftTeam) {
            logging.append(t1.info());
        }

        logging.append("-----------------------------------------\n");

        for (Hero t2 : rightTeam) {
            logging.append(t2.info());
        }
    }

    public Fighting() throws HeadlessException {
        super("Fighting!");
        setContentPane(panelka);
        command1.append("\n--------------------------------\n"); // добавляем в поле текст
        command2.append("\n--------------------------------\n"); // добавляем в поле текст
        logging.append("\n----------------------------------\n"); // добавляем в поле битвы текст
        //---------------------------------------------------------------------------------------------
        comboBox1.addItem("Тигрил");
        comboBox1.addItem("Акали");
        comboBox1.addItem("Жанна");

        //---------------------------------------------------------------------------------------------
        comboBox2.addItem("Минотавр");
        comboBox2.addItem("Джинкс");
        comboBox2.addItem("Зои");

        //---------------------------------------------------------------------------------------------
        pack();
        super.setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Выход при закрытии окна

        //---------------------------------------------------------------------------------------------
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (leftTeamCount < commandCount) {
                    leftTeamCount++;
                    switch (comboBox1.getSelectedIndex()) {
                        case 0:
                            leftTeam[leftTeamCount - 1] = new Warrior(250, "Тигрил", 50, 0);
                            command1.append(leftTeam[leftTeamCount - 1].info());
                            break;
                        case 1:
                            leftTeam[leftTeamCount - 1] = new Assasin(150, "Акали", 70, 0);
                            command1.append(leftTeam[leftTeamCount - 1].info());
                            break;
                        case 2:
                            leftTeam[leftTeamCount - 1] = new Doctor(120, "Жанна", 0, 60);
                            command1.append(leftTeam[leftTeamCount - 1].info());
                            break;
                    }
                } else {
                    command1.append("Команда сформирована \n");
                    button1.setVisible(false);
                }
            }
        });

        //---------------------------------------------------------------------------------------------
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (rightTeamCount < commandCount) {
                    rightTeamCount++;
                    switch (comboBox2.getSelectedIndex()) {
                        case 0:
                            rightTeam[rightTeamCount - 1] = new Warrior(290, "Минотавр", 60, 0);
                            command2.append(rightTeam[rightTeamCount - 1].info());
                            break;
                        case 1:
                            rightTeam[rightTeamCount - 1] = new Assasin(160, "Джинкс", 90, 0);
                            command2.append(rightTeam[rightTeamCount - 1].info());
                            break;
                        case 2:
                            rightTeam[rightTeamCount - 1] = new Doctor(110, "Зои", 0, 80);
                            command2.append(rightTeam[rightTeamCount - 1].info());
                            break;
                    }
                } else {
                    command2.append("Команда сформирована \n");
                    button2.setVisible(false);
                }
            }
        });

        //---------------------------------------------------------------------------------------------
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (leftTeamCount<3 || rightTeamCount<3){
                    logging.append("В командах должно быть по 3 героя\n");
                } else {
                    logging.append("--------Да начнется битва--------\n\n");
                    fightBegin();
                }
            }
        });
        //---------------------------------------------------------------------------------------------

        setVisible(true);
    }
}