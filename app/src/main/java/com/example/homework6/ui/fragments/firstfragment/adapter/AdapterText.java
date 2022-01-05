package com.example.homework6.ui.fragments.firstfragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework6.databinding.ListHolderTextBinding;
import com.example.homework6.interfaces.OnItemClickListener;
import com.example.homework6.model.TextModel;

import java.util.ArrayList;

public class AdapterText extends RecyclerView.Adapter<AdapterText.HolderText>{
    ArrayList<TextModel> text = new ArrayList<>();
    TextModel textModel;
    OnItemClickListener onItemClickListener;

    public AdapterText(ArrayList<TextModel> text) {
        this.text = text;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public AdapterText.HolderText onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderText(ListHolderTextBinding.inflate(LayoutInflater.from(parent.getContext()),parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterText.HolderText holder, int position) {
        holder.onBind(text.get(position));
    }

    public void setText(TextModel textModel){
        text.add(textModel);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return text.size();
    }

    public class HolderText extends RecyclerView.ViewHolder {
        ListHolderTextBinding binding;
        public HolderText(@NonNull ListHolderTextBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(TextModel textModel) {
            binding.tvText.setText(textModel.getTextInput());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.OnItemClick(textModel);
                }
            });
        }
    }
}

