package ir.finto.mvvmproject.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.databinding.FragmentDetailMovieBinding;
import ir.finto.mvvmproject.model.DetailMovie;

public class DetailMovieFragment extends Fragment {

    public DetailMovieFragment() {
        // Required empty public constructor
    }

    FragmentDetailMovieBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail_movie, container, false);
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_movie,container,false);

        binding.setDetailMovie(
                new DetailMovie(
                        getArguments().getString("name") ,
                        getArguments().getString("description") ,
                        getArguments().getString("link_img") ,
                        getArguments().getString("genre")));
        return binding.getRoot();
    }
}