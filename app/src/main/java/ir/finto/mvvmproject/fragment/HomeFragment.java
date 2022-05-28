package ir.finto.mvvmproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ir.finto.mvvmproject.R;


public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }

    Button btnGo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnGo = view.findViewById(R.id.btn_go);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections = HomeFragmentDirections.actionHomeFragmentToDetailFragment();

//                Bundle bundle = new Bundle();
//                bundle.putString("name","MyName");

                Navigation.findNavController(btnGo).navigate(navDirections);
//                Navigation.findNavController(btnGo).navigate(R.id.action_homeFragment_to_detailFragment,bundle);
            }
        });
    }
}