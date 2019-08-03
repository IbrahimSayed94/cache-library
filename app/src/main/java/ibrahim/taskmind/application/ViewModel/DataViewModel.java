package ibrahim.taskmind.application.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import ibrahim.taskmind.application.Model.DataResponse;
import ibrahim.taskmind.application.Repository.DataFactory;

public class DataViewModel extends ViewModel
{
    public LiveData<PagedList<DataResponse>> itemPagedList;
    public LiveData<PageKeyedDataSource<Integer, DataResponse>> liveDataSource;


    public DataViewModel() {

        DataFactory itemDataSourceFactory = new DataFactory();
        liveDataSource = itemDataSourceFactory.getDriverShipmentDataSource();
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(10).build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig))
                .build();
    }
} // class of DataViewModel
