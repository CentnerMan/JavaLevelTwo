package ru.lebedev.se.exceptions;

/*
1	Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

2	Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

3	В методе main() вызвать полученный метод, обработать возможные исключения
MySizeArrayException и MyArrayDataException и вывести результат расчета.

 */
public class CheckArray {
    public static void main(String[] args) {
//        String[][] arr = new String[4][4];
        String[][] arr = {{"1", "2", "3", "4"}, {"1", "7", "3", "4"}, {"1", "2", "6", "4"}, {"1", "2", "3", "4"}};
        try {
            System.out.println("Сумма элементов массива равна " + arrFourFour(arr));

        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());

        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("--------------------------------");
        }
    }

    public static int arrFourFour(String[][] arrayOfString) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;
        int current = 0;
        if (arrayOfString.length != 4 || arrayOfString[0].length != 4 || arrayOfString[1].length != 4
                || arrayOfString[2].length != 4 || arrayOfString[3].length != 4)
            throw new MyArraySizeException("Ошибка. Это не двумерный строковый массив размером 4х4.");

        for (int i = 0; i < arrayOfString.length; i++) {
            for (int j = 0; j < arrayOfString[0].length; j++) {
                try {
                    // Преобразуем String в int
                    current = Integer.parseInt(arrayOfString[i][j].trim());
                    summ = summ + current;
                } catch (NumberFormatException nfe) {
//                    System.out.println("NumberFormatException: " + nfe.getMessage());
                    throw new MyArrayDataException("Ошибка. В ячейке [" + i + "][" + j + "] содержится не число");
                }
            }
        }
        return summ;
    }


}
