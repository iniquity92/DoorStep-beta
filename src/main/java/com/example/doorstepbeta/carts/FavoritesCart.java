package com.example.doorstepbeta.carts;

public class FavoritesCart extends Carts {

    public FavoritesCart(){
        super();
    }

    public FavoritesCart(boolean ifAddItemToCart,boolean ifUpdateCartProductCount,String favoritesCartTag){
        super(ifAddItemToCart,ifUpdateCartProductCount,favoritesCartTag);
    }
}
