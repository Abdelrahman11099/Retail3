package com.example.retailapp.webServices;

import com.example.retailapp.ProductModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsResponse {
    @SerializedName("products")
    private List<ProductModel> productsList;

    public List<ProductModel> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductModel> productsList) {
        this.productsList = productsList;
    }
}
