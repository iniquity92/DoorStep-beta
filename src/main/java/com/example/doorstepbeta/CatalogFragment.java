package com.example.doorstepbeta;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doorstepbeta.carts.Carts;
import com.example.doorstepbeta.carts.FavoritesCart;
import com.example.doorstepbeta.carts.ShoppingCart;
import com.example.doorstepbeta.item.Item;
//import com.example.doorstepbeta.threads.CartPoll;
import com.example.doorstepbeta.threads.CatalogButtonsHandler;

import java.util.ArrayList;
import java.util.List;

/***
 * This or the mainActivity implements the interfaces onClickAddToFavoritesCart, and onClickAddToShoppingCart
 ***/

public class CatalogFragment extends Fragment{

    private String catalog_database;
    private RecyclerView recyclerView;
    private CatalogAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Carts shoppingCart;
    private Carts favoritesCart;

    Item i0,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16;

    List<Item> shoppingCatalog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.catalog_fragment,container,false);

        catalog_database = getArguments().getString("catalog_db_type");

        recyclerView = (RecyclerView) view.findViewById(R.id.catalog_fragment_recycler_view);

        CartModelClass cartModel = new ViewModelProvider(getActivity()).get(CartModelClass.class);

        /******* Test data, replace this with data from google firebase ******/

        i0 = new Item(cartModel,"Header","Header",0,0);
        i1 = new Item(cartModel,"Aeroplane",2,40000000,R.drawable.ic_paper_aeroplane,false);
        i2 = new Item(cartModel,"Shopping cart",30,500,R.drawable.ic_paper_aeroplane,false);
        i3 = new Item(cartModel,"Stuffed toy",5000,10.0,R.drawable.ic_paper_aeroplane,false);
        i4 = new Item(cartModel,"Hand Lense",400,20,R.drawable.ic_paper_aeroplane,false);
        i5 = new Item(cartModel,"Laptop",30,20000,R.drawable.ic_paper_aeroplane,false);
        i6 = new Item(cartModel,"Aeroplane",2,40000000,R.drawable.ic_paper_aeroplane,true);
        i7 = new Item(cartModel,"Shopping cart",30,500,R.drawable.ic_paper_aeroplane,true);
        i8 = new Item(cartModel,"Stuffed toy",5000,10.0,R.drawable.ic_paper_aeroplane,false);
        i9 = new Item(cartModel,"Hand Lense",400,20,R.drawable.ic_paper_aeroplane,true);
        i10 = new Item(cartModel,"Laptop",30,20000,R.drawable.ic_paper_aeroplane,false);
        i11 = new Item(cartModel,"Aeroplane",2,40000000,R.drawable.ic_paper_aeroplane,false);
        i12 = new Item(cartModel,"Shopping cart",30,500,R.drawable.ic_paper_aeroplane,false);
        i13 = new Item(cartModel,"Stuffed toy",5000,10.0,R.drawable.ic_paper_aeroplane,true);
        i14 = new Item(cartModel,"Hand Lense",400,20,R.drawable.ic_paper_aeroplane,false);
        i15 = new Item(cartModel,"Laptop",30,20000,R.drawable.ic_paper_aeroplane,false);
        i16 = new Item(cartModel,"Footer","Footer",0,0);

        shoppingCatalog = new ArrayList<>();

        shoppingCatalog.add(i1);
        shoppingCatalog.add(i2);
        shoppingCatalog.add(i3);
        shoppingCatalog.add(i4);
        shoppingCatalog.add(i5);
        shoppingCatalog.add(i6);
        shoppingCatalog.add(i7);
        shoppingCatalog.add(i8);
        shoppingCatalog.add(i9);
        shoppingCatalog.add(i10);
        shoppingCatalog.add(i11);
        shoppingCatalog.add(i12);
        shoppingCatalog.add(i13);
        shoppingCatalog.add(i14);
        shoppingCatalog.add(i15);

        /********** End Test Data ********************/

        recyclerView.hasFixedSize();

        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);


        /***
         * View Model
         */


       // shoppingCart = cartModel.getShoppingCarts();
        //favoritesCart = cartModel.getFavoritesCarts();

        mAdapter = new CatalogAdapter(shoppingCatalog,cartModel);
        recyclerView.setAdapter(mAdapter);

        return view;
    }






}
