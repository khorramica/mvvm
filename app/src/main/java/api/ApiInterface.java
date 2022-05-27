package api;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import ir.finto.mvvmproject.model.Movie;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("getMovie_series.php")
    Single<List<Movie>> getMovieList();
}
