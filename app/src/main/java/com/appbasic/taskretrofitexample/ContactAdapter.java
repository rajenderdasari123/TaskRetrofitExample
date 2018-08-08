package com.appbasic.taskretrofitexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import retrofit2.Callback;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewholder> {
    List<Contact> contactlist;
    MainActivity mainActivity;

    public ContactAdapter(List<Contact> contactlist, MainActivity mainActivity) {
        this.contactlist = contactlist;
        this.mainActivity = mainActivity;

    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        view.getLayoutParams().width=MainActivity.width;
        view.getLayoutParams().height=MainActivity.height/6;

        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        Contact cont = contactlist.get(position);
        holder.id.setText(""+cont.getCuisine_id());
        holder.name.setText(""+cont.getCuisine_name());
    }

    @Override
    public int getItemCount() {
        return contactlist.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;

        public MyViewholder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
