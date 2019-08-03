package ibrahim.taskmind.application.Repository;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import java.util.List;

import ibrahim.taskmind.application.Model.DataResponse;

public class DataFactory  extends DataSource.Factory
{
    private MutableLiveData<PageKeyedDataSource<Integer, DataResponse>> responseDataSource
            = new MutableLiveData<>();


    public MutableLiveData<PageKeyedDataSource<Integer, DataResponse>> getDriverShipmentDataSource() {
        return responseDataSource;
    }

    @Override
    public androidx.paging.DataSource create() {
        DataSource itemDataSource = new DataSource();
        responseDataSource.postValue(itemDataSource);
        return itemDataSource;
    }
}
