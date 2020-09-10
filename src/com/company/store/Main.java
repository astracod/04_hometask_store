package com.company.store;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class Main  {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Menu menu = new Menu(System.in, System.out);
       while (menu.showMenu());
    }
}
