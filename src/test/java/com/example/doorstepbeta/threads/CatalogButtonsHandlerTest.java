package com.example.doorstepbeta.threads;

import com.example.doorstepbeta.R;
import com.example.doorstepbeta.carts.FavoritesCart;
import com.example.doorstepbeta.carts.ShoppingCart;
import com.example.doorstepbeta.item.Item;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CatalogButtonsHandlerTest {

    ShoppingCart shoppingCart = new ShoppingCart(true,true);
    FavoritesCart favoritesCart = new FavoritesCart(true,true);

    Item i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15;

    CatalogButtonsHandler cbhSCi1;
    CatalogButtonsHandler cbhFCi1;


    @Test
    public void startThreads() {
        i1 = new Item("aeroplane1","Aeroplane",2,"1234567");
        i2 = new Item("Apple2","Washington Apple",40000,"100");
        i3 = new Item("AppleElectronics","Apple Ipod",1,"400");

        cbhSCi1 = new CatalogButtonsHandler(shoppingCart,i1);
        cbhFCi1 = new CatalogButtonsHandler(favoritesCart, i1);
       // cbhSCi1.startThreads();
        //cbhFCi1.startThreads();

        cbhSCi1 = new CatalogButtonsHandler(shoppingCart,i2);
        cbhFCi1 = new CatalogButtonsHandler(favoritesCart, i2);
        //cbhSCi1.startThreads();
        //cbhFCi1.startThreads();

        cbhSCi1 = new CatalogButtonsHandler(shoppingCart,i3);
        cbhFCi1 = new CatalogButtonsHandler(favoritesCart, i3);
        //cbhSCi1.startThreads();
        //cbhFCi1.startThreads();


    }

    @Test
    public void getCartContent() {
        List<Item> cartContentActual = new ArrayList<>();

        try {
            cartContentActual.addAll(cbhSCi1.getCartContent());
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        i1 = new Item("aeroplane1","Aeroplane",2,"1234567");
        i2 = new Item("Apple2","Washington Apple",40000,"100");
        i3 = new Item("AppleElectronics","Apple Ipod",1,"400");

        assertEquals(i1.getProductCode(), cartContentActual.get(0).getProductCode());
        assertEquals(i1.getProductName(), cartContentActual.get(0).getProductName());
        assertEquals(i1.getProductQuantity(), cartContentActual.get(0).getProductQuantity());
        assertEquals(i1.getProductUnitPrice(), cartContentActual.get(0).getProductUnitPrice());

        assertEquals(i2.getProductCode(), cartContentActual.get(1).getProductCode());
        assertEquals(i2.getProductName(), cartContentActual.get(1).getProductName());
        assertEquals(i2.getProductQuantity(), cartContentActual.get(1).getProductQuantity());
        assertEquals(i2.getProductUnitPrice(), cartContentActual.get(1).getProductUnitPrice());

        assertEquals(i3.getProductCode(), cartContentActual.get(2).getProductCode());
        assertEquals(i3.getProductName(), cartContentActual.get(2).getProductName());
        assertEquals(i3.getProductQuantity(), cartContentActual.get(2).getProductQuantity());
        assertEquals(i3.getProductUnitPrice(), cartContentActual.get(2).getProductUnitPrice());





    }

    @Test
    public void getCartContentCount() {
    }
}