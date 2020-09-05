package com.company.store;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

/*        MyStore b = new MyStore();
        b.showNomenclature();
        b.showProductByArticle(2);
        b.addProductByArticle(5, 2);
        b.addProductByArticle(3, 3);
        b.addProductByArticle(5,4);
        b.deleteProductFromCart(3);
        b.changeQuantityOnProduct(5,5);
        b.addProductByArticle(1,4);
        b.showCart();
        b.emptyTheCart();
        b.score();*/
        Menu menu = new Menu(System.in, System.out);
       while (menu.showMenu());

    }
}
