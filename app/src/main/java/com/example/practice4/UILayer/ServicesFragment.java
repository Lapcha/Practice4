package com.example.practice4.UILayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.practice4.DataLayer.Models.Service;
import com.example.practice4.DataLayer.RepImp.RepositoryImp;
import com.example.practice4.SelectedItem;
import com.example.practice4.DataLayer.DS.ServicesDB;
import com.example.practice4.UILayer.Adapters.AdapterListServices;
import com.example.practice4.UILayer.ViewModels.MainMenuViewModel;
import com.example.practice4.UILayer.ViewModels.ServicesListViewModel;
import com.example.practice4.databinding.FragmentServicesBinding;

import java.util.ArrayList;

public class ServicesFragment extends Fragment implements SelectedItem {
    private FragmentServicesBinding binding;
    private ServicesListViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentServicesBinding.inflate(getLayoutInflater());
        viewModel =  new ViewModelProvider(this).get(ServicesListViewModel.class);
        AdapterListServices adapter = new AdapterListServices(getContext(), viewModel.getServices(), this);
        binding.listViewServices.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onItemClicked(Object service) {
        RepositoryImp.getInstance().setServiceName(service.toString());
        Navigation.findNavController(binding.getRoot()).popBackStack();
    }
}
