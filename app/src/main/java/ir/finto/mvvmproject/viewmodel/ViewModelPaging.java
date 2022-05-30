package ir.finto.mvvmproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;
import ir.finto.mvvmproject.api.ItemDataSource;
import ir.finto.mvvmproject.api.ItemDataSourceFactory;
import ir.finto.mvvmproject.model.Items;

public class ViewModelPaging extends ViewModel {


    public static LiveData<PagedList<Items>> itemListLiveData;
    public static LiveData<PageKeyedDataSource<Integer,Items>> sourceLiveData;

    public ViewModelPaging() {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        sourceLiveData = itemDataSourceFactory.getSourceMutableLiveData();

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE)
                .build();

        itemListLiveData = new LivePagedListBuilder(itemDataSourceFactory,config).build();

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
