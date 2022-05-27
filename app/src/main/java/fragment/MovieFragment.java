package fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.adapter.MovieAdapter;
import ir.finto.mvvmproject.databinding.FragmentMovieBinding;
import ir.finto.mvvmproject.model.Movie;
import ir.finto.mvvmproject.viewmodel.ViewModelMovie;

public class MovieFragment extends Fragment {

    public MovieFragment() {
        // Required empty public constructor
    }

    FragmentMovieBinding binding;
    RecyclerView rcViewMovie;
    MovieAdapter movieAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_movie, container, false);

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie,container,false);

        rcViewMovie = binding.rcviewMovie;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelMovie viewModelMovie = new ViewModelProvider(getActivity()).get(ViewModelMovie.class);
        MutableLiveData<List<Movie>> listMutableLiveData = viewModelMovie.getListMutableLiveData();

        listMutableLiveData.observe(getActivity(), new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                rcViewMovie.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                rcViewMovie.setHasFixedSize(true);
                movieAdapter = new MovieAdapter(getActivity(),movies);
                rcViewMovie.setAdapter(movieAdapter);
            }
        });
    }
}