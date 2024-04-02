package com.example.practice4.UILayer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.practice4.DataLayer.Models.Service;
import com.example.practice4.R;
import com.example.practice4.SelectedItem;

import java.util.List;

public class AdapterListServices extends
        RecyclerView.Adapter<AdapterListServices.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<Service> items;
    private SelectedItem selectedItemListener;

    public AdapterListServices(Context context, List<Service> items, SelectedItem selectedItemListener) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        this.selectedItemListener = selectedItemListener;
    }

    @Override
    public AdapterListServices.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void
    onBindViewHolder(AdapterListServices.ViewHolder holder, int position) {
        Service item = items.get(position);
        holder.textView.setText(item.getName());
        holder.imageView.setImageResource(R.drawable.hair_cut);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemListener.onItemClicked(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textViewItemName);
            imageView = view.findViewById(R.id.imageViewItemImage);
        }
    }
}