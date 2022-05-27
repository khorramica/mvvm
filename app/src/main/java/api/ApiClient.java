package api;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import ir.finto.mvvmproject.model.Movie;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    String baseUrl = "http://192.168.1.101/mvvm/";

    ApiInterface request;
    Retrofit retrofit;

    public  ApiClient()
    {
        retrofit  = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        request = retrofit.create(ApiInterface.class);
    }

    public Single<List<Movie>> GetMovieList()
    {
        return request.getMovieList();
    }
}
