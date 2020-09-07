package com.company.store;

import java.io.*;

/*Добавление товара в корзину по его коду
    4. Удаление товара из корзины
    5. Просмотр товаров в корзине
    6. Изменение количества товаров в корзине
    7. Формирование заказа (крассивый выывод содержимого корзины с заголовком (номер заказа) и итоговой суммой, после чего корзина очищается)*/

public class Cart {

    private Vector<CartItem> items;
    private Vector<Order> order;
    private Vector<CartItem> file;


    public Cart() {
        file = new Vector<>();
        items = new Vector<>();
        order = new Vector<>();
    }

    public void line() {
        System.out.print("-----------------------------------------------------------------------\n");
    }

    /**
     * создание пути к файлу и запись в него данных
     *
     * @throws IOException
     */
    public void myStream() throws IOException {
        OutputStream out = new FileOutputStream("C:/Users/Admin/Desktop/2.txt");
        ObjectOutputStream outward = new ObjectOutputStream(out);
        outward.writeObject(file);
    }

    /**
     * метод записи данных в файл, для дальнейшей передачи его в поток
     *
     * @param product
     * @param quantity
     * @throws IOException
     */

    public void writingToFile(Product product, int quantity) throws IOException {
        file.addInArray(new CartItem(product, quantity));
        myStream();
    }

    /**
     * показать содержание внешнего файла
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void showFile() throws IOException, ClassNotFoundException {
        InputStream in = new FileInputStream("C:/Users/Admin/Desktop/2.txt");
        ObjectInputStream outside = new ObjectInputStream(in);
        file = (Vector<CartItem>) outside.readObject();
        for (int i = 0; i < file.getSize(); i++) {
            System.out.println(" Вывод с файла : " + file.getIndex(i));
        }
    }

    /**
     * Добавление товара в корзину и обозначить количество
     *
     * @param product
     * @param quantity
     */
    public void addingItemInBasketByAndQuantity(Product product, int quantity) throws IOException {
        System.out.println(" Извещение системы -> Товар в количестве : " + quantity + " добавлен в корзину.");
        boolean itemСontains = false;
        for (int i = 0; i < items.getSize(); i++) {
            if (product.getArticle() == items.getIndex(i).getProduct().getArticle()) {
                int a = items.getIndex(i).getQuantity();
                items.getIndex(i).setQuantity(quantity + a);
                itemСontains = true;
            }
        }
        if (!itemСontains) {
            items.addInArray(new CartItem(product, quantity));
            writingToFile(product, quantity);
        }
        line();
    }


    /**
     * Показать корзину.
     */
    public void showBasket() throws IOException, ClassNotFoundException {
        System.out.println(" Содержимое корзины : \n");
        for (int j = 0; j < items.getSize(); j++) {
            System.out.println(items.getIndex(j));
        }
        showFile();
        line();
    }

    /**
     * Метод общитывающий стоимость покупки
     */
    public void getPriceForCheck() {
        int a = 0;
        int s = 0;
        String d = "";
        int totalOrder = 0;
        for (int i = 0; i < items.getSize(); i++) {
            if (items.getIndex(i) != null) {
                a = items.getIndex(i).getProduct().getPrice();
                s = items.getIndex(i).getQuantity();
                d = items.getIndex(i).getProduct().getName();
                int v = a * s;
                order.addInArray(new Order(d, v, s));
                totalOrder += v;
            }
        }

        for (int i = 0; i < order.getSize(); i++) {
            System.out.println(order.getIndex(i));
        }
        if (totalOrder != 0) {
            System.out.println(" Общая стоимость покупки : " + totalOrder + " рублей.");
            line();
        } else System.out.println(" Нельзя оформить заказ при отсутствии продуктов в карзине.");
    }

    /**
     * Удаление товара из корзины по артиклю
     */
    public void productRemoval(int article) throws IOException {
        System.out.println(" Извещение системы -> Товар с артиклем № " + article + " удален из корзины.");
        int a = -1;
        for (int i = 0; i < items.getSize(); i++) {
            if (article == items.getIndex(i).getProduct().getArticle()) {
                a = i;
            }
        }
        if (a != -1) {
            items.removeArrayElement(a);
            file.removeArrayElement(a);
            myStream();
        }

        line();
    }

    public void emptyTheCart() {
        System.out.println(" Извещение системы -> Корзина пуста.");
        items.allDelete();
        for (int i = 0; i < items.getSize(); i++) {
            int a = 0;
            if (items.getIndex(i) == null) {
                a++;
            }
        }
    }

    /**
     * изменение количества товаров
     */
    public void changeQuantity(int article, int quantity) throws IOException {
        for (int i = 0; i < items.getSize(); i++) {
            if (article == items.getIndex(i).getProduct().getArticle()) {
                items.getIndex(i).setQuantity(quantity);
                file.getIndex(i).setQuantity(quantity);
                myStream();
                break;
            }
        }
    }
}
