package com.example.doorstepbeta;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doorstepbeta.carts.FavoritesCart;
import com.example.doorstepbeta.carts.ShoppingCart;
import com.example.doorstepbeta.item.Item;
import com.example.doorstepbeta.threads.CatalogButtonsHandler;

import java.util.ArrayList;
import java.util.List;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder> {

    private List<Item> catalogItemList;
    private ShoppingCart shoppingCart;
    private FavoritesCart favoritesCart;
    private CartModelClass cartModel;



    public CatalogAdapter(){}

    public CatalogAdapter(List<Item> catalogItemList,CartModelClass cartModel){
        this.catalogItemList = new ArrayList<>();
        this.catalogItemList.addAll(catalogItemList);
        this.shoppingCart = shoppingCart;
        this.favoritesCart = favoritesCart;
        this.cartModel = cartModel;
    }


    @NonNull
    @Override
    public CatalogAdapter.CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View holder = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.catalog_item_view_for_recycler_view,parent,false);

        /*** Must tie the interface to the view created by this adapter hence the interface instances are
         * passed on to the viewHolder Class which binds these implemtations to the adapter
         * ***/
        CatalogViewHolder viewHolder = new CatalogViewHolder(holder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CatalogAdapter.CatalogViewHolder holder, int position) {
        final Item item = catalogItemList.get(position);

        // use Glide library https://github.com/bumptech/glide, implementation 'com.github.bumptech.glide:glide:4.11.0'
        // annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
        // to load image from the remote site

        // for testing purpose have them load from the resource
        // holder.img_item_cardview.setImageURI(item.getProductPhotoUri());

        holder.img_item_cardview.setImageResource(item.getProductImageResourceTestOnly());
        holder.tv_item_cardview_item_name.setText(item.getProductName());
        holder.tv_item_cardview_item_qty.setText(""+item.getProductQuantity());// comment out this line
        //holder.tv_item_cardview_item_qty.setText(item.getProductStockQuantity()); in actual code
        holder.tv_item_cardview_item_price.setText(""+item.getProductUnitPrice());

        if (item.isProductOutOfStock()){
            holder.btn_item_cardview_add_cart.setText("Out of Stock");
            holder.btn_item_cardview_add_cart.setEnabled(false);
        }
        else{
            holder.btn_item_cardview_add_cart.setEnabled(true);
        }


        holder.btn_item_cardview_add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Adapter::LOG::ADD2CART", item.getProductName());

                CatalogButtonsHandler cbh = new CatalogButtonsHandler(cartModel, item,1);
                cbh.addItemToCart();
                holder.btn_item_cardview_add_cart.setEnabled(false);
            }
        });


        holder.btn_item_cardview_add_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Adapter::LOG::ADD2FAV", item.getProductName());

                CatalogButtonsHandler cbh = new CatalogButtonsHandler(cartModel, item,0);
                cbh.addItemToCart();
                holder.btn_item_cardview_add_wishlist.setEnabled(false);
            }
        });

    }

    @Override
    public int getItemCount() {
        return catalogItemList.size();
    }

    /***
     * This class unfolds the view from the layout passed to the adapter. it also implements the
     * OnClickListener method of the View class. It is done to provide custom functionality to our buttons
     * using method overriding
     */
    public class CatalogViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_item_cardview;
        private TextView tv_item_cardview_item_name;
        private TextView tv_item_cardview_item_qty;
        private TextView tv_item_cardview_item_price;
        private Button btn_item_cardview_add_cart;
        private Button btn_item_cardview_add_wishlist;



        public CatalogViewHolder(@NonNull View itemView) {
            super(itemView);

            img_item_cardview = (ImageView) itemView.findViewById(R.id.img_item_cardview);
            tv_item_cardview_item_name = (TextView) itemView.findViewById((R.id.tv_item_cardview_item_name));
            tv_item_cardview_item_price = (TextView) itemView.findViewById(R.id.tv_item_cardview_item_price);
            tv_item_cardview_item_qty = (TextView) itemView.findViewById(R.id.tv_item_cardview_item_qty);
            btn_item_cardview_add_cart = (Button) itemView.findViewById(R.id.btn_item_cardview_add_cart);
            btn_item_cardview_add_wishlist = (Button) itemView.findViewById(R.id.btn_item_cardview_add_wishlist);

        }

    }

}
