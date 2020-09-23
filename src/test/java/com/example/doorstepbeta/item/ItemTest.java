package com.example.doorstepbeta.item;

import android.util.Log;

import com.example.doorstepbeta.users.AppUser;
import com.example.doorstepbeta.users.AppUserTest;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    Item item1 = new Item("item1","Paper Plane",2000,"2.00");
    Item item2 = new Item("item2","Shutter Clock", 200, "110.00");
    Item item3 = new Item("item3","Smiley Ball",10000,"20.00");

    Item testItem = new Item();


    @Test
    public void getProductCode() {


    }

    @Test
    public void setProductCode() {
    }

    @Test
    public void getProductName() {
    }

    @Test
    public void setProductName() {
    }

    @Test
    public void getProductSKU() {
    }

    @Test
    public void setProductSKU() {
    }

    @Test
    public void getProductPhotoUri() {
    }

    @Test
    public void setProductPhotoUri() {
    }

    @Test
    public void getProductQuantity() {
    }

    @Test
    public void setProductQuantity() {
    }

    @Test
    public void getProductStockQuantity() {
    }

    @Test
    public void setProductStockQuantity() {
    }

    @Test
    public void getProductUnitPrice() {
    }

    @Test
    public void setProductUnitPrice() {
    }

    @Test
    public void isProductOutOfStock() {
    }

    @Test
    public void setIsProductOutOfStock() {
    }

    @Test
    public void getProductImageResourceTestOnly() {
    }

    @Test
    public void setProductImageResourceTestOnly() {
    }

    @Test
    public void getProductVendor() {
    }

    @Test
    public void setProductVendor() {
    }

    @Test
    public void getProductManufacturer() {
    }

    @Test
    public void setProductManufacturer() {
    }

    @Test
    public void getProductDescription() {
    }

    @Test
    public void setProductDescription() {
    }

    @Test
    public void setProductReview() {

        item1.setProductReview(new AppUserTest("Abhishek"),"Best Plane in the sky",4);
        item1.setProductReview(new AppUserTest("Suman"),"I rode it to the moon, but it came late", 3);
        item1.setProductReview(new AppUserTest("Rishabh"),"Flew faster than my jet",5);
    }

    @Test
    public void setProductReviewToProductReviewsList() {
    }

    @Test
    public void getProductReviewsList() {
        List<Item.ProductReview> reviews = item1.getProductReviewsList();
        String expectedName;
        String expectedReview;
        int expectedRating;

        int i=0;

        for (Item.ProductReview review : reviews) {
            switch (i++){
                case 0:
                    expectedName = "Abhishek";
                    expectedRating = 4;
                    expectedReview = "Best Plane in the sky";
                    break;
                case 1:
                    expectedName = "Suman";
                    expectedReview = "I rode it to the moon, but it came late";
                    expectedRating = 3;
                    break;
                case 2:
                    expectedName = "Rishabh";
                    expectedReview = "Flew faster than my jet";
                    expectedRating = 5;
                    break;
                default:
                    expectedName = "Default String";
                    expectedReview = "Default review";
                    expectedRating = 999;
                    break;

            }
            assertArrayEquals(expectedName.toCharArray(),review.getProductuser().toString().toCharArray());
            System.out.println("ItemTest - "+review.getProductuser().toString());
            assertArrayEquals(expectedReview.toCharArray(),review.getProductReview().toCharArray());
            assertEquals(expectedRating,review.getProductRating());
        }


    }

    @Test
    public void displayRevieews() {
    }
}