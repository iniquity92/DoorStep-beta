package com.example.doorstepbeta.threads;

import com.example.doorstepbeta.CartModelClass;
import com.example.doorstepbeta.carts.Carts;
import com.example.doorstepbeta.item.Item;

import java.util.List;

public class CatalogButtonsHandler {
    private CartModelClass cartModel;
    private Item item;
    private int shopCartVsFavCart; //1 for shopping cart, 0 fro favorites cart

    public CatalogButtonsHandler(CartModelClass cartModel, Item item, int shopCartVsFavCart){
        this.cartModel = cartModel;
        this.item = item;
        this.shopCartVsFavCart = shopCartVsFavCart;
    }

    public void addItemToCart(){
        if (shopCartVsFavCart==1){
            cartModel.getShoppingCarts().addItemToCart(item);
        }
        else if (shopCartVsFavCart == 0)
        cartModel.getFavoritesCarts().addItemToCart(item);
    }

//    public List<Item> getCartContent(){
//        return cart.getCartContents();
//    }
//
//    public int getCartContentCount(){
//        return cart.getCartProductCount();
//    }

}
