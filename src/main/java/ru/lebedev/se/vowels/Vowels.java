package ru.lebedev.se.vowels;
/*
Нужно для каждой строки подсчитать количество гласных (т.е. букв a, o, u, i, e, y).

Входные данные - в первой строке указано количество строк подлежащих обработке.
Дальше следуют сами строки, состоящие только из маленьких английских (латинских) букв и пробелов.
Ответ должен содержать количество гласных для каждой строки.
 */

public class Vowels {
    public static void main(String[] args) {
        String inputString = "10\n" +
                "bc yfammacoqlwgjj yrtstrcw  hujqgqvqqjcrsdhdb\n" +
                " quajwsdnubbcpfrgqjc  sqxlo vcbqadqj j vloetrk e uhnc f s\n" +
                " pptgqyiy mzceoha x zeq  z y  m icpjzv ec elg ag\n" +
                "xzaip wpoivhpqmx uxcpulvbibhe ju jydwizx\n" +
                "v wmzvao cqwtmezt ihi u ggkkgjqbvnttktwfe ba\n" +
                " auoekyf sqzdbfsz n jkef jjorkcelf pvgajyrhk\n" +
                " cxhxlwhpbvyrxwb uslch pjvv fgyyne  qku rxmjvkrimlnvauljz pd\n" +
                "vkjoiur eygirvab itesqytbn pfekbnzcroog  rdz dbbhu  smoob\n" +
                "rmabtp ihcy k m g enjmqvskjtlqqcdrlehsbvuhqmtc bklvzemvxuf\n" +
                "nukxgcjkqbsmd dwomddivyiaszzvfsl djsmxdd uwlc hfsrnw tan\n" +
                "a kg osqkmcjv qxkbbqqmkjb iuhsqhg  sc j yscugaovbcmzv\n" +
                "hikmyxfw ri l to o ji jyirjqrf  hdsncempvq\n" +
                " ishd c xkdinomf xya k usxnjtf bhyqrzamxkvuyxpkr psaymizkrh\n" +
                "ut lofdofvzvrooqrmhfc gj jhdbwpdsdv nytaotw wzk\n" +
                "mzat  davsfepahhffcakeomzzgwxwmkwmgiaqiwjhoejj t vtfa\n" +
                "watdx bkfeiqci gavtoodlpeglarmwn szlm uxg nnduofzvgo xqgfb\n" +
                "utdqjuqopxi fdczngozfwggefukpfwry jpdyqze  jevjs";

        //-------------------------------------------------------------------------------------
        String[] strings = inputString.split("\n");
        char[] letters = {'a', 'o', 'u', 'i', 'e', 'y'};
                
        for (int i = 1; i < Integer.parseInt(strings[0]) + 1; i++) {
            System.out.println(countVowels(strings[i], letters));
        }
    }
    // Вычисляем количество гласных в строке

    public static int countVowels(String string, char[] letters) {
        int numVowels = 0;
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < letters.length; j++) {
                if (letters[j] == string.charAt(i)) numVowels++;
            }
        }
        return numVowels;
    }

}
