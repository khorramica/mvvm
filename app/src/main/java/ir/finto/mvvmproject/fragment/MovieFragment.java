package ir.finto.mvvmproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.adapter.MovieAdapter;
import ir.finto.mvvmproject.databinding.FragmentMovieBinding;
import ir.finto.mvvmproject.interFace.onClickMovieListener;
import ir.finto.mvvmproject.model.Movie;
import ir.finto.mvvmproject.viewmodel.ViewModelMovie;

public class MovieFragment extends Fragment implements onClickMovieListener {


    public MovieFragment() {
        // Required empty public constructor
    }

    FragmentMovieBinding binding;
    RecyclerView recyclerView;

    MovieAdapter adapterMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_movie, container, false);

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie,container,false);
        recyclerView = binding.recyclerViewMovie;

        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("KH_","public void onViewCreated");
        ViewModelMovie viewModelMovie = new ViewModelProvider(getActivity()).get(ViewModelMovie.class);
        MutableLiveData<List<Movie>> listMutableLiveData = viewModelMovie.getListMutableLiveData();

        listMutableLiveData.observe(getActivity(), new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,true));
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                recyclerView.setHasFixedSize(true);

                adapterMovie = new MovieAdapter(getActivity(),movies,MovieFragment.this::onClick);

                recyclerView.setAdapter(adapterMovie);
            }
        });
    }

    @Override
    public void onClick(Movie movie) {
        Bundle bundle = new Bundle();
        bundle.putString("id",movie.getId());
        bundle.putString("name",movie.getName());
        bundle.putString("description",movie.getDescription());
        bundle.putString("link_img",movie.getLink_img());
        bundle.putString("genre",movie.getGenre());

        Navigation.findNavController(recyclerView).navigate(R.id.action_movieFragment_to_detailMovieFragment,bundle);

    }
}