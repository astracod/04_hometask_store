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

    public ChangeQuantityOnProduct( InputStream input, PrintStream out,MyStore store) {
        this.store = store;
        this.scanner = new Scanner(input);
        this.out = out;
        this.name = "Изменение количества товаров в корзине";
    }

    @Override
    public String getActionName() {
        return  name;
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
