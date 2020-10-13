package com.example.retailapp.asyncTask;

import android.os.AsyncTask;

import com.example.retailapp.ProductModel;
import com.example.retailapp.room.ProductDAO;

import java.util.List;

public class GetProductAsyncTask extends AsyncTask<Void,Void, List<ProductModel>> {

    private ProductDAO productDAO;

    public GetProductAsyncTask(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    protected List<ProductModel> doInBackground(Void... voids) {

        return productDAO.getAllProducts();
    }
}
