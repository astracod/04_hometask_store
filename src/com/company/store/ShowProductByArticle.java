package com.company.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ShowProductByArticle implements MenuAction {

    private MyStore store;
    private Scanner scanner;
    private PrintStream out;
    private String name;
    private int num ;

    public ShowProductByArticle(InputStream inputStream, PrintStream out) {
        this.store = new MyStore();
        this.scanner = new Scanner(inputStream);
        this.out = out;
        this.name = "Просмотр подробной информации о товаре по его коду :";
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
        store.showProductByArticle(a);
    }
}
