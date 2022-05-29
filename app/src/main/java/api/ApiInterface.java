package api;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import ir.finto.mvvmproject.model.ApiStackResponse;
import ir.finto.mvvmproject.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("getMovie_Series.php")
    Single<List<Movie>> getMovieList();

    @GET("answers")
    Call<ApiStackResponse> GetApiStackResponse(
            @Query("page") int page,
            @Query("pagesize") int pagesize,
            @Query("site") String site
    );
}
