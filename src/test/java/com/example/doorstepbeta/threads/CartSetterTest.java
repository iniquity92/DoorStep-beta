package com.example.doorstepbeta.threads;

import com.example.doorstepbeta.carts.ShoppingCart;
import com.example.doorstepbeta.item.Item;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartSetterTest {

    ShoppingCart cart = new ShoppingCart(true,true);
    Item item = new Item("Apple1","Washington Apple",100,"140");

    CartSetter setter = new CartSetter(cart, item);
    @Test
    public void start() {
        setter.start();
    }

    @Test
    public void run() {
    }

    @Test
    public void getIsSuccessful() {
        boolean expected = true;
        assertEquals(true,setter.getIsSuccessful());
    }
}