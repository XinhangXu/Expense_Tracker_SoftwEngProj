package com.expensetracker.spinner_category;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.expensetracker.R;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<CategoryItems> {


    public CategoryAdapter(Context context, ArrayList<CategoryItems> categoryList ) {
        super(context, 0, categoryList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    public View initView(int position, View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView_spinner);
        TextView textView = convertView.findViewById(R.id.textView_spinner);

        CategoryItems currentItem = getItem(position);
        if(currentItem != null){
            imageView.setImageResource(currentItem.getCategoryImg());
            textView.setText(currentItem.getCategoryName());
        }


        return convertView;
    }

}
