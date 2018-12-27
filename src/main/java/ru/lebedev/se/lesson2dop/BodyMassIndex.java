package ru.lebedev.se.lesson2dop;
/*
Необходимо рассчитать Индекс Массы Тела (Body Mass Index = BMI). Определяется она как вес делённый на рост в квадрате:

BMI = вес / рост^2
Здесь вес берется в килограммах, а рост в метрах.

На основании этого показателя выделяют четыре категории:

Underweight     -           BMI < 18.5      (недостаточная масса)
Normal weight   -   18.5 <= BMI < 25.0      (норма)
Overweight      -   25.0 <= BMI < 30.0      (избыточная масса)
Obesity         -   30.0 <= BMI             (ожирение)
Например, если я вешу 80 кг а мой рост 173 см то можно вычислить:

BMI = 80 / (1.73)^2 = 26.7
т.е. присутствует избыточный вес.

вес в килограммах и рост в метрах.
Ответ должен содержать одно из слов under, normal, over, obese, через пробел.



118 2.05
106 1.77
87 1.83
45 1.12
70 1.87
54 1.57
105 1.76
50 1.96
114 1.76
72 2.45
53 2.10
66 2.25
54 1.50
95 1.62
86 1.72
62 1.57
65 2.24
72 1.43
93 2.01
109 3.01
106 2.97
77 1.69
114 2.09
98 1.72
85 2.46
113 1.94
53 1.77
 */

public class BodyMassIndex {
    public static void main(String[] args) {
        String inputString = "118 2.05\n" +
                "106 1.77\n" +
                "87 1.83\n" +
                "45 1.12\n" +
                "70 1.87\n" +
                "54 1.57\n" +
                "105 1.76\n" +
                "50 1.96\n" +
                "114 1.76\n" +
                "72 2.45\n" +
                "53 2.10\n" +
                "66 2.25\n" +
                "54 1.50\n" +
                "95 1.62\n" +
                "86 1.72\n" +
                "62 1.57\n" +
                "65 2.24\n" +
                "72 1.43\n" +
                "93 2.01\n" +
                "109 3.01\n" +
                "106 2.97\n" +
                "77 1.69\n" +
                "114 2.09\n" +
                "98 1.72\n" +
                "85 2.46\n" +
                "113 1.94\n" +
                "53 1.77";

        String[] strings = inputString.split("\n");

        for (int i = 0; i < strings.length; i++) {
            String[] tempArr = strings[i].split(" ");
            int h = Integer.parseInt(tempArr[0]);
            double w = Double.parseDouble(tempArr[1]);
            System.out.print(BodyMassIndex(h, w) + " ");
        }

    }

    public static String BodyMassIndex(int height, double weight) {
        double index = height * 1.0 / (weight * weight);
        if (index < 18.5) return "under";
        if (index >= 18.5 && index < 25.0) return "normal";
        if (index >= 25.0 && index < 30.0) return "over";
        if (index >= 30.0) return "obese";
        else return "i do not know";
    }
}
