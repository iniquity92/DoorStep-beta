package com.example.doorstepbeta;

import androidx.fragment.app.Fragment;

public interface NavigationHost {
    public void navigateTo(Fragment fragment, boolean addToBackStack, boolean isMainActivity);
}
