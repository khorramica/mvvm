package ir.finto.mvvmproject.api;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;


import ir.finto.mvvmproject.model.Items;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, Items>> sourceMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<PageKeyedDataSource<Integer, Items>> getSourceMutableLiveData() {
        return sourceMutableLiveData;
    }

    @NonNull
    @Override
    public DataSource create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        sourceMutableLiveData.postValue(itemDataSource);
        return itemDataSource;
    }
}
