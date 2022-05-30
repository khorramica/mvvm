package ir.finto.mvvmproject.api;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import ir.finto.mvvmproject.model.ApiStackResponse;
import ir.finto.mvvmproject.model.Items;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Items> {

    public static String NAME_SITE = "stackoverflow";
    public static int PAGE = 1;
    public static int PAGE_SIZE = 30;

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> loadParams, @NonNull LoadCallback<Integer, Items> loadCallback) {

        ApiStack.getInstance().GetApiStack().GetApiStackResponse(loadParams.requestedLoadSize, PAGE_SIZE, NAME_SITE).enqueue(new Callback<ApiStackResponse>() {
            @Override
            public void onResponse(Call<ApiStackResponse> call, Response<ApiStackResponse> response) {

                if (response.body() != null) {
                    Integer key = response.body().has_more ? loadParams.key + 1 : null;
                    loadCallback.onResult(response.body().items, key);
                }

            }

            @Override
            public void onFailure(Call<ApiStackResponse> call, Throwable t) {
                Log.d("ERROR : ", t.getMessage() + "");
            }
        });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> loadParams, @NonNull LoadCallback<Integer, Items> loadCallback) {
        ApiStack.getInstance().GetApiStack().GetApiStackResponse(loadParams.key, PAGE_SIZE, NAME_SITE).enqueue(new Callback<ApiStackResponse>() {
            @Override
            public void onResponse(Call<ApiStackResponse> call, Response<ApiStackResponse> response) {

                if (response.body() != null) {
                    Integer key = (loadParams.key > 1) ? loadParams.key - 1 : null;
                    loadCallback.onResult(response.body().items, key);
                }

            }

            @Override
            public void onFailure(Call<ApiStackResponse> call, Throwable t) {
                Log.d("ERROR : ", t.getMessage() + "");
            }
        });

    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> loadInitialParams, @NonNull LoadInitialCallback<Integer, Items> loadInitialCallback) {

        ApiStack.getInstance().GetApiStack().GetApiStackResponse(PAGE, PAGE_SIZE, NAME_SITE).enqueue(new Callback<ApiStackResponse>() {
            @Override
            public void onResponse(Call<ApiStackResponse> call, Response<ApiStackResponse> response) {
                if (response.body() != null) {
                    loadInitialCallback.onResult(response.body().items, null, PAGE + 1);
                }
            }

            @Override
            public void onFailure(Call<ApiStackResponse> call, Throwable t) {
                Log.d("ERROR : ", t.getMessage() + "");
            }
        });

    }
}
