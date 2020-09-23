package com.example.doorstepbeta.item;

import android.net.Uri;

import com.example.doorstepbeta.CartModelClass;
import com.example.doorstepbeta.annotations.TestVariables;
import com.example.doorstepbeta.users.AppUser;

import java.util.ArrayList;
import java.util.List;

public class Item {

    public static class ProductReview{
        private AppUser productuser;
        private String productReview;
        private int productRating;

        public ProductReview(){}
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

    private CartModelClass cartModel;
    private String productCode;
    private String productName;
    private String productSKU;
    private Uri productPhotoUri;
    private int productQuantity;
    private int productStockQuantity;
    private int productImageResourceTestOnly;
    private double productUnitPrice;
    private String productVendor;
    private String productDescription;
    private String productManufacturer;
    private boolean isProductOutOfStock;
    private ProductReview productReview;
    private List<ProductReview> productReviewsList;

    @TestVariables
    public List<ProductReview> productReviewListTest;
    public ProductReview productReviewTest;


    public Item(){
        this.productReviewsList = new ArrayList<>();
    }
    public Item(CartModelClass cartModel,String productCode, String productName, int productQuantity, double productUnitPrice){
        this.productCode = productCode;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productUnitPrice = productUnitPrice;
        this.productReviewsList = new ArrayList<>();
        this.cartModel = cartModel;
    }
    public Item(CartModelClass cartModel,String productName,int productQuantity,double productUnitPrice,
                int productImageResourceTestOnly,boolean isProductOutOfStock){

        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productUnitPrice = productUnitPrice;
        this.productImageResourceTestOnly = productImageResourceTestOnly;
        this.isProductOutOfStock = isProductOutOfStock;
        this.productReviewsList = new ArrayList<>();
        this.cartModel = cartModel;
    }


    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public Uri getProductPhotoUri() {
        return productPhotoUri;
    }

    public void setProductPhotoUri(Uri productPhotoUri) {
        this.productPhotoUri = productPhotoUri;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {

        this.productQuantity = productQuantity;
        cartModel.getShoppingCarts().updateCartProductCount(this.productQuantity, this);
    }

    public int getProductStockQuantity() {
        return productStockQuantity;
    }

    public void setProductStockQuantity(int productStockQuantity) {
        this.productStockQuantity = productStockQuantity;
    }

    public double getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public boolean isProductOutOfStock() {
        return isProductOutOfStock;
    }
    public void setIsProductOutOfStock(boolean isProductOutOfStock){
        this.isProductOutOfStock = isProductOutOfStock;
    }

    public int getProductImageResourceTestOnly() {
        return productImageResourceTestOnly;
    }

    public void setProductImageResourceTestOnly(int productImageResourceTestOnly) {
        this.productImageResourceTestOnly = productImageResourceTestOnly;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductReview(AppUser user,String review,int rating) {
        this.productReview = new ProductReview(user,review,rating);
        setProductReviewToProductReviewsList(this.productReview);
    }

    public void setProductReviewToProductReviewsList(ProductReview productReview){
        productReviewsList.add(productReview);
    }

    public List<ProductReview> getProductReviewsList(){
        return this.productReviewsList;
    }

    public void displayRevieews(){
        //the outside code will call this method
        //which in turn will call the getProductReviewsList
        //this method then will dissemble the list
    }



}
