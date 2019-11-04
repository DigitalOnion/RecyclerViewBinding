package com.outerspace.recyclerviewbinding;

import java.util.ArrayList;
import java.util.List;

import com.outerspace.recyclerviewbinding.databinding.ItemPersonContactBinding;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.v4.util.Consumer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ItemViewHolder> implements Consumer<Person> {

    LifecycleOwner lifecycleOwner = null;

    MutableLiveData<List<Person>> mutablePersonList = new MutableLiveData<>();
    List<Person> personList = new ArrayList<>();

    public MainRecyclerAdapter(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
        mutablePersonList.observe(lifecycleOwner, personList -> {
            notifyDataSetChanged();
        });
        mutablePersonList.setValue(personList);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPersonContactBinding binding  = ItemPersonContactBinding.inflate(inflater, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(binding.getRoot());

        itemViewHolder.itemViewModel.getFullName().observe(lifecycleOwner, binding.fullName::setText);
        itemViewHolder.itemViewModel.getTitle().observe(lifecycleOwner, binding.title::setText);
        itemViewHolder.itemViewModel.getNickname().observe(lifecycleOwner, binding.nickname::setText);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
        itemViewHolder.itemViewModel.getFullName().setValue(personList.get(position).fullName);
        itemViewHolder.itemViewModel.getTitle().setValue(personList.get(position).title);
        itemViewHolder.itemViewModel.getNickname().setValue(personList.get(position).nickname);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    // implement Consumer<Person>
    @Override
    public void accept(Person person) {
        personList.add(person);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewModel itemViewModel = new ItemViewModel();
        public ItemViewHolder(@NonNull View itemView) { super(itemView); }
    }

}
