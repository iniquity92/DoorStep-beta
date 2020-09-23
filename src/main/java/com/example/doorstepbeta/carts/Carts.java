package com.example.doorstepbeta.carts;

import android.util.Log;

import com.example.doorstepbeta.item.Item;
import com.example.doorstepbeta.users.AppUser;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class Carts {
    protected String cartId;
    protected AppUser cartUser;
    protected int cartProductCount;
    protected Item cartItem;
    protected List<Item> cartContents;
    protected boolean isCartUpdated;
    protected boolean ifAddITemToCart;
    protected boolean ifUpdateCartProductCount;
    protected String cartTag;

    public Carts(){
        cartContents = new ArrayList<>();
        isCartUpdated = false;
        ifAddITemToCart = true;
        ifUpdateCartProductCount = true;
    }
    public Carts(boolean ifAddITemToCart,boolean ifUpdateCartProductCount,String cartTag){
        cartContents = new ArrayList<>();
        isCartUpdated = false;
        this.ifUpdateCartProductCount = ifUpdateCartProductCount;
        this.ifAddITemToCart = ifAddITemToCart;
        this.cartTag = cartTag;
    }

    public void removeOne(){}

    public boolean addItemToCart(Item item){

        boolean isSuccessful;
        int intialCartSize = cartContents.size();
        cartContents.add(item);

        if (cartContents.size()>intialCartSize){
            isSuccessful = true;

            updateCartProductCount(cartContents.size(),this);
        }
        else {
            isSuccessful = false;
        }
        return  isSuccessful;
    }

    public List<Item> getCartContents(){
        return cartContents;
    }
    public void updateCartProductCount(int size,Object source){

        if (source == this){
            cartProductCount = size;
        }
        else {
            cartProductCount += size;
        }
        Log.d("Cart", "Count = "+cartProductCount);
        isCartUpdated = true;
    }
    public int getCartProductCount(){
        return cartProductCount;
    }

    public boolean isCartUpdated(){
        return isCartUpdated;
    }

    public void setIsCartUpdated(boolean modifying){
        isCartUpdated = modifying;
    }
    public void removeItemFromCart(){}
    public String getCartTag(){return cartTag;}

//    public void updateCartProductCountByOne(){
//        cartProductCount++;
//    }

    public void itemStockListener(){}
    public void clearCart(){}

}
