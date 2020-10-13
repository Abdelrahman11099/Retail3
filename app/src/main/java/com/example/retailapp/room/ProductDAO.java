package com.example.retailapp.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.retailapp.ProductModel;

import java.util.List;

@Dao
public interface ProductDAO {

    @Insert
    void insertProduct(ProductModel productModel);
    @Query("SELECT * FROM products")
    List<ProductModel> getAllProducts();

    @Query("DELETE FROM PRODUCTS")
    void deleteAllProducts();

    @Update
    void updateProduct(ProductModel productModel);
}
