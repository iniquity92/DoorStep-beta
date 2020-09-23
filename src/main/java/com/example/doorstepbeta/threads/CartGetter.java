package com.example.doorstepbeta.threads;

import com.example.doorstepbeta.carts.Carts;
import com.example.doorstepbeta.item.Item;

import java.util.List;

public class CartGetter implements Runnable {

    private Thread thread;
    private Carts cart;
    private List<Item> cartProductList;

    public CartGetter(Carts cart){
        this.cart = cart;
        thread = new Thread(this,"CartGetter");
    }

    public void start(){
        thread.start();
    }

    @Override
    public void run() {
        cartProductList = cart.getCartContents();
    }
}
