package ibrahim.taskmind.application.ViewModel;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.security.PublicKey;

import ibrahim.taskmind.Library.Main.MindValley;
import ibrahim.taskmind.application.Model.DataResponse;


public class DetailsViewModel extends ViewModel
{
    MutableLiveData<DataResponse> dataResponseMutableLiveData = new MutableLiveData<>();

    public LiveData<DataResponse> getData(String id)
    {
        DataResponse object = new DataResponse();
        MindValley mindValley = new MindValley();

       object = (DataResponse) mindValley.getCashe(id);

        Log.e("QP" , "Object View Model : "+object.getCreated_at());
        dataResponseMutableLiveData.setValue(object);

        return dataResponseMutableLiveData;
    }


} // class of DetaildViewModel
