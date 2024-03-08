package com.example.practice4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.practice4.databinding.FragmentThirdBinding;

import java.util.ArrayList;

public class ThirdFragment extends Fragment implements SelectedItem{
    private ArrayList<Fruit> fruits = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentThirdBinding binding = FragmentThirdBinding.inflate(getLayoutInflater());
        downloadData();
        AdapterRecyclerView adapter = new AdapterRecyclerView(getContext(), fruits, this);
        binding.listViewFruits.setAdapter(adapter);
        return binding.getRoot();
    }
    public void downloadData(){
        for (int i = 1; i <= 200; ++i)
            fruits.add(new Fruit("Яблоко " + i + " вида"));
    }

    @Override
    public void onItemClicked(Fruit fruit) {
        Toast.makeText(getContext(), fruit.toString(), Toast.LENGTH_SHORT).show();
        Log.i("fruitOnClick", fruit.toString());
    }
}

