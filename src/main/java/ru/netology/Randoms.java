package ru.netology;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        random = new Random();
        this.min = min;
        this.max = max;
    }

    // адаптер к методу next() класса Iterator
    private int getRandom() {
        int r = random.nextInt(max + 1 - min); // нормируем диапазон случайных чисел в [0,max + 1 - min)
        return r + min; // возвращаем случайное число в диапазон [min,max]
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return true; // следующее случайное число есть всегда
            }

            @Override
            public Integer next() {
                return getRandom();
            }
        };
    }
}
