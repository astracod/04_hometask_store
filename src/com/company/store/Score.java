package com.company.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Score implements MenuAction {
    private MyStore store;
    private Scanner scanner;
    private PrintStream out;
    private int num;
    private String name;

    public Score(InputStream input, PrintStream out) {
        this.store = new MyStore();
        this.scanner = new Scanner(input);
        this.out = out;
        this.name = "Формирование заказа :";
    }

    @Override
    public int getActionName(int i) {
        System.out.println(name);
        return num = i + 1;
    }

    @Override
    public void execute(Menu menu) throws IOException {
        store.score();
        store.emptyTheCart();
        System.out.println(" Всего доброго!!!");
    }
}
