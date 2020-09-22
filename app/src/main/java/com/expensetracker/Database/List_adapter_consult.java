package com.expensetracker.Database;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.expensetracker.Consultperson;
import com.expensetracker.R;

import java.util.ArrayList;


public class List_adapter_consult extends ArrayAdapter<Consultperson> {

    private Context context;
    private int layout;
    private ArrayList<Consultperson> arrayList;

    public List_adapter_consult(Context context, int layout, ArrayList<Consultperson> arrayList) {
        super(context, R.layout.list_consult, arrayList);
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }


/*    public int getCount() {
        return arrayList.size();
    }


    public Object getItem(int position) {
        return arrayList.get(position);
    }


    public long getItemId(int position) {
        return position;
    }


    private class ViewHolder {
        ImageView imageView;
        TextView name, description;
    }*/

    public View getView(int position, View view, ViewGroup viewGroup) {

        String name = getItem(position).getName();
        String description  = getItem(position).getDescription();
        //String img = getItem(position).get;
        Consultperson person = new Consultperson(name, description);

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(layout, null);

        TextView txt_name = view.findViewById(R.id.list_consult_name);
        TextView txt_description = view.findViewById(R.id.list_consult_description);
        //TextView txt_name = view.findViewById(R.id.list_consult_name);

        txt_name.setText(name);
        txt_description.setText(description);

        return view;


    }


    @Nullable

    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}


