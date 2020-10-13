package com.example.retailapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retailapp.ProductModel;
import com.example.retailapp.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductsViewHolder> {

    private List<ProductModel> ProductsList;
    private Context context;

    private OnProductClickListener onProductClickListener;

    private OnAddProductClickListener onAddProductClickListener;

    public interface OnProductClickListener{
        void OnProductClick(View view,int position);
    }
    public interface OnAddProductClickListener{
        void OnAddProductClick(View view,int position);
    }

    public ProductAdapter(List<ProductModel> productsList, Context context, OnProductClickListener onProductClickListener, OnAddProductClickListener onAddProductClickListener) {
        ProductsList = productsList;
        this.context = context;
        this.onProductClickListener = onProductClickListener;
        this.onAddProductClickListener = onAddProductClickListener;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_rv_item,parent,false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductsViewHolder holder, int position) {

        ProductModel productModel = ProductsList.get(position);
        holder.productTitleTv.setText(productModel.getTitle());
        holder.productDetailsTv.setText(productModel.getDetails());
        holder.productPriceTv.setText(productModel.getPrice());

        Glide.with(context).load(productModel.getImage()).into(holder.productIv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProductClickListener.OnProductClick(v,holder.getAdapterPosition());
            }
        });

        holder.addProductIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddProductClickListener.OnAddProductClick(v,holder.getAdapterPosition());
            }
        });


    }

    @Override
    public int getItemCount() {
        return ProductsList.size();
    }

    class ProductsViewHolder extends RecyclerView.ViewHolder {

        ImageView productIv;
        TextView productTitleTv;
        TextView productDetailsTv;
        TextView productPriceTv;
        ImageButton addProductIb;
        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            productIv = itemView.findViewById(R.id.product_iv);
            productTitleTv = itemView.findViewById(R.id.product_title_tv);
            productDetailsTv = itemView.findViewById(R.id.product_details_tv);
            productPriceTv = itemView.findViewById(R.id.product_price_tv);
            addProductIb = itemView.findViewById(R.id.add_product_ib);


        }
    }
}
