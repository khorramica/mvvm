package ir.finto.mvvmproject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ir.finto.mvvmproject.R;

public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    TextView txtName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this ir.finto.mvvmproject.fragment
        return  inflater.inflate(R.layout.fragment_detail, container, false);

//        txtName = view.findViewById(R.id.txt_Name);
//        txtName.setText(getArguments().getString("name"));
        //return  view;

    }
}