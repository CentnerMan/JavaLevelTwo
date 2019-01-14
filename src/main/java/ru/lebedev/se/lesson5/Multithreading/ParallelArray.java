package ru.lebedev.se.lesson5.Multithreading;

/**
 * @author Anatoly Lebedev
 * @version 1.0
 */

public class ParallelArray {
    static final int size = 10000000;
    static final int threads = 2; // количество потоков
    static final int h = size / threads;
    static float[] arr = new float[size];
    static long timeToStart;
    static long timeToEnd;

    // Заполняем массив 1

    public static void initializeArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
        }
    }

    // Функция рассчета

    public static void calcAnything(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    // Разделяем массив на 2 и считаем в 2 потока

    public static float[] TwoThreadCalc(float[] arr) {
        int h = arr.length / 2;

        float[] a1 = new float[h];
        float[] a2 = new float[arr.length - h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        // Считаем
        Thread t1 = new Thread(() -> {
            calcAnything(a1);
        });
        Thread t2 = new Thread(() -> {
            calcAnything(a2);
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Склеиваем
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        return arr;
    }

    // Считаем одним потоком

    static void SingleThreadArrayTimeMeasuring() {
        // заполняем массив единицами
        initializeArray(arr);
        timeToStart = System.currentTimeMillis(); // засекаем начальное время

        calcAnything(arr);

        timeToEnd = System.currentTimeMillis(); // засекаем конечное время
        System.out.println("Однопоточный режим: " + (timeToEnd - timeToStart)); // Выводим время выполнения процесса
    }

    // Считаем в несколько потоков

    static void MultipleThreadArrayTimeMeasuring() {
        initializeArray(arr);

        timeToStart = System.currentTimeMillis(); // Засекаем время

        // Делим на threads потоков

        TwoThreadCalc(arr);

        timeToEnd = System.currentTimeMillis(); // засекаем конечное время
        System.out.println("Многопоточный режим: " + (timeToEnd - timeToStart)); // Выводим время выполнения процесса
    }


    public static void main(String[] args) {

        // Однопоточный режим

        SingleThreadArrayTimeMeasuring();

        // Многопоточный режим

        MultipleThreadArrayTimeMeasuring();

    }
}
