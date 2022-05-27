package ir.finto.mvvmproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.adapter.userAdapter;
import ir.finto.mvvmproject.databinding.ActivityDataBindingSimplePart01Binding;
import ir.finto.mvvmproject.model.Users;


public class Part01SimpleDataBindingActivity extends AppCompatActivity {

    ActivityDataBindingSimplePart01Binding binding;
    List<Users> list = new ArrayList<>();
    userAdapter adapter;
    Users user;
    RecyclerView rvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_simple_part01);
        rvUsers = binding.recycleViewUser;
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
rvUsers.setHasFixedSize(true);
        list.add(new Users("Tom kroz", "Tomkroz@gmail.com", "https://m.media-amazon.com/images/M/MV5BMTk1MjM3NTU5M15BMl5BanBnXkFtZTcwMTMyMjAyMg@@._V1_UY264_CR11,0,178,264_AL_.jpg"));
        list.add(new Users("Bradpitt", "brad@yahoo.com", "https://i.pinimg.com/originals/dd/ff/61/ddff61e3162dce870f044b240cda6d60.jpg"));
        list.add(new Users("Celion dion", "cd@gmail.com", "https://see.news/wp-content/uploads/2022/04/celine-dion-e1650445468835.jpg"));

        adapter = new userAdapter(this, list);
        rvUsers.setAdapter(adapter);

        binding.setUserInfo(user);
    }
}