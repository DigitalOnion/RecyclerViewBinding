package com.outerspace.recyclerviewbinding;

import com.outerspace.recyclerviewbinding.databinding.ActivityMainBinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        binding.mainRecycler.setLayoutManager(manager);

        MainRecyclerAdapter adapter = new MainRecyclerAdapter(this);
        binding.mainRecycler.setAdapter(adapter);

        PersonRepo repo = PersonRepo.getInstance();
        repo.setPersonConsumer(adapter);
        repo.start();
    }
}
