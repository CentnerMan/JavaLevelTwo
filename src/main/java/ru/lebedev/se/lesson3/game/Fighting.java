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
    private JButton restart;
    private JScrollPane leftPan;
    private JScrollPane rightPan;

    // Первичная инициализация
    // счетчик раундов
    int round = 1;
    int commandCount = 20; // Количество участников команды, в принципе, любое

    // создаюстся две команды

    Hero[] leftTeam = new Hero[commandCount + 1];
    int leftTeamCount = 0; // текущее количество героев в левой команде, оно же указатель на последнего живого
    int leftTeamDead = commandCount; //Указатель на кладбище левой команды

    Hero[] rightTeam = new Hero[commandCount + 1];
    int rightTeamCount = 0; // текущее количество героев в правой команде
    int rightTeamDead = commandCount; //Указатель на кладбище правой команды


    void fightBegin() {
        int randomStep = rnd(1, 2);
        int randomAct;
        do {
            // проходим по всем участникам команды
            if (randomStep == 1 && leftTeamCount > 0) {
                logging.append("----------------------------- Раунд " + (round) + " -----------------------------\n");

                for (int i = 0; i < leftTeamCount; i++) {
                    if (leftTeam[i] instanceof Doctor) {
                        for (int j = 0; j < leftTeamCount; j++) {
                            if (leftTeam[j].getHealth() < leftTeam[j].getMaxHealth()) {
                                logging.append((leftTeam[i].healingStr(leftTeam[j])));
                                break;
                            }
                        }
                    } else {
                        randomAct = rnd(0, rightTeamCount - 1);
                        logging.append(leftTeam[i].hitStr(rightTeam[randomAct]));
                        if (rightTeam[randomAct].getHealth() <= 0) { // если умер от удара - на кладбище
                            logging.append("Герой противника " + rightTeam[randomAct].getName() + " - уничтожен!\n");
//                            logging.append(rightTeamCount+" "+rightTeamDead+" "+randomAct+"\n");
                            if (rightTeamCount > 1) {
                                rightTeam[rightTeamDead] = rightTeam[randomAct];
                                rightTeamDead--;
                                for (int j = randomAct; j < rightTeamCount - 1; j++) { // сдвигаем влево
                                    rightTeam[j] = rightTeam[j + 1];
                                }
                                rightTeamCount--;
                            } else {
                                rightTeamCount--;
                                break;
                            }
                        }
                    }
                }
                round++;
                randomStep = 2;
                if (rightTeamCount <= 0) break;
            } else {
                if (randomStep == 2 && rightTeamCount > 0) {

                    logging.append("----------------------------- Раунд " + (round) + " -----------------------------\n");

                    for (int i = 0; i < rightTeamCount; i++) {
                        if (rightTeam[i] instanceof Doctor) {
                            for (int j = 0; j < rightTeamCount; j++) {
                                if (rightTeam[j].getHealth() < rightTeam[j].getMaxHealth()) {
                                    logging.append((rightTeam[i].healingStr(rightTeam[j])));
                                    break;
                                }
                            }
                        } else {
                            randomAct = rnd(0, leftTeamCount - 1);
                            logging.append(rightTeam[i].hitStr(leftTeam[randomAct]));
                            if (leftTeam[randomAct].getHealth() <= 0) { // если умер от удара - на кладбище
                                leftTeam[leftTeamDead] = leftTeam[randomAct];
                                logging.append("Герой противника " + leftTeam[randomAct].getName() + " - уничтожен!\n");
                                if (leftTeamCount > 1) {
                                    leftTeamDead--;
                                    for (int j = randomAct; j < leftTeamCount - 1; j++) { // сдвигаем влево
                                        leftTeam[j] = leftTeam[j + 1];
                                    }
                                    leftTeamCount--;
                                } else {
                                    leftTeamCount--;
                                    break;
                                }
                            }
                        }
                    }
                    round++;
                    randomStep = 1;
                }
                if (leftTeamCount <= 0) break;
            }
        } while (leftTeamCount > 0 && rightTeamCount > 0); // while have live heroes


        logging.append("-----------------------------------------\n");
        if (leftTeamCount > 0) {
            logging.append("Победила 1 команда\nОстались в живых:\n");
            for (int i = 0; i < leftTeamCount; i++) {
                logging.append(leftTeam[i].getName() + ", осталось здоровья " + leftTeam[i].getHealth() + " из " + leftTeam[i].getMaxHealth() + "\n");
            }
        } else {
            logging.append("Победила 2 команда\nОстались в живых:\n");
            for (int i = 0; i < rightTeamCount; i++) {
                logging.append(rightTeam[i].getName() + ", осталось здоровья " + rightTeam[i].getHealth() + " из " + rightTeam[i].getMaxHealth() + "\n");
            }
        }
    }

    public Fighting() throws HeadlessException {
        super("Fighting!");
        setContentPane(panelka);
        command1.append("\n--------------------------------\n"); // добавляем в поле текст
        command2.append("\n--------------------------------\n"); // добавляем в поле текст
        logging.append("\n---------------------------------------\n"); // добавляем в поле битвы текст
        //---------------------------------------------------------------------------------------------
        comboBox1.addItem("Воин");
        comboBox1.addItem("Ассасин");
        comboBox1.addItem("Жрец");

        //---------------------------------------------------------------------------------------------
        comboBox2.addItem("Воин");
        comboBox2.addItem("Ассасин");
        comboBox2.addItem("Жрец");

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
                            leftTeam[leftTeamCount - 1] = new Warrior();
                            command1.append(leftTeamCount + ". ");
                            command1.append(leftTeam[leftTeamCount - 1].logInfo());
                            break;
                        case 1:
                            leftTeam[leftTeamCount - 1] = new Assasin();
                            command1.append(leftTeamCount + ". ");
                            command1.append(leftTeam[leftTeamCount - 1].logInfo());
                            break;
                        case 2:
                            leftTeam[leftTeamCount - 1] = new Doctor();
                            command1.append(leftTeamCount + ". ");
                            command1.append(leftTeam[leftTeamCount - 1].logInfo());
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
                            rightTeam[rightTeamCount - 1] = new Warrior();
                            command2.append(rightTeamCount + ". ");
                            command2.append(rightTeam[rightTeamCount - 1].logInfo());
                            break;
                        case 1:
                            rightTeam[rightTeamCount - 1] = new Assasin();
                            command2.append(rightTeamCount + ". ");
                            command2.append(rightTeam[rightTeamCount - 1].logInfo());
                            break;
                        case 2:
                            rightTeam[rightTeamCount - 1] = new Doctor();
                            command2.append(rightTeamCount + ". ");
                            command2.append(rightTeam[rightTeamCount - 1].logInfo());
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

                if (leftTeamCount < 1 || rightTeamCount < 1) {
                    logging.append("В командах должен быть хотя бы 1 герой\n");
                } else {
                    logging.setText("\n");
                    logging.append("--------Да начнется битва--------\n\n");
                    fightBegin();
                }
            }
        });
        //---------------------------------------------------------------------------------------------
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setVisible(true);
                button2.setVisible(true);
                logging.setText("");
                logging.append("\n-------------------------------------------\n"); // добавляем в поле битвы текст
                command1.setText("");
                command1.append("Команда 1\n");
                command1.append("\n--------------------------------\n"); // добавляем в поле текст
                command2.setText("");
                command2.append("Команда 2\n");
                command2.append("\n--------------------------------\n"); // добавляем в поле текст
                leftTeamCount = 0;
                leftTeamDead = commandCount;
                rightTeamCount = 0;
                rightTeamDead = commandCount;
                round = 1;
            }
        });

        setVisible(true);
    }
}