package com.company.store;

/*   минимальные характеристики товара:
    код
    имя
    цена
    краткое описание
    */

public class Product {

    private int article;
    private int price;
    private String name;
    private  String description;

    public Product(){}

    public Product(int article,String name, int price, String description){
        this.article = article;
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public int getArticle(){
        return article;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public void aboutYourself() {

        System.out.print(" Артикль : "+getArticle()+" | Название товара : "+getName()+"| Цена товара : "+getPrice()+" руб | Описание товара : "+getDescription()+"\n");

    }

    @Override
    public String toString() {
        return " Артикль : "+getArticle()+" | Название товара : "+getName()+"| Цена товара : "+getPrice()+" руб | Описание товара : "+getDescription();
    }
}
