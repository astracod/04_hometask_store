package com.company.store;

import java.io.Serializable;

public class CartItem implements Serializable {

    private Product product;
    private int quantity = 1;

    public CartItem(Product product, int quantity) {
        this.product = product;
        setQuantity(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  product + ", количество : " + quantity;
    }
}
