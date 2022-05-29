package ir.finto.mvvmproject.api;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import ir.finto.mvvmproject.model.Movie;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    String baseUrl = "http://192.168.50.77/mvvm/";

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

//                .client(okHttpClient)


//        OkHttpClient.Builder builder = new OkHttpClient.Builder()
//                .readTimeout(30, TimeUnit.SECONDS)
//                .writeTimeout(30, TimeUnit.SECONDS)
//                .connectTimeout(3, TimeUnit.SECONDS);
//
//        OkHttpClient okHttpClient = builder.build();

//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
