package com.company.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ChangeQuantityOnProduct implements MenuAction {

    private MyStore store;
    private Scanner scanner;
    private PrintStream out;
    private int num;
    private String name;

    public ChangeQuantityOnProduct( InputStream input, PrintStream out) {
        this.store = new MyStore();
        this.scanner = new Scanner(input);
        this.out = out;
        this.name = "Удаление товара из корзины :";
    }

    @Override
    public int getActionName(int i) {
        System.out.println(name);
        return num = i + 1;
    }

    @Override
    public void execute(Menu menu) throws IOException {
        System.out.println(" Введите артикль товара :");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println(" Введите количество товара :");
        int b = Integer.parseInt(scanner.nextLine());
        store.changeQuantityOnProduct(a, b);
    }
}
