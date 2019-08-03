package ibrahim.taskmind.application.Network;

import java.util.List;

import ibrahim.taskmind.application.Model.DataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RestApi
{
    @GET("raw/wgkJgazE/")
    Call<List<DataResponse>> getData(
            @Query("page") int pageNumber
    );
}
