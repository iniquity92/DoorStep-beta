package com.example.doorstepbeta.users;

public class AppUserTest extends AppUser {
    private String mTestUser;

    public AppUserTest(){}
    public AppUserTest(String name){
        this.mTestUser = name;
    }
    public String getReviewerName() {
        return mTestUser;
    }
}
