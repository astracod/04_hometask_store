package com.company.store;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu(System.in, System.out);
       while (menu.showMenu());

    }
}
