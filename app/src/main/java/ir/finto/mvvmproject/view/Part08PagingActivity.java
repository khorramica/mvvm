package ir.finto.mvvmproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.adapter.PagingItemAdapter;
import ir.finto.mvvmproject.model.Items;
import ir.finto.mvvmproject.viewmodel.ViewModelPaging;

public class Part08PagingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PagingItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part08_paging);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PagingItemAdapter(this);
        ViewModelPaging viewModelPaging = new ViewModelProvider(this).get(ViewModelPaging.class);

        viewModelPaging.itemListLiveData.observe(this, new Observer<PagedList<Items>>() {
            @Override
            public void onChanged(PagedList<Items> items) {
                adapter.submitList(items);
            }
        });

        recyclerView.setAdapter(adapter);
    }
}