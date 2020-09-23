package com.example.doorstepbeta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doorstepbeta.carts.Carts;

public class CartFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CartAdapter cartAdapter;
    private Carts carts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        String tag = getArguments().getString("cartTag");
        View view = inflater.inflate(R.layout.cart_fragment_layout, container, false);

        CartModelClass cartModel = new ViewModelProvider(getActivity()).get(CartModelClass.class);

        recyclerView = (RecyclerView) view.findViewById(R.id.cart_fragment_recycler_view);

        recyclerView.hasFixedSize();

        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        cartAdapter = new CartAdapter(cartModel,tag);
        recyclerView.setAdapter(cartAdapter);

        Button myBtn = new Button(getActivity());

        myBtn.setVisibility(View.VISIBLE);
        myBtn.setText("Proceed to checkout");

        return view;
    }
}
