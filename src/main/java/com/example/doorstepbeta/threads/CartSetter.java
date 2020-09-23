package com.example.doorstepbeta.threads;

import android.net.IpSecManager;

import com.example.doorstepbeta.carts.Carts;
import com.example.doorstepbeta.item.Item;

public class CartSetter implements Runnable {

    private Thread thread;
    private Carts cart;
    private Item item;
    private boolean isSuccessful;

    public CartSetter(Carts cart, Item item){
        this.cart = cart;
        this.item = item;
        thread = new Thread(this,"CartSetter");

    }

    public void start(){
        thread.start();
    }

    @Override
    public void run() {
       isSuccessful = cart.addItemToCart(item);
    }

    public boolean getIsSuccessful(){return  isSuccessful;}
}
