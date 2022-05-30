package ir.finto.mvvmproject.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiStack {
    String BASE_URL = "https://api.stackexchange.com/2.2/";
    Retrofit retrofit;
    static ApiStack apiStack;

    public ApiStack()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiStack getInstance()
    {
        if(apiStack == null)
            apiStack = new ApiStack();

        return apiStack;
    }

    public ApiInterface GetApiStack()
    {
        return retrofit.create(ApiInterface.class);
    }
}
