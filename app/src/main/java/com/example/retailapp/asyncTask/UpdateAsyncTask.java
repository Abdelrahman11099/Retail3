package com.example.retailapp.asyncTask;

import android.os.AsyncTask;

import com.example.retailapp.ProductModel;
import com.example.retailapp.room.ProductDAO;

public class UpdateAsyncTask extends AsyncTask<ProductModel,Void,Void> {

    private ProductDAO productDAO;

    public UpdateAsyncTask(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    protected Void doInBackground(ProductModel... productModels) {
        productDAO.updateProduct(productModels[0]);
        return null;
    }
}
