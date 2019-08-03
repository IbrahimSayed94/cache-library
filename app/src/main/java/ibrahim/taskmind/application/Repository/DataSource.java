package ibrahim.taskmind.application.Repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import java.util.List;

import ibrahim.taskmind.Library.Main.MindValley;
import ibrahim.taskmind.application.Model.DataResponse;
import ibrahim.taskmind.application.Network.RestApi;
import ibrahim.taskmind.application.Network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataSource extends PageKeyedDataSource<Integer, DataResponse>
{
    private static final String TAG = "DataSource";

    private static final int FIRST_PAGE = 1;


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, DataResponse> callback) {

        RestApi restApi = RetrofitClient.getClient().create(RestApi.class);
        Call<List<DataResponse>> call = restApi.getData(FIRST_PAGE);
        call.enqueue(new Callback<List<DataResponse>>() {
            @Override
            public void onResponse(Call<List<DataResponse>> call, Response<List<DataResponse>> response) {
                if(response.body() != null)
                {
                    callback.onResult(response.body(),null,FIRST_PAGE+1);

                }
            }

            @Override
            public void onFailure(Call<List<DataResponse>> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, DataResponse> callback) {
        RestApi restApi = RetrofitClient.getClient().create(RestApi.class);
        Call<List<DataResponse>> call = restApi.getData(FIRST_PAGE);
        call.enqueue(new Callback<List<DataResponse>>() {
            @Override
            public void onResponse(Call<List<DataResponse>> call, Response<List<DataResponse>> response) {
                Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                if(response.body() != null)
                {

                    callback.onResult(response.body(),adjacentKey);
                }
                Log.e(TAG,"before : "+params.key+" : "+FIRST_PAGE+" : "+adjacentKey);
            }

            @Override
            public void onFailure(Call<List<DataResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, DataResponse> callback) {

        RestApi restApi = RetrofitClient.getClient().create(RestApi.class);
        Call<List<DataResponse>> call = restApi.getData(params.key);
        call.enqueue(new Callback<List<DataResponse>>() {
            @Override
            public void onResponse(Call<List<DataResponse>> call, Response<List<DataResponse>> response) {
                if(response.body() != null)
                {
                    callback.onResult(response.body(),params.key+1);
                }

                Log.e(TAG,"after : "+params.key+" : "+FIRST_PAGE);
            }

            @Override
            public void onFailure(Call<List<DataResponse>> call, Throwable t) {

            }
        });

    }
}
