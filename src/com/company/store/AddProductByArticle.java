package com.company.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class AddProductByArticle implements MenuAction {
    private MyStore store;
    private Scanner scanner;
    private PrintStream out;
    private int num;
    private String name;



    public AddProductByArticle(InputStream input, PrintStream out,MyStore store) {
        this.store = store;
        this.scanner = new Scanner(input);
        this.out = out;
        this.name = "Добавление товара в корзину по его коду";
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
        store.addProductByArticle(a, b);
    }
}
