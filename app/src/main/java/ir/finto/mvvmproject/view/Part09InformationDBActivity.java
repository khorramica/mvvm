package ir.finto.mvvmproject.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.RoomDB.Information;
import ir.finto.mvvmproject.adapter.InformationAdapter;
import ir.finto.mvvmproject.interFace.onDeleteItems;
import ir.finto.mvvmproject.viewmodel.ViewModelRoomDB;

public class Part09InformationDBActivity extends AppCompatActivity implements onDeleteItems {

    RecyclerView recyclerView;
    FloatingActionButton fab;
public static int NEW_REQUEST_CODE_INFO =1;
List<Information> informationList = new ArrayList<>();
InformationAdapter adapter;
ViewModelRoomDB viewModelRoomDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part09_information_dbactivity);

        viewModelRoomDB = new ViewModelProvider(this).get(ViewModelRoomDB.class);

        recyclerView = findViewById(R.id.recyclerView_DB);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new InformationAdapter(this,informationList,this);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.btn_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Part09InformationDBActivity.this,Part09AddInformationDBActivity.class);
                startActivityForResult(intent,NEW_REQUEST_CODE_INFO);


            }
        });

        viewModelRoomDB.getAllInformation().observe(this, new Observer<List<Information>>() {
            @Override
            public void onChanged(List<Information> information) {
                adapter.Insert(information);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_REQUEST_CODE_INFO && resultCode == RESULT_OK)
        {
            String rand_id = UUID.randomUUID().toString();
            Information information = new Information(rand_id,data.getStringExtra(Part09AddInformationDBActivity.KEY_INFO_SAVE));

            viewModelRoomDB.InsertInformation(information);
            Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDelete(Information information) {
        viewModelRoomDB.DeleteInformation(information);
    }
}