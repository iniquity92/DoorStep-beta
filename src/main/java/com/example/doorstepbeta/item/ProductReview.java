package com.example.doorstepbeta.item;

import com.example.doorstepbeta.users.AppUser;

public class ProductReview{
    private AppUser productuser;
    private String productReview;
     private int productRating;

    public ProductReview(AppUser user,String review,int rating){
        productuser = user;
        productReview = review;
        productRating = rating;
    }

    public AppUser getProductuser() {
        return productuser;
    }

    public void setProductuser(AppUser productuser) {
        this.productuser = productuser;
    }

    public int getProductRating() {
        return productRating;
    }

    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }

    public String getProductReview() {
        return productReview;
    }

    public void setProductReview(String productReview) {
        this.productReview = productReview;
    }
}