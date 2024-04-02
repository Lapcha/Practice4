package com.example.practice4.UILayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.practice4.DataLayer.RepImp.RepositoryImp;
import com.example.practice4.SelectedItem;
import com.example.practice4.R;
import com.example.practice4.UILayer.Adapters.AdapterListMasters;
import com.example.practice4.UILayer.ViewModels.MastersListViewModel;
import com.example.practice4.databinding.FragmentMastersBinding;


public class MasterFragment extends Fragment implements SelectedItem {
    private FragmentMastersBinding binding;
    private MastersListViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMastersBinding.inflate(getLayoutInflater());
        viewModel =  new ViewModelProvider(this).get(MastersListViewModel.class);
        AdapterListMasters adapter = new AdapterListMasters(getContext(), viewModel.getMasters(), this);
        binding.listViewMasters.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onItemClicked(Object master) {
        RepositoryImp.getInstance().setBufferMasterName(master.toString());
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_masters_to_detailed_info);
    }
}

