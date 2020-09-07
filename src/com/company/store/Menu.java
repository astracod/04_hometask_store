package com.company.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;

/*твоя следующая задача сделать консольный магазин со следующим функционалом
    (Реализовать меню)
    1. Просмотр списка товаров
    2. Просмотр подробной информации о товаре по его коду
    3. Добавление товара в корзину по его коду
    4. Удаление товара из корзины
    5. Просмотр товаров в корзине
    6. Изменение количества товаров в корзине
    7. Формирование заказа (крассивый выывод содержимого корзины с заголовком (номер заказа) и итоговой суммой, после чего корзина очищается)
*/
public class Menu  {
    private MyStore store;
    private Scanner scanner;
    private PrintStream out;


    public Menu() {
    }

    public Menu(InputStream input, PrintStream out) {
        this.store = new MyStore();
        this.scanner = new Scanner(input);
        this.out = out;
    }

    public boolean showMenu() throws IOException, ClassNotFoundException {
        out.println("    1. Просмотр списка товаров\n" +
                "    2. Просмотр подробной информации о товаре по его коду\n" +
                "    3. Добавление товара в корзину по его коду\n" +
                "    4. Удаление товара из корзины\n" +
                "    5. Просмотр товаров в корзине\n" +
                "    6. Изменение количества товаров в корзине\n" +
                "    7. Формирование заказа "
                );
        int answer = Integer.parseInt(scanner.nextLine());
        responseToRequest(answer);
        return answer != 7;
    }


    public void responseToRequest(int answer) throws IOException, ClassNotFoundException {
        if (answer == 1) {
            store.showNomenclature();
        }
        if (answer == 2) {
            System.out.println(" Введите артикль товара :");
            int a = Integer.parseInt(scanner.nextLine());
            store.showProductByArticle(a);
        }
        if (answer == 3) {
            System.out.println(" Введите артикль товара :");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.println(" Введите количество товара :");
            int b = Integer.parseInt(scanner.nextLine());
            store.addProductByArticle(a, b);
        }
        if (answer == 4) {
            System.out.println(" Введите артикль товара :");
            int a = Integer.parseInt(scanner.nextLine());
            store.deleteProductFromCart(a);
        }
        if (answer == 5) {
            store.showCart();
        }
        if (answer == 6) {
            System.out.println(" Введите артикль товара :");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.println(" Введите количество товара :");
            int b = Integer.parseInt(scanner.nextLine());
            store.changeQuantityOnProduct(a, b);
        }
        if (answer == 7){
            store.score();
            store.emptyTheCart();
            System.out.println(" Всего доброго!!!");
        }
    }
}
