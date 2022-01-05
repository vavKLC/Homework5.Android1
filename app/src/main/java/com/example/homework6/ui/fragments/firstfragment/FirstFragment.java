package com.example.homework6.ui.fragments.firstfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework6.R;
import com.example.homework6.databinding.FragmentFirstBinding;
import com.example.homework6.interfaces.OnItemClickListener;
import com.example.homework6.model.TextModel;
import com.example.homework6.ui.fragments.firstfragment.adapter.AdapterText;

import java.util.ArrayList;


public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    ArrayList<TextModel> text = new ArrayList<>();
    TextModel textModel;
    AdapterText adapterText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater , container , false);
        adapterText =new AdapterText(text);
        binding.recyclerView.setAdapter(adapterText);
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setData();
        getData();


    }


    private void setData() {
        if (getArguments() != null){
            textModel = (TextModel) getArguments().getSerializable("key");
            adapterText.setText(textModel);
        }
    }

    private void getData() {
        adapterText.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(TextModel text) {
                String s =textModel.getTextInput();
                TextModel textModel = new TextModel(s);
                Bundle bundle = new Bundle();
                bundle.putSerializable("key1" , textModel);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.secondFragment, bundle);
            }
        });
    }
}