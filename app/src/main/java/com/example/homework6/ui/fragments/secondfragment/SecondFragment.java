package com.example.homework6.ui.fragments.secondfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework6.R;
import com.example.homework6.databinding.FragmentSecondBinding;
import com.example.homework6.model.TextModel;

import org.w3c.dom.Text;


public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    TextModel textModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        binding.btnButtonFr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = binding.etText.getText().toString();
                TextModel textModel = new TextModel(s);
                Bundle bundle = new Bundle();
                bundle.putSerializable("key" , textModel);
                Navigation.findNavController(view).navigate(R.id.firstFragment,bundle );

            }
        });
        getData();
    }

    private void getData() {
        if (getArguments() != null){
            textModel = (TextModel) getArguments().getSerializable("key1");
            binding.etText.setText(textModel.getTextInput());
        }
    }
}