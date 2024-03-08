package com.example.practice4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practice4.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    private ArrayList<Vegetable> vegetables = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentSecondBinding binding = FragmentSecondBinding.inflate(getLayoutInflater());
        downloadData();
        AdapterListView adapter = new AdapterListView(getContext(), R.layout.item, vegetables);
        binding.listViewVegetables.setAdapter(adapter);
        binding.listViewVegetables.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), vegetables.get(position).toString(), Toast.LENGTH_SHORT).show();
                Log.i("vegetableOnClick", vegetables.get(position).toString());
            }
        });
        return binding.getRoot();
    }
    public void downloadData(){
        for (int i = 1; i <= 200; ++i)
            vegetables.add(new Vegetable("Морковь " + i + " вида"));
    }
}
