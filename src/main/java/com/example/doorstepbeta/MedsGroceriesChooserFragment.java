package com.example.doorstepbeta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MedsGroceriesChooserFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.meds_groceries_chooser_fragment,container,false);

        Button btn_browse_medicine = (Button) view.findViewById(R.id.btn_browse_medicines);
        Button btn_browse_groceries = (Button) view.findViewById(R.id.btn_browse_groceries);




        return view;
    }
}
