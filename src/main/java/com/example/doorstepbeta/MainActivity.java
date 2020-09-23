package com.example.doorstepbeta;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.doorstepbeta.carts.Carts;
import com.example.doorstepbeta.carts.FavoritesCart;
import com.example.doorstepbeta.carts.ShoppingCart;
import com.example.doorstepbeta.login.Login;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationHost {
    private Login login;
    private FirebaseUser mUser;
    private androidx.appcompat.widget.Toolbar mToolbar;
    private MenuItem cart; //to update the UI
    private MenuItem itemSearch;
    private MenuItem itemCart;
    private MenuItem itemFavorite;
    private MenuItem itemOrderHistory;
   // private ShoppingCart shoppingCart;
//    private FavoritesCart favoritesCart;
    private Carts shoppingCart;
    private Carts favoritesCart;

    private CartModelClass cartViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(getApplication());

//      Step 1 : check customer login status
       login = new Login(this);
        if (!login.checkUserLoginStatus()){
            login.startLoginIntent();
            mUser = login.getmUser();
        }
        else {
            mUser = login.getmUser();
        }


        cartViewModel =  new ViewModelProvider(this).get(CartModelClass.class);
        cartViewModel.setFavoritesCarts(new FavoritesCart(true,true,"favoritescart"));
        cartViewModel.setShoppingCarts(new ShoppingCart(true,true,"shoppingcart"));

        //start from

      navigateTo(new MedsGroceriesChooserFragment(),true,true);




      listenForCartChanges(cartViewModel);
      //onCreate function ends here, put every code that is to run at initialization must go before this line
    }

    @Override
    public void navigateTo(Fragment fragment, boolean addToBackStack, boolean isMainActivity) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        if (isMainActivity) {
                transaction.replace(R.id.container, fragment);
        }
        else {
            transaction.replace(R.id.container,fragment);
        }

        if (addToBackStack){
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        itemSearch = menu.findItem(R.id.search_bar);
        itemCart = menu.findItem(R.id.shopping_cart);
        itemFavorite = menu.findItem(R.id.favorites_cart);
        itemOrderHistory = menu.findItem(R.id.orders);

//        itemCart.getActionView().setBackgroundResource(R.color.colorPrimaryDark);
//        itemCart.getActionView().findViewById(R.id.shopping_cart_badge);
//        itemCart.getActionView().findViewById(R.id.shopping_cart_text);

        androidx.appcompat.widget.SearchView searchBar = (androidx.appcompat.widget.SearchView) itemSearch.getActionView();

        itemCart.getActionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               navigateToCarts(v);
               Log.d("MENUITEMCART", "Shoppin Cart");
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    public void navigateToCarts(@NonNull View item) {

        Bundle data = new Bundle();
        Fragment fragment = new CartFragment();

        switch (item.getId()){
            case R.id.favorites_cart:
                data.putString("cartTag", "favoritescart");

                break;
            case R.id.shopping_cart_action_layout:
                data.putString("cartTag","shoppingcart");
                break;

        }
        fragment.setArguments(data);
        navigateTo(fragment, true, false);
        //return super.onOptionsItemSelected(item);
    }

    public void openCatalog(View v){

        Bundle data = new Bundle();
        Fragment fragment= new CatalogFragment();

        switch (v.getId()){
            case R.id.btn_browse_groceries:
                data.putString("catalog_db_type","groceries");

                break;
            case R.id.btn_browse_medicines:
                data.putString("catalog_db_type","medicines");
                break;
        }

        fragment.setArguments(data);
        navigateTo(fragment,true,false);
    }



    public void updateAppBarUI(final Carts cart){

        final int cartResBadge;
        final int cartResText;
        final MenuItem item;

        switch (cart.getCartTag()){
            case "shoppingcart":
                item = itemCart;
                cartResBadge = R.id.shopping_cart_badge;
                cartResText = R.id.shopping_cart_text;
                break;
            case "favoritescart":
                item = itemFavorite;
                cartResBadge = R.id.favorites_badge;
                cartResText = R.id.favorites_cart_text;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + cart.getCartTag());
        }

        new Thread(){
            @Override
            public void run() {
                super.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        item.getActionView().findViewById(cartResBadge).setVisibility(View.VISIBLE);
                        TextView CartTextView = (TextView) item.getActionView().findViewById(cartResText);
                        CartTextView.setVisibility(View.VISIBLE);
                        CartTextView.setText(""+cart.getCartProductCount());
                    }
                });
            }
        }.start();



        Log.d("MAINACTIVITY::UPDATEAPPBAR", "I'm here");

    }


    public void listenForCartChanges(final CartModelClass cartModel) {

        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    while(true){
                        if (cartModel.getShoppingCarts().isCartUpdated()){
                            updateAppBarUI(cartModel.getShoppingCarts());
                            cartModel.getShoppingCarts().setIsCartUpdated(false);
                        }
                        if (cartModel.getFavoritesCarts().isCartUpdated()){
                            updateAppBarUI(cartModel.getFavoritesCarts());
                            cartModel.getFavoritesCarts().setIsCartUpdated(false);

                        }
                        Thread.sleep(1000);
                    }

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();


    }


    //End of class every other code before this comment
}

