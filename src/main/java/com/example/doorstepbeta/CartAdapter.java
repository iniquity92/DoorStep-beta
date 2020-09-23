package com.example.doorstepbeta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassifierEvent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doorstepbeta.carts.Carts;
import com.example.doorstepbeta.item.Item;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements AdapterView.OnItemSelectedListener {

    private Carts carts;
    private CartModelClass cartModel;
    private String cartTag;
    private List<Item> cartItemList;
    private List quantity;
    private ArrayAdapter adapterForQtySpinner;
    private double totalForProduct;
    private int itemCount = 1;
    private CartViewHolder mHolder;
    private Item mItem;
    private int mItemPos;
    private final int TYPE_HEADER = 1;
    private final int TYPE_CART = 2;
    private final int TYPE_FOOTER = 3;


    public CartAdapter(CartModelClass cartModel,String cartTag){
      //  this.carts = cart;
        this.cartModel = cartModel;
        this.cartTag = cartTag;
        this.cartItemList = new ArrayList<>();

        if (cartTag == "shoppingcart"){
            this.cartItemList.addAll(this.cartModel.getShoppingCarts().getCartContents());
        }
        else if (cartTag == "favoritescart"){
            this.cartItemList.addAll(this.cartModel.getFavoritesCarts().getCartContents());
        }

        this.quantity = new ArrayList();
        this.quantity.add(1);
        this.quantity.add(2);
        this.quantity.add(3);
        this.quantity.add(4);
        this.quantity.add(5);
        this.quantity.add(6);
        this.quantity.add(7);
        this.quantity.add(8);
        this.quantity.add(9);
        this.quantity.add(10);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER){
            View holder = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cart_adapter_header, parent, false);

            CartHeader viewHolder = new CartHeader(holder);
            return viewHolder;
        }
        else if (viewType == TYPE_CART) {
            View holder = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cart_adapter_layout, parent, false);

            adapterForQtySpinner = new ArrayAdapter(parent.getContext(), android.R.layout.simple_spinner_item, quantity);
            adapterForQtySpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            CartViewHolder viewHolder = new CartViewHolder(holder);
            return viewHolder;
        }
        else{
            View holder = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cart_adapter_footer,parent,false);

            CartFooter viewHolder = new CartFooter(holder);
            return viewHolder;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

        final Item item = cartItemList.get(position);

        //mHolder = holder;
        //mItem = item;
        //mItemPos = position;

        if (getItemViewType(position) == TYPE_HEADER){

            ((CartHeader) holder).tv_cart_header_label.setVisibility(View.VISIBLE);
            ((CartHeader) holder).tv_cart_header_cart_total.setVisibility(View.VISIBLE);
        }

        else if (getItemViewType(position) == TYPE_FOOTER){
            ((CartFooter) holder).btn_cart_footer_checkout.setVisibility(View.VISIBLE);
        }
        else {
            ((CartViewHolder)  holder).img_cart_item.setImageResource(item.getProductImageResourceTestOnly());
            ((CartViewHolder) holder).tv_cart_item_name.setText(item.getProductName());
            if (cartTag == "shoppingcart") {
                ((CartViewHolder)holder).spn_cart_item.setAdapter(adapterForQtySpinner);
                ((CartViewHolder)holder).spn_cart_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int spinPosition, long id) {
                        int newItemCount = (int) parent.getItemAtPosition(spinPosition);

                        ((CartViewHolder) holder).tv_cart_item_item_total.setText("" + (newItemCount * item.getProductUnitPrice()));

                        if (newItemCount != 1) {
                            cartModel.getShoppingCarts().getCartContents().get(position).setProductQuantity(newItemCount - 1);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ((CartViewHolder)holder).tv_cart_item_stock_qty.setVisibility(View.INVISIBLE);
                ((CartViewHolder)holder).tv_cart_item_stock_qty_label.setVisibility(View.INVISIBLE);
            } else if (cartTag == "favoritescart") {
                ((CartViewHolder) holder).tv_cart_item_stock_qty_label.setVisibility(View.VISIBLE);
                ((CartViewHolder)holder).tv_cart_item_stock_qty.setVisibility(View.VISIBLE);
                ((CartViewHolder)holder).tv_cart_item_stock_qty.setText("" + mItem.getProductStockQuantity());

                ((CartViewHolder)holder).tv_cart_item_qty_label.setVisibility(View.INVISIBLE);
                ((CartViewHolder)holder).spn_cart_item.setVisibility(View.INVISIBLE);
            }
            ((CartViewHolder)holder).tv_cart_item_item_total.setText("" + item.getProductUnitPrice());
        }




    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        //updateCartproductcount

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void itemPriceUpdater(int itemQty){

    }

    @Override
    public int getItemViewType(int position) {

        super.getItemViewType(position);

        int val;

        if (cartModel.getShoppingCarts().getCartContents().get(position).getProductName() == "Header"){
            val = TYPE_HEADER;
        }
        else if (cartModel.getShoppingCarts().getCartContents().get(position).getProductName() == "Footer"){
            val = TYPE_FOOTER;
        }
        else{
            val = TYPE_CART;
        }
        return val ;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_cart_item;
        private TextView tv_cart_item_name;
        private Spinner spn_cart_item;
        private TextView tv_cart_item_item_total;
        private TextView tv_cart_item_qty_label;
        private ImageButton btn_cart_item_delete;
        private TextView tv_cart_item_stock_qty_label;
        private TextView tv_cart_item_stock_qty;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
             img_cart_item = itemView.findViewById(R.id.img_cart_item);
             tv_cart_item_name = itemView.findViewById(R.id.tv_cart_item_name);
             tv_cart_item_qty_label = itemView.findViewById(R.id.tv_cart_item_qty_label);
             tv_cart_item_stock_qty_label = itemView.findViewById(R.id.tv_cart_item_stock_qty_label);
             tv_cart_item_stock_qty = itemView.findViewById(R.id.tv_cart_item_stock_qty);
             spn_cart_item = itemView.findViewById(R.id.spn_cart_item);
             tv_cart_item_item_total = itemView.findViewById(R.id.tv_cart_item_item_total);
             btn_cart_item_delete = itemView.findViewById(R.id.btn_cart_item_delete);
        }
    }

    public class CartHeader extends RecyclerView.ViewHolder{

        private TextView tv_cart_header_label;
        private TextView tv_cart_header_cart_total;

        public CartHeader(@NonNull View itemView) {
            super(itemView);
            tv_cart_header_label = (TextView) itemView.findViewById(R.id.tv_cart_header_label);
            tv_cart_header_cart_total = (TextView) itemView.findViewById(R.id.tv_cart_header_cart_total);
        }
    }

    public class CartFooter extends  RecyclerView.ViewHolder{

        private Button btn_cart_footer_checkout;
        public CartFooter(@NonNull View itemView) {
            super(itemView);
            btn_cart_footer_checkout = (Button) itemView.findViewById(R.id.btn_cart_footer_checkout);
        }
    }
}
