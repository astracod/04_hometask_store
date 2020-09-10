package com.company.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ShowCart implements MenuAction {

    private MyStore store;
    private Scanner scanner;
    private PrintStream out;
    private int num;
    private String name;

    public ShowCart(InputStream input, PrintStream out) {
        this.store = new MyStore();
        this.scanner = new Scanner(input);
        this.out = out;
        this.name = "Просмотр товаров в корзине :";
    }


    @Override
    public int getActionName(int i) {
        System.out.println(name);
        return num = i + 1;
    }

    @Override
    public void execute(Menu menu) throws IOException {
        store.showCart();
    }
}
