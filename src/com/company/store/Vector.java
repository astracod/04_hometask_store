package com.company.store;

import java.io.Serializable;

/***
 * методы:
 * 1) Записать значение в массив
 * 2) Удаление элемента по порядковому номеру
 * 3) Показать массив
 * @param <T>
 */

public class Vector<T> implements Serializable {
    private Object[] arr;

    private int size = 0;
    private int capacity = 5;


    public Vector() {
        this.arr = new Object[capacity];
    }

    public T getIndex(int index) {
        return (T) arr[index];
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }


    /***
     * Записать значение в массив
     * @param value
     */
    public void addInArray(T value) {
        if (size == capacity - 1) {
            capacity *= capacity;
            Object[] buf = new Object[capacity];
            for (int i = 0; i < arr.length; i++) {
                buf[i] = arr[i];
            }
            arr = buf;
        }
        arr[size] = value;
        size++;
    }

    public void addInArray(Vector<Product> index, int k) {
        if (size == capacity - 1) {
            capacity *= capacity;
            Object[] buf = new Object[capacity];
            for (int i = 0; i < arr.length; i++) {
                buf[i] = arr[i];
            }
            arr = buf;
        }
        arr[size] = k;
        size++;
    }



    /***
     * Удаление элемента по порядковому номеру
     * @param index
     */
    public void removeArrayElement(int index) {
        Object[] buf = new Object[capacity - 1];
        for (int i = 0; i < index; i++) {
            buf[i] = arr[i];
        }
        for (int j = index; j < arr.length & arr[j + 1] != null; j++) {

            buf[j] = arr[j + 1];

        }
        size--;
        arr = buf;
    }

    /***
     *  Показать массив
     * @return
     */
    public void showArray() {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }

    /**
     * отчищение массива
     */
    public void allDelete(){
        arr = new Object[capacity];
    }


}
