package com.company.store;

import java.io.IOException;

public class Main  {

    public static void main(String[] args) throws IOException {

        Menu menu = new Menu(System.in, System.out);
       while (menu.showMenu());
    }

}
