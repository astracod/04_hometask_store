package com.company.store;

/*    1. Просмотр списка товаров
    2. Просмотр подробной информации о товаре по его коду
    3. Добавление товара в корзину по его коду с количеством
    4. Удаление товара из корзины
    5. Просмотр товаров в корзине
    6. Изменение количества товаров в корзине
    7. Формирование заказа (крассивый выывод содержимого корзины с заголовком (номер заказа) и итоговой суммой, после чего корзина очищается)
    */

import java.io.IOException;
import java.io.Serializable;

public class MyStore  {

    private Vector<Product> nomenclature;
    private Cart cart;


    public MyStore() {
        nomenclature = new Vector<>();
        cart = new Cart();
        nomenclature.addInArray(new Product(1, "кофе \"Паулик\" ", 300, "вакуумная упаковкаб вес 250 гр"));
        nomenclature.addInArray(new Product(2, "чай \"Бруклин\" ", 400, "вакуумная упаковка, вес 400 гр"));
        nomenclature.addInArray(new Product(3, "хлеб \"Бородинский\" ", 50, "упакован в пищевую пленку, вес 200 гр"));
        nomenclature.addInArray(new Product(4, "моющее средство \"Аква\" ", 230, "пластиковая емкость, вес 300 гр"));
        nomenclature.addInArray(new Product(5, "конфеты \"Маска\" ", 600, "полиэтиленовый пакет, вес 1000 гр"));
    }


    public void line() {
        System.out.print("|-----------------------------------------------------------------------|\n");
    }

public void information(String information){
    System.out.println();
    System.out.println("|----------------------------> "+information+"  <---------------------------|");
}
    /**
     * Метод просмотра всего товара
     */
    public void showNomenclature() {
        information(" Витрина : ");
        for (int i = 0; i < nomenclature.getSize(); i++) {
            nomenclature.getIndex(i).aboutYourself();
        }
        line();
    }

    /**
     * Просмотр подробной информации о товаре по его артиклю
     *
     * @param article
     */
    public void showProductByArticle(int article) {
        System.out.println(" Просмотр подробной информации о товаре по его артиклю : " + article + "\n");
        for (int i = 0; i < nomenclature.getSize(); i++) {
            if (nomenclature.getIndex(i).getArticle() == article) {
                nomenclature.getIndex(i).aboutYourself();
            }
        }
        line();
    }

    /**
     * Добавление товара в корзину по его коду  с добавлением количества
     */
    public void addProductByArticle(int article, int quantity) throws IOException {
        for (int i = 0; i < nomenclature.getSize(); i++) {
            if (article == nomenclature.getIndex(i).getArticle())
                cart.addingItemInBasketByAndQuantity(nomenclature.getIndex(i), quantity);
        }
    }


    /**
     * удаление товара из корзины
     */
    public void deleteProductFromCart(int article) throws IOException {
        cart.productRemoval(article);
    }

    /**
     * отчистка корзины
     */
    public void emptyTheCart(){
        cart.emptyTheCart();
    }

    /**
     * Просмотр товаров в корзине
     */
    public void showCart() throws IOException, ClassNotFoundException {
        cart.showBasket();
    }

    /**
     * Изменение количества товаров в корзине
     */
    public void changeQuantityOnProduct(int article, int quantity) throws IOException {
        cart.changeQuantity(article, quantity);
    }

    /**
     *   формирование заказа
     */
    public void score(){
        cart.getPriceForCheck();
    }


}

