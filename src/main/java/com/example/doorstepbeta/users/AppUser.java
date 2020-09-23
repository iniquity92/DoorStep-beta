package com.example.doorstepbeta.users;

import com.example.doorstepbeta.carts.FavoritesCart;
import com.example.doorstepbeta.carts.ShoppingCart;
import com.example.doorstepbeta.orders.Orders;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class AppUser {
    private FirebaseUser user;
    private ShoppingCart cart;
    private FavoritesCart wishlist;
    private List<Orders> previousOrders;
    private List<Orders> currentOrder;
    private int age;
    private List<String> addresses;

    //for testing until the networking code is done, use this user
    private String mTestUser;

    public String getmTestUser(){
        return mTestUser;
    }


}
