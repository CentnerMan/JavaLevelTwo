package ru.lebedev.se.lesson3;

/*
Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
 */

import java.util.ArrayList;

public class WordsArray {
    static String[] words = {"пиво", "сало", "хлеб", "сало", "пиво", "пиво", "колбаса", "оливье",
            "шампанское", "селедка", "шампанское", "оливье"};

    static ArrayList<WordsCount> count = new ArrayList<>();
    static Boolean wordFound = false;

    public static void main(String[] args) {
        count.add(new WordsCount(words[0])); // первое слово точно отсутствует, добавляем сразу
        for (int i = 1; i < words.length; i++) {
            wordFound = false;
            for (int j = 0; j < count.size(); j++) {
                if ((count.get(j).getWord().equals(words[i]))) // если слово нашли
                {
                    // увеличиваем количество на 1
                    count.get(j).setCount(count.get(j).wCount + 1);
                    wordFound = true; // Ура, нашли
                    break;
                }
            }
            if (!wordFound) { // если не нашли, добавляем в список
                count.add(new WordsCount(words[i]));
            }
        }

        for (int i = 0; i < count.size(); i++) {
            System.out.println(count.get(i).getWord() + " " + count.get(i).getCount());
        }
    }


}
