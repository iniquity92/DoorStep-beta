package com.example.doorstepbeta.carts;

public class ShoppingCart extends Carts {

    public ShoppingCart(){
        super();
    }
    public ShoppingCart(boolean ifAddItemtoCart,boolean ifUpdateCartProductCount,String shoppingCartTag){
        super(ifAddItemtoCart,ifUpdateCartProductCount,shoppingCartTag);
    }
}
