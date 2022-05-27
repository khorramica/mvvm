package ir.finto.mvvmproject.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import api.ApiClient;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.finto.mvvmproject.model.Movie;

public class ViewModelMovie extends ViewModel {

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiClient apiClient;
    private MutableLiveData<List<Movie>> listMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Movie>> getListMutableLiveData() {

        apiClient = new ApiClient();

        compositeDisposable.add(apiClient.GetMovieList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Movie>>() {
                    @Override
                    public void onSuccess(@NonNull List<Movie> movies) {

                        listMutableLiveData.setValue(movies);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("Livedata Error", e.getMessage());
                    }
                }));
        return listMutableLiveData;

    }


    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
