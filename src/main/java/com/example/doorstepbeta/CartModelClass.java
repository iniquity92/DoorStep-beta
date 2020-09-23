package com.example.doorstepbeta;

import androidx.lifecycle.ViewModel;

import com.example.doorstepbeta.carts.Carts;

public class CartModelClass extends ViewModel {

    private Carts shoppingCarts;
    private Carts favoritesCarts;


    public void setShoppingCarts(Carts carts){
        this.shoppingCarts = carts;
    }

    public Carts getShoppingCarts(){
        return shoppingCarts;
    }

    public void setFavoritesCarts(Carts carts){
        this.favoritesCarts = carts;
    }

    public Carts getFavoritesCarts(){
        return favoritesCarts;
    }
}
